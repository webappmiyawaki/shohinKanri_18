package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.shohin.Shohin;
import model.shohin.ShohinModel;

@WebServlet("/SerchShohin")
public class SerchShohin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String shohin_mei = request.getParameter("shohin_mei");
		String shohin_bunrui = request.getParameter("shohin_bunrui");

		if(shohin_mei==null||shohin_bunrui==null) {
			request.setAttribute("shohin",null);
		}else {
			ShohinModel shohinModel = new ShohinModel();
			Shohin shohin = shohinModel.selectUnit(shohin_mei,shohin_bunrui);
			System.out.println(shohin);
			request.setAttribute("shohin", shohin);
		}
		RequestDispatcher dispatcher
		= request.getRequestDispatcher("/WEB-INF/jsp/main.jsp");
			dispatcher.forward(request,response);
	}
}
