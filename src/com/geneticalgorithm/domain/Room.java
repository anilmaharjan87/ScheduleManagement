package com.geneticalgorithm.domain;

public class Room {
	
	private String roomNumber;
	private int capacity;

	
	public String getRoomNumber() {
		return roomNumber;
	}

	public int getCapacity() {
		return capacity;
	}

	public Room(String roomNumber, int capacity) {


		this.roomNumber = roomNumber;
		this.capacity = capacity;
	}

	@Override
	public String toString() {
		return "RoomDao [ roomNumber=" + roomNumber + ", capacity=" + capacity + "]";
	}

}
