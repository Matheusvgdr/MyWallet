package control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/InserTypeServlet")
public class InserTypeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public InserTypeServlet() {
        super();

    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String pfd = request.getParameter("deposit");
		String n = request.getParameter("nome");
		
		HttpSession session = request.getSession();
		
		session.setAttribute("type", pfd);
		session.setAttribute("nm", n);
		response.sendRedirect("movimentatio.jsp");
		
	
	}

}
