package com.example.asm.controller;

import com.example.asm.entity.ChucVu;
import com.example.asm.repository.ChucVuRepository;
import com.example.asm.service.ChucVuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/chuc-vu")
public class ChucVuController {
    @Autowired
    private ChucVuService chucVuService;

    @Autowired
    private ChucVuRepository chucVuRepository;

    @GetMapping()
    public String form() {
        return "/chucVu/chucvu-index";
    }

    @GetMapping("/hien-thi")
    public String hienThi(Model model, @RequestParam(name = "num", defaultValue = "0") Integer num) {
        Page<ChucVu> chucVuPage = chucVuRepository.findAll(PageRequest.of(num, 3));
        model.addAttribute("list", chucVuPage.getContent());
        model.addAttribute("next", num);
        model.addAttribute("totalPages", chucVuPage.getTotalPages());
        return "/chucVu/chucvu-index";
    }

    @GetMapping("/search")
    public String searchByName(@RequestParam("ten") String ten, Model model) {
        List<ChucVu> searchResults = chucVuService.searchByTen(ten);
        model.addAttribute("list", searchResults);
        return "/chucVu/chucvu-index";
    }

    @GetMapping("/view-add")
    public String viewadd(Model model) {
        model.addAttribute("chucVu", new ChucVu());
        return "/chucVu/chucvu-view-add";
    }

    @PostMapping("/add")
    public String add(@ModelAttribute("chucVu") ChucVu chucVu) {
        chucVuService.save(chucVu);
        return "redirect:/chuc-vu/hien-thi";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable String id) {
        chucVuService.delete(id);
        return "redirect:/chuc-vu/hien-thi";
    }

    @GetMapping("/detail/{id}")
    public String detail(@PathVariable String id, Model model) {
        ChucVu chucVu = chucVuService.getOne(id);
        model.addAttribute("chucVu", chucVu);
        return "/chucVu/chucvu-detail";
    }

    @PostMapping("/update/{id}")
    public String update(@PathVariable("id") String id, ChucVu chucVu) {
        chucVuService.save(chucVu);
        return "redirect:/chuc-vu/hien-thi";
    }
}
