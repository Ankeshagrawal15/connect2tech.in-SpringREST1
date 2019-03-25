package com.journaldev.service;

import com.c2t.annotation.basic.Employee;
import com.c2t.annotation.basic.EmployeeVo;
import com.journaldev.spring.DAO.EmployeeDao;

public interface EmployeeService {
	
	public Employee GetEmployee();
	public EmployeeVo GetAllEmployees();
	public EmployeeVo DeleteEmployee();
	
	
	

}
