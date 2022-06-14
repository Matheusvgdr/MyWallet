package model;

import java.util.Date;

public class Movimentation {
	private Date moviDate;
	private double money;
	private String notes;
	private String type;
	
	
	public Date getMoviDate() {
		return moviDate;
	}


	public void setMoviDate(Date moviDate) {
		this.moviDate = moviDate;
	}


	public double getMoney() {
		return money;
	}


	public void setMoney(double money) {
		this.money = money;
	}


	public String getNotes() {
		return notes;
	}


	public void setNotes(String notes) {
		this.notes = notes;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	@Override
	public String toString() {
		return "Movimentation [moviDate=" + moviDate + ", money=" + money + ", notes=" + notes + ", type=" + type + "]";
	}
	
	
}
