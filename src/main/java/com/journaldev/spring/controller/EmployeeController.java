package com.journaldev.spring.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.c2t.annotation.basic.Employee;
import com.c2t.annotation.basic.EmployeeVo;
import com.journaldev.service.EmployeeService;
import com.sun.media.jfxmedia.logging.Logger;

//import com.journaldev.spring.model.Employee;

@Controller
public class EmployeeController {

	Map<Integer,Employee> empData=new HashMap<Integer, Employee>();
	
	@Autowired
	SessionFactory sf;
	@Autowired
	@Qualifier(value="employeeServiceImpl")
	EmployeeService eService;
	
	
//	@RequestMapping(value="/rest/emp/dummy",method=RequestMethod.GET)
//	public @ResponseBody Employee getDummyEmployee()
//	{
//		Employee emp=new Employee();
//		emp.setId(9999);
//		emp.setName("Dummy");
//		emp.setCreatedDate(new Date());
//		
//		empData.put(1,emp);
//		return emp;
//		
//	}
	
	@RequestMapping(value="/rest/emp/dummy",method=RequestMethod.GET)
	public @ResponseBody  Employee getDummyEmployee()
	{
		Employee emp=new Employee();
		emp.setCellphone("90383839");
		emp.setFirstname("Hiren");
		emp.setId(2l);
		emp.setLastname("Sonagara");
		emp.setBirthDate(new java.sql.Date(1996, 06, 23));
		
		Session s=sf.openSession();
		s.beginTransaction();
		s.save(emp);
		s.getTransaction().commit();
		


		//empData.put(1,emp);
		return emp;
	
	}
	@RequestMapping(value="/get",method=RequestMethod.GET)
	public @ResponseBody  Employee getDummyEmployee1()
	{
		Employee e=eService.GetEmployee();
		return  e;
		
	}
	
	
	
	@RequestMapping(value = "/get/all", method = RequestMethod.GET)
	public @ResponseBody List<Employee> getAllEmployees() {
		//logger.info("Start getAllEmployees.");
		
		
		
		String sql="select e from Employee e";
		
		return sf.openSession().createQuery(sql).list();
	}
	
	
	@RequestMapping(value="rest/em/dummy/list", method=RequestMethod.GET)

	public @ResponseBody EmployeeVo getDummyEmployeeList()

	{

		Query q = sf.openSession().createQuery("from Employee");

		List <Employee> list = q.list();

	     EmployeeVo e1=new EmployeeVo();

	     e1.setEmployees(list);

		return e1;

		

	}	
	
	@RequestMapping(value="/rest/emp/{id}", method=RequestMethod.GET)
	public @ResponseBody Employee getEmployee(@PathVariable("id") int empId)
	{
		
		Session s = sf.openSession();

		Employee emp = (Employee)s.get(Employee.class, new Long(empId));


		return emp;
		
	}
	
	@RequestMapping(value="/rest/deleteemp/{id}", method=RequestMethod.GET)
	public @ResponseBody String deleteEmployee(@PathVariable("id") int empId)
	{
		
		Session s = sf.openSession();

		Employee emp = (Employee)s.get(Employee.class, new Long(empId));
		 s.delete(emp);

		 s.beginTransaction().commit();
		return "delete";
		
	}


	
	


	
}