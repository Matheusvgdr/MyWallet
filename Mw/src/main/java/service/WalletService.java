package service;

import java.util.List;

import dao.WalletDAO;
import model.Wallet;

public class WalletService {
	WalletDAO wallet = new WalletDAO();
	
	public boolean modify(Wallet wa) {

		return wallet.modifyWallet(wa);
	}
	
	public boolean insert(Wallet wa) {
		return wallet.insertWallet(wa);
	}
	
	public boolean delete(String id) {
		
		return wallet.deleteWallet(Integer.parseInt(id));
	}
	public Wallet searchForId(int id) {
		
		return wallet.searchForId(id);
	}
	
	public List<Wallet> listWallet(int idUser){
		return wallet.listWallet(idUser);
	}
}

