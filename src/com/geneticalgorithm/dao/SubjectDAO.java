package com.geneticalgorithm.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.geneticalgorithm.domain.Professor;
import com.geneticalgorithm.domain.Subject;
import com.geneticalgorithm.utils.GAConstants;

import connection.MySql;

public class SubjectDAO {

	public static void addSubject(Subject subject) {
		Connection con =null;
		try {
			 con = MySql.createConnection();

			/**
			 * inserting subject
			 */
			String sql = "insert into subject (subject_code, subject_name,group_id) values(?,?,?)";
			PreparedStatement psmt = con.prepareStatement(sql);
			psmt.setString(1, subject.getSubjectCode());
			psmt.setString(2, subject.getSubjectName());
			psmt.setInt(3, subject.getGroup().getGroupId());
			psmt.executeUpdate();

			/**
			 * Getting saved subject for id using subject code
			 */
			Subject databaseInsertedSubject = getByCode(subject.getSubjectCode());

			/**
			 * Inserting into each subject_professor for each professor and subject
			 */
			String professorSQl = "INSERT INTO `subject_professor`(`subject_id`, `professor_id`) VALUES (?,?)";

			psmt = con.prepareStatement(professorSQl);

			List<Professor> professors = subject.getProfessor();

			for (Professor professor : professors) {
				psmt.setInt(1, databaseInsertedSubject.getId());
				psmt.setInt(2, professor.getId());
				psmt.executeUpdate();
			}

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

	}

	private static Subject getByCode(String code) {
		// TODO Auto-generated method stub
		Connection con =null;
		try {
			 con = MySql.createConnection();

			String sql = "SELECT * FROM subject s  where s.subject_code=?";
			PreparedStatement psmt = con.prepareStatement(sql);
			psmt.setString(1, code);
			ResultSet rs = psmt.executeQuery();

			if (rs.next()) {

				// Subject subject = new Subject(rs.getInt(1), rs.getString(2), rs.getString(3),
				// null);
				Subject subject = new Subject();
				subject.setId(rs.getInt("subject_id"));
				subject.setSubjectCode(rs.getString("subject_name"));
				return subject;
			}
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
