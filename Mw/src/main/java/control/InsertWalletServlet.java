package control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.User;
import model.Wallet;
import service.WalletService;

@WebServlet("/InsertWalletServlet")
public class InsertWalletServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public InsertWalletServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User u = new User();
		WalletService service = new WalletService();
		Wallet wallet = new Wallet();
	
		u.setId(Integer.parseInt(request.getParameter("idUs")));
		
		wallet.setNameWallet(request.getParameter("nameWlt"));
		wallet.setId_user(u);
		
		if(service.insert(wallet)) {
			response.sendRedirect("pages/transactionsWallet.jsp");
		}
	}
}