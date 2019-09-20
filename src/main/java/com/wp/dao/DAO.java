package com.wp.dao;

import java.util.List;

import com.wp.entity.Emp;

public interface DAO {

	public List<Emp> getAllEmp();
	
	public void save(Emp emp);
	
	public void update(Emp emp);
	
	public void delete(Emp eno);
	
	public Emp search(int eno);
}
