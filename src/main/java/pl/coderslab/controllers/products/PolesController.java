package pl.coderslab.controllers.products;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.entity.Poles;
import pl.coderslab.repository.PolesRepository;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Controller
@RequestMapping("/product/poles")
public class PolesController {

    @Autowired
    private PolesRepository polesRepository;


    @GetMapping("/form")
    public String add(Model model, HttpServletRequest request) {
        model.addAttribute("poles", new Poles());
        model.addAttribute("formAction", request.getContextPath() + "/product/poles/save");
        return "product/poles/form";
    }

    @GetMapping("/edit/{id}")
    public String edit(Model model, HttpServletRequest request, @PathVariable Long id){
        Poles poles = polesRepository.findOne(id);
        model.addAttribute("poles", poles);
        model.addAttribute("formAction", request.getContextPath() + "/product/poles/save");
        return "product/poles/form";
    }

    @PostMapping("/save")
    public String save(@Valid Poles poles, BindingResult errors, HttpServletRequest request){
        if (errors.hasErrors()) {
            return "product/poles/form";
        }
        polesRepository.save(poles);
        return "redirect:"+request.getContextPath()+"/product/poles/list";
    }

    @GetMapping("/list")
    public String showAll(Model model){
        model.addAttribute("poles", polesRepository.findAll());
        return "product/poles/list";
    }

    @RequestMapping(path = "/delete/{id}", produces = "text/html; charset=UTF-8")
    public String delete(@PathVariable Long id, HttpServletRequest request) {
        Poles poles = polesRepository.findOne(id);
        polesRepository.delete(poles);
        return "redirect:" + request.getContextPath() + "/product/poles/list";
    }
}
