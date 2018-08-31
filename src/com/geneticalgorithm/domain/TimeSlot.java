package com.geneticalgorithm.domain;

public class TimeSlot {
private String timeSlot;

public TimeSlot(String timeSlot) {
	
	this.timeSlot = timeSlot;
}

public String getTimeSlot() {
	return timeSlot;
}

@Override
public String toString() {
	return "TimeSlot [timeSlot=" + timeSlot + "]";
}

}
