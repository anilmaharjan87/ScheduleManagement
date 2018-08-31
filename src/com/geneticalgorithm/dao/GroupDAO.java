package com.geneticalgorithm.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.geneticalgorithm.domain.Group;
import com.geneticalgorithm.domain.Professor;
import com.geneticalgorithm.domain.Subject;

import connection.MySql;

public class GroupDAO {
	public static List<Group> getGroup() {
		Connection con = null;
		try {
			List<Group> groups = new ArrayList<>();
			con = MySql.createConnection();
			String sql = "select * from student_group";
			PreparedStatement psmt = con.prepareStatement(sql);
			ResultSet rs = psmt.executeQuery();
			while (rs.next()) {

				String groupName = rs.getString("group_name");
				int groupSize = rs.getInt("group_size");
				int id = rs.getInt("group_id");
				Group tempGroup = new Group(id, groupName, groupSize);
				groups.add(tempGroup);
			}
			return groups;
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

	public static void addGroup(Group group) {
		Connection con = null;
		try {
			con = MySql.createConnection();

			/**
			 * inserting subject
			 */
			String sql = "insert into student_group (group_name, group_size) values(?,?)";
			PreparedStatement psmt = con.prepareStatement(sql);
			psmt.setString(1, group.getGroupName());
			psmt.setInt(2, group.getGroupSize());
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
