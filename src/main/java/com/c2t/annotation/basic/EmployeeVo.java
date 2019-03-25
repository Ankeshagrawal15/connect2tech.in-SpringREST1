package com.c2t.annotation.basic;

import java.util.ArrayList;

import java.util.List;



import javax.xml.bind.annotation.XmlRootElement;



@XmlRootElement(name = "employee")

public class EmployeeVo {

	List<Employee> employees=new ArrayList<Employee>();



	public List<Employee> getEmployees() {

		return employees;

	}



	public void setEmployees(List<Employee> employees) {

		this.employees = employees;

	}



	

	



}
