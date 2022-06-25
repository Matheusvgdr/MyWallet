package model;

public class Wallet {
	
	private int id;
	private String nameWallet;
	private double budget;
	private User id_user;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNameWallet() {
		return nameWallet;
	}
	public void setNameWallet(String nameWallet) {
		this.nameWallet = nameWallet;
	}
	public double getBudget() {
		return budget;
	}
	public void setBudget(double budget) {
		this.budget = budget;
	}
	public User getId_user() {
		return id_user;
	}
	public void setId_user(User id_user) {
		this.id_user = id_user;
	}
	
	@Override
	public String toString() {
		return "Wallet [id=" + id + ", nameWallet=" + nameWallet + ", budget=" + budget + ", id_user=" + id_user + "]";
	}
	

}
