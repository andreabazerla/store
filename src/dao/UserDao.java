package dao;

import java.util.List;

import model.User;

public interface UserDao extends GenericDao<User> {
	
	public void createUser(User user);

	public List<User> readUsers();

	public User updateUser(User user);

	public void deleteUser(int id);

	public User loadUser(String pattern);
	
}
