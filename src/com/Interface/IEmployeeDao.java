package com.Interface;

import java.util.List;

import entity.Employees;

public interface IEmployeeDao {
	public List<Employees> queryAllEmployees();
	
	public Employees queryEmployeeByNum(String employee_num);
	
	public boolean addEmployee(Employees employees);
	
	public boolean deleteEmployee(String employee_num);
	
	public boolean updateEmployee(Employees employees);
}
