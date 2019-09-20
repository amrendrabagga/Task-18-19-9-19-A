package com.wp.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.wp.entity.Emp;
import com.wp.model.EmpModel;
import com.wp.service.EmpCRUDService;

@Controller
public class EmpController {

	@Autowired
	EmpCRUDService empCRUDService;
	
	@RequestMapping("home")
	public String showHome() {
		return "index.jsp";
	}
	@RequestMapping("/dataentry")
	public String showDataEntryForm() {
		return "EmpEntry";
	}
	
	@RequestMapping("SaveEmp")
	public ModelAndView saveEmp(@ModelAttribute("empInfo") EmpModel empModel) {
		 
		ModelAndView mv = new ModelAndView("success");
		Emp emp = new Emp();
		emp.setEno(empModel.getEno());
		emp.setEname(empModel.getEname());
		emp.setDesignation(empModel.getDesignation());
		emp.setSalary(empModel.getSalary());
		emp.setDept(empModel.getDept());
		
		empCRUDService.saveEmp(emp);
		return mv;
		
	}
	
	@RequestMapping("datafetch")
	public ModelAndView fetchAllEmp() {
		List<Emp> list = empCRUDService.getAllEmp();

		ModelAndView mv = new ModelAndView("DisplayEmp");
		mv.addObject("empList",list);
		
		return mv;	
	}
	@RequestMapping("datasearch")
	public String fetchEmp() {
		return "SearchEmp";
	}
	@PostMapping("GetEmp")
	public ModelAndView searchEmp(@RequestParam("eno") int eno) {
		Emp emp = empCRUDService.searchEmp(eno);
		ModelAndView mv = new ModelAndView("SearchEmp");
		mv.addObject("emp", emp);
		return mv;
	}
	
	@GetMapping("update")
	public String updateDelete(@RequestParam Map<String,String> requestParams,ModelMap map) {
		Emp emp = empCRUDService.searchEmp(Integer.parseInt(requestParams.get("eno")));
		map.addAttribute("emp",emp);
		return "update";
	}
	
	@PostMapping("UpdateEmp")
	public ModelAndView updateEmp(@ModelAttribute("empInfo") EmpModel empModel) {
		
		ModelAndView mv = new ModelAndView("redirect:datafetch");
		Emp emp = new Emp();
		emp.setEno(empModel.getEno());
		emp.setEname(empModel.getEname());
		emp.setDesignation(empModel.getDesignation());
		emp.setSalary(empModel.getSalary());
		emp.setDept(empModel.getDept());
		empCRUDService.updateEmp(emp);
//		mv.addObject("empInfo",emp);
		return mv;
	}
	
	@RequestMapping("delete")
	public ModelAndView deleteEmp(@RequestParam("eno") int eno) {
		ModelAndView mv = new ModelAndView("redirect:datafetch");
		Emp emp = empCRUDService.searchEmp(eno);
		System.out.println(emp.getEno());
		mv.addObject("empInfo",emp);
		empCRUDService.deleteEmp(emp);
		
		return mv;
	}
}
