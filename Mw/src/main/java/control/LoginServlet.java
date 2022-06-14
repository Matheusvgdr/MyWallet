package control;

import java.io.IOException;
import java.util.Objects;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UserDAO;
import model.User;


@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public LoginServlet() {
        super();
   
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doPost(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String user = request.getParameter("userName");
		String password = request.getParameter("password");
		User u = null;
		
		HttpSession session = request.getSession();
		
		UserDAO dao = new UserDAO();
		
		u = dao.consultUser(user, password);
		
		if(!Objects.isNull(u)) {
			
			session.setAttribute("userSession", u.getUserName());
			response.sendRedirect("menu.jsp");
			
		} else {
			
			response.sendRedirect("erro.jsp");
		}
	}

}
