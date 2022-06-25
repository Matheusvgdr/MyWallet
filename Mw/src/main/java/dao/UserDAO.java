package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.User;

public class UserDAO {

	Connection conex = null;

	public User searchForId(int id) {
		
		User us = null;
		ResultSet rs = null;
		conex = DAO.createConnection();
		
		String sql = "SELECT * FROM tb_users WHERE id=?";
		
		try {
			PreparedStatement ps = conex.prepareStatement(sql);
			ps.setInt(1, id);
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				us = new User();
				
				us.setId(rs.getInt("id"));
				us.setPersonName(rs.getString("personName"));
				us.setUserName(rs.getString("userName"));
				us.setCpf(rs.getString("cpf"));
				us.setUserPassword(rs.getString("userPassword"));
				
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return us;
	
	}
	
	//Modificar usu�rio
	public boolean modifyUser(User us) {
		
		boolean result = true;
		int returnQuery;

		conex = DAO.createConnection();

		String sql = "UPDATE tb_users SET personName = ?, userName = ?, cpf = ?, userPassword = ? WHERE id=?;";

		try {

			PreparedStatement ps = conex.prepareStatement(sql);

			ps.setString(1, us.getPersonName());
			ps.setString(2, us.getUserName());
			ps.setString(3, us.getCpf());
			ps.setString(4, us.getUserPassword());
			ps.setInt(5, us.getId());

			returnQuery = ps.executeUpdate();

			if (returnQuery <= 0) {
				
				result = false;
				
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}

		return result;

		
	}
	
	//Consultar usu�rio
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

			while (rs.next()) {
				usu = new User();
				usu.setId(rs.getInt("id"));
				usu.setUserName(rs.getString("userName"));
				usu.setUserPassword(rs.getString("userPassword"));
				usu.setPersonName(rs.getString("personName"));
				usu.setCpf(rs.getString("cpf"));
				

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return usu;

	}
	
	//Inserir usu�rio
	public boolean insertUser(User usr) {

		boolean result = true;
		int returnQuery;

		conex = DAO.createConnection();

		String sql = "INSERT INTO tb_users(personName, userName, userPassword, cpf) VALUES (?, ?, ?, ?);";

		try {
			PreparedStatement ps = conex.prepareStatement(sql);

			ps.setString(1, usr.getPersonName());
			ps.setString(2, usr.getUserName());
			ps.setString(3, usr.getUserPassword());
			ps.setString(4, usr.getCpf());
			
			returnQuery = ps.executeUpdate();

			if (returnQuery <= 0) {
				result = false;
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}

		return result;

	}
	
	//Deletar usuario
	public boolean deleteUser(int id) {

		boolean result = true;
		int returnQuery;

		conex = DAO.createConnection();

		String sql = "DELETE FROM tb_users WHERE id=?;";

		try {

			PreparedStatement ps = conex.prepareStatement(sql);

			ps.setInt(1, id);

			returnQuery = ps.executeUpdate();

			if (returnQuery <= 0) {
				result = false;
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}

		return result;

	}
	
	//Listar todos os usu�rios
	public List<User> listUser(int idU){
		
		List<User> listOfUsers = new ArrayList<User>();
		ResultSet rs = null;
		User usr = null;
		
		conex = DAO.createConnection();
		
		String sql = "SELECT * FROM tb_users WHERE id= ?";
		
		try {
			PreparedStatement ps = conex.prepareStatement(sql);
			ps.setInt(1, idU);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				usr = new User();
				
				usr.setId(rs.getInt("id"));
				usr.setPersonName(rs.getString("personName"));
				usr.setUserName(rs.getString("userName"));
				usr.setUserPassword(rs.getString("userPassword"));
				usr.setCpf(rs.getString("cpf"));
				
				listOfUsers.add(usr);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return listOfUsers;
		
	}
}
