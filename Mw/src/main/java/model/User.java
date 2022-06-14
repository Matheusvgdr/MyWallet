package model;

import java.util.Date;

public class User {
	private int id;
	private String personName;
	private String userName;
	private String cpf;
	private String birthday;
	private String userPassword;
	private String photo;
	
	
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


	public String getBirthday() {
		return birthday;
	}


	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}


	public String getUserPassword() {
		return userPassword;
	}


	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}


	public String getPhoto() {
		return photo;
	}


	public void setPhoto(String photo) {
		this.photo = photo;
	}


	@Override
	public String toString() {
		return "User [id=" + id + ", personName=" + personName + ", userName=" + userName + ", cpf=" + cpf
				+ ", birthday=" + birthday + ", userPassword=" + userPassword + ", photo=" + photo + "]";
	}
	
	
}
