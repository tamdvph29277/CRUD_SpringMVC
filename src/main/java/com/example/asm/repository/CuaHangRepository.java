package com.example.asm.repository;

import com.example.asm.entity.CuaHang;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface CuaHangRepository extends JpaRepository<CuaHang, String> {
    List<CuaHang> findAllByOrderByMaAsc();
}
