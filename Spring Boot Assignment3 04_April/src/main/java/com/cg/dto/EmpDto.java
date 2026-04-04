package com.cg.dto;

import jakarta.validation.constraints.*;
import java.time.LocalDate;
import org.springframework.format.annotation.DateTimeFormat;

public class EmpDto {

	private Integer empId;

	@NotBlank
	@Size(min = 3, max = 25)
	@Pattern(regexp = "^[a-zA-Z ]+$", message = "Only alphabets allowed")
	private String empName;

	@NotNull
	@Min(1000)
	@Max(500000)
	private Double empSal;

	@NotNull
	@FutureOrPresent(message = "DOJ must be today or future")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate empDoj;

	@Pattern(regexp = "^(hr|production)$", message = "Only hr or production allowed")
	private String deptName;

	public Integer getEmpId() {
		return empId;
	}

	public void setEmpId(Integer empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public Double getEmpSal() {
		return empSal;
	}

	public void setEmpSal(Double empSal) {
		this.empSal = empSal;
	}

	public LocalDate getEmpDoj() {
		return empDoj;
	}

	public void setEmpDoj(LocalDate empDoj) {
		this.empDoj = empDoj;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
}