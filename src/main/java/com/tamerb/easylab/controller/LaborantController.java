package com.tamerb.easylab.controller;

import com.tamerb.easylab.model.Laborant;
import com.tamerb.easylab.service.LaborantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class LaborantController {


    @Autowired
    LaborantService laborantService;

    @GetMapping("/laborants")
    public String listLaborants(Model model) {

        List<Laborant> laborantList = laborantService.listAll();
        model.addAttribute("laborantList", laborantList);
        return "laborants";
    }

    @PostMapping("/laborants/save")
    public String saveLaborants(Laborant laborant) {
        laborantService.save(laborant);
        return "redirect:/laborants";
    }

    @GetMapping("/laborants/new")
    public String createLaborants(Model model) {
        model.addAttribute("laborants", new Laborant());
        return "laborants_create";

    }


}
