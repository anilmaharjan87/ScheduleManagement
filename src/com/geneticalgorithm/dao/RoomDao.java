package com.geneticalgorithm.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.geneticalgorithm.domain.Room;

import connection.MySql;

public class RoomDao {
	public static void addRoom(Room room) {
		Connection con=null;
		try {
				 con=MySql.createConnection();
				String sql = "Insert into room" + "(room_number, capacity)" + "values(?,?)";
				PreparedStatement psmt=con.prepareStatement(sql);
				psmt.setString(1, room.getRoomNumber());
				psmt.setInt(2, room.getCapacity());
				psmt.executeUpdate();
			}catch(Exception e) {
				System.out.println("exception caught");
			}finally {
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
	}
}
