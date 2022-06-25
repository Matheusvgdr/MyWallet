package control;

import java.io.IOException;
import java.util.Objects;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Wallet;
import service.WalletService;

@WebServlet("/PrepareModificationWalletServlet")
public class PrepareModificationWalletServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public PrepareModificationWalletServlet() {
        super();
     
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		WalletService serviceW = new WalletService();
		
		Wallet wallet = new Wallet();
		
		HttpSession session = request.getSession();
		
		//-----------------------------------------
		
		String idRequest = request.getParameter("id");
		wallet = serviceW.searchForId(Integer.parseInt(idRequest));

		
		//-----------------------------------------
		
		if(!Objects.isNull(wallet)) {
			
			session.setAttribute("walletSelected", wallet);
			response.sendRedirect("modifyWallet.jsp");
			
		} else {
			response.sendRedirect("error.jsp");
		}
	
	}

}
