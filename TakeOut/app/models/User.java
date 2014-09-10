package models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 通用顾客类
 * 
 * @author Administrator
 * 
 */
@Entity
@Table(name = "user")
public class User extends BasicModel {
	// 默认新注册为消费者
	public static int COMSUMER = 0;
	public static int BUSSINESS = 1;
	public static int ENTERPRISE = 2;

	@Column(name = "account")
	public String account;

	@Column(name = "passwd")
	public String passwd;

	@Column(name = "type")
	public int TYPE;

	@Column(name = "limit")
	public Double paylimit;

	@Column(name = "score")
	public Integer score;

}
