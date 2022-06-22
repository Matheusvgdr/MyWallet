package model;

import java.util.Date;

public class User {
	private int id;
	private String personName;
	private String userName;
	private String cpf;
	private String userPassword;

	
	
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getPersonName() {
		return personName;
	}


	public void setPersonName(String personName) {
		this.personName = personName;
	}


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public String getCpf() {
		return cpf;
	}


	public void setCpf(String cpf) {
		this.cpf = cpf;
	}


	public String getUserPassword() {
		return userPassword;
	}


	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}



	@Override
	public String toString() {
		return "User [id=" + id + ", personName=" + personName + ", userName=" + userName + ", cpf=" + cpf
				 + ", userPassword=" + userPassword + "]";
	}
	
	
}
