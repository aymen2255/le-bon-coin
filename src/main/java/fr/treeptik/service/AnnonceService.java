package fr.treeptik.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import fr.treeptik.dao.AnnonceDAO;
import fr.treeptik.dao.DAOFactory;
import fr.treeptik.dao.exception.DAOException;
import fr.treeptik.pojo.Annonce;
import fr.treeptik.util.JPAUtil;
import fr.treeptik.util.JSOUPUtil;

public class AnnonceService {
	public static Annonce create() throws DAOException {
		JPAUtil.beginTX();
		List<Annonce> listAnnonce = JSOUPUtil.testJsoup();
		try {
			for (Annonce annonce1 : listAnnonce) {
				DAOFactory.getAnnonceDAO().create(annonce1);
				System.out.println(annonce1);
			}

		} catch (DAOException e) {
			throw new DAOException(e, "probleme annonce service");
		}
		JPAUtil.commitTX();
		return null;
	}

	public static Annonce findAnnonceById(Integer id) {
		//EntityManager em = JPAUtil.getEntityManager();
		Annonce annonce = null;
		try {
			annonce = DAOFactory.getAnnonceDAO().find(id);
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//Annonce annonce = em.find(Annonce.class, id);System.out.println(annonce.getTitle());

		return annonce;

	}
	
	public static List<Annonce> findAll(){
		List<Annonce> annonces = new ArrayList<Annonce>();
		AnnonceDAO annonceDAO = DAOFactory.getAnnonceDAO();
		try {
			annonces = annonceDAO.findAll();
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return annonces;
	}
	
	public static void deleteAnnonce(Annonce annonce){
		try {
			JPAUtil.beginTX();
			DAOFactory.getAnnonceDAO().delete(annonce);
			JPAUtil.commitTX();
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
		
		
		