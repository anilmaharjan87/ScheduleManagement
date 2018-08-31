package com.entity;

/**
 * Simple Room abstraction -- used to store the room capacity and compare against the student Group's size.
 */
public class Room {
	private  int roomId;
	private  String roomNumber;
	private int capacity;


	/**
	 * Initialize new Room
	 * 
	 * @param roomId
	 *            The ID for this classroom
	 * @param roomNumber
	 *            The room number
	 * @param capacity
	 *            The room capacity
	 */
	public Room(int roomId, String roomNumber, int capacity) {
		this.roomId = roomId;
		this.roomNumber = roomNumber;
		this.capacity = capacity;
	}

	/**
	 * Return roomId
	 * 
	 * @return roomId
	 */
	public int getRoomId() {
		return this.roomId;
	}

	/**
	 * Return room number
	 * 
	 * @return roomNumber
	 */
	public String getRoomNumber() {
		return this.roomNumber;
	}

	/**
	 * Return room capacity
	 * 
	 * @return capacity
	 */
	public int getRoomCapacity() {
		return this.capacity;
	}

	public void setRoomId(int roomId) {
		this.roomId = roomId;
	}

	public void setRoomNumber(String roomNumber) {
		this.roomNumber = roomNumber;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
}