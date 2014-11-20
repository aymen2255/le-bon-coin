package fr.treeptik.pojo;

import java.util.Collection;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String name;
	private Integer age;
	private String login;
	private String password;
	@ManyToMany
	private Collection<Annonce> annonces;

	public User() {
		super();
	}



	public User(Integer id, String name, Integer age, String login,
			String password, Collection<Annonce> annonces) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.login = login;
		this.password = password;
		this.annonces = annonces;
	}



	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Collection<Annonce> getAnnonces() {
		return annonces;
	}

	public void setAnnonces(Collection<Annonce> annonces) {
		this.annonces = annonces;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}





}
