package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.User;
import model.Wallet;

public class WalletDAO {
	
	Connection conex = null;
	
	public Wallet searchForId(int id) {
		
		Wallet wa = null;
		ResultSet rs = null;
		conex = DAO.createConnection();
		
		String sql = "SELECT * FROM tb_wallet WHERE id=?";
		
		try {
			PreparedStatement ps = conex.prepareStatement(sql);
			ps.setInt(1, id);
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				wa = new Wallet();
				
				wa.setId(rs.getInt("id"));
				wa.setBudget(rs.getDouble("budget"));
				wa.setNameWallet(rs.getString("nameWallet"));
			
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return wa;
	
	}

	public boolean modifyWallet(Wallet wa) {
		boolean result = true;
		int returnQuery;
		
		conex = DAO.createConnection();
		
		String sql = "UPDATE tb_wallet SET nameWallet = ? WHERE id = ?";
		
		try {
			PreparedStatement ps = conex.prepareStatement(sql);
			
			ps.setString(1, wa.getNameWallet());
			ps.setInt(2, wa.getId());
			
			returnQuery = ps.executeUpdate();
			
			if(returnQuery <= 0) {
				result = false;
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return result;
	}
	
	public boolean insertWallet(Wallet wallet) {

		boolean result = true;
		int returnQuery;

		conex = DAO.createConnection();

		String sql = "INSERT INTO tb_wallet(nameWallet, budget, id_user) VALUES (?, ?, ?);";

		try {
			PreparedStatement ps = conex.prepareStatement(sql);

			ps.setString(1, wallet.getNameWallet());
			ps.setDouble(2, wallet.getBudget());
			ps.setDouble(3, wallet.getId_user().getId());
	
			returnQuery = ps.executeUpdate();

			if (returnQuery <= 0) {
				result = false;
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}

		return result;

	}
	public boolean deleteWallet(int id) {

		boolean result = true;
		int returnQuery;

		conex = DAO.createConnection();

		String sql = "DELETE FROM tb_wallet WHERE id=?;";

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
	public List<Wallet> listWallet(int idUser){
		
		List<Wallet> listOfWallets = new ArrayList<Wallet>();
		ResultSet rs = null;
		Wallet wa = null;
		
		conex = DAO.createConnection();
		
		String sql = "SELECT * FROM tb_wallet WHERE id_user= ?";
		
		try {
			PreparedStatement ps = conex.prepareStatement(sql);
			ps.setInt(1, idUser);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				wa = new Wallet();
				
				wa.setId(rs.getInt("id"));
				wa.setNameWallet(rs.getString("nameWallet"));
				wa.setBudget(rs.getDouble("budget"));
				
				
				listOfWallets.add(wa);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return listOfWallets;
		
	}
	public boolean insertMoney(Wallet wa) {
		
		boolean result = true;
		int returnQuery;

		conex = DAO.createConnection();

		String sql = "INSERT INTO tb_wallet(nameWallet, budget) VALUES (?);";

		try {
			PreparedStatement ps = conex.prepareStatement(sql);

			ps.setDouble(1, wa.getBudget());
			
			returnQuery = ps.executeUpdate();

			if (returnQuery <= 0) {
				result = false;
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}

		return result;
	}
	
	
	
}
