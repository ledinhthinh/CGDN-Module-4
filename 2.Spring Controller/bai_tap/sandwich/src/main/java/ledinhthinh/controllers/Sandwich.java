package ledinhthinh.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Sandwich {

    @RequestMapping("/")
    public String condiments(){
        return "index";
    }

    @RequestMapping("/save")
    public String save (@RequestParam("condiment") String[] condiment, Model model){
        model.addAttribute("condiment",condiment);
        return "condiment";
    }

}
