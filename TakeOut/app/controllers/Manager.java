package controllers;

import play.mvc.Controller;
import models.Menu;

public class Manager extends Controller{

	public static void index(String name){
		render(name);
	}
	
	public static void addMenu(Menu menu){
		menu.create();
		flash.success("success to add the menu!");
		index("menu.html");
	}
	
	public static void modifyMenu(Long id){
		Menu menu = Menu.findById(id);
	    menu.edit("menu", params.all());
	    validation.valid(menu);
	    if(validation.hasErrors()) {
	        menu.refresh();
	        flash.success("fail to modify the menu!");
	    }
	    flash.success("success to modify the menu!");
	    index("menu.html");
	}
	
	public static void deleteMenu(Menu menu){
		menu.delete();
		flash.success("success to delete the %s", menu.name);
		index("menu.html");
	}
	
}
