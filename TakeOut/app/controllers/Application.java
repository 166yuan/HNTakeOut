package controllers;

import play.*;
import play.cache.Cache;
import play.libs.Images;
import play.mvc.*;

import java.util.*;

import models.*;

public class Application extends Controller {

    public static void index() {
       Users.login();
    }
    
    /**通用
     * @param id 任意id
     */
    public static void captcha(String Rid) {
        Images.Captcha captcha = Images.captcha();
        String code = captcha.getText("#E4EAFD");
        System.out.println("appid:"+Rid);
        System.out.println("code:"+code);
        Cache.set(Rid, code, "8h");
        System.out.println(Cache.get(Rid));
        renderBinary(captcha,code);
    }
}