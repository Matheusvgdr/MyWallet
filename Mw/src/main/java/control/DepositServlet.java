package control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.MovimentationDAO;
import dao.TypeMovDAO;
import dao.WalletDAO;
import model.Movimentation;
import model.TypeMov;
import model.User;
import model.Wallet;
import service.MovimentationService;

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
		User u = new User();
		TypeMov tp = new TypeMov();
		MovimentationService ms = new MovimentationService();
				
		u.setId(Integer.parseInt(request.getParameter("idUs")));
		tp.setId(Integer.parseInt(request.getParameter("idType")));
		
		m.setMoney(Integer.parseInt(request.getParameter("money")));
		m.setMoviDate(request.getParameter("dateMovi"));
		m.setType(request.getParameter("typeM"));
		m.setId_user(u);;
		m.setId_type(tp);;
		
		HttpSession sessionM = request.getSession();
		if(ms.insert(m)) {
			sessionM.setAttribute("movimentation", m);
			response.sendRedirect("home.jsp");
			
		}else {
			response.sendRedirect("erro.html");
		}
		
		
		

	}

}
