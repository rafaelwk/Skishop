package pl.coderslab.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.entity.Product;
import pl.coderslab.entity.ProductType;
import pl.coderslab.repository.ProductRepsitory;
import pl.coderslab.repository.ProductTypeRepository;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/productType")
public class ProductTypeController {

    @Autowired
    private ProductTypeRepository productTypeRepository;

    @Autowired
    private ProductRepsitory productRepsitory;

    @GetMapping("/form")
    public String add(Model model, HttpServletRequest request) {
        model.addAttribute("productType", new ProductType());
        model.addAttribute("formAction", request.getContextPath() + "/productType/save");
        return "productType/form";

    }

    @GetMapping("/edit/{id}")
    public String edit(Model model, HttpServletRequest request, @PathVariable Long id){
        ProductType productType = productTypeRepository.findOne(id);
        model.addAttribute("productType", productType);
        model.addAttribute("formAction", request.getContextPath() + "/productType/save");
        return "productType/form";
    }

    @PostMapping("/save")
    public String save(@Valid ProductType productType, BindingResult errors, HttpServletRequest request){
        if (errors.hasErrors()) {
            return "productType/form";
        }
        productTypeRepository.save(productType);
        return "redirect:"+request.getContextPath()+"/productType/list";
    }

    @GetMapping("/list")
    public String showAll(Model model){
        model.addAttribute("productTypes", productTypeRepository.findAll());
        return "productType/list";
    }

    @RequestMapping(path = "/delete/{id}", produces = "text/html; charset=UTF-8")
    public String delete(@PathVariable Long id, HttpServletRequest request) {
        ProductType productType = productTypeRepository.findOne(id);
        productTypeRepository.delete(productType);
        return "redirect:"+request.getContextPath()+"/productType/list";

    }

    @ModelAttribute("products")
    public List<Product> productList() {
        return productRepsitory.findAll();
    }

}
