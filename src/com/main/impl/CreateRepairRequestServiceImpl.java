package com.main.impl;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.HashMap;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import com.main.models.RepairServiceResponse;

public class CreateRepairRequestServiceImpl extends ServiceBase {
	/*
	 * 
	 * create table SERVICE_INFO_TABLE ( id int(30) not null auto_increment,
	 * customerId int not null ,
	 * 
	 * productName varchar(60), productModel varchar(60), productSN varchar(60),
	 * 
	 * userId int not null ,
	 * 
	 * accessoryList varchar(60), problemList varchar(60), isCourier boolean
	 * default false, courierName varchar(30), courierPhone varchar(30),
	 * techComment varchar(120), shopUserComment varchar(120), customerComment
	 * varchar(120), serviceStatus varchar(20), primary key (id), FOREIGN
	 * KEY(customerId) REFERENCES SERVICE_CUSTOMER_TABLE(id), FOREIGN
	 * KEY(userId) REFERENCES validEmporiumUser(empId) )
	 * 
	 * 
	 * 
	 */

	private String SERVICE_INFO_TABLE = "SERVICE_INFO_TABLE";
	private String customerId = "customerId";
	private String productName = "productName";
	private String productModel = "productModel";
	private String productSN = "productSN";
	private String userId = "userId";
	private String accessoryList = "accessoryList";
	private String problemList = "problemList";
	private String isCourier = "isCourier";
	private String courierName = "courierName";
	private String courierPhone = "courierPhone";
	private String techComment = "techComment";
	private String shopUserComment = "shopUserComment";
	private String customerComment = "customerComment";
	private String serviceStatus = "serviceStatus";
	private String courierDocumentNo = "courierDocumentNo";
	private String service_order_date = "service_order_date";
	private String service_completion_date = "service_completion_date";
	private String service_order_number = "service_order_number";

	private String actual_service_cost = "actual_service_cost";
	private String tentative_quoted_cost = "tentative_quoted_cost";
	private String tentative_service_completion_date = "tentative_service_completion_date";
	public String vatTinNumber = "vatTinNumber";

	public String taxName = "taxName";
	public String taxRate = "taxRate";
	public String taxValue = "taxValue";

	private JSONObject customerInfo;
	private JSONObject courierInfo;
	private JSONObject tecnicianInfo;
	private JSONArray productInfo; // contains tax & taxtype & tax rate & tax
									// value
	private JSONObject userInfo;
	private Timestamp serviceCreationDate;
	private Timestamp serviceCompletionDate;
	private Timestamp tentaiveServiceCompletionDate;
	private String tentaiveServiceCost;
	private String finalServiceCost;
	private JSONObject taxInfo;
	private String serviceInvoiceNumber;
	private JSONObject paymentInfo;
	private String advancedPayment;

	public void execute() throws InternalError, JSONException, SQLException {
		this.getConnection();
		int customerValidID;
		RepairServiceResponse repairServiceResponse = new RepairServiceResponse();
		repairServiceResponse.setStatus(false);

		if (this.userInfo.getString("id") == null || this.userInfo.getString("id").equals("")) {
			throw new InternalError("SHOP USER INFORMATION NOT PROVIDED");
		}
		// createCustomer if not created
		if (customerInfo.getString("id") == null || customerInfo.getString("id").equals("")) {
			// create customer
			CustomerServiceImpl customerServiceImpl = new CustomerServiceImpl();
			customerServiceImpl.setUserName(customerInfo.getString("name"));
			customerServiceImpl.setUserAddress(customerInfo.getString("address"));
			customerServiceImpl.setUserPhone(customerInfo.getString("phone"));
			customerServiceImpl.execute();
			customerValidID = customerServiceImpl.getCustomerCreationResponse().getId();
		} else {
			customerValidID = Integer.parseInt(customerInfo.getString("id"));
		}

		GenerateInvoiceOnlyImpl generateInvoiceOnlyImpl = new GenerateInvoiceOnlyImpl();
		generateInvoiceOnlyImpl.SALES_INVOICE_TABLE = "REPAIR_INVOICE_TABLE";
		HashMap<String, String> invoiceInformation = generateInvoiceOnlyImpl.getNewInvoice();

		String sql = "insert into " + this.SERVICE_INFO_TABLE + " (" + this.customerId + ", " + this.productName + ", "
				+ this.productModel + "," + this.productSN + "," + this.accessoryList + "," + this.problemList + ","
				+ this.shopUserComment + "," + this.customerComment + "," + this.serviceStatus + ","
				+ this.tentative_quoted_cost + "," + this.tentative_service_completion_date + ","
				+ this.service_order_date + ","

				+ this.service_order_number + "," + this.vatTinNumber + ","

				+ this.isCourier + "," + this.courierName + "," + this.courierPhone + "," + this.courierDocumentNo + ","

				+ this.userId + "," + this.advancedPayment + "," + this.taxName + "," + this.taxRate + ","
				+ this.taxValue + ") "
						+ "							  values (?, ?, ?, ?, ?" 
				+ "											  ?, ?, ?, ?, ?"
				+ " 										  ?, ? , ?, ?, ?"
				+ "											  ?, ?, ?, ?, ?"
				+ "											  ?, ?, ?)";

		PreparedStatement ps = this.dbConnection.prepareStatement(sql);
		this.dbConnection.setAutoCommit(false);
		for (int productLoop = 0; productLoop < this.productInfo.length(); productLoop++) {
			JSONObject singleProduct = (JSONObject) this.productInfo.get(productLoop);
			ps.setInt(1, customerValidID);
			ps.setString(2, singleProduct.getString("name"));
			ps.setString(3, singleProduct.getString("model"));
			ps.setString(4, singleProduct.getString("sn"));
			ps.setString(5, singleProduct.getString("accessoryList"));
			ps.setString(6, singleProduct.getString("problemList"));
			ps.setString(7, singleProduct.getString("shopUserComment"));
			ps.setString(8, singleProduct.getString("customerComment"));
			ps.setString(9, "IN_PROGRESS");
			ps.setString(10, singleProduct.getString("tentative_quoted_cost"));
			ps.setTimestamp(11, Timestamp.valueOf(singleProduct.getString("tentative_service_completion_date")));
			ps.setTimestamp(12, Timestamp.valueOf(singleProduct.getString("service_order_date")));

			ps.setString(13, invoiceInformation.get("invoice"));
			ps.setString(14, invoiceInformation.get("vatTinNumber"));

			ps.setBoolean(15, this.courierInfo.getBoolean("isCourier"));
			ps.setString(16, this.courierInfo.getString("courierName"));
			ps.setString(17, this.courierInfo.getString("courierPhone"));
			ps.setString(18, this.courierInfo.getString("courierDocumentNo"));
			ps.setString(19, this.userInfo.getString("id"));
			ps.setString(20, this.paymentInfo.getString("advancePayment"));

			ps.setString(21, singleProduct.getString("taxType"));
			ps.setString(22, singleProduct.getString("taxRate"));
			ps.setString(23, singleProduct.getString("taxValue"));

			ps.addBatch();

		}

		int[] recordsAffected = ps.executeBatch();
		if (recordsAffected.length == this.productInfo.length()) {
			repairServiceResponse.setStatus(true);
			repairServiceResponse.setCreatedProductList(recordsAffected);
		}

		repairServiceResponse.setRepairReceiptId(invoiceInformation.get("invoice"));
		this.dbConnection.commit();
		ps.close();
		this.dbConnection.close();

	}

	public void setCustomerInfo(JSONObject jsonObject) {
		this.customerInfo = jsonObject;

	}

	public void setProductInfo(JSONArray jsonArray) {
		this.productInfo = jsonArray;

	}

	public void setCourierInfo(JSONObject jsonObject) {
		this.courierInfo = jsonObject;

	}

	public void setTechnicianInfo(JSONObject jsonObject) {
		this.tecnicianInfo = jsonObject;

	}

	public void setUserInfo(JSONObject jsonObject2) {
		this.userInfo = jsonObject2;

	}

	public void setPaymentInfo(JSONObject jsonObject2) {
		this.paymentInfo = jsonObject2;

	}
}
