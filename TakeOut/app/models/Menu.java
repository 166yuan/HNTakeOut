package models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/** 通用菜式类
 * @author CSY
 *
 */
@Entity
@Table(name = "menu")
public class Menu extends BasicModel{
	
	public static int LUNCH=0;
	public static int SUPPER=1;
	public static int LUN_SUP=2;
	/**
	 * 名字
	 */
	@Column(name = "name")
	public String name;
	
	/**
	 *  菜单信息
	 */
	@Column(name = "info")
	public String info;
	
	/**
	 * 价格
	 */
	@Column(name = "price")
	public double price;
	
	/**
	 *  菜单图片路径
	 */
	@Column(name = "image_url")
	public String imageUrl;
	
	/**
	 * 	菜式类型：0 为午餐 1为晚餐 2为午晚通用
	 */
	@Column(name = "menu_type")
	public int menuType;
}
