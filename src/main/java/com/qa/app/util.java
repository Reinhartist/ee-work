package com.qa.app;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class util {

	public static Gson gson = new Gson();

	public static String toJson(Object obj) {
		return gson.toJson(obj);
	}
	
	public static Person fromJson(String s) {
		return gson.fromJson(s, Person.class);
	}
}
