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


@WebServlet("/PrepareModificationServlet")
public class PrepareModificationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public PrepareModificationServlet() {
        super();

    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		UserService service = new UserService();
		User user = new User();
		
		String idRequest = request.getParameter("id");
		
		HttpSession session = request.getSession();
		
		user = service.searchForId(Integer.parseInt(idRequest));
		
		if(!Objects.isNull(user)) {
			session.setAttribute("userSelected", user);
			response.sendRedirect("modifyUser.jsp");
		} else {
			response.sendRedirect("error.jsp");
		}
		
		
	}

}
