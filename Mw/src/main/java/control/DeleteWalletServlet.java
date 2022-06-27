package control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import service.WalletService;

@WebServlet("/DeleteWalletServlet")
public class DeleteWalletServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public DeleteWalletServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		doPost(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String id = request.getParameter("id");

		WalletService service = new WalletService();

		if (service.delete(id)) {

			response.sendRedirect("pages/home.jsp");
		}
	}

}
