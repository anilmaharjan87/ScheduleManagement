package com.geneticalgorithm.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.geneticalgorithm.domain.Professor;

import connection.MySql;

public class ProfessorDAO {
	public static List<Professor> getProfessor() {
		Connection con = null;
		try {
			List<Professor> professors = new ArrayList<>();
			con = MySql.createConnection();
			String sql = "select * from professor";
			PreparedStatement psmt = con.prepareStatement(sql);
			ResultSet rs = psmt.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("professor_id");
				String professorName = rs.getString("professor_name");
				Professor tempProfessor = new Professor(id, professorName);
				professors.add(tempProfessor);
			}

			return professors;
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

	public static void addProfessor(Professor professor) {
		Connection con = null;
		try {
			con = MySql.createConnection();
			String sql = "Insert into professor" + "(professor_name)" + "values(?)";
			PreparedStatement psmt = con.prepareStatement(sql);
			psmt.setString(1, professor.getProfessorName());
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
