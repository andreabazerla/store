package service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dao.UserDaoImpl;
import model.User;

@Service
@Transactional
public class UserServiceImpl implements UserService {

  @Autowired
  private UserDaoImpl userDao;

  public void create(User user) throws SQLException {
    userDao.createUser(user);
  }

  public List<User> read() {
    return userDao.readUsers();
  }

  public User get(int id) {
    return userDao.getUser(id);
  }

  public User load(String pattern) {
    return userDao.loadUser(pattern);
  }

  public void update(User user) {
    userDao.updateUser(user);
  }

  public void delete(int id) {
    userDao.deleteUser(id);
  }

}
