package controllers;

import play.cache.Cache;
import play.data.validation.Required;
import play.libs.Codec;
import play.mvc.Controller;
import play.mvc.Http.Cookie;
import utils.MessageUtil;

public class User extends Controller{
	
	public static void login() {
		String randomID = Codec.UUID();
        render(randomID);
    }
	
	public static void register(){
		render();
	}
	
	public static void check_Login(
	String username, 
     String password, 
    String code, 
     String randomID
			){
		
		models.User user=models.User.find("account=? and passwd=?",username,password ).first();
	
		if(user!=null){
			System.out.println("the code is :"+Cache.get(randomID));
			 if(code.equals(Cache.get(randomID))){
				Manager.index(); 
			 }else{
				 
			 }
			
		}else{
			MessageUtil.generateInfoMsg("登录失败");
			login();
			
		}
	}
	
}
