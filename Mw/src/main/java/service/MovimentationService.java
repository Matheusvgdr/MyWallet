package service;

import java.util.List;

import dao.MovimentationDAO;
import model.Movimentation;

public class MovimentationService {
	MovimentationDAO mvt = new MovimentationDAO();

	public boolean insert(Movimentation mov) {
		
		return mvt.insertMovimentation(mov);
	}

	public boolean delete(String id) {

		return mvt.deleteMovimentation(Integer.parseInt(id));
	}

	public Movimentation searchForId(int id) {

		return mvt.searchForId(id);
	}
	
	public Movimentation calcDeposits(int idUser) {
		
		return mvt.calcAll(idUser);
	}
	
	public List<Movimentation> listMov(int idUser){
		return mvt.listMov(idUser);
	}
	
}
