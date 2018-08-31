package com.geneticalgorithm.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.geneticalgorithm.domain.Professor;
import com.geneticalgorithm.domain.Subject;
import com.geneticalgorithm.domain.TimeClass;

import connection.MySql;

public class ClassDao {

	public static List<TimeClass> getTimeClasses() {
		Connection con = null;
		try {
			List<TimeClass> timeClasses = new ArrayList<>();
			con = MySql.createConnection();
			String sql = "SELECT   p.`professor_name`,   sg.`group_name`,   s.`subject_code`,   s.`subject_name`,   r.`room_number`,   t.`timeslot` FROM   class c   INNER JOIN professor p     ON c.`professor_id` = p.`professor_id`   INNER JOIN room r     ON c.`room_id` = r.`room_id`     INNER JOIN  subject s     ON c.`subject_id`=s.`subject_id`     INNER JOIN  student_group sg ON     c.`group_id`=sg.`group_id`     RIGHT   JOIN timeslot t     ON c.`timeslot_id` = t.`timeslot_id`  ORDER BY t.`timeslot_id` ";
			PreparedStatement psmt = con.prepareStatement(sql);
			ResultSet rs = psmt.executeQuery();
			while (rs.next()) {

				String professorName = rs.getString("professor_name");
				String groupName = rs.getString("group_name");
				String subjectCode = rs.getString("subject_code");
				String roomNumber = rs.getString("room_number");
				String timeSlot = rs.getString("timeslot");
				String subjectName = rs.getString("subject_name");
				TimeClass tempClass = new TimeClass(groupName, subjectCode, roomNumber, timeSlot, professorName,
						subjectName);
				timeClasses.add(tempClass);
			}
			return timeClasses;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}

	public static TimeClass getTimeClass(int groupId, String timslot) {
		Connection con = null;
		try {
			con = MySql.createConnection();
			String sql = "SELECT   p.`professor_name`,   sg.`group_name`,   s.`subject_code`,   s.`subject_name`,   r.`room_number`,   t.`timeslot` FROM   class c,   SUBJECT s,   student_group sg,   professor p,   room r,   timeslot t WHERE c.`subject_id` = s.`subject_id`   AND c.`group_id` = sg.`group_id`   AND c.`professor_id` = p.`professor_id`   AND c.`room_id` = r.`room_id`   AND c.`timeslot_id` = t.`timeslot_id`   AND c.`group_id`="
					+ groupId + " AND   t.`timeslot`='" + timslot + "' ORDER BY t.timeslot_id ";
			PreparedStatement psmt = con.prepareStatement(sql);
			ResultSet rs = psmt.executeQuery();
			TimeClass timeClass = null;
			if (rs.next()) {

				String professorName = rs.getString("professor_name");
				String groupName = rs.getString("group_name");
				String subjectCode = rs.getString("subject_code");
				String roomNumber = rs.getString("room_number");
				String timeSlot = rs.getString("timeslot");
				String subjectName = rs.getString("subject_name");

				timeClass = new TimeClass(groupName, subjectCode, roomNumber, timeSlot, professorName, subjectName);
			} else {
				timeClass = new TimeClass();

			}
			return timeClass;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}

	public static void TruncateTable() {
		Connection con = null;
		try {
			con = MySql.createConnection();
			String sql = "truncate table class";
			PreparedStatement psmt = con.prepareStatement(sql);
			psmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {

				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
