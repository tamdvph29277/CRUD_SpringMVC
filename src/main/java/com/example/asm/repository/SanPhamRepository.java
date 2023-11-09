package com.example.asm.repository;

import com.example.asm.entity.SanPham;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SanPhamRepository extends JpaRepository<SanPham, String> {
    List<SanPham> findAllByOrderByMaAsc();
}
