package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.shohin.ShohinModel;

@WebServlet("/Main")
public class Main extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ShohinModel shohinModel =new ShohinModel();

		HttpSession session = request.getSession();

		//戻り値：List<Shohin>
		session.setAttribute("shohinList",shohinModel.selectAll());

		RequestDispatcher dispatcher =
		        request.getRequestDispatcher("/WEB-INF/jsp/main.jsp");

		    dispatcher.forward(request, response);
	}

}