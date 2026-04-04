package com.cg.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.cg.entity.Emp;

public interface EmpRepo extends JpaRepository<Emp, Integer> {
}