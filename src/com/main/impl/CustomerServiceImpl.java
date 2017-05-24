package com.main.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.main.models.CustomerServiceResponse;

public class CustomerServiceImpl  extends ServiceBase {
	private CustomerServiceResponse customerServiceResponse;
	
	private String userName;
	private String userAddress;
	private String userPhone;
	
	public String CUSTOMER_TABLE = "EMP_CUSTOMER_TABLE";
	public String COL_USER_NAME ="name";
	private String COL_USER_ADDRESS="address";
	private String COL_USER_PHONE="phone";

	public void setUserName(String str) {
		this.userName = str;
		
	}

	public void setUserAddress(String str) {
		this.userAddress = str;
		
	}

	public void setUserPhone(String str) {
		this.userPhone = str;
		
	}

	public void execute() {
		
		this.getConnection();
		customerServiceResponse = new CustomerServiceResponse();
		try {
			customerServiceResponse.setStatus(false);
			String query = " insert into "+CUSTOMER_TABLE+" ("+this.COL_USER_NAME+", "+this.COL_USER_ADDRESS+","+this.COL_USER_PHONE+")"
			        + " values (?, ?, ?)";
			
			PreparedStatement preparedStmt =  this.dbConnection.prepareStatement(query,Statement.RETURN_GENERATED_KEYS);
		    preparedStmt.setString (1, this.userName);
		    preparedStmt.setString (2, this.userAddress);
		    preparedStmt.setString   (3, this.userPhone);

		    int count = preparedStmt.executeUpdate();
		    if (count > 0) {
		    	customerServiceResponse.setStatus(true);
		    }
		    
		    customerServiceResponse.setName(this.userName);
		    customerServiceResponse.setAddress(this.userAddress);
		    customerServiceResponse.setPhone(this.userPhone);
		    ResultSet rs = preparedStmt.getGeneratedKeys();
		    if (rs != null && rs.next()) {
		    	customerServiceResponse.setId(rs.getInt(1));
		    	
		    }
		    System.out.println(count);
		    this.dbConnection.close();  
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
		
		
		
	}

	public CustomerServiceResponse getCustomerCreationResponse() {
		// TODO Auto-generated method stub
		return customerServiceResponse;
	}

}
