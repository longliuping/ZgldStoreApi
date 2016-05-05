package com.zgld.api.test;

import java.lang.reflect.Type;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.zgld.api.beans.GsonBean;
import com.zgld.api.beans.YRebateLevel;
import com.zgld.api.utils.HttpUtil;

public class Test {
	public static String pwd(String pwd, String passwordformat) {
		String json = HttpUtil.submitPost("http://114.215.198.143:55/Home/index",
				"password=" + pwd + "&passwordformat=1&PasswordSalt=" + passwordformat).toString();
		if (json != null && !json.isEmpty()) {
			Gson g = new Gson();
			Type entityType = new TypeToken<GsonBean>() {
			}.getType();
			GsonBean gsonBean = g.fromJson(json, entityType);
			return gsonBean.getPassword();
		} else {
			return "";
		}
	}

	public static void main(String[] args) {
//		pwd("123456", "n2FiT+glPSuqrahoRrP7Og==");
		System.out.println(proportion (100.0, 20));
	}
	public static Double proportion (Double price,int number){
		return (price*number)/100;
	}
	
}
