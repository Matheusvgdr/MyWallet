package control;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.TypeMov;
import service.TypeMovService;


@WebServlet("/PrepareMovimentationServlet")
public class PrepareMovimentationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public PrepareMovimentationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		TypeMovService servico = new TypeMovService();
		
		List<TypeMov> listOfTypes = new ArrayList<TypeMov>();
		
		HttpSession session = request.getSession();
		
		listOfTypes = servico.listar();
		
		session.setAttribute("typeMovi", listOfTypes);
		
		response.sendRedirect("movimentation.jsp");
		
	}

}
