package model;

import java.util.Date;

public class Wallet {
	
	private int id;
	private String nameWallet;
	private double budget;
	
	
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
