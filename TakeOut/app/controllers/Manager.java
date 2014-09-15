package controllers;

import play.mvc.Controller;
import models.Menu;

public class Manager extends Controller{

	public static void index(){
		render();
	}
	
	public static void addMenu(Menu menu){
		menu.edit(rootParamNode, name)
	}
	
	public static void modifyPrice(Menu menu,double price){
		menu.create();
	}
	
	public static void deleteMenu(Menu menu){
		menu.delete();
	}
	
	
	
}
