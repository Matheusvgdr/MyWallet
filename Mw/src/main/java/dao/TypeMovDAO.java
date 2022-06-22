package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.TypeMov;

public class TypeMovDAO {
	Connection conex = null;

	public boolean insertTypeMov(TypeMov tm) {
		
		boolean result = true;
		int returnQuery;

		conex = DAO.createConnection();

		String sql = "INSERT INTO tb_typeMovi(description) VALUES (?);";

		try {
			PreparedStatement ps = conex.prepareStatement(sql);

			ps.setString(1, tm.getDescription());
			
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
