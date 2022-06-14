package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.User;

public class UserDAO {

	Connection conex = null;
	
	public User consultUser(String login, String pass) {
		
		User usu = null;
		ResultSet rs = null;
		
		conex = DAO.createConnection();

		String sql = "SELECT * FROM tb_users WHERE userName = ? AND userPassword = ?";
		
		try {
			PreparedStatement ps = conex.prepareStatement(sql);
			
			ps.setString(1, login);
			ps.setString(2, pass);
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				usu = new User();

				usu.setUserName(rs.getString("user"));
				usu.setUserPassword(rs.getString("password"));

			}			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return usu;
		
	}
}
