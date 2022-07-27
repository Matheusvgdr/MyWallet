package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.TypeMov;

public class TypeMovDAO {
	Connection conex = null;
	
	public List<TypeMov> listar(){
		List<TypeMov> listOfTypeMov = new ArrayList<TypeMov>();
		
		ResultSet rs = null;
		TypeMov tm = null;
		
		conex = DAO.createConnection();
		
		String sql = "SELECT * FROM tb_typeMovi";
		
		try {
			PreparedStatement ps = conex.prepareStatement(sql);
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				tm = new TypeMov();
				
				tm.setId(rs.getInt("id"));
				tm.setDescription(rs.getString("description")); 
				
				
				listOfTypeMov.add(tm);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return listOfTypeMov;
	}
	
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
