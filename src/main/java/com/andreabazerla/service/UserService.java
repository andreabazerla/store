package com.andreabazerla.service;

import com.andreabazerla.model.User_t;

public interface UserService extends GenericService<User_t> 
{
	public User_t get(int id);
	
	public User_t load(String pattern);
	
}
