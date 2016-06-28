package com.Interface;

import entity.User;

public interface IUserDao {
	
	public boolean userLogin(User user);
	
	public boolean saveUser(User user);
	
	public boolean ValidateName(String name);
	
}
