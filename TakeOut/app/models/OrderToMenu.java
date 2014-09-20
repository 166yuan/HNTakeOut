package models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "ordertomenu")
public class OrderToMenu extends BasicModel{

	@Column(name = "orderid")
	public String orderId;
	
	@Column(name = "menuid")
	public String menuId;
	
}
