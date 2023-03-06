package com.emp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.emp.model.Employee;
import com.emp.utility.DBConnectionUtility;

public class EmployeeDAOImpl implements EmployeeDAO {
	private String EMP_CREATE_QUERY = "INSERT INTO EMPLOYEE (EMP_ID, EMP_NAME, EMP_MOB, EMP_MAIL, COUNTRY, STATE, ADDRESS, PASSWORD) "
									  + "VALUES (EMP_ID_SEQ.NEXTVAL, ?, ?, ?, ?, ?, ?, ?)";
	
	PreparedStatement preparedStatementObj;
	long count = 0;
	
	@Override
	public boolean createEmployee(Employee employee) {
		
		try {
			//get DB Connection obj
			 Connection connection = DBConnectionUtility.getDBConnection();
			
			//create prepared statement
			if(connection != null) {
				PreparedStatement preparedStatementObj = connection.prepareStatement(EMP_CREATE_QUERY);
				if(preparedStatementObj != null) {
					preparedStatementObj.setString(1, employee.getName());
					preparedStatementObj.setString(2, employee.getMobile());
					preparedStatementObj.setString(3, employee.getEmail());
					preparedStatementObj.setString(4, employee.getCountry());
					preparedStatementObj.setString(5, employee.getState());
					preparedStatementObj.setString(6, employee.getAddress());
					preparedStatementObj.setString(7, employee.getPassword());
					count = preparedStatementObj.executeLargeUpdate();
				}
			}
			
		} catch (SQLException sqe) {
			sqe.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			
		}
		
		return count >= 1 ? true : false;
	}

}
