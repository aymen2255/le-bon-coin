package fr.treeptik.runtime;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import fr.treeptik.dao.exception.DAOException;
import fr.treeptik.pojo.Annonce;
import fr.treeptik.pojo.User;
import fr.treeptik.service.AnnonceService;
import fr.treeptik.service.UserService;
import fr.treeptik.util.JPAUtil;

public class Main {

	public static void main(String[] args) throws DAOException {
		//AnnonceService.create();
		//User user = new User(null, "jooo", 25, "login", "password", null);
		//UserService.create(user, null);
		User user = UserService.seConnecter("toto", "toto");//System.out.println(user.getName());
		List<Annonce> annonces = AnnonceService.findAll();
		for (Annonce annonce : annonces) {
			System.out.println(annonce.getId());
		}
		UserService.addAnnonce(annonces);
		
		
	
	for (Annonce annonce : annonces) {
		
		user.getAnnonces().remove(annonce);
		
		AnnonceService.deleteAnnonce(annonce);
	}
		
		
		
		

		
	}

	public static void add() throws DAOException {
		List<Annonce> annonces = new ArrayList<Annonce>();
		List<User> users = new ArrayList<User>();

		EntityManager em = JPAUtil.getEntityManager();
		JPAUtil.beginTX();
		TypedQuery<User> query = em.createQuery(
				"select u from User u where u.id=17", User.class);
		User user = query.getSingleResult();
		Annonce a1 = new Annonce();
		a1.setTitle("aaaa");
		em.persist(a1);
		Annonce a2 = new Annonce();
		a2.setTitle("aaaaa");
		em.persist(a2);

		user.setAnnonces(annonces);
		user.getAnnonces().add(a1);
		user.getAnnonces().add(a2);
		System.out.println(user.getAnnonces());
		a1.setUsers(users);
		a1.getUsers().add(user);
		em.persist(a1);
		em.flush();

		JPAUtil.commitTX();

	}
	public static void voidaddAnnonce(){
		
	}

}
