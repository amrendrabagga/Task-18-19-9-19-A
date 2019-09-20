package com.wp.service;

import java.util.List;

import com.wp.entity.Emp;

public interface CRUDService {

	public void saveEmp(Emp emp);
	public List<Emp> getAllEmp();
	public Emp searchEmp(int eno);
	public void updateEmp(Emp emp);
	public void deleteEmp(Emp emp); 
}
