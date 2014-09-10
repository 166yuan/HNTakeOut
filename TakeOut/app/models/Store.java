package models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 通用店铺类
 * 
 * @author 陈思远
 * 
 */
@Entity
@Table(name = "store")
public class Store extends BasicModel {
	
	public static int Alipay=0;
	public static int COD=1;
	public static int Alipay_COD=2;

	@Column(name = "name")
	public String name;
	
	@Column(name = "owner_id")
	public String ownerId;
	
	@Column(name = "rank")
	public Double rank;
	
	@Column(name = "send_price")
	public Double sendPrice;
	
	@Column(name = "publish")
	public String publish;
	
	@Column(name = "payway")
	public int PayWay;
	
	@Column(name = "intro")
	public String introduction;
	
	@Column(name = "address")
	public String address;
	
	@Column(name = "op_hour")
	public String openHours;
	
	@Column(name = "image_url")
	public String image;
}
