package com.ty.shopping.controller;

import com.ty.shopping.dao.UserDao;
import com.ty.shopping.dto.User;

public class TestValidate {
	public static void main(String[] args) {

		UserDao dao = new UserDao();
		User user = dao.validateUser("jim@gmail.com", "qwerty");
		if (user != null) {
			System.out.println("The details of user are :");
			System.out.println(user.getName());
			System.out.println(user.getMobile());

		} else {
			System.out.println("Wrong email or password");
		}
	}
}
