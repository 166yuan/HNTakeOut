package controllers;

import models.User;
import play.cache.Cache;
import play.data.validation.Required;
import play.libs.Codec;
import play.mvc.Controller;
import play.mvc.Http.Cookie;
import utils.MessageUtil;

public class Users extends Controller {

	public static void login() {
		String randomID = Codec.UUID();
		render(randomID);
	}

	public static void register() {
		render();
	}

	public static void check_Login(String username, String password,
			String code, String randomID) {
		User user = User.find("account=? and passwd=?", username, password)
				.first();

		if (user != null) {
			Manager.index(user.account);
		} else {
			MessageUtil.generateInfoMsg("登录失败");
			login();

		}
	}

	/**
	 * 注册新用户方法
	 * 
	 * @param username
	 *            用户名
	 * @param password
	 *            密码
	 * @param repeat
	 *            重复密码
	 * @param email
	 *            邮箱
	 */
	public static void newUser(String username, String password, String repeat,String email) {
		User user = User.find("account=?", username).first();
		if (user != null) {
			MessageUtil.generateErrorMsg("存在的用户名");
			register();
		} else if(!password.equals(repeat)){
			System.out.println("mm:"+password+"rp:"+repeat);
			MessageUtil.generateErrorMsg("两次输入密码不一致");
			register();
		}
		else if(email!=null){
			user = new User();
			user.account = username;
			user.passwd = password;
			user.email = email;
			user.save();
			MessageUtil.generateInfoMsg(flash, "注册成功，请登录");
			login();
		}
		else{
			MessageUtil.generateErrorMsg("请输入邮箱");
			register();
		}
     }

}
