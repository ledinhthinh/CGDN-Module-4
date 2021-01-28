package com.blog.demo.controller;

import com.blog.demo.entity.BlogEntity;
import com.blog.demo.entity.Category;
import com.blog.demo.service.BlogService;
import com.blog.demo.service.CatelogyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
public class BlogController {
    @Autowired
    private BlogService blogService;
    @Autowired
    private CatelogyService catelogyService;

    @GetMapping("")
    public String goHome() {
        return "home";
    }

    @GetMapping("/list")
    public String list(Model model, @PageableDefault(size = 2) Pageable pageable,
                       @RequestParam Optional<String> keyword) {
        String checkKeyWord = "";
        if (!keyword.isPresent()) {
            model.addAttribute("blogentytis", this.blogService.findAll(pageable));
        } else {
            checkKeyWord = keyword.get();
            model.addAttribute("blogentytis", this.blogService.searchBlogtByName(checkKeyWord, pageable));
        }
        model.addAttribute("checkKeyWord", checkKeyWord);
        return "list";
    }
     @GetMapping("/sort")
     public String sort(Model model,Pageable pageable){
        model.addAttribute("blogentytis",blogService.findAllByOrderByDateOfManufacture(pageable));
        return "list";
     }
    @GetMapping("/listcategory")
    public String listcategory(Model model, @PageableDefault(size = 2) Pageable pageable, @RequestParam Optional<String> keyword) {
        String checkKeyWord = "";
        if (!keyword.isPresent()) {
            model.addAttribute("categorylist", this.catelogyService.findAll(pageable));
        } else {
            checkKeyWord = keyword.get();
            model.addAttribute("categorylist", this.catelogyService.searchCategorytByName(checkKeyWord, pageable));
        }
        model.addAttribute("checkKeyWord", checkKeyWord);
        return "listcategory";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("blogentitys", new BlogEntity());
        return "create";
    }
    @GetMapping("/createcategory")
    public String createcategory(Model model){
        model.addAttribute("categorylist",new Category());
        return "createcategory";
    }

    @PostMapping("/save")
    public String save(BlogEntity entity, RedirectAttributes redirectAttributes) {
        blogService.save(entity);
        redirectAttributes.addFlashAttribute("massage", " them thanh cong");

        return "redirect:/list";
    }
    @PostMapping("/savecategory")
    public String savecategory(Category category,RedirectAttributes redirectAttributes){
        catelogyService.save(category);
        redirectAttributes.addFlashAttribute("massage", "them thanh cong category ");
        return "redirect:/listcategory";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable int id, Model model) {
        model.addAttribute("blogentitys", blogService.findById(id));
        return "edit";
    }
    @GetMapping("/editcategory/{id}")
    public String editcatagory(@PathVariable int id,Model model){
        model.addAttribute("categorylist",catelogyService.findById(id));
        return "editcategory";
    }

    @PostMapping("/update")
    public String update(BlogEntity blogEntity, RedirectAttributes redirectAttributes) {
        blogService.update(blogEntity.getId(), blogEntity);
        redirectAttributes.addFlashAttribute("massage1", " sua thanh cong");
        return "redirect:/list";
    }
    @PostMapping("/updatecategory")
    public String updatecategory(Category category,RedirectAttributes redirectAttributes){
        catelogyService.update(category);
        redirectAttributes.addFlashAttribute("massage1","sua category xong ");
        return "redirect:/listcategory";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable int id, Model model) {
        model.addAttribute("blogentitys", blogService.findById(id));
        return "delete";
    }
    @GetMapping("/deletecategory/{id}")
    public String deletecategory(@PathVariable int id,Model model){
        model.addAttribute("categorylist",catelogyService.findById(id));
        return "deletecategory";
    }


    @PostMapping("/delete")
    public String delete(BlogEntity blogEntity, RedirectAttributes redirectAttributes) {
        blogService.remove(blogEntity.getId());
        redirectAttributes.addFlashAttribute("massage2", " xoas thaanh cong");
        return "redirect:/list";
    }
    @PostMapping("deletecategory")
    public String deletecategory(Category category,RedirectAttributes redirectAttributes){
        blogService.remove(category.getIdCategory());
        redirectAttributes.addFlashAttribute("massage2","xoa thanh cong category");
        return "redirect:/listcategory";
    }

    @GetMapping("/view/{id}")
    public String view(@PathVariable int id, Model model) {
        model.addAttribute("blogentitys", blogService.findById(id));
        return "view";
    }


    @GetMapping("/viewcategory/{id}")
    public  String viewcategory(@PathVariable int id,Model model){
        model.addAttribute("categorylist",catelogyService.findById(id));
        return "viewcategory";
    }


//    @PostMapping("/find")
//    public String find(@RequestParam String searchName,Model model){
//        model.addAttribute("blogentitys",blogService.findByName(searchName));
//        return"list";
//    }
}