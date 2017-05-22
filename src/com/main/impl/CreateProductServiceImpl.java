package com.main.impl;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import com.main.models.CustomerServiceResponse;
import com.main.models.ProductServiceResponse;

public class CreateProductServiceImpl extends ServiceBase {
	private JSONArray productList ;
	private ProductServiceResponse productServiceResponse;
	
	public String PRODUCT_TABLE = "EMP_PRODUCT_TABLE";
	public String COL_BRAND_NAME ="brandName";
	public String COL_BRAND_MODEL="brandModel";
	public String COL_SN="serialNumber";
	private String COL_PRICE="price";
	private String COL_TAXT_TYPE="tax_type";

	public void setBrandName(String string) {
		// TODO Auto-generated method stub
		
	}

	public void setProductList(JSONArray productList) {
		this.productList = productList;
		
	}

	public void executeCreation() {
		this.getConnection();
		productServiceResponse = new ProductServiceResponse();
		try {
			productServiceResponse.setStatus(false);
			productServiceResponse.setCounter(0);
			
			for (int i=0;i <this.productList.length();i++) {
				JSONObject singleProduct = (JSONObject) this.productList.get(i);
				if (singleProduct.getString("isNew").toLowerCase() == "true") {
					String query = " insert into "+PRODUCT_TABLE+" ("+this.COL_BRAND_NAME+", "+this.COL_BRAND_MODEL+","+this.COL_SN+","+this.COL_PRICE+","+this.COL_TAXT_TYPE+")"
					        + " values (?, ?, ?,?,?)";
					PreparedStatement preparedStmt =  this.dbConnection.prepareStatement(query);
				    preparedStmt.setString(1, singleProduct.getString("brandName"));
				    preparedStmt.setString(2, singleProduct.getString("brandModel"));
				    preparedStmt.setString(3, singleProduct.getString("serialNumber"));
				    preparedStmt.setInt(4, singleProduct.getInt("price"));
				    preparedStmt.setString(5, singleProduct.getString("taxType"));
				    int count = preparedStmt.executeUpdate();
				    if (count > 0) {
				    	productServiceResponse.setStatus(true);
				    	productServiceResponse.incrementCounter();
				    }
				    System.out.println(productServiceResponse.getCounterValue());
				}
			}
			
			this.dbConnection.close();  
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
		
		
	}

	public ProductServiceResponse getResponse() {
		return productServiceResponse;
	}

}
