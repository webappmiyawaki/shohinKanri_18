package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.shohin.IsModel;
import model.shohin.Shohin;
import model.shohin.ShohinModel;

@WebServlet("/DeleteShohin")
public class DeleteShohin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession(true);
		Shohin shohin = (Shohin)session.getAttribute("shohin");

		IsModel isModel = new IsModel();
		if(shohin.getShohin_id()==0) {
			ShohinModel shohinModel = new ShohinModel();
			isModel.setDelete(shohinModel.deleteUnit(shohin.getStringShohin_id()));
			request.setAttribute("isModel", isModel);
		}
		request.getRequestDispatcher("/Main").forward(request, response);
	}

}
