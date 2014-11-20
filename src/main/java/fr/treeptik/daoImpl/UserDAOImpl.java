package fr.treeptik.daoImpl;

import fr.treeptik.dao.UserDAO;
import fr.treeptik.pojo.User;

public class UserDAOImpl extends GenericDAOImpl<User, Integer> implements
		UserDAO {

	public UserDAOImpl() {
		super(User.class);
	}

	}


