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
				mov.getId_type().setId(rs.getInt("id_type"));
				;
				mov.getId_user().setId(rs.getInt("id_user"));

			}

		} catch (SQLException e) {

			e.printStackTrace();
		}

		return mov;
	}

	// faz uma movimentação (Saque/Depósito)
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
	
	public boolean verificar(Movimentation conta ) {

			List<Movimentation> lis = new ArrayList<Movimentation>();
		    List<Movimentation> listaW = new ArrayList<Movimentation>();

			double calcD = 0;
			
			lis = this.listDeposits(conta.getId_user().getId(), 1);
			
			for(Movimentation i: lis){
			
				calcD += i.getMoney();
				
			}
			
			
			double calcW = 0;
			listaW = this.listWithdraw(conta.getId_user().getId(), 2);
			
			for(Movimentation i: listaW){
			
				calcW += i.getMoney();
				
			}
			
			double totalMoney = calcD - calcW;
			
			if(conta.getMoney() > totalMoney && conta.getId_type().getId() == 2 ) {
				return false;
				
			}else {
				
				return true;
			}
	}
	// Deleta uma movimentação de um usuário
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

	// Lista todas as movimentações de um usuário
	public List<Movimentation> listMov(int idUser) {

		List<Movimentation> listOfMovimentation = new ArrayList<Movimentation>();
		ResultSet rs = null;
		Movimentation mvt = null;
		User u = null;
		TypeMov tm = null;
		conex = DAO.createConnection();

		String sql = "SELECT M.money, M.moviDate, U.personName, T.description FROM tb_movimentation M INNER JOIN tb_users U ON U.id = M.id_user INNER JOIN tb_typeMovi T ON T.id = M.id_type WHERE id_user = ?;";

		try {
			PreparedStatement ps = conex.prepareStatement(sql);
			ps.setInt(1, idUser);
			rs = ps.executeQuery();

			while (rs.next()) {
				u = new User();
				tm = new TypeMov();
				mvt = new Movimentation();
				
				mvt.setId_user(u);
				mvt.setId_type(tm);
				
				mvt.setMoney(rs.getDouble("money"));
				mvt.setMoviDate(rs.getString("moviDate"));
				mvt.getId_user().setPersonName(rs.getString("personName"));;
				mvt.getId_type().setDescription(rs.getString("description"));

				listOfMovimentation.add(mvt);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return listOfMovimentation;
	}

	// Lista todos os depósitos de um usuário
	public List<Movimentation> listDeposits(int idUser, int idType) {

		List<Movimentation> listOfDeposits = new ArrayList<Movimentation>();
		ResultSet rs = null;
		Movimentation mvt = null;
		conex = DAO.createConnection();

		String sql = " SELECT money FROM tb_movimentation WHERE id_user= ? AND id_type= ?;";

		try {
			PreparedStatement ps = conex.prepareStatement(sql);
			ps.setInt(1, idUser);
			ps.setInt(2, idType);

			rs = ps.executeQuery();

			while (rs.next()) {
				mvt = new Movimentation();

				mvt.setMoney(rs.getDouble("money"));

				listOfDeposits.add(mvt);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return listOfDeposits;
	}

	//Lista todos os saques de um usuário
	public List<Movimentation> listWithdraw(int idUser, int idType) {

		List<Movimentation> listOfWithdraws = new ArrayList<Movimentation>();
		ResultSet rs = null;
		Movimentation mvt = null;
		conex = DAO.createConnection();

		String sql = " SELECT money FROM tb_movimentation WHERE id_user= ? AND id_type= ?;";

		try {
			PreparedStatement ps = conex.prepareStatement(sql);
			ps.setInt(1, idUser);
			ps.setInt(2, idType);

			rs = ps.executeQuery();

			while (rs.next()) {
				mvt = new Movimentation();

				mvt.setMoney(rs.getDouble("money"));

				listOfWithdraws.add(mvt);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return listOfWithdraws;
	}

	public List<Movimentation> listAllMoney(int idUser, int idType) {

		List<Movimentation> listOfWithdraws = new ArrayList<Movimentation>();
		ResultSet rs = null;
		Movimentation mvt = null;
		conex = DAO.createConnection();

		String sql = " SELECT money FROM tb_movimentation WHERE id_user= ? AND id_type= ?;";

		try {
			PreparedStatement ps = conex.prepareStatement(sql);
			ps.setInt(1, idUser);
			ps.setInt(2, idType);

			rs = ps.executeQuery();

			while (rs.next()) {
				mvt = new Movimentation();

				mvt.setMoney(rs.getDouble("money"));

				listOfWithdraws.add(mvt);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return listOfWithdraws;
	}
}
