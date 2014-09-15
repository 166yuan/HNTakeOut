package controllers;

import play.mvc.Controller;
import models.Menu;

public class Manager extends Controller{

	public static void index(String name){
		render(name);
	}
	
	public static void addMenu(Menu menu){
		menu.create();
	}
	
	public static void modifyPrice(Menu menu,double price){
		
	}
	
	public static void deleteMenu(Menu menu){
		menu.delete();
	}
	
	
	
}
