package model;

import java.util.Date;

public class Movimentation {
	private int id;
	private String moviDate;
	private double money;
	private String notes;
	private String type;
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id; 
	}
	public String getMoviDate() {
		return moviDate;
	}


	public void setMoviDate(String moviDate) {
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
