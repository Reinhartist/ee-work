package com.qa.app;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class util {

	public static Gson gson = new Gson();

	public static String toJson(Object obj) {
		return gson.toJson(obj);
	}
	
	public static <T> T fromJson(String s, Class<T> t) {
		return gson.fromJson(s, t);
	}
}
