package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.MoviWallet;
import model.Movimentation;
import model.TypeMov;
import model.User;
import model.Wallet;

public class MoviWalletDAO {
	
	Connection conex = null;
	
	public MoviWallet searchForId(int id) {

		MoviWallet mov = null;
		ResultSet rs = null;
		conex = DAO.createConnection();

		String sql = "SELECT * FROM tb_moviWallet WHERE id=?";

		try {
			PreparedStatement ps = conex.prepareStatement(sql);
			ps.setInt(1, id);

			rs = ps.executeQuery();

			while (rs.next()) {
				mov = new MoviWallet();

				mov.setId(rs.getInt("id"));
				mov.setMoney(rs.getDouble("money"));
				mov.setMoviDate(rs.getString("moviDate"));
				mov.setType(rs.getString("type"));
				mov.getId_type().setId(rs.getInt("id_type"));
				mov.getId_user().setId(rs.getInt("id_user"));
				mov.getId_account().setNumberAccount(rs.getInt("id_account"));
				mov.getId_wallet().setId(rs.getInt("id_wallet"));

			}

		} catch (SQLException e) {

			e.printStackTrace();
		}

		return mov;
	}

	// faz uma movimentação (Saque/Depósito)
	public boolean insertMoviWallet(MoviWallet mov) {

		boolean result = true;
		int returnQuery;

		conex = DAO.createConnection();

		String sql = "INSERT INTO tb_moviWallet (moviDate, money, id_user, id_type, id_wallet) VALUES (?, ?, ?, ?, ?);";

		try {
			PreparedStatement ps = conex.prepareStatement(sql);

			ps.setString(1, mov.getMoviDate());
			ps.setDouble(2, mov.getMoney());
			ps.setInt(3, mov.getId_user().getId());
			ps.setInt(4, mov.getId_type().getId());
			ps.setInt(5, mov.getId_wallet().getId());

			returnQuery = ps.executeUpdate();

			if (returnQuery <= 0) {
				result = false;
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}

		return result;

	}
	
	public boolean verificar(MoviWallet conta ) {

			List<MoviWallet> lis = new ArrayList<MoviWallet>();
		    List<MoviWallet> listaW = new ArrayList<MoviWallet>();

			double calcD = 0;
			
			lis = this.listDeposits(conta.getId_user().getId(), conta.getId_type().getId(), conta.getId_wallet().getId());
			
			for(MoviWallet i: lis){
			
				calcD += i.getMoney();
				
			}
			
			
			double calcW = 0;
			listaW = this.listWithdraw(conta.getId_user().getId(), conta.getId_type().getId(), conta.getId_wallet().getId());
			
			for(MoviWallet i: listaW){
			
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

		String sql = "DELETE FROM tb_moviWallet WHERE id=?;";

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
	public List<MoviWallet> listMov(int idUser) {

		List<MoviWallet> listOfMovimentation = new ArrayList<MoviWallet>();
		ResultSet rs = null;
		MoviWallet mvt = null;
		User u = null;
		TypeMov tm = null;
		conex = DAO.createConnection();

		String sql = "SELECT M.money, M.moviDate, U.personName, T.description FROM tb_moviWallet M INNER JOIN tb_users U ON U.id = M.id_user INNER JOIN tb_typeMovi T ON T.id = M.id_type WHERE id_user = ?;";

		try {
			PreparedStatement ps = conex.prepareStatement(sql);
			ps.setInt(1, idUser);
			rs = ps.executeQuery();

			while (rs.next()) {
				u = new User();
				tm = new TypeMov();
				mvt = new MoviWallet();
				
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
	public List<MoviWallet> listDeposits(int idUser, int idType, int idWallet) {

		List<MoviWallet> listOfDeposits = new ArrayList<MoviWallet>();
		ResultSet rs = null;
		MoviWallet mvt = null;
		conex = DAO.createConnection();

		String sql = " SELECT money FROM tb_moviWallet WHERE id_user= ? AND id_type= ? AND id_wallet = ?;";

		try {
			PreparedStatement ps = conex.prepareStatement(sql);
			ps.setInt(1, idUser);
			ps.setInt(2, idType);
			ps.setInt(3, idWallet);

			rs = ps.executeQuery();

			while (rs.next()) {
				mvt = new MoviWallet();

				mvt.setMoney(rs.getDouble("money"));

				listOfDeposits.add(mvt);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return listOfDeposits;
	}

	//Lista todos os saques de um usuário
	public List<MoviWallet> listWithdraw(int idUser, int idType, int idWa) {

		List<MoviWallet> listOfWithdraws = new ArrayList<MoviWallet>();
		ResultSet rs = null;
		MoviWallet mvt = null;
		conex = DAO.createConnection();

		String sql = " SELECT money FROM tb_moviWallet WHERE id_user= ? AND id_type= ? AND id_wallet = ?;";

		try {
			PreparedStatement ps = conex.prepareStatement(sql);
			ps.setInt(1, idUser);
			ps.setInt(2, idType);
			ps.setInt(3, idWa);

			rs = ps.executeQuery();

			while (rs.next()) {
				mvt = new MoviWallet();

				mvt.setMoney(rs.getDouble("money"));

				listOfWithdraws.add(mvt);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return listOfWithdraws;
	}

	public List<MoviWallet> listPix(int idUser, int idType) {

		List<MoviWallet> listOfPix = new ArrayList<MoviWallet>();
		ResultSet rs = null;
		MoviWallet mvt = null;
		conex = DAO.createConnection();

		String sql = " SELECT money FROM tb_moviWallet WHERE id_user= ? AND id_type= ?;";

		try {
			PreparedStatement ps = conex.prepareStatement(sql);
			ps.setInt(1, idUser);
			ps.setInt(2, idType);

			rs = ps.executeQuery();

			while (rs.next()) {
				mvt = new MoviWallet();

				mvt.setMoney(rs.getDouble("money"));

				listOfPix.add(mvt);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return listOfPix;
	}

}
