package controllers;

import play.mvc.Controller;

public class Manager extends Controller{

	public static void index(String name){
		render(name);
	}
	
}
