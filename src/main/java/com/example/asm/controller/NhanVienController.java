package com.example.asm.controller;

import com.example.asm.entity.ChucVu;
import com.example.asm.entity.NhanVien;
import com.example.asm.service.ChucVuService;
import com.example.asm.service.CuaHangService;
import com.example.asm.service.NhanVienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/nhan-vien")
public class NhanVienController {

    @Autowired
    private NhanVienService nhanVienService;
    @Autowired
    private CuaHangService cuaHangService;
    @Autowired
    private ChucVuService chucVuService;

    @GetMapping()
    public String form() {
        return "nhanVien/nhan-vien-index";
    }

    @GetMapping("/hien-thi")
    public String hienthi(Model model) {
        List<NhanVien> list = nhanVienService.getAll();
        model.addAttribute("list", list);
        return "nhanVien/nhan-vien-index";
    }

    @GetMapping("/view-add")
    public String viewadd(Model model) {
        model.addAttribute("nhanVien", new NhanVien());
        model.addAttribute("listCH", cuaHangService.getAll());
        model.addAttribute("listCV", chucVuService.getAll());
        return "nhanVien/nhan-vien-add";
    }

    @GetMapping("/detail/{id}")
    public String viewadd(@PathVariable String id, Model model) {
        NhanVien nhanVien = nhanVienService.getOne(id);
        model.addAttribute("nhanVien", nhanVien);
        model.addAttribute("listCH", cuaHangService.getAll());
        model.addAttribute("listCV", chucVuService.getAll());
        return "nhanVien/nhan-vien-detail";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable String id) {
        nhanVienService.delete(id);
        return "redirect:/nhan-vien/hien-thi";
    }

    @PostMapping("/update/{id}")
    public String update(@PathVariable("id") String id, NhanVien nhanVien) {
        nhanVienService.save(nhanVien);
        return "redirect:/nhan-vien/hien-thi";
    }

    @PostMapping("/add")
    public String add(@ModelAttribute("nhanVien") NhanVien nhanVien) {
        nhanVienService.save(nhanVien);
        return "redirect:/nhan-vien/hien-thi";
    }

}
