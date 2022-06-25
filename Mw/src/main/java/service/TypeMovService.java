package service;

import java.util.List;

import dao.TypeMovDAO;
import model.TypeMov;

public class TypeMovService {
	TypeMovDAO dao = new TypeMovDAO();

	public List<TypeMov> listar() {
		return dao.listar();
	}

}
