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
	public String information;
	
	@Column(name = "price")
	public double price;
}
