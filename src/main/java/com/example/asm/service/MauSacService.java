package com.example.asm.service;

import com.example.asm.entity.MauSac;
import com.example.asm.repository.MauSacRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MauSacService {

    @Autowired
    private MauSacRepository mauSacRepository;

    public List<MauSac> getAll() {
        return mauSacRepository.findAllByOrderByMaAsc();
    }

    public MauSac getOne(String id) {
        return mauSacRepository.findById(id).orElse(null);
    }

    public void save(MauSac mauSac) {
        this.mauSacRepository.save(mauSac);
    }

    public void delete(String id) {
        this.mauSacRepository.deleteById(id);
    }
}
