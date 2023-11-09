package com.example.asm.controller;

import com.example.asm.entity.DongSP;
import com.example.asm.service.DongSpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/dong-sp")
public class DongSpController {
    @Autowired
    private DongSpService dongSpService;

    @GetMapping("/hien-thi")
    public String hienthi(Model model) {
        List<DongSP> list = dongSpService.getAll();
        model.addAttribute("list", list);
        return "/dongSp/dong-sp-index";
    }

    @GetMapping()
    public String form() {
        return "/dongSp/dong-sp-index";
    }

    @GetMapping("/view-add")
    public String viewadd(Model model) {
        model.addAttribute("dong", new DongSP());
        return "/dongSp/dong-sp-view-add";
    }

    @GetMapping("/detail/{id}")
    public String detail(@PathVariable String id, Model model) {
        DongSP dong = dongSpService.getOne(id);
        model.addAttribute("dong", dong);
        return "/dongSp/dong-sp-detail";
    }

    @PostMapping("/add")
    public String add(@ModelAttribute("dong") DongSP dongSP) {
        dongSpService.save(dongSP);
        return "redirect:/dong-sp/hien-thi";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable String id) {
        dongSpService.delete(id);
        return "redirect:/dong-sp/hien-thi";
    }

    @PostMapping("/update/{id}")
    public String update(@PathVariable("id") String id, DongSP dongSP) {
        dongSpService.save(dongSP);
        return "redirect:/dong-sp/hien-thi";
    }
}
