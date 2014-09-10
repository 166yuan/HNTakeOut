package models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**通用店主类
 * @author Administrator
 *
 */
@Entity
@Table(name = "keeper")
public class Keeper extends BasicModel{
	
	@Column(name = "account")
	public String account;
	
	@Column(name = "password")
	public String password;
	
	@Column(name = "name")
	public String name;
	
	@Column(name = "sex")
	public boolean sex;
	
	@Column(name = "phone")
	public String phone;
	
	
}
