package com.bjtxt.ssh.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.bjtxt.ssh.entities.Employee;

public class EmployeeDao extends BaseDao{
	

	/**
	 * 获取所有的员工信息
	 * */
	public List<Employee> getAll(){
		String hql = "From Employee e left outer join fetch e.department";
		System.out.println(getSession().createQuery(hql).list());
		return getSession().createQuery(hql).list();
	}
	/**
	 * 	删除员工信息
	 * */
	public void delete(Integer id){
		String hql = "delete from Employee e where e.id=?";
		getSession().createQuery(hql).setInteger(0, id).executeUpdate();
	}
	
	/**
	 * 添加员工信息
	 * */
	public void saveOrUpdate(Employee employee){
		getSession().saveOrUpdate(employee);
	}
}
