package fr.treeptik.pojo;

import java.util.Collection;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Annonce {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String title;
	@Column(columnDefinition="text")
	private String description;
	private String link;
	private Integer price;
	private Integer count;
	@ManyToMany(mappedBy = "annonces")
	private Collection<User> users;

	public Annonce() {
		
	}

	

	public Annonce(Integer id, String title, String description, String link,
			Integer price, Integer count, List<User> users) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.link = link;
		this.price = price;
		this.count = count;
		this.users = users;
	}



	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}



	public Collection<User> getUsers() {
		return users;
	}



	public void setUsers(Collection<User> users) {
		this.users = users;
	}



	@Override
	public String toString() {
		return "Annonce [id=" + id + ", title=" + title + ", description="
				+ description + ", link=" + link + ", price=" + price
				+ ", count=" + count + "]";
	}






}
