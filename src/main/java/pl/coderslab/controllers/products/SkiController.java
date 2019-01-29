package pl.coderslab.controllers.products;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.entity.Ski;
import pl.coderslab.repository.SkiRepository;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Controller
@RequestMapping("/product/ski")
public class SkiController {

    @Autowired
    private SkiRepository skiRepository;

    @GetMapping("/form")
    public String add(Model model, HttpServletRequest request) {
        model.addAttribute("ski", new Ski());
        model.addAttribute("formAction", request.getContextPath() + "/product/ski/save");
        return "product/ski/form";
    }

    @GetMapping("/edit/{id}")
    public String edit(Model model, HttpServletRequest request, @PathVariable Long id){
        Ski ski = skiRepository.findOne(id);
        model.addAttribute("ski", ski);
        model.addAttribute("formAction", request.getContextPath() + "/product/ski/save");
        return "product/ski/form";
    }

    @PostMapping("/save")
    public String save(@Valid Ski ski, BindingResult errors, HttpServletRequest request){
        if (errors.hasErrors()) {
            return "product/ski/form";
        }
        skiRepository.save(ski);
        return "redirect:"+request.getContextPath()+"/product/ski/list";
    }

    @GetMapping("/list")
    public String showAll(Model model){
        model.addAttribute("ski", skiRepository.findAll());
        return "product/ski/list";
    }

    @RequestMapping(path = "/delete/{id}", produces = "text/html; charset=UTF-8")
    public String delete(@PathVariable Long id, HttpServletRequest request) {
        Ski ski = skiRepository.findOne(id);
        skiRepository.delete(ski);
        return "redirect:" + request.getContextPath() + "/product/ski/list";
    }
}
