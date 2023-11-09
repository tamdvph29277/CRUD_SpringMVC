package com.example.asm.repository;

import com.example.asm.entity.MauSac;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MauSacRepository extends JpaRepository<MauSac, String> {
    List<MauSac> findAllByOrderByMaAsc();
}
