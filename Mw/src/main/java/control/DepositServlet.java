package control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.WalletDAO;
import model.Movimentation;
import model.Wallet;

@WebServlet("/DepositServlet")
public class DepositServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public DepositServlet() {
        super();
   
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Wallet wa = new Wallet();
		WalletDAO dao = new WalletDAO();

		wa.setBudget(Integer.parseInt(request.getParameter("money")) + wa.getBudget());
		
		dao.insertMoney(wa);
		response.sendRedirect("home.jsp");

	}

}
