package com.main;

import java.util.HashMap;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import com.main.impl.GenerateInvoiceOnlyImpl;
import com.main.impl.PaymentDetailsImpl;
import com.main.models.ProductServiceResponse;

@Path("/invoice/")
public class GenerateInvoiceService {
	
	@Path("sales")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public ProductServiceResponse createSalesInvoice(JSONObject orderInfo) throws JSONException{
		GenerateInvoiceOnlyImpl generateInvoiceOnlyImpl = new GenerateInvoiceOnlyImpl();
		HashMap<String, String> invoiceInformation = generateInvoiceOnlyImpl.getNewInvoice();
		ProductServiceResponse productServiceResponse = new ProductServiceResponse();
		productServiceResponse.setStatus(false);
		if (invoiceInformation.size() > 0){
			System.out.println(invoiceInformation);
			PaymentDetailsImpl paymentDetailsImpl = new PaymentDetailsImpl();
			paymentDetailsImpl.setPaymentInfo(orderInfo.getJSONObject("paymentInfo"));
			paymentDetailsImpl.setInvoiceInfo(invoiceInformation);
			boolean success  = paymentDetailsImpl.updatePaymentDetails();
			if (success){
				productServiceResponse.setStatus(success);
			}
		}
		return productServiceResponse;
	}
	
	
	public static void main(String[] args) {
		GenerateInvoiceOnlyImpl generateInvoiceOnlyImpl = new GenerateInvoiceOnlyImpl();
		HashMap<String, String> invoiceInformation = generateInvoiceOnlyImpl.getNewInvoice();
		System.out.println(invoiceInformation);
		
		PaymentDetailsImpl paymentDetailsImpl = new PaymentDetailsImpl();
		JSONObject orderInfo = new JSONObject();
		
		try {
			JSONObject paymentInfo = new JSONObject();
			//paymentInfo.put("type", "CASH");
			//paymentInfo.put("cash", "7899");
			
			//paymentInfo.put("type", "CARD");
			//paymentInfo.put("cardNumber", "7899213891321239123");
			//paymentInfo.put("bankName", "State Bank Of Baroda and standarad chartered bank");
			
	
			paymentInfo.put("type", "CHEQ");
			paymentInfo.put("cheqNo", "989898988");
			paymentInfo.put("cheqDate", "23/23/1230");
			paymentInfo.put("bankName", "JANA GANA MANA");
	
			
			orderInfo.put("paymentInfo", paymentInfo);
			paymentDetailsImpl.setPaymentInfo(orderInfo.getJSONObject("paymentInfo"));
			paymentDetailsImpl.setInvoiceInfo(invoiceInformation);
			boolean success  = paymentDetailsImpl.updatePaymentDetails();
			System.out.println(success);
			
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
