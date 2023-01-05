package com.develovit.sita.datamodel;

public class LogbooksItem{
	private String date;
	private int thesisId;
	private Object notes;
	private int supervisorId;
	private String createdAt;
	private Object supervisedAt;
	private String fileProgress;
	private Object supervisedBy;
	private String problem;
	private String updatedAt;
	private String progress;
	private Object fileNotes;
	private int id;
	private int status;

	public String getDate(){
		return date;
	}

	public int getThesisId(){
		return thesisId;
	}

	public Object getNotes(){
		return notes;
	}

	public int getSupervisorId(){
		return supervisorId;
	}

	public String getCreatedAt(){
		return createdAt;
	}

	public Object getSupervisedAt(){
		return supervisedAt;
	}

	public String getFileProgress(){
		return fileProgress;
	}

	public Object getSupervisedBy(){
		return supervisedBy;
	}

	public String getProblem(){
		return problem;
	}

	public String getUpdatedAt(){
		return updatedAt;
	}

	public String getProgress(){
		return progress;
	}

	public Object getFileNotes(){
		return fileNotes;
	}

	public int getId(){
		return id;
	}

	public int getStatus(){
		return status;
	}
}
