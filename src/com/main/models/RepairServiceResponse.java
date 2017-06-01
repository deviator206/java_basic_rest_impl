package com.main.models;

public class RepairServiceResponse extends MainResponse{

	private int[] recordsCreated;
	private String repairReceiptId;

	public void setCreatedProductList(int[] recordsAffected) {
		this.recordsCreated = recordsAffected;
		
	}

	public void setRepairReceiptId(String string) {
		this.repairReceiptId = string;
		
	}

}
