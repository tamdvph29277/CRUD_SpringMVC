package com.example.asm.service;

import com.example.asm.entity.NhanVien;
import com.example.asm.repository.NhanVienRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NhanVienService {
    @Autowired
    private NhanVienRepository nhanVienRepository;

    public List<NhanVien> getAll() {
        return nhanVienRepository.findAllByOrderByMaAsc();
    }

    public NhanVien getOne(String id) {
        return nhanVienRepository.findById(id).orElse(null);
    }

    public void save(NhanVien nhanVien) {
        nhanVienRepository.save(nhanVien);
    }

    public void delete(String id) {
        nhanVienRepository.deleteById(id);
    }
}
