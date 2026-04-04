package com.cg.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.entity.Emp;
import com.cg.repository.EmpRepo;

@Service
public class EmpServiceImpl implements EmpService {

	@Autowired
	private EmpRepo repo;

	public List<Emp> getAll() {
		return repo.findAll();
	}

	public Optional<Emp> getById(Integer id) {
		return repo.findById(id);
	}

	public void save(Emp emp) {
		repo.save(emp);
	}

	public void delete(Integer id) {
		repo.deleteById(id);
	}
}