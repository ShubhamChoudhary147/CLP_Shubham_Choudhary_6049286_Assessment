package com.cg.service;

import java.util.List;
import java.util.Optional;
import com.cg.entity.Emp;

public interface EmpService {
	List<Emp> getAll();

	Optional<Emp> getById(Integer id);

	void save(Emp emp);

	void delete(Integer id);
}