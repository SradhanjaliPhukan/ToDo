package todo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import todo.dao.UserDao;
import todo.model.User;
/**
 * 
 * @author Sradhanjali
 * Services related to users
 *
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {

	private UserDao userDao;
	
	@Autowired
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public List<User> getAllUsers() {
		return userDao.getAllUsers();
	}

	@Override
	public User getUserById(int id) {
		return userDao.getUserById(id);
	}

	@Override
	public void addUser(User user) {
		userDao.addUser(user);

	}

	@Override
	public void updateUser(User user) {
		userDao.updateUser(user);

	}

	@Override
	public void deleteUser(int id) {
		userDao.deleteUser(id);

	}

}
