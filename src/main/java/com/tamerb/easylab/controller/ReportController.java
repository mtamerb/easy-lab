package com.tamerb.easylab.controller;

import com.tamerb.easylab.exception.ResourceNotFoundException;
import com.tamerb.easylab.model.Laborant;
import com.tamerb.easylab.model.Report;
import com.tamerb.easylab.service.LaborantService;
import com.tamerb.easylab.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class ReportController {

    @Autowired
    LaborantService laborantService;

    @Autowired
    ReportService reportService;


    @GetMapping("reports")
    public String home(Model model) {
        String keyword = null;
        return pageReports(model, 1, "id", "asc", null);
    }

    @GetMapping("/reports/{pageNum}")
    public String pageReports(Model model, @PathVariable(name = "pageNum") int pageNum,
                              @Param("sortField") String sortField,
                              @Param("sortDir") String sortDir,
                              @Param("keyword") String keyword) {

        Page<Report> page = reportService.listAll(pageNum, sortField, sortDir, keyword);
        List<Report> reportList = page.getContent();

        model.addAttribute("currentPage", pageNum);
        model.addAttribute("totalPages", page.getTotalPages());
        model.addAttribute("totalItems", page.getTotalElements());
        model.addAttribute("sortField", sortField);
        model.addAttribute("sortDir", sortDir);
        model.addAttribute("keyword", keyword);
        model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc" : "asc");

        model.addAttribute("reportList", reportList);
        return "reports";


    }


    @PostMapping("/reports/save")
    public String saveReports(Report report) {
        reportService.save(report);
        return "redirect:/reports";
    }

    @GetMapping("/reports/new")
    public String createReports(Model model) {
        List<Laborant> laborantList = laborantService.listAll();
        model.addAttribute("laborantList", laborantList);

        model.addAttribute("report", new Report());
        return "reports_create";
    }


    @GetMapping("reports/edit/{id}")
    public String editReports(@PathVariable("id") Long id, Model model) throws ResourceNotFoundException {
        Report report = reportService.get(id);
        model.addAttribute("report", report);

        List<Laborant> laborantList = laborantService.listAll();
        model.addAttribute("laborantList", laborantList);
        deleteReports(id);
        return "reports_create";
    }


    @RequestMapping("/reports/delete/{id}")
    public String deleteReports(@PathVariable(name = "id") Long id) throws ResourceNotFoundException {
        reportService.delete(id);
        return "redirect:/reports";
    }

}
