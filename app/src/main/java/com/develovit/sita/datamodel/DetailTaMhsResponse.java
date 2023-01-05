package com.develovit.sita.datamodel;

import java.util.List;

public class DetailTaMhsResponse{
	private int count;
	private List<LogbooksItem> logbooks;
	private String status;

	public int getCount(){
		return count;
	}

	public List<LogbooksItem> getLogbooks(){
		return logbooks;
	}

	public String getStatus(){
		return status;
	}
}