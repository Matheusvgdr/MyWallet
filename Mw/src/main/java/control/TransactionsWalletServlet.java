package control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.MoviWalletDAO;
import model.Account;
import model.MoviWallet;
import model.TypeMov;
import model.User;
import model.Wallet;


@WebServlet("/TransactionsWalletServlet")
public class TransactionsWalletServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public TransactionsWalletServlet() {
        super();
       
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	User us = new User();
	Wallet wa = new Wallet();
	TypeMov tm = new TypeMov();
	MoviWallet mw = new MoviWallet();
	MoviWalletDAO dao = new MoviWalletDAO();
	
	us.setId(Integer.parseInt(request.getParameter("idUs")));
	wa.setId(Integer.parseInt(request.getParameter("idWa")));
	tm.setId(Integer.parseInt(request.getParameter("idType")));
	
	mw.setMoviDate(request.getParameter("dateMovi"));
	mw.setMoney(Integer.parseInt(request.getParameter("moneyWallet")));
	mw.setId_user(us);
	mw.setId_type(tm);
	mw.setId_wallet(wa);
	
	
	HttpSession sessionM = request.getSession();
	
	if(dao.insertMoviWallet(mw)) {
		sessionM.setAttribute("moviWallet", mw);
		response.sendRedirect("pages/home.jsp");
		
	}else {
		response.sendRedirect("pages/error.html");
	}
	
	
	
	
	}

}
