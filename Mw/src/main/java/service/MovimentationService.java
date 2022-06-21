package service;

import dao.MovimentationDAO;
import model.Movimentation;

public class MovimentationService {
	MovimentationDAO mvt = new MovimentationDAO();

	public boolean modify(Movimentation mov) {

		return mvt.modifyMovimentation(mov);
	}

	public boolean insert(Movimentation mov) {
		return mvt.insertMovimentation(mov);
	}

	public boolean delete(String id) {

		return mvt.deleteMovimentation(Integer.parseInt(id));
	}

	public Movimentation searchForId(int id) {

		return mvt.searchForId(id);

	}
}
