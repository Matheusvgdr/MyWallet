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
				mov.setMoviDate(rs.getString("moviDate"));
				mov.setType(rs.getString("type"));
				mov.getId_type().setId(rs.getInt("id_type"));;
				mov.getId_user().setId(rs.getInt("id_user"));
				

			}

		} catch (SQLException e) {

			e.printStackTrace();
		}

		return mov;
	}

	public boolean insertMovimentation(Movimentation mov) {

		boolean result = true;
		int returnQuery;
		
		conex = DAO.createConnection();

		String sql = "INSERT INTO tb_movimentation (moviDate, money, typeMovi, id_user, id_type) VALUES (?, ?, ?, ?,?);";

		try {
			PreparedStatement ps = conex.prepareStatement(sql);

			ps.setString(1, mov.getMoviDate());
			ps.setDouble(2, mov.getMoney());
			ps.setString(3, mov.getType());
			ps.setInt(4, mov.getId_user().getId());
			ps.setInt(5, mov.getId_type().getId());

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

	public List<Movimentation> listMov(int idUser) {

		List<Movimentation> listOfMovimentation = new ArrayList<Movimentation>();
		ResultSet rs = null;
		Movimentation mvt = null;
		conex = DAO.createConnection();

		String sql = " SELECT * FROM tb_movimentation WHERE id_user= ?;";

		try {
			PreparedStatement ps = conex.prepareStatement(sql);
			ps.setInt(1,idUser );
			rs = ps.executeQuery();

			while (rs.next()) {
				mvt = new Movimentation();

				mvt.setMoney(rs.getDouble("money"));
				mvt.setMoviDate(rs.getString("moviDate"));
				mvt.setType(rs.getString("typeMovi"));	
			

				listOfMovimentation.add(mvt);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	return listOfMovimentation;
	}
	
	public Movimentation calcAll(int id) {
	
		Movimentation mov = null;
		ResultSet rs = null;
		conex = DAO.createConnection();

		String sql = " SELECT SUM(money) FROM tb_movimentation WHERE id_type = ?;";

		try {
			PreparedStatement ps = conex.prepareStatement(sql);
			ps.setInt(1, id);

			rs = ps.executeQuery();

			while (rs.next()) {
				mov = new Movimentation();

			}

		} catch (SQLException e) {

			e.printStackTrace();
		}

		return mov;
	}


}
