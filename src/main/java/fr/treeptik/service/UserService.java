package fr.treeptik.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import fr.treeptik.dao.DAOFactory;
import fr.treeptik.dao.exception.DAOException;
import fr.treeptik.pojo.Annonce;
import fr.treeptik.pojo.User;
import fr.treeptik.util.JPAUtil;


public class UserService{
	static User utilisateur =null;
	public static User create(User user , List<Annonce> annonces) throws DAOException {
		JPAUtil.beginTX();
		try {
			DAOFactory.getUserDAO().create(user);
		} catch (DAOException e) {
			throw new DAOException(e, "jhh");
		}
		JPAUtil.commitTX();
		return null;
	}
	public static User seConnecter(String login, String password){
		
		EntityManager em = JPAUtil.getEntityManager();
		
		TypedQuery<User> query = em.createQuery("SELECT u FROM User u WHERE u.login = :login AND u.password = :password", User.class);
		//em.cr
		query.setParameter("login", login);
		query.setParameter("password", password);
		try {
			if(!query.getResultList().isEmpty()){
				utilisateur = query.getSingleResult();
				//System.out.println(utilisateur.getAnnonces());
			} 
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return utilisateur;
	}
	
	public static void addAnnonce(List<Annonce> annonces){
		EntityManager em = JPAUtil.getEntityManager();
		JPAUtil.beginTX();
		for (Annonce annonce : annonces) {
			
			utilisateur.getAnnonces().add(annonce);em.merge(utilisateur);em.flush();
		}
		
		JPAUtil.commitTX();
		
	}
}
