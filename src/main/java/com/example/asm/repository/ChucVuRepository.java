package com.example.asm.repository;

import com.example.asm.entity.ChucVu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ChucVuRepository extends JpaRepository<ChucVu, String> {

    List<ChucVu> findByTenContainingOrderByMa(String ten);

}
