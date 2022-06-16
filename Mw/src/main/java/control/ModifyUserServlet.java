package control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.User;
import service.UserService;

@WebServlet("/ModifyUserServlet")
public class ModifyUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ModifyUserServlet() {
        super();
       
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User user = new User();
		UserService service = new UserService();
		
		user.setId(Integer.parseInt(request.getParameter("id")));
		user.setPersonName(request.getParameter("personName"));
		user.setUserName(request.getParameter("userName"));
		user.setUserPassword(request.getParameter("userPassword"));
		user.setCpf(request.getParameter("cpf"));
		user.setPhoto(request.getParameter("photo"));
		user.setBirthday(request.getParameter("birthday"));
		
		if(service.modify(user)) {
			response.sendRedirect("home.jsp");
	}

	}
}
