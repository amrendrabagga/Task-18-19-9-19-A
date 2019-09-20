package com.wp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.wp.dao.DAO;
import com.wp.dao.EmpDAO;
import com.wp.entity.Emp;

@Service
public class EmpCRUDService implements CRUDService {

	@Autowired
//	@Qualifier("myDAO") //it we have only bean(component of type dao then no need)
	DAO empDAO;
	
	@Override
	public void saveEmp(Emp emp) {
		empDAO.save(emp);
	}
	
	@Override
	public List<Emp> getAllEmp(){
		List<Emp> list = empDAO.getAllEmp();
		return list;	
	}
	@Override
	public Emp searchEmp(int eno) {
		Emp emp = empDAO.search(eno);
		return emp;
	}
	@Override
	public void updateEmp(Emp emp) {
		empDAO.update(emp);
	}
	@Override
	public void deleteEmp(Emp emp) {
		empDAO.delete(emp);
	}
 }
