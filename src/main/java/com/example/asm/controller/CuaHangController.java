package com.example.asm.controller;


import com.example.asm.entity.CuaHang;
import com.example.asm.service.CuaHangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("cua-hang")
public class CuaHangController {

    @Autowired
    private CuaHangService cuaHangService;

    @GetMapping()
    public String form() {
        return "cuaHang/cua-hang-index";
    }

    @GetMapping("/view-add")
    public String viewadd(Model model) {
        model.addAttribute("cuaHang", new CuaHang());
        return "cuaHang/cua-hang-view-add";
    }

    @PostMapping("/add")
    public String add(@ModelAttribute("cuaHang") CuaHang cuaHang) {
        cuaHangService.save(cuaHang);
        return "redirect:/cua-hang/hien-thi";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable String id) {
        cuaHangService.delete(id);
        return "redirect:/cua-hang/hien-thi";
    }

    @GetMapping("/detail/{id}")
    public String detail(@PathVariable String id, Model model) {
        CuaHang cuaHang = cuaHangService.getOne(id);
        model.addAttribute("cuaHang", cuaHang);
        return "cuaHang/cua-hang-detail";
    }

    @PostMapping("/update/{id}")
    public String update(@PathVariable("id") String id, CuaHang cuaHang) {
        cuaHangService.save(cuaHang);
        return "redirect:/cua-hang/hien-thi";
    }

    @GetMapping("/hien-thi")
    public String hienthi(Model model) {
        List<CuaHang> list = cuaHangService.getAll();
        model.addAttribute("list", list);
        return "cuaHang/cua-hang-index";
    }

}
