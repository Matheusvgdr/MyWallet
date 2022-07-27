package service;
import java.util.List;

import dao.MovimentationDAO;
import model.Movimentation;

public class MovimentationService {
	MovimentationDAO mvt = new MovimentationDAO();

	public boolean insert(Movimentation mov) {
		boolean insertValido = true;

		if (mvt.verificar(mov)) {
			insertValido = mvt.insertMovimentation(mov);
		} else {
			insertValido = false;
		}
		return insertValido;
	}

	public boolean delete(String id) {

		return mvt.deleteMovimentation(Integer.parseInt(id));
	}

	public Movimentation searchForId(int id) {

		return mvt.searchForId(id);
	}

	public List<Movimentation> listMov(int idUser) {
		return mvt.listMov(idUser);
	}
}