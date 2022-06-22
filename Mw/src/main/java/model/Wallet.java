package model;

public class Wallet {
	
	private int id;
	private String nameWallet;
	private double budget;
	private int id_user;
	
	public int getId_user() {
		return id_user;
	}

	public void setId_user(int id_user) {
		this.id_user = id_user;
	}

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


	@Override
	public String toString() {
		return "Wallet [nameWallet=" + nameWallet + ", budget=" + budget + ", openCount=" + "]";
	}
	
	
	
}
