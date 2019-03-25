package com.journaldev.spring.DAO;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.c2t.annotation.basic.Employee;
import com.c2t.annotation.basic.EmployeeVo;

@Repository
public class EmployeeDaoImpl  implements EmployeeDao{

Map<Integer,Employee> empData=new HashMap<Integer, Employee>();
	
	@Autowired
	SessionFactory sf;
	@Override
	public Employee getEmployee() {
		return  (Employee)sf.openSession().get(Employee.class, 2l);
		//done
	}

	@Override
	public EmployeeVo GetEmployees() {
		// TODO Auto-generated method stub
		Session s = sf.openSession();
        Query q = s.createQuery("from Employee");
        List<Employee> emp = q.list();
        
        EmployeeVo emp1 = new EmployeeVo();
        emp1.setEmployees(emp);
        return emp1;
		
	}

	@Override
	public Employee GetById(long id) {
		// TODO Auto-generated method stub
		return  (Employee)sf.openSession().get(Employee.class, id);
		
	}

	@Override
	public String delete(long id) {

		Session s = sf.openSession();

		Employee emp = (Employee)s.get(Employee.class, new Long(id));
		 s.delete(emp);

		 s.beginTransaction().commit();
		return "delete";
	}
	
	

}
