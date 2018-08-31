package com.geneticalgorithm.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.geneticalgorithm.domain.Admin;
import com.geneticalgorithm.utils.GAConstants;

import connection.MySql;

public class LoginDao {
	public static int verifyAdmin(Admin theAdmin) {
		Connection con =null;
		try {
			
			 con = MySql.createConnection();
			PreparedStatement pstmt = con.prepareStatement("select * from admin where name=? and password=?");
			pstmt.setString(1, theAdmin.getUsername());
			pstmt.setString(2, theAdmin.getPassword());
			ResultSet rs = pstmt.executeQuery();
			int count = 0;
			if(rs.last()) {
				count = rs.getRow();
			}
			if(count == 1) {
				return GAConstants.LOGIN_SUCCESS;
			} else {
				return GAConstants.LOGIN_FAILURE;
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
		return GAConstants.LOGIN_FAILURE;
	}


	
}
