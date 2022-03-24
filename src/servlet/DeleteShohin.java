package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.shohin.ShohinModel;

@WebServlet("/DeleteShohin")
public class DeleteShohin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String shohin_id = request.getParameter("shohin_id");
		if(shohin_id!=null) {
			ShohinModel shohinModel = new ShohinModel();
			shohinModel.deleteUnit(shohin_id);
		}
		RequestDispatcher dispatcher =
		        request.getRequestDispatcher("/Main");

		    dispatcher.forward(request, response);
	}

}