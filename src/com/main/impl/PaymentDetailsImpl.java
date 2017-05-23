package com.main.impl;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

public class PaymentDetailsImpl extends ServiceBase{
	
	private JSONObject paymentInfo;
	private HashMap<String, String> invoiceInformation;
	
	private String COL_CASH = "cash";
	private String COL_INVOICE = "invoice_id";
	private String COL_TIN ="invoice_tin";
	private String PAYMENT_TABLE="PAYMENT_DETAILS_TABLE";
	private String COL_CARD_NO ="cardNo";
	private String COL_BANK_NAME="bankName";
	private String COL_CHEQ_NO ="cheqNo";
	private String COL_CHEQ_DATE= "cheqDate";
	
	public void setPaymentInfo(JSONObject jsonObject) {
		this.paymentInfo = jsonObject;
		
	}

	public void setInvoiceInfo(HashMap<String, String> invoiceInformation2) {
		this.invoiceInformation = invoiceInformation2;
		
	}

	public boolean updatePaymentDetails() {
		boolean success =false;
		this.getConnection();
		try {
			PreparedStatement preparedStmt =  getQueryBasedOnInput();
		    int count = preparedStmt.executeUpdate();
		    if (count > 0){
		    	success = true;
		    }
		    this.dbConnection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		
		return success;
	}

	private PreparedStatement getQueryBasedOnInput() throws JSONException, SQLException {
		
		String query = "" ;
		PreparedStatement preparedStmt = null ;
	    	if(this.paymentInfo.getString("type").equals("CASH")) {
				//insert into PAYMENT_DETAILS_TABLE(cash,invoice_id,invoice_tin) values ('5000','CE/2017-18/6','2763039355V');
				query = "insert into "+this.PAYMENT_TABLE+"("+this.COL_CASH+","+this.COL_INVOICE+","+this.COL_TIN+") values (?,?,?)";
				//("+this.paymentInfo.getString("cash")+","+this.invoiceInformation.get("invoice")+","+this.invoiceInformation.get("vatTinNumber")+")
				preparedStmt =  this.dbConnection.prepareStatement(query);
				preparedStmt.setString(1, this.paymentInfo.getString("cash"));
				preparedStmt.setString(2, this.invoiceInformation.get("invoice"));
				preparedStmt.setString(3, this.invoiceInformation.get("vatTinNumber"));
				
			} else if(this.paymentInfo.getString("type").equals("CARD")) {
				//insert into PAYMENT_DETAILS_TABLE(cardNo,bankName,invoice_id,invoice_tin) values ('345678093234324823418','Standarad Chartered Bank','CE/2017-18/6','2763039355V');
				query = "insert into "+this.PAYMENT_TABLE+"("+this.COL_CARD_NO+","+this.COL_BANK_NAME+","+this.COL_INVOICE+","+this.COL_TIN+") values (?,?,?,?)";
				//("+this.paymentInfo.getString("cardNumber")+","+this.paymentInfo.getString("bankName")+","+this.invoiceInformation.get("invoice")+","+this.invoiceInformation.get("vatTinNumber")+")"
				preparedStmt =  this.dbConnection.prepareStatement(query);
				
				preparedStmt.setString(1, this.paymentInfo.getString("cardNumber"));
				preparedStmt.setString(2, this.paymentInfo.getString("bankName"));
				preparedStmt.setString(3, this.invoiceInformation.get("invoice"));
				preparedStmt.setString(4, this.invoiceInformation.get("vatTinNumber"));
				

			} else if(this.paymentInfo.getString("type").equals("CHEQ")) {
				//insert into PAYMENT_DETAILS_TABLE(cheqNo,cheqDate,bankName,invoice_id,invoice_tin) values ('345678093218','12/6/2017','SBI','CE/2017-18/6','2763039355V');
				query = "insert into "+this.PAYMENT_TABLE+"("+this.COL_CHEQ_NO+","+this.COL_CHEQ_DATE+","+this.COL_BANK_NAME+","+this.COL_INVOICE+","+this.COL_TIN+") values (?,?,?,?,?)";
				// ("+this.paymentInfo.getString("cheqNo")+","+this.paymentInfo.getString("cheqDate")+","+this.paymentInfo.getString("bankName")+","+this.invoiceInformation.get("invoice")+","+this.invoiceInformation.get("vatTinNumber")+")
				preparedStmt =  this.dbConnection.prepareStatement(query);
				preparedStmt.setString(1, this.paymentInfo.getString("cheqNo"));
				preparedStmt.setString(2, this.paymentInfo.getString("cheqDate"));
				preparedStmt.setString(3, this.paymentInfo.getString("bankName"));
				preparedStmt.setString(4, this.invoiceInformation.get("invoice"));
				preparedStmt.setString(5, this.invoiceInformation.get("vatTinNumber"));
				
			}
		return preparedStmt;
	}

}
