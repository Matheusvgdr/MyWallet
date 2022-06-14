package model;

import java.util.Date;

public class Wallet {
	
	private String nameWallet;
	private double budget;
	private Date openCount;
	
	
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


	public Date getOpenCount() {
		return openCount;
	}


	public void setOpenCount(Date openCount) {
		this.openCount = openCount;
	}


	@Override
	public String toString() {
		return "Wallet [nameWallet=" + nameWallet + ", budget=" + budget + ", openCount=" + openCount + "]";
	}
	
	
	
}
