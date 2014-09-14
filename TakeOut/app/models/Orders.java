package models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import play.db.jpa.Model;

/**通用订单类
 * @author 陈思远
 *
 */
@Entity
@Table(name = "orders")
public class Orders extends BasicModel{
	
	/**
	 * 订单号
	 */
	@Column(name = "number")
	public String number;
	
	/**
	 * 订单号
	 */
	@Column(name = "name")
	public String name;
	
	/**
	 * 下单时间
	 */
	@Column(name = "book_time")
	public Long bookTime;
	
	/**
	 * 送餐时间
	 */
	@Column(name = "send_time")
	public Long sendTime;
	
	/**
	 * 餐厅电话
	 */
	@Column(name = "res_number")
	public String resNumber;
	
	/**
	 * 联系电话
	 */
	@Column(name = "con_number")
	public String conNumber;
	
	
	@Column(name = "info")
	public String info;
}
