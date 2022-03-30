package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.shohin.Shohin;
import model.shohin.ShohinModel;
import model.shohin.VerifyModel;

@WebServlet("/SearchShohin")
public class SearchShohin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession(true);
		Shohin shohin = (Shohin)session.getAttribute("shohin");

		ShohinModel shohinModel = new ShohinModel();
		List<Shohin> shohinList=(List<Shohin>)session.getAttribute("shohinList");
		VerifyModel isModel = new VerifyModel();
//		if(shohin!=null) {
			shohinList = shohinModel.selectAny(shohin.getShohin_mei(),shohin.getShohin_bunrui());
//			if(shohin.getShohin_mei().equals("")&&shohin.getShohin_bunrui().equals("")) {
//				shohinList = shohinModel.selectAll();
//			}else if(shohin.getShohin_mei().equals("")||shohin.getShohin_bunrui().equals("")) {
//				shohinList = shohinModel.selectAny(shohin.getShohin_mei(),shohin.getShohin_bunrui());
//			}else {
//				shohinList = shohinModel.selectAny(shohin.getShohin_mei(),shohin.getShohin_bunrui());
//			}
//		}

		request.setAttribute("isSearched", isModel);
		request.setAttribute("shohinList", shohinList);
		session.setAttribute("shohinList", shohinList);
		request.getRequestDispatcher("/WEB-INF/jsp/main.jsp").forward(request,response);
	}
}
