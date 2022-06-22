package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Movimentation;
import model.TypeMov;
import model.User;
import model.Wallet;

public class MovimentationDAO {

	Connection conex = null;

	public Movimentation searchForId(int id) {

		Movimentation mov = null;
		ResultSet rs = null;
		conex = DAO.createConnection();

		String sql = "SELECT * FROM tb_movimentation WHERE id=?";

		try {
			PreparedStatement ps = conex.prepareStatement(sql);
			ps.setInt(1, id);

			rs = ps.executeQuery();

			while (rs.next()) {
				mov = new Movimentation();

				mov.setId(rs.getInt("id"));
				mov.setMoney(rs.getDouble("money"));

			}

		} catch (SQLException e) {

			e.printStackTrace();
		}

		return mov;
	}

	public boolean modifyMovimentation(Movimentation mov) {
		boolean result = true;
		int returnQuery;

		conex = DAO.createConnection();

		String sql = "UPDATE tb_movimentation SET money = ? WHERE id = ?";

		try {
			PreparedStatement ps = conex.prepareStatement(sql);

			ps.setDouble(1, mov.getMoney());

			returnQuery = ps.executeUpdate();

			if (returnQuery <= 0) {
				result = false;
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}

		return result;
	}

	public boolean insertMovimentation(Movimentation mov) {

		boolean result = true;
		int returnQuery;
		
		TypeMov t = new TypeMov();
		User u = new User();
		
		conex = DAO.createConnection();

		String sql = "INSERT INTO tb_movimentation (moviDate, money, typeMovi, id_user, id_type) VALUES (?, ?, ?, ?,?);";

		try {
			PreparedStatement ps = conex.prepareStatement(sql);

			ps.setString(1, mov.getMoviDate());
			ps.setDouble(2, mov.getMoney());
			ps.setString(3, mov.getType());
			ps.setInt(4, mov.getId_user());
			ps.setInt(5, mov.getId_type());

			returnQuery = ps.executeUpdate();

			if (returnQuery <= 0) {
				result = false;
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}

		return result;

	}

	public boolean deleteMovimentation(int id) {

		boolean result = true;
		int returnQuery;

		conex = DAO.createConnection();

		String sql = "DELETE FROM tb_movimentation WHERE id=?;";

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

//	public List<Movimentation> listWallet() {
//
//		List<Movimentation> listOfMovimentation = new ArrayList<Movimentation>();
//		ResultSet rs = null;
//		Movimentation mvt = null;
//
//		conex = DAO.createConnection();
//
//		String sql = "SELECT * FROM tb_movimentation";
//
//		try {
//			PreparedStatement ps = conex.prepareStatement(sql);
//
//			rs = ps.executeQuery();
//
//			while (rs.next()) {
//				mvt = new Movimentation();
//
//				mvt.setId(rs.getInt("id"));
//				mvt.setMoney(rs.getDouble("money"));
//				mvt.setMoviDate(rs.getString("moviDate"));
//				mvt.setType(rs.getString("type"));
//				mvt.setId_user(rs.getInt("id_user"));
//				mvt.setId_type(rs.getInt("id_typev"));
//
//				listOfMovimentation.add(mvt);
//
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//
//		return listOfMovimentation;
//	}

	public boolean insertMoney(Movimentation mov) {

		boolean result = true;
		int returnQuery;

		conex = DAO.createConnection();

		String sql = "INSERT INTO tb_movimentation(money) VALUES (?);";

		try {
			PreparedStatement ps = conex.prepareStatement(sql);

			ps.setDouble(1, mov.getMoney());

			returnQuery = ps.executeUpdate();

			if (returnQuery <= 0) {
				result = false;
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}

		return result;
	}
	
	public boolean withdrawMoney(Movimentation mov) {

		boolean result = true;
		int returnQuery;

		conex = DAO.createConnection();

		String sql = "INSERT INTO tb_movimentation(money) VALUES (?);";

		try {
			PreparedStatement ps = conex.prepareStatement(sql);

			ps.setDouble(1, mov.getMoney());

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