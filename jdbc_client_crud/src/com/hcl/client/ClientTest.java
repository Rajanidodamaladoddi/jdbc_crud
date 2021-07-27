package com.hcl.client;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import com.hcl.util.DBUtil;

public class ClientTest {

	public static void main(String[] args) {
		//createEmployee();
		  getEmployeeById();
		//getAllEmployeesInfo();
		//updateEmployeeEmailById();
		//deleteEmployeeById();
	}

	private static void deleteEmployeeById() {
		try(Connection connection = DBUtil.getConnection();
				Statement st = connection.createStatement();) {
			
			String SQLINSERT = "DELETE FROM employee_table WHERE employee_id=2";
			int executeUpdate = st.executeUpdate(SQLINSERT);
			if(executeUpdate ==1){
				System.out.println("Employee is deleted..");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	private static void updateEmployeeEmailById() {
		try(Connection connection = DBUtil.getConnection();
				Statement st = connection.createStatement();) {
			
			String SQLINSERT = "UPDATE employee_table set email='martin.cs2017@yahoo.com' WHERE employee_id=1";
			int executeUpdate = st.executeUpdate(SQLINSERT);
			if(executeUpdate ==1){
				System.out.println("Email is updated..");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private static void getAllEmployeesInfo() {
		 
		try (Connection connection = DBUtil.getConnection(); Statement st = connection.createStatement();) {
 
			String SQL = "SELECT *FROM employee_table";
			ResultSet rs = st.executeQuery(SQL);
			while (rs.next()) {
				int empId = rs.getInt("employee_id");
				String eName = rs.getString("employee_name");
				String email = rs.getString("email");
				Double salary = rs.getDouble("salary");
				BigDecimal bonus = rs.getBigDecimal("bonus");
 
				System.out.println(empId + "\t" + eName + "\t" + salary + "\t" + email + "\t" + bonus);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
 
	private static void getEmployeeById() {
 
		try (Connection connection = DBUtil.getConnection(); Statement st = connection.createStatement();) {
 
			String SQL = "SELECT *FROM employee_table WHERE employee_id=3";
			ResultSet rs = st.executeQuery(SQL);
			if (rs.next()) {
				int empId = rs.getInt("employee_id");
				String eName = rs.getString("employee_name");
				String email = rs.getString("email");
				Double salary = rs.getDouble("salary");
				BigDecimal bonus = rs.getBigDecimal("bonus");
 
				System.out.println(empId + "\t" + eName + "\t" + salary + "\t" + email + "\t" + bonus);
 
			} else {
				System.out.println("Employee doesn't exit with provided ID..");
			}
 
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	

	private static void createEmployee() {
		try(Connection connection = DBUtil.getConnection();
				Statement st = connection.createStatement();) {
			
			String SQLINSERT = "INSERT INTO employee_table(employee_name,email,salary,date_of_joining,bonus) "
					+ "VALUES('prem','prem@gmail.com',15000.00,'2019-11-30',15000.00)";
			int executeUpdate = st.executeUpdate(SQLINSERT);
			if(executeUpdate ==1){
				System.out.println("Employee is created..");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}