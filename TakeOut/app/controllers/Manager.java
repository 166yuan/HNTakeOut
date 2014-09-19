package controllers;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

import org.apache.ivy.util.StringUtils;
import org.codehaus.groovy.util.StringUtil;
import org.h2.constant.SysProperties;

import play.mvc.Controller;
import utils.MessageUtil;
import models.Menu;

public class Manager extends Controller {

	public static void index(String name) {
		render(name);
	}

	public static void modifyMenu(String id) {
		Menu menu = Menu.findById(id);
		render(menu);
	}

	public static void modifyMenu2(String menuid, String name, String price,
			String info, File f) {
		Menu menu = Menu.findById(menuid);
		if (name.length() > 0) {
			menu.name = name;
		}
		if (price.length() > 0) {
			try {
				menu.price = Double.parseDouble(price);
			} catch (Exception e) {
				// TODO: handle exception
				MessageUtil.generateErrorMsg("价格输入错误");
			}
		}
		if (info.length() > 0) {
			menu.info = info;
		}
		if (f != null) {
			String path = copy(f, new File("public/images/"));
			menu.imageUrl = "/public/images/" + path;
		}
		menu.save();
		modifyMenu(menuid);
	}

	public static void deleteMenu(String id) {
		Menu menu=Menu.findById(id);
		menu.delete();
		showMenu();
	}

	public static void showMenu() {
		List<Menu> menulist = Menu.findAll();
		render(menulist);
	}

	public static void addMenu() {
		render();
	}

	public static void editMenu() {
		render();
	}

	public static void newMenu(String name, String price, String info, File f ,String selltime) {
		try {
			System.out.println(selltime);
			Menu menu = new Menu();
			menu.name = name;
			menu.price = Double.parseDouble(price);
			menu.menuType=Integer.parseInt(selltime);
			if(info.length()>0){menu.info = info;}
			if(f!=null){
			String url = copy(f, new File("public/images/"));
			menu.imageUrl = "/public/images/" + url;
			}else{
				menu.imageUrl = "/public/images/" + "nopicture.png";
			}
			menu.save();
			showMenu();
		} catch (Exception e) {
			MessageUtil.generateErrorMsg("信息输入有误，请检查拼写");
			addMenu();
		}
	}

	/**
	 * 功能描述：拷贝一个目录或者文件到指定路径下，即把源文件拷贝到目标文件路径下
	 * 
	 * @param source
	 *            源文件
	 * @param target
	 *            目标文件路径
	 * @return void
	 */
	static String copy(File source, File target) {
		File tarpath = new File(target, source.getName());
		if (source.isDirectory()) {
			tarpath.mkdir();
			File[] dir = source.listFiles();
			for (int i = 0; i < dir.length; i++) {
				copy(dir[i], tarpath);
			}
		} else {
			try {
				InputStream is = new FileInputStream(source); // 用于读取文件的原始字节流
				OutputStream os = new FileOutputStream(tarpath); // 用于写入文件的原始字节的流
				byte[] buf = new byte[1024];// 存储读取数据的缓冲区大小
				int len = 0;
				while ((len = is.read(buf)) != -1) {
					os.write(buf, 0, len);
				}
				is.close();
				os.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return tarpath.getName();
	}
	
	public static void showLunch(){
		List<Menu>lunchlist=Menu.find("menu_type=?",Menu.LUNCH).fetch();
		List<Menu>lunchlist2=Menu.find("menu_type=?", Menu.LUN_SUP).fetch();
		lunchlist.addAll(lunchlist2);
//		System.out.println(lunchlist.size());
		render(lunchlist);
	}
	
	public static void showDinner(){
		List<Menu>dinnerlist2=Menu.find("menu_type=?",Menu.LUN_SUP).fetch();
		List<Menu>dinnerlist=Menu.find("menu_type=?",Menu.SUPPER).fetch();
		dinnerlist.addAll(dinnerlist2);
		render(dinnerlist);
	}
}
