package todo.dao;

import java.util.List;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import todo.model.User;

@Repository
public class UserDaoImpl implements UserDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	private Session getSession(){
		return sessionFactory.getCurrentSession();
	}
	
	@Override
	public List<User> getAllUsers() {
		Session session = getSession();
		CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
		CriteriaQuery<User> criteria = criteriaBuilder.createQuery(User.class);
		criteria.select(criteria.from(User.class));
		return session.createQuery(criteria).getResultList();
	}

	@Override
	public User getUserById(int id) {
		return getSession().get(User.class, id);
	}

	@Override
	public void addUser(User user) {
		getSession().saveOrUpdate(user);

	}
	
	@Override
	public void updateUser(User user) {
		getSession().saveOrUpdate(user);
	}

	@Override
	public void deleteUser(int id) {
		Session session = getSession();
		User user = session.get(User.class, id);
		session.delete(user);
	}

}
