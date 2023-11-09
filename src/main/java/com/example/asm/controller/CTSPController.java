package com.example.asm.controller;

import com.example.asm.entity.CTSP;
import com.example.asm.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/ctsp")
public class CTSPController {

    @Autowired
    private CTSPService ctspService;
    @Autowired
    private SanPhamService sanPhamService;
    @Autowired
    private NsxService nsxService;
    @Autowired
    private MauSacService mauSacService;
    @Autowired
    private DongSpService dongSpService;


    @GetMapping()
    public String form() {
        return "ctsp/ctsp-index";
    }

    @GetMapping("/view-add")
    public String viewadd(Model model) {
        model.addAttribute("ctsp", new CTSP());
        model.addAttribute("listSP", sanPhamService.getAll());
        model.addAttribute("listNsx", nsxService.getAll());
        model.addAttribute("listMau", mauSacService.getAll());
        model.addAttribute("listDong", dongSpService.getAll());
        return "ctsp/ctsp-view-add";
    }

    @GetMapping("/hien-thi")
    public String hienThi(Model model) {
        List<CTSP> list = ctspService.getAll();
        model.addAttribute("list", list);
        return "ctsp/ctsp-index";
    }

    @GetMapping("/detail/{id}")
    public String detail(@PathVariable String id, Model model) {
        CTSP ctsp = ctspService.getOne(id);
        model.addAttribute("ctsp", ctsp);
        model.addAttribute("listSP", sanPhamService.getAll());
        model.addAttribute("listNsx", nsxService.getAll());
        model.addAttribute("listMau", mauSacService.getAll());
        model.addAttribute("listDong", dongSpService.getAll());
        return "ctsp/ctsp-detail";
    }

    @PostMapping("/add")
    public String add(@ModelAttribute("ctsp") CTSP ctsp) {
        ctspService.save(ctsp);
        return "redirect:/ctsp/hien-thi";
    }

    @PostMapping("/update/{id}")
    public String update(@PathVariable("id") String id, CTSP ctsp) {
        ctspService.save(ctsp);
        return "redirect:/ctsp/hien-thi";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable String id) {
        ctspService.delete(id);
        return "redirect:/ctsp/hien-thi";
    }
}
