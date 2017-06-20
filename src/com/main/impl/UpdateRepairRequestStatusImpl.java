package com.main.impl;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import com.main.models.UpdateRepairServiceResponse;

public class UpdateRepairRequestStatusImpl extends ServiceBase {
	private JSONArray updatedProductList ;
	private UpdateRepairServiceResponse updateRepairServiceResponse;

	public void execute() throws SQLException, JSONException {
		this.getConnection();
		
		Statement stmt;
		stmt = this.dbConnection.createStatement();
		int counter =0;
		updateRepairServiceResponse = new UpdateRepairServiceResponse();
		
		for (int i =0; i< updatedProductList.length();i++) {
			String sql = "update  SERVICE_INFO_TABLE set serviceStatus = ?,  techComment = ? where  service_order_number = ? AND id = ?";
			PreparedStatement ps = this.dbConnection.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
			JSONObject jo =  updatedProductList.getJSONObject(i);
			ps.setString(3, jo.getString("serviceNumber"));
			ps.setString(4, jo.getString("itemId"));
			ps.setString(1, jo.getString("status"));
			ps.setString(2, jo.getString("techComment"));
			counter = ps.executeUpdate();
			if (counter > 0){
				updateRepairServiceResponse.setStatus(true);
			}
			break;
		}
	}

	public UpdateRepairServiceResponse getSearchResult() {
		return this.updateRepairServiceResponse;
	}

	public void setUpdatedProductList(JSONArray jsonObject) {
		this.updatedProductList = jsonObject;
		
	}

}
