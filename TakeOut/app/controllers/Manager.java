package controllers;

import play.mvc.Controller;
import utils.MessageUtil;
import models.Menu;
import models.User;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.*;

public class Manager extends Controller{

	public static void index(String name){
		render(name);
	}
	
	public static void addMenu(Menu menu){
		menu.save();
	}
	
	public static void showMenu() {
		List<Menu> menulist = Menu.findAll();
		render(menulist);
	}
	
	public static void editMenu(String id,double price){
		Menu menu = Menu.findById(id);
		menu.price=price;
	    if(menu!=null)
	    	menu.save();
	}
	
	public static void deleteMenu(Menu menu){
		menu.delete();
	}
	
	public static void newMenu(String name, String price, String info, File f) {
		try {
			Menu menu = new Menu();
			menu.name = name;
			menu.price = Double.parseDouble(price);
			menu.info = info;
			String url = copy(f, new File("public/images/"));
			menu.imageUrl = "/public/images/" + url;
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
	
}
