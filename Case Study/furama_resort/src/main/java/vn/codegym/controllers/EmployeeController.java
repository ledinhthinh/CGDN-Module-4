package vn.codegym.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import vn.codegym.model.Employee;
import vn.codegym.service.DivisionService;
import vn.codegym.service.EducationDegreeService;
import vn.codegym.service.EmployeeService;
import vn.codegym.service.PositionService;

import java.util.Optional;

@Controller
@RequestMapping("employee")
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;
    @Autowired
    PositionService positionService;
    @Autowired
    EducationDegreeService educationDegreeService;
    @Autowired
    DivisionService divisionService;

    @GetMapping("/home")
    public String home(){
        return "home";
    }

    @GetMapping("/error")
    public String error(){
        return "error";
    }

    @GetMapping("/list")
    public String listEm(Model model, @RequestParam Optional<String> nameSearch, @PageableDefault(size = 5) Pageable pageable){
        String nameSearchAfter = "";
        if (!nameSearch.isPresent()){
            model.addAttribute("emList",this.employeeService.findAll(pageable));
        }else {
            nameSearchAfter = nameSearch.get();
            model.addAttribute("emList",this.employeeService.findAllByEmployeeNameContaining(pageable,nameSearchAfter));
        }
        model.addAttribute("nameSearchAfter",nameSearchAfter);
        return "employee/list";
    }

    @GetMapping("/create")
    public String formCreateEm(Model model){
        model.addAttribute("employee",new Employee());
        model.addAttribute("position",positionService.findAll());
        model.addAttribute("educationDegree",educationDegreeService.findAll());
        model.addAttribute("division",divisionService.findAll());
        return "employee/create";
    }

    @PostMapping("/create")
    public String save(@Validated @ModelAttribute("employee") Employee employee, BindingResult bindingResult,Model model){
        if (bindingResult.hasFieldErrors()){
            model.addAttribute("position",positionService.findAll());
            model.addAttribute("educationDegree",educationDegreeService.findAll());
            model.addAttribute("division",divisionService.findAll());
            return "employee/create";
        }else {
            employeeService.save(employee);
            return "redirect:/employee/list";
        }
    }

    @GetMapping("/edit/{id}")
    public String formEditEm(@PathVariable String id,Model model){
        model.addAttribute("employee",employeeService.findById(id));
        model.addAttribute("position",positionService.findAll());
        model.addAttribute("educationDegree",educationDegreeService.findAll());
        model.addAttribute("division",divisionService.findAll());
        return "employee/edit";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute Employee employee){
        employeeService.save(employee);
        return "redirect:/employee/list";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable String id){
        this.employeeService.delete(id);
        return "redirect:/employee/list";
    }
}
