package com.geneticalgorithm.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.geneticalgorithm.domain.TimeClass;
import com.geneticalgorithm.domain.TimeSlot;

import connection.MySql;

public class TimeSlotDAO {
	public static void addTimeSlot(TimeSlot timeslot) {
		Connection con =null;
		try {
			 con = MySql.createConnection();
			String sql = "Insert into timeslot" + "(timeslot)" + "values(?)";
			PreparedStatement psmt = con.prepareStatement(sql);
			psmt.setString(1, timeslot.getTimeSlot());

			psmt.executeUpdate();
		} catch (Exception e) {
			System.out.println("exception caught");
		}
	}
	public static List<TimeSlot> getTimeSlot() {
		Connection con =null;
		try {
			List<TimeSlot> timeSlots = new ArrayList<>();
		 con = MySql.createConnection();
			String sql = "SELECT * from timeslot";
			PreparedStatement psmt = con.prepareStatement(sql);
			ResultSet rs = psmt.executeQuery();
			while (rs.next()) {
				
				String timeSlot=rs.getString("timeslot");
				
				TimeSlot tempTimeSlot = new TimeSlot(timeSlot);
				timeSlots.add(tempTimeSlot);
			}
			return timeSlots;
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}
}
