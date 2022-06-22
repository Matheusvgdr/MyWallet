package control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.User;
import service.UserService;


@WebServlet("/InsertServlet")
public class InsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public InsertServlet() {
        super();
 
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		User us = new User();
		
		UserService service = new UserService();
		
		us.setPersonName(request.getParameter("name"));
		us.setUserName(request.getParameter("userName"));
		us.setUserPassword(request.getParameter("password"));
		us.setCpf(request.getParameter("cpf"));
		
		if(service.insert(us)) {
			response.sendRedirect("home.jsp");
		}
	}

}
