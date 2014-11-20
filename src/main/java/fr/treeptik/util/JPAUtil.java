package fr.treeptik.util;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class JPAUtil {
	private static EntityManager entityManager = null;
	public static EntityManager getEntityManager() {
		if (entityManager==null){
		entityManager = Persistence.createEntityManagerFactory(
				"annonce").createEntityManager();
		
		}
		return entityManager;
	}
	public static void beginTX(){
		try {
			getEntityManager().getTransaction().begin();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	public static void commitTX(){
		try {
			getEntityManager().getTransaction().commit();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
}
