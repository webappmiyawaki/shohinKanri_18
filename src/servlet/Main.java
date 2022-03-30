package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/Main")
public class Main extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String requestPath=null;
		if(session.getAttribute("shohinList")==null) {
			requestPath="/WEB-INF/jsp/main.jsp";
		}else {
			requestPath="/SearchShohin";
		}
		request.getRequestDispatcher(requestPath).forward(request, response);
	}

}
