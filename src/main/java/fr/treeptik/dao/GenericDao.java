package fr.treeptik.dao;

import java.util.List;

import fr.treeptik.dao.exception.DAOException;

public interface GenericDao<T, PK> {
	T create(T obj) throws DAOException;
	T update(T obj) throws DAOException;
	T find(PK id) throws DAOException;
	List<T> findAll() throws DAOException;
	
	void delete(T obj) throws DAOException;
}
