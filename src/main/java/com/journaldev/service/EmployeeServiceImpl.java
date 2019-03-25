package com.journaldev.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.c2t.annotation.basic.Employee;
import com.c2t.annotation.basic.EmployeeVo;
import com.journaldev.spring.DAO.EmployeeDao;


@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	@Qualifier(value="employeeDaoImpl")
	EmployeeDao eDao;
	
	
	
	@Override
	public Employee GetEmployee() {
		// TODO Auto-generated method stub
		Employee emp= eDao.getEmployee();
		return emp;
	}

	@Override
	public EmployeeVo GetAllEmployees() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EmployeeVo DeleteEmployee() {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
