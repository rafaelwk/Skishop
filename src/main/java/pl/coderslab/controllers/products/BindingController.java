package pl.coderslab.controllers.products;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.entity.Binding;
import pl.coderslab.repository.BindingRepository;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Controller
@RequestMapping("/product/binding")
public class BindingController {

    @Autowired
    private BindingRepository bindingRepository;

    @GetMapping("/form")
    public String addBindig(Model model, HttpServletRequest request) {
        model.addAttribute("binding", new Binding());
        model.addAttribute("formAction", request.getContextPath() + "/product/binding/save");
        return "product/binding/form";

    }

    @GetMapping("/edit/{id}")
    public String saveBinding(Model model, HttpServletRequest request, @PathVariable Long id){
        Binding binding = bindingRepository.findOne(id);
        model.addAttribute("binding", binding);
        model.addAttribute("formAction", request.getContextPath() + "/product/binding/save");
        return "product/binding/form";
    }

    @PostMapping("/save")
    public String savePublisher(@Valid Binding binding, BindingResult errors, HttpServletRequest request){
        if (errors.hasErrors()) {
            return "product/binding/form";
        }
        bindingRepository.save(binding);
        return "redirect:"+request.getContextPath()+"/product/binding/list";
    }

    @GetMapping("/list")
    public String showAll(Model model){
        model.addAttribute("bindings", bindingRepository.findAll());
        return "product/binding/list";
    }

    @RequestMapping(path = "/delete/{id}", produces = "text/html; charset=UTF-8")
    public String delete(@PathVariable Long id, HttpServletRequest request) {
        Binding binding = bindingRepository.findOne(id);
        bindingRepository.delete(id);
        return "redirect:"+request.getContextPath()+"/product/binding/list";

    }

}
