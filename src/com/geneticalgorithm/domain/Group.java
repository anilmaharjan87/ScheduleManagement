package com.geneticalgorithm.domain;

public class Group {
private int groupId;
private String groupName;
private int groupSize;
public Group(int groupId, String groupName, int groupSize) {
	super();
	this.groupId = groupId;
	this.groupName = groupName;
	this.groupSize = groupSize;
}
public int getGroupId() {
	return groupId;
}
public void setGroupId(int groupId) {
	this.groupId = groupId;
}
public String getGroupName() {
	return groupName;
}
public void setGroupName(String groupName) {
	this.groupName = groupName;
}
public int getGroupSize() {
	return groupSize;
}
public void setGroupSize(int groupSize) {
	this.groupSize = groupSize;
}
public Group() {
	super();
}

}
