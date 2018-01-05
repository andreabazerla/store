package com.andreabazerla.dao;

import java.util.List;

import com.andreabazerla.model.User_t;

public interface UserDao extends GenericDao<User_t> {
	
	public void createUser(User_t user);

	public List<User_t> readUsers();

	public User_t getUser(int id);

	public User_t updateUser(User_t user);

	public void deleteUser(int id);

	public User_t loadUser(String pattern);

	public boolean hasUserPurchase(int idUser);

	
}
