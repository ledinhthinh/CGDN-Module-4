package com.thinh.controllers;

import com.thinh.model.Dictionary;
import com.thinh.service.DictionaryService;
import com.thinh.service.DictionaryServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class dictionaryController {
    private DictionaryService dictionaryService = new DictionaryServiceImpl();

    @GetMapping("/search")
    public String search() {
        return "index";
    }

    @PostMapping("/result")
    public String meaning(@RequestParam String keyword, Model model) {
        List<Dictionary> dictionaries = dictionaryService.findAll();
        for (int i = 0; i < dictionaries.size(); i++) {
            if (keyword.equalsIgnoreCase(dictionaries.get(i).getEn())) {
                model.addAttribute("keyword", keyword);
                model.addAttribute("mean", dictionaries.get(i).getVi());
                return "mean";
            }
        }
        return "mean";
    }
}
