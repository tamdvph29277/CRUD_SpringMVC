package com.example.asm.service;

import com.example.asm.entity.ChucVu;
import com.example.asm.repository.ChucVuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChucVuService {
    @Autowired
    private ChucVuRepository chucVuRepository;

    public List<ChucVu> getAll() {
        return chucVuRepository.findAll();
    }

    public List<ChucVu> searchByTen(String ten) {
        return chucVuRepository.findByTenContainingOrderByMa(ten);
    }

    public ChucVu getOne(String id) {
        return chucVuRepository.findById(id).orElse(null);
    }

    public void save(ChucVu chucVu) {
        this.chucVuRepository.save(chucVu);
    }

    public void delete(String id) {
        this.chucVuRepository.deleteById(id);
    }
}
