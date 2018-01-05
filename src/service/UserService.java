package service;

import model.User;

public interface UserService extends GenericService<User> {

	public User get(int id);	
	public User load(String pattern);
	
}
