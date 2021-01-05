package vn.codegym.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Math {

    @GetMapping("/")
    public String greeting(){
        return "index";
    }

    @RequestMapping("/math")
    public String math(@RequestParam int usd, Model model) {
        int vnd = usd * 22000;
        model.addAttribute("vnd", vnd);
        model.addAttribute("usd", usd);
        return "index";
    }
}
