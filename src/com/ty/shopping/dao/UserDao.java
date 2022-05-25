package com.ty.shopping.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ty.shopping.dto.User;
import com.ty.shopping.util.AESalgorithm;
import com.ty.shopping.util.ConnectionObject;
import static com.ty.shopping.util.AppConstants.*;

public class UserDao {
	
	public User validateUser(String email,String password)
	{
		Connection connection=ConnectionObject.getConnection();
		String query="Select * from user where email=? and password=?";
		String enc = AESalgorithm.encrypt(password, SECRET_KEY);
		try {
			PreparedStatement preparedStatement=connection.prepareStatement(query);
			preparedStatement.setString(1,email);
			preparedStatement.setString(2,enc);
			ResultSet resultSet=preparedStatement.executeQuery();
			if(resultSet.next())
			{
				User user=new User();
				user.setId(resultSet.getInt(1));
				user.setName(resultSet.getString(2));
				user.setEmail(resultSet.getString(3));
				user.setMobile(resultSet.getLong(5));
				return user;
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
		return null;
		
	}
	
	public int saveUser(User user) {
		String query = "Insert into user values(?,?,?,?,?)";
		Connection connection = ConnectionObject.getConnection();
		try {
			String enc = AESalgorithm.encrypt(user.getPassword(), SECRET_KEY);
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, user.getId());
			preparedStatement.setString(2, user.getName());
			preparedStatement.setString(3, user.getEmail());
			preparedStatement.setString(4, enc);
			preparedStatement.setLong(5, user.getMobile());
			return preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

		}
		return 0;
	}
}
