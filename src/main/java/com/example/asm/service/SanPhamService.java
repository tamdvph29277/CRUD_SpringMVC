package com.example.asm.service;

import com.example.asm.entity.SanPham;
import com.example.asm.repository.SanPhamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SanPhamService {

    @Autowired
    private SanPhamRepository sanPhamRepository;

    public List<SanPham> getAll() {
        return sanPhamRepository.findAllByOrderByMaAsc();
    }

    public SanPham getOne(String id) {
        return sanPhamRepository.findById(id).orElse(null);
    }

    public void save(SanPham sanPham) {
        sanPhamRepository.save(sanPham);
    }

    public void delete(String id) {
        sanPhamRepository.deleteById(id);
    }

}
