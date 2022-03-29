package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.shohin.IsModel;
import model.shohin.Shohin;
import model.shohin.ShohinModel;

@WebServlet("/SerchShohin")
public class SerchShohin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession(true);
		Shohin shohin = (Shohin)session.getAttribute("shohin");

		ShohinModel shohinModel = new ShohinModel();
		List<Shohin> shohinList=null;
		IsModel isModel = new IsModel();
		if(shohin.getShohin_mei().equals("")&&shohin.getShohin_bunrui()==null) {
			shohinList = shohinModel.selectAll();
		}else if(shohin.getShohin_mei().equals("")||shohin.getShohin_bunrui().equals("")) {
			shohinList = shohinModel.selectAny(shohin.getShohin_mei(),shohin.getShohin_bunrui());
		}else {
			shohinList = shohinModel.selectAny(shohin.getShohin_mei(),shohin.getShohin_bunrui());
		}

		request.setAttribute("isSearched", isModel);
		request.setAttribute("shohinList", shohinList);
		request.getRequestDispatcher("/WEB-INF/jsp/main.jsp").forward(request,response);
	}
}
