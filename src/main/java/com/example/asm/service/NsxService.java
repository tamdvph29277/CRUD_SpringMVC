package com.example.asm.service;

import com.example.asm.entity.NSX;
import com.example.asm.repository.NsxRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NsxService {

    @Autowired
    private NsxRepository nsxRepository;

    public List<NSX> getAll() {
        return nsxRepository.findAllByOrderByMaAsc();
    }

    public NSX getOne(String id) {
        return nsxRepository.findById(id).orElse(null);
    }

    public void save(NSX nsx) {
        nsxRepository.save(nsx);
    }

    public void delete(String id) {
        nsxRepository.deleteById(id);
    }
}
