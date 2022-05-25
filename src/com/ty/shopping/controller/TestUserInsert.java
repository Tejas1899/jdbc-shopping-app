package com.ty.shopping.controller;

import com.ty.shopping.dao.UserDao;
import com.ty.shopping.dto.User;

public class TestUserInsert {
public static void main(String[] args) {
	User user=new User();
	user.setId(4);
	user.setName("jim");
	user.setEmail("jim@gmail.com");
	user.setPassword("qwerty");
	user.setMobile(79876465);
	
	UserDao dao=new UserDao();
	int res=dao.saveUser(user);
	if(res>0)
	{
		System.out.println("Data inserted");
	}
	else
	{
		System.out.println("Data not inserted");
	}
}
}
