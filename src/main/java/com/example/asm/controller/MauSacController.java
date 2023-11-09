package com.example.asm.controller;

import com.example.asm.entity.MauSac;
import com.example.asm.service.MauSacService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/mau-sac")
public class MauSacController {

    @Autowired
    private MauSacService mauSacService;

    @GetMapping()
    public String form() {
        return "mauSac/mau-sac-index";
    }

    @GetMapping("/hien-thi")
    public String hienthi(Model model) {
        List<MauSac> list = mauSacService.getAll();
        model.addAttribute("list", list);
        return "mauSac/mau-sac-index";
    }

    @GetMapping("/view-add")
    public String viewadd(Model model) {
        model.addAttribute("mau", new MauSac());
        return "mauSac/mau-sac-view-add";
    }

    @PostMapping("/add")
    public String add(@ModelAttribute("dong") MauSac mauSac) {
        mauSacService.save(mauSac);
        return "redirect:/mau-sac/hien-thi";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable String id) {
        mauSacService.delete(id);
        return "redirect:/mau-sac/hien-thi";
    }

    @GetMapping("/detail/{id}")
    public String detail(@PathVariable String id, Model model) {
        MauSac mauSac = mauSacService.getOne(id);
        model.addAttribute("mau", mauSac);
        return "mauSac/mau-sac-detail";
    }

    @PostMapping("/update/{id}")
    public String update(@PathVariable("id") String id, MauSac mauSac) {
        mauSacService.save(mauSac);
        return "redirect:/mau-sac/hien-thi";
    }
}
