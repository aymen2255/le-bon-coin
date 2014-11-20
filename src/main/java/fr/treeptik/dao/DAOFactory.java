package fr.treeptik.dao;

import fr.treeptik.daoImpl.AnnonceDAOImpl;
import fr.treeptik.daoImpl.UserDAOImpl;


public class DAOFactory {
	
	public static UserDAO getUserDAO() {
		return new UserDAOImpl();
	}
	
	public static AnnonceDAO getAnnonceDAO() {
		return new AnnonceDAOImpl();
	}

}
