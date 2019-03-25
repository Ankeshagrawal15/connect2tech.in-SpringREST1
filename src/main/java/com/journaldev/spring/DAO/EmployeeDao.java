package com.journaldev.spring.DAO;

import java.util.List;

import com.c2t.annotation.basic.Employee;
import com.c2t.annotation.basic.EmployeeVo;

public interface EmployeeDao {
	
	
	public Employee getEmployee();
	public EmployeeVo GetEmployees();
	public Employee GetById(long id);
	public String delete(long id);

		
	
		
}
 