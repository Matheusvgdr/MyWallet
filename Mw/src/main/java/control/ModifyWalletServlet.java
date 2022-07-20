package control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Wallet;
import service.WalletService;

@WebServlet("/ModifyWalletServlet")
public class ModifyWalletServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ModifyWalletServlet() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		Wallet user = new Wallet();
		WalletService service = new WalletService();

		user.setId(Integer.parseInt(request.getParameter("id")));
		user.setNameWallet(request.getParameter("nameWallet"));


		if (service.modify(user)) {
			response.sendRedirect("pages/wallet.jsp");

		}
	}
}
