package pl.coderslab.controllers.products;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.entity.Boot;
import pl.coderslab.repository.BootRepsitory;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Controller
@RequestMapping("/product/boot")
public class BootControllers {

    @Autowired
    private BootRepsitory bootRepsitory;

    @GetMapping("/form")
    public String add(Model model, HttpServletRequest request) {
        model.addAttribute("boot", new Boot());
        model.addAttribute("formAction", request.getContextPath() + "/product/boot/save");
        return "product/boot/form";
    }

    @GetMapping("/edit/{id}")
    public String edit(Model model, HttpServletRequest request, @PathVariable Long id){
        Boot boot = bootRepsitory.findOne(id);
        model.addAttribute("boot", boot);
        model.addAttribute("formAction", request.getContextPath() + "/product/boot/save");
        return "product/boot/form";
    }

    @PostMapping("/save")
    public String save(@Valid Boot boot, BindingResult errors, HttpServletRequest request){
        if (errors.hasErrors()) {
            return "product/boot/form";
        }
        bootRepsitory.save(boot);
        return "redirect:"+request.getContextPath()+"/product/boot/list";
    }

    @GetMapping("/list")
    public String showAll(Model model){
        model.addAttribute("boots", bootRepsitory.findAll());
        return "product/boot/list";
    }

    @RequestMapping(path = "/delete/{id}", produces = "text/html; charset=UTF-8")
    public String delete(@PathVariable Long id, HttpServletRequest request) {
        Boot boot = bootRepsitory.findOne(id);
        bootRepsitory.delete(boot);
        return "redirect:"+request.getContextPath()+"/product/boot/list";
    }
}
