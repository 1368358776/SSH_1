package com.bjtxt.ssh.actions;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.Map;

import javax.lang.model.element.Parameterizable;

import org.apache.struts2.interceptor.RequestAware;

import com.bjtxt.ssh.entities.Employee;
import com.bjtxt.ssh.service.DepartmentService;
import com.bjtxt.ssh.service.EmployeeService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;

public class EmployeeAction extends ActionSupport implements RequestAware,ModelDriven<Employee>,Preparable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private EmployeeService employeeService;
	
	public void setEmployeeService(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	
	private Integer id;
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	 private InputStream inputStream;
	 public InputStream getInputStream() {
	     return inputStream;
	 }
	 
	 private DepartmentService departmentService;
	 
	 
	 
	public void setDepartmentService(DepartmentService departmentService) {
		this.departmentService = departmentService;
	}
	
	public String list(){
		request.put("employees", employeeService.getAll());
		return "list";
	}

	public String delete(){
		
		try {
			employeeService.delete(id);
			inputStream = new ByteArrayInputStream("1".getBytes("UTF-8"));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			try {
				inputStream = new ByteArrayInputStream("0".getBytes("UTF-8"));
			} catch (UnsupportedEncodingException e1) {
				e1.printStackTrace();
			}
		}
		return "delete";
	}
	
	public String input(){
		request.put("departments", departmentService.getAll());
		return "input";
	}
	
	public String save(){
		model.setCreateTime(new Date());
		employeeService.saveOrUpdate(model);
		System.out.println("model::"+model);
		return "success";
	}
	
	public void prepareSave(){
		model = new Employee();
	}
	private Map<String,Object> request;
	@Override
	public void setRequest(Map<String, Object> arg0) {
		this.request = arg0;
	}

	@Override
	public void prepare() throws Exception {}
	private Employee model;
	@Override
	public Employee getModel() {
		
		return model;
	}
}
