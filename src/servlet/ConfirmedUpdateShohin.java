package servlet;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.shohin.ConfirmErrorCheck;
import model.shohin.Shohin;
import model.shohin.ShohinModel;

@WebServlet("/ConfirmedUpdateShohin")
public class ConfirmedUpdateShohin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		Enumeration<String> addFormNames = request.getAttributeNames();
		System.out.println(addFormNames);

		String shohin_id = request.getParameter("shohin_id");
		String shohin_mei = request.getParameter("shohin_mei");
		String shohin_bunri = request.getParameter("shohin_bunrui");
		String hanbai_tanka = request.getParameter("hanbai_tanka");
		String shiire_tanka = request.getParameter("shiire_tanka");

		ConfirmErrorCheck cec = new ConfirmErrorCheck();
		cec.shohinCheck(shohin_id, shohin_mei, shohin_bunri, hanbai_tanka, shiire_tanka);
		if(cec.getErrorMessage().equals("")) {
			ShohinModel shohinModel = new ShohinModel();
			Shohin shohin = Shohin.builder()
					.shohin_id(Integer.parseInt(shohin_id))
					.shohin_mei(shohin_mei)
					.shohin_bunrui(shohin_bunri)
					.hanbai_tanka(Integer.parseInt(hanbai_tanka))
					.shiire_tanka(Integer.parseInt(shiire_tanka))
					.torokubi(null)
					.build();
			shohinModel.insert(shohin);
			request.setAttribute("message", cec);
		}else {
			request.setAttribute("message", cec);
		}
		//ErrorMessage.toString()
		RequestDispatcher dispatcher
		= request.getRequestDispatcher("/WEB-INF/jsp/addShohin.jsp");
			dispatcher.forward(request,response);
	}

}
