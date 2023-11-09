package com.example.asm.controller;

import com.example.asm.entity.NSX;
import com.example.asm.entity.SanPham;
import com.example.asm.service.SanPhamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/san-pham")
public class SanPhamController {
    @Autowired
    private SanPhamService sanPhamService;

    @GetMapping()
    public String form() {
        return "sanPham/san-pham-index";
    }

    @GetMapping("/hien-thi")
    public String hienThi(Model model) {
        List<SanPham> list = sanPhamService.getAll();
        model.addAttribute("list", list);
        return "sanPham/san-pham-index";
    }


    @GetMapping("/view-add")
    public String viewadd(Model model) {
        model.addAttribute("sanPham", new SanPham());
        return "sanPham/san-pham-view-add";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable String id) {
        sanPhamService.delete(id);
        return "redirect:/san-pham/hien-thi";
    }

    @GetMapping("/detail/{id}")
    public String detail(@PathVariable String id, Model model) {
        SanPham sanPham = sanPhamService.getOne(id);
        model.addAttribute("sanPham", sanPham);
        return "sanPham/san-pham-detail";
    }


    @PostMapping("/update/{id}")
    public String update(@PathVariable("id") String id, SanPham sanPham) {
        sanPhamService.save(sanPham);
        return "redirect:/san-pham/hien-thi";
    }


    @PostMapping("/add")
    public String add(@ModelAttribute("nsx") SanPham sanPham) {
        sanPhamService.save(sanPham);
        return "redirect:/san-pham/hien-thi";
    }
}
