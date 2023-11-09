package com.example.asm.repository;

import com.example.asm.entity.NSX;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NsxRepository extends JpaRepository<NSX, String> {
    List<NSX> findAllByOrderByMaAsc();
}
