package com.example.asm.repository;

import com.example.asm.entity.CTSP;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CTSPRepossitory extends JpaRepository<CTSP, String> {
}
