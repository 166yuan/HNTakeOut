package utils;

import models.Admin;
import models.User;

public class DatabaseUtil {
	public static void init() {
		User user=new User();
		user.account="123";
		user.passwd="1234";
		user.save();
	}
}
