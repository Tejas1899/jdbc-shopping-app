package com.ty.shopping.controller;

import java.util.List;

import com.ty.shopping.dao.ProductDao;
import com.ty.shopping.dto.Product;

public class ProductController {
	public static void main(String[] args) {
//	Product product=new Product();
//	product.setId(5);
//	product.setName("Mobile");
//	product.setBrand("VIVO");
//	product.setType("Android");
//	product.setCost(10000.00);
//	ProductDao dao=new ProductDao();
//	dao.saveProduct(product);
//	if(product!=null)
//	{
//		System.out.println("Data Inserted");
//	}
//	else
//	{
//		System.out.println("Data not inserted");
//	}
	
//		ProductDao dao=new ProductDao();
//	    List list=dao.getAllProduct();	
//		System.out.println(list);
		
		ProductDao dao=new ProductDao();
		dao.getProductById(6);
		
		
	}
}
