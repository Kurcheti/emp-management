package com.emp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.emp.utility.DBConnectionUtility;

public class AdminDAOImpl implements AdminDAO {
	PreparedStatement preparedStatement = null;
	ResultSet resultSet = null;

	private static String IS_VALID_ADMIN_QUERY = "SELECT COUNT(*) FROM ADMIN WHERE ADMIN_NAME = ? AND PASSWORD = ?";

	@Override
	public boolean isValidAdmin(String userName, String password) {
		Connection connection = DBConnectionUtility.getDBConnection();
		int count = 0;
		try {
			// prepare statement
			preparedStatement = connection.prepareStatement(IS_VALID_ADMIN_QUERY);
			if(preparedStatement !=null ) {
				preparedStatement.setString(1, userName);
				preparedStatement.setString(2, password);
				
				resultSet = preparedStatement.executeQuery();
				if(resultSet != null) {
					resultSet.next();
					count = resultSet.getInt(1);
				}
			}
		} catch (SQLException SQE) {
			SQE.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
			resultSet.close();
			preparedStatement.close();
			}catch (SQLException SQE) {
				SQE.printStackTrace();
			}
		}
		

		return count==1 ? true : false;
	}
}
