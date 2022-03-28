package servlet;

import java.io.IOException;
import java.util.List;

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
			request.setAttribute("shohinList",null);
		}else {
			ShohinModel shohinModel = new ShohinModel();
			List<Shohin> shohinList = shohinModel.selectAny(shohin_mei,shohin_bunrui);
//			shohinList.stream().forEach(System.out::println);
			request.setAttribute("shohinList", shohinList);
		}
		RequestDispatcher dispatcher
		= request.getRequestDispatcher("/WEB-INF/jsp/main.jsp");
			dispatcher.forward(request,response);
	}
}
