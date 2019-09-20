package com.wp.dao;

import java.util.List;

import javax.servlet.ServletContext;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.web.context.ServletContextAware;


import com.wp.entity.Emp;
import com.wp.util.Util;


@Repository
public class EmpDAO implements DAO{


	
	private SessionFactory sessionFactory;
	private Session session;
	private Transaction tr;
	public EmpDAO() {

	}
	@Autowired//constructor type autowiring
	public EmpDAO(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
		this.session = this.sessionFactory.openSession(); 
	}
	@Override
	public List<Emp> getAllEmp() {
		List<Emp> listEmp = session.createNamedQuery("GET_ALL_EMP").list();
		return listEmp;
	}

	@Override
	public void save(Emp emp) {
		tr = session.beginTransaction();
		session.save(emp);
		tr.commit();
		System.out.println("emp saved");
	}

	@Override
	public void update(Emp emp) {
		tr = session.beginTransaction();
		session.update(emp);
		tr.commit();
	}

	@Override
	public void delete(Emp emp) {
		tr = session.beginTransaction();
		session.delete(emp);
		tr.commit();
		System.out.println("emp deleted");
	}

	@Override
	public Emp search(int eno) {
		Emp emp = session.get(Emp.class, eno);
		session.clear();
		return emp;
	}
//	@Override
//	public void setServletContext(ServletContext servletContext) {
//		this.context = servletContext;
//		session = ((Session)context.getAttribute("hSession"));
//		
//	}

	
}
