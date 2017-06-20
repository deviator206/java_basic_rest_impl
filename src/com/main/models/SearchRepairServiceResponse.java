package com.main.models;

import java.util.ArrayList;
import java.util.List;

public class SearchRepairServiceResponse extends MainResponse {
	
	public List<RepairRequestResponse> searchResults = new ArrayList<>();

	public List<RepairRequestResponse> getSearchResults() {
		return searchResults;
	}

	public void setSearchResults(List<RepairRequestResponse> responseSearchResult) {
		this.searchResults = responseSearchResult;
	}

}
