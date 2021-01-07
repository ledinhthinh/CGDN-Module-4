package com.caculator.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalculatorController {

    @RequestMapping("/")
    public String Calculator(){
        return "index";
    }

    @RequestMapping("/calculating")
    public String Calculating(@RequestParam int num1 , @RequestParam int num2, @RequestParam String operator, Model model){
        switch (operator){
            case "+": model.addAttribute("result" ,"Addition" + (num1+num2));
            break;
            case "-":
                model.addAttribute("result", "Subtraction: " + (num1-num2));
                break;
            case "X":
                model.addAttribute("result", "Multiplication: " + (num1*num2));
                break;
            case "/":
                model.addAttribute("result", "Division: " + (num1/num2));
                break;
        }
        model.addAttribute(num1);
        model.addAttribute(num2);
        return "index";
    }

}
