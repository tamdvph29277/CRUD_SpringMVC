package com.example.asm.repository;

import com.example.asm.entity.DongSP;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DongSpRepository extends JpaRepository<DongSP, String> {

    List<DongSP> findAllByOrderByMaAsc();
}
