package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.shohin.IsModel;
import model.shohin.Shohin;
import model.shohin.ShohinModel;

@WebServlet("/SerchShohin")
public class SerchShohin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String shohin_mei = request.getParameter("shohin_mei");
		String shohin_bunrui = request.getParameter("shohin_bunrui");
		ShohinModel shohinModel = new ShohinModel();
		List<Shohin> shohinList=null;
		IsModel isModel = new IsModel();
		if(shohin_mei==null||shohin_bunrui==null) {
			shohinList = shohinModel.selectAll();
		}else if(shohin_mei.equals("")||shohin_bunrui.equals("")) {
			shohinList = shohinModel.selectAll();
		}else {
			shohinList = shohinModel.selectAny(shohin_mei,shohin_bunrui);
		}

		request.setAttribute("isSearched", isModel);
		request.setAttribute("shohinList", shohinList);
		request.getRequestDispatcher("/WEB-INF/jsp/main.jsp").forward(request,response);
	}
}
