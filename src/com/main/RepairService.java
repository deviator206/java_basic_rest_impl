package com.main;

import java.sql.SQLException;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import com.main.impl.CreateRepairRequestServiceImpl;
import com.main.models.CustomerServiceResponse;
import com.main.models.RepairServiceResponse;

@Path("/repair/")
public class RepairService {
	
	@Path("drop-from-customer")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public RepairServiceResponse createRepairRequest(JSONObject repairRequest) throws JSONException, InternalError, SQLException{
		CreateRepairRequestServiceImpl createRepairRequestServiceImpl = new CreateRepairRequestServiceImpl();
		//createRepairRequestServiceImpl.setCustomerInfo(repairRequest.get("customerInfo"))
		createRepairRequestServiceImpl.setCustomerInfo(repairRequest.getJSONObject("customerInfo"));
		createRepairRequestServiceImpl.setProductInfo(repairRequest.getJSONArray("productInfo"));
		createRepairRequestServiceImpl.setCourierInfo(repairRequest.getJSONObject("courierInfo"));
		//createRepairRequestServiceImpl.setTechnicianInfo(repairRequest.getJSONObject("technicianInfo"));
		createRepairRequestServiceImpl.setUserInfo(repairRequest.getJSONObject("userInfo"));
		createRepairRequestServiceImpl.setPaymentInfo(repairRequest.getJSONObject("paymentInfo"));
		createRepairRequestServiceImpl.execute();
		
		return null;
		
	}

}
