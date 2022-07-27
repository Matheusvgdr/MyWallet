package control;

import java.io.IOException;
import java.util.Objects;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.User;
import service.UserService;

@WebServlet("/PrepareIdUserForWalletServlet")
public class PrepareIdUserForWalletServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public PrepareIdUserForWalletServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		UserService service = new UserService();
		
		User usr = new User();
		HttpSession session = request.getSession();
		
		String idRequest = request.getParameter("id");
		 
		usr = service.searchForId(Integer.parseInt(idRequest));
				
		if(!Objects.isNull(usr)) {
			session.setAttribute("userSelected", usr);
			response.sendRedirect("modifyWallet.jsp");
		} else {
			response.sendRedirect("error.jsp");
		}
	}
}
