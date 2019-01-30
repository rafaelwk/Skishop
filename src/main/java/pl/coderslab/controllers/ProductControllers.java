package pl.coderslab.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.entity.CartItem;
import pl.coderslab.entity.Product;
import pl.coderslab.entity.ProductType;
import pl.coderslab.repository.CartItemRepository;
import pl.coderslab.repository.ProductRepsitory;
import pl.coderslab.repository.ProductTypeRepository;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductControllers {

    @Autowired
    private ProductRepsitory productRepsitory;

    @Autowired
    private ProductTypeRepository productTypeRepository;

    @GetMapping("/form/{productTypeId}")
    public String add(Model model, HttpServletRequest request, @PathVariable Long productTypeId) {
        Product product = new Product();
        model.addAttribute("product", product);
        model.addAttribute("formAction", request.getContextPath() + "/product/form/"+productTypeId);
        return "product/form";
    }

    @PostMapping("/form/{productTypeId}")
    public String add(@Valid Product product, BindingResult error, Model model, HttpServletRequest request, @PathVariable Long productTypeId) {
        ProductType productType = productTypeRepository.findOne(productTypeId);
        product.setProductType(productType);
        if(error.hasErrors()){
            return "product/form";
        }
        productRepsitory.save(product);
        return "product/form";
    }

    @GetMapping("/listtype/{productTypeid}")
    public String showAll(Model model, @PathVariable Long productTypeid){

        model.addAttribute("producttypes", productRepsitory.findAllByProductType(productTypeRepository.findOne(productTypeid)));
        return "product/listtype";
    }


    @GetMapping("/edit/{id}")
    public String edit(Model model, HttpServletRequest request, @PathVariable Long id){
        Product product = productRepsitory.findOne(id);
        model.addAttribute("product", product);
        model.addAttribute("formAction", request.getContextPath() + "/product/save");
        return "product/form";
    }

    @PostMapping("/save")
    public String save(@Valid Product product, BindingResult errors, HttpServletRequest request){
        if (errors.hasErrors()) {
            return "product/boot/form";
        }
        productRepsitory.save(product);
        return "redirect:"+request.getContextPath()+"/product/list";
    }

    @GetMapping("/list")
    public String showAll(Model model){
        model.addAttribute("products", productRepsitory.findAll());
        return "product/list";
    }

    @RequestMapping(path = "/delete/{id}", produces = "text/html; charset=UTF-8")
    public String delete(@PathVariable Long id, HttpServletRequest request) {
        Product product = productRepsitory.findOne(id);
        productRepsitory.delete(product);
        return "redirect:"+request.getContextPath()+"/product/list";
    }

    @ModelAttribute("productTypes")
    public List<ProductType> productTypeList() {
        return productTypeRepository.findAll();
    }
}
