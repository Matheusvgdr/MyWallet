package control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MovimentationDAO;
import dao.TypeMovDAO;
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
		Movimentation m = new Movimentation();
		
		int va = Integer.parseInt(request.getParameter("money"));
		String data = request.getParameter("dateMovi");
		String tipo = request.getParameter("typeM");
		String idU = request.getParameter("idUser");
		String idT = request.getParameter("idType");
		
		m.setMoney(va);
		m.setMoviDate(data);
		m.setType(tipo);
		m.setId_user(Integer.parseInt(idU));
		m.setId_type(Integer.parseInt(idT));
		
		MovimentationDAO dao = new MovimentationDAO();
		
		dao.insertMovimentation(m);
		
		response.sendRedirect("movimentatio.jsp");

	}

}
