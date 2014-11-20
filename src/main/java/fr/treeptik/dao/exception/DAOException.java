package fr.treeptik.dao.exception;

public class DAOException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DAOException(Exception e, String string) {
		super(string,e);
	}

}
