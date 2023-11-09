package com.example.asm.service;

import com.example.asm.entity.CuaHang;
import com.example.asm.repository.CuaHangRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CuaHangService {

    @Autowired
    private CuaHangRepository cuaHangRepository;

    public List<CuaHang> getAll() {
        return cuaHangRepository.findAllByOrderByMaAsc();
    }

    public CuaHang getOne(String id) {
        return cuaHangRepository.findById(id).orElse(null);
    }

    public void save(CuaHang cuaHang) {
        cuaHangRepository.save(cuaHang);
    }

    public void delete(String id) {
        cuaHangRepository.deleteById(id);
    }
}
