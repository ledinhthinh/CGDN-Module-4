package vn.codegym.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import vn.codegym.model.Customer;
import vn.codegym.service.CustomerService;
import vn.codegym.service.CustomerTypeService;

import java.util.Optional;

@Controller
@RequestMapping(value = {"customer",""})
public class CustomerController {
    @Autowired
    CustomerService customerService;
    @Autowired
    CustomerTypeService customerTypeService;

    @GetMapping("/home")
    public String home() {
        return "home";
    }

    @GetMapping("error")
    public String error() {
        return "error";
    }

    @GetMapping("/list")
    public String listCus(Model model, @RequestParam Optional<String> nameSearch, @PageableDefault(size = 5) Pageable pageable) {
        String nameSearchAfter = "";
        if (!nameSearch.isPresent()) {
            model.addAttribute("cusList", this.customerService.findAll(pageable));
        } else {
            nameSearchAfter = nameSearch.get();
            model.addAttribute("cusList", this.customerService.findAllByCustomerNameContaining(pageable, nameSearchAfter));
        }
        model.addAttribute("nameSearchAfter", nameSearchAfter);
        return "customer/list";
    }

    @GetMapping("/create")
    public String formCreateCus(Model model) {
        model.addAttribute("customer", new Customer());
        model.addAttribute("customerTypes", customerTypeService.findAll());
        return "customer/create";
    }

    @PostMapping("/create")
    public String save(@Validated @ModelAttribute("customer") Customer customer, BindingResult bindingResult, Model model) {
        if (bindingResult.hasFieldErrors()) {
            model.addAttribute("customerTypes", customerTypeService.findAll());
            return "customer/create";
        } else {
            customerService.save(customer);
            return "redirect:/customer/list";
        }
    }

    @GetMapping("/edit/{id}")
    public String formEditCus(@PathVariable String id, Model model) {
        model.addAttribute("customer", customerService.findById(id));
        model.addAttribute("customerType", customerTypeService.findAll());
        return "customer/edit";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute Customer customer) {
        customerService.save(customer);
        return "redirect:/customer/list";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable String id){
        this.customerService.delete(id);
        return "redirect:/customer/list";
    }
}
