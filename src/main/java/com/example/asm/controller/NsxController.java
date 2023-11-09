package com.example.asm.controller;

import com.example.asm.entity.NSX;
import com.example.asm.service.NsxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/nsx")
public class NsxController {

    @Autowired
    private NsxService nsxService;

    @GetMapping()
    public String form() {
        return "nsx/nsx-index";
    }

    @GetMapping("/hien-thi")
    public String hienThi(Model model) {
        List<NSX> list = nsxService.getAll();
        model.addAttribute("list", list);
        return "nsx/nsx-index";
    }


    @GetMapping("/view-add")
    public String viewadd(Model model) {
        model.addAttribute("nsx", new NSX());
        return "nsx/nsx-view-add";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable String id) {
        nsxService.delete(id);
        return "redirect:/nsx/hien-thi";
    }

    @GetMapping("/detail/{id}")
    public String detail(@PathVariable String id, Model model) {
        NSX nsx = nsxService.getOne(id);
        model.addAttribute("nsx", nsx);
        return "nsx/nsx-detail";
    }


    @PostMapping("/update/{id}")
    public String update(@PathVariable("id") String id, NSX nsx) {
        nsxService.save(nsx);
        return "redirect:/nsx/hien-thi";
    }


    @PostMapping("/add")
    public String add(@ModelAttribute("nsx") NSX nsx) {
        nsxService.save(nsx);
        return "redirect:/nsx/hien-thi";
    }

}
