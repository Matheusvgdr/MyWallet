package service;

import java.util.List;

import dao.UserDAO;
import model.User;

public class UserService {
	UserDAO user = new UserDAO();

	public boolean modify(User us) {

		return user.modifyUser(us);
	}
	
	public boolean insert(User us) {
		return user.insertUser(us);
	}
	
	public boolean delete(String id) {
		
		int idUser;
		return user.deleteUser(idUser = Integer.parseInt(id));
	}
	public User searchForId(int id) {
		return user.searchForId(id);
	}
	
	public List<User> list(int idUser) {
		return user.listUser(idUser);
	}
}
