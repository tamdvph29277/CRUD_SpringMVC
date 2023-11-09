package com.example.asm.service;

import com.example.asm.entity.CTSP;
import com.example.asm.repository.CTSPRepossitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CTSPService {

    @Autowired
    private CTSPRepossitory ctspRepossitory;

    public List<CTSP> getAll() {
        return ctspRepossitory.findAll();
    }

    public CTSP getOne(String id) {
        return ctspRepossitory.findById(id).orElse(null);
    }

    public void save(CTSP ctsp) {
        ctspRepossitory.save(ctsp);
    }

    public void delete(String id) {
        ctspRepossitory.deleteById(id);
    }
}
