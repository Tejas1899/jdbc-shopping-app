package com.ty.shopping.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ty.shopping.dto.Product;
import com.ty.shopping.util.ConnectionObject;

public class ProductDao {

	public int saveProduct(Product product) {
		String query = "Insert into product values(?,?,?,?,?)";
		Connection connection = ConnectionObject.getConnection();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, product.getId());
			preparedStatement.setString(2, product.getName());
			preparedStatement.setString(3, product.getBrand());
			preparedStatement.setString(4, product.getType());
			preparedStatement.setDouble(5, product.getCost());
			return preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return 0;
	}

	public List<Product> getAllProduct() {
		String query = "Select * from product";
		Connection connection = ConnectionObject.getConnection();
		List list = new ArrayList();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Product product = new Product();
				int id = resultSet.getInt(1);
				String name = resultSet.getString(2);
				String brand = resultSet.getString(3);
				String type = resultSet.getString(4);
				double cost = resultSet.getDouble(5);
				product.setId(id);
				product.setName(name);
				product.setBrand(brand);
				product.setType(type);
				product.setCost(cost);
				list.add(product);
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	public void getProductById(int id) {
		Connection connection = ConnectionObject.getConnection();
		String query = "Select * from product where id=?";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, id);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				System.out.println(resultSet.getInt("id"));
				System.out.println(resultSet.getString("name"));
				System.out.println(resultSet.getString("brand"));
				System.out.println(resultSet.getString("type"));
				System.out.println(resultSet.getDouble("cost"));
			} else {
				System.out.println("No details available for this id :" + id);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	public void getProductByBrand(String brand) {
		Connection connection = ConnectionObject.getConnection();
		String query = "Select * from product where brand=?";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, brand);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				System.out.println(resultSet.getInt("id"));
				System.out.println(resultSet.getString("name"));
				System.out.println(resultSet.getString("brand"));
				System.out.println(resultSet.getString("type"));
				System.out.println(resultSet.getDouble("cost"));
			} else {
				System.out.println("No details available for this brand :" + brand);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}
	
	public void getProductByBrandAndType(String brand,String type)
	{
		Connection connection = ConnectionObject.getConnection();
		String query = "Select * from product where brand=? and type=?";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, brand);
			preparedStatement.setString(2,type);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				System.out.println(resultSet.getInt("id"));
				System.out.println(resultSet.getString("name"));
				System.out.println(resultSet.getString("brand"));
				System.out.println(resultSet.getString("type"));
				System.out.println(resultSet.getDouble("cost"));
			} else {
				System.out.println("No details available for this brand :"+brand+"and type :"+type);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
