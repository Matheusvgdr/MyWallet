package service;

import java.util.List;

import dao.MoviWalletDAO;
import model.MoviWallet;

public class MoviWalletService {
	MoviWalletDAO mvt = new MoviWalletDAO();

	public boolean insert(MoviWallet mov) {
		boolean insertValido = true;

		if (mvt.verificar(mov)) {
			insertValido = mvt.insertMoviWallet(mov);
		} else {
			insertValido = false;
		}
		return insertValido;
	}

	public boolean delete(String id) {

		return mvt.deleteMovimentation(Integer.parseInt(id));
	}

	public MoviWallet searchForId(int id) {

		return mvt.searchForId(id);
	}

	public List<MoviWallet> listMov(int idUser) {
		return mvt.listMov(idUser);
	}
}
