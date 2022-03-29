package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.shohin.ShohinModel;

@WebServlet("/UpdateShohin")
public class UpdateShohin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ShohinModel shohinModel = new ShohinModel();
		String shohin_id = request.getParameter("shohin_id");

		shohinModel.update(shohin_id);

		request.getRequestDispatcher("/WEB-INF/jsp/updateShohin.jsp").forward(request,response);
	}

}
