package com.bjtxt.ssh.dao;

import java.util.List;

import com.bjtxt.ssh.entities.Department;

public class DepartmentDao extends BaseDao{
	
	public List<Department> getAll(){
		String hql = "From Department";
		System.out.println(getSession().createQuery(hql).list());
		return getSession().createQuery(hql).list();
	}
}
