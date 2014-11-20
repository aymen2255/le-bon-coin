package fr.treeptik.daoImpl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import javax.persistence.Query;
import javax.swing.text.Utilities;

import fr.treeptik.dao.GenericDao;
import fr.treeptik.dao.exception.DAOException;
import fr.treeptik.pojo.Annonce;
import fr.treeptik.pojo.User;
import fr.treeptik.util.JPAUtil;

public abstract class GenericDAOImpl<T, PK> implements GenericDao<T, PK> {

	private Class<T> type;

	public GenericDAOImpl(Class<T> type) {
		this.type = type;
	}

	public T create(T obj) throws DAOException {
		try {
			JPAUtil.getEntityManager().persist(obj);

		} catch (PersistenceException e) {
			throw new DAOException(e, "jhh");
		}
		return obj;

	}

	public T find(PK id) throws DAOException {
		T entity = null;
		try {
			entity = JPAUtil.getEntityManager().find(type, id);

		} catch (Exception e) {
			throw new DAOException(e, "prob dao");
		}
		return entity;

	}

	public T update(T obj) throws DAOException {
		T entity = null;
		try {
			entity = JPAUtil.getEntityManager().merge(obj);
		} catch (Exception e) {
			throw new DAOException(e, "jhh");
		}
		return entity;
	}

	public void delete(T obj) throws DAOException {

		try {

			JPAUtil.getEntityManager().remove(obj);
		} catch (Exception e) {
			throw new DAOException(e, "jhh");
		}

	}
	public List<T> findAll(){
		EntityManager em = JPAUtil.getEntityManager();
		Query query = em.createQuery("select a from Annonce a");
		List resultList = query.getResultList();
		return resultList;
		
	}
	
	

		
	

}
