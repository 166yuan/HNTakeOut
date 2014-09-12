package controllers;

import play.cache.Cache;
import play.data.validation.Required;
import play.libs.Codec;
import play.mvc.Controller;
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
	 @Required(message="请输入用户名") String username, 
     @Required(message="请输入密码") String password, 
     @Required(message="请输入验证码") String code, 
     String randomID
			){
		
		models.User user=models.User.find("account=? and passwd=?",username,password ).first();
		if(user!=null){
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
