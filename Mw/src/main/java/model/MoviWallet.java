package model;

public class MoviWallet {
	private int id;
	private String moviDate;
	private double money;
	private String type;
	private User id_user;
	private TypeMov id_type;
	private Wallet id_wallet;
	private Account id_account;
	
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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public User getId_user() {
		return id_user;
	}

	public void setId_user(User id_user) {
		this.id_user = id_user;
	}

	public TypeMov getId_type() {
		return id_type;
	}

	public void setId_type(TypeMov id_type) {
		this.id_type = id_type;
	}

	public Wallet getId_wallet() {
		return id_wallet;
	}

	public void setId_wallet(Wallet id_wallet) {
		this.id_wallet = id_wallet;
	}

	public Account getId_account() {
		return id_account;
	}

	public void setId_account(Account id_account) {
		this.id_account = id_account;
	}
	
}
