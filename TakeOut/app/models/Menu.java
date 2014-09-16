package models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "menu")
public class Menu extends BasicModel{

	@Column(name = "name")
	public String name;
	
	@Column(name = "info")
	public String info;
	
	@Column(name = "price")
	public double price;
	
	@Column(name = "image_url")
	public String imageUrl; 
}
