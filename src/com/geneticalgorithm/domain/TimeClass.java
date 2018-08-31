package com.geneticalgorithm.domain;

public class TimeClass {
	private String groupName;
	private String subjectCode;
	private String roomNumber;
	private String timeSlot;
	private String subjectName;
	public String getSubjectName() {
		return this.subjectName;
	}
	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}
	private String professorName;
	public String getProfessorName() {
		return professorName;
	}
	public void setProfessorName(String professorName) {
		this.professorName = professorName;
	}

	public TimeClass() {
	}

	public TimeClass(String groupName, String subjectCode, String roomNumber, String timeSlot, String professorName, String subjectName) {
		super();
		this.groupName = groupName;
		this.subjectCode = subjectCode;
		this.subjectName=subjectName;
		this.roomNumber = roomNumber;
		this.timeSlot = timeSlot;
		this.professorName = professorName;
	}
	
	@Override
	public String toString() {
		return "TimeClass [groupName=" + groupName + ", subjectCode=" + subjectCode + ", roomNumber=" + roomNumber
				+ ", timeSlot=" + timeSlot + ", subjectName=" + subjectName + ", professorName=" + professorName + "]";
	}
	public String getGroupName() {
		return groupName;
	}
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
	public String getSubjectCode() {
		return subjectCode;
	}
	public void setSubjectCode(String subjectCode) {
		this.subjectCode = subjectCode;
	}
	public String getRoomNumber() {
		return roomNumber;
	}
	public void setRoomNumber(String roomNumber) {
		this.roomNumber = roomNumber;
	}
	public String getTimeSlot() {
		return timeSlot;
	}
	public void setTimeSlot(String timeSlot) {
		this.timeSlot = timeSlot;
	}
	public TimeClass(String groupName, String subjectCode, String roomNumber, String timeSlot) {
		super();
		
		this.groupName = groupName;
		this.subjectCode = subjectCode;
		this.roomNumber = roomNumber;
		this.timeSlot = timeSlot;
	}
	
}
