package com.example.asm.service;

import com.example.asm.entity.DongSP;
import com.example.asm.repository.DongSpRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DongSpService {
    @Autowired
    private DongSpRepository dongSpRepository;

    public List<DongSP> getAll() {
        return dongSpRepository.findAllByOrderByMaAsc();
    }

    public DongSP getOne(String id) {
        return dongSpRepository.findById(id).orElse(null);
    }

    public void save(DongSP dongSp) {
        this.dongSpRepository.save(dongSp);
    }

    public void delete(String id) {
        this.dongSpRepository.deleteById(id);
    }
}
