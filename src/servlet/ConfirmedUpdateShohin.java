package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.shohin.ConfirmErrorCheck;
import model.shohin.Shohin;
import model.shohin.ShohinModel;
import model.shohin.VerifyModel;

@WebServlet("/ConfirmedUpdateShohin")
public class ConfirmedUpdateShohin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		HttpSession session = request.getSession(true);
		session.removeAttribute("message");
		Shohin shohin = (Shohin)session.getAttribute("shohin");
		ShohinModel shohinModel = new ShohinModel();
		VerifyModel verifyModel = new VerifyModel();
		ConfirmErrorCheck cec = new ConfirmErrorCheck();
		String error=cec.shohinCheck(shohin).toString();
		if(error.isBlank()) {
			verifyModel.setUpdated(shohinModel.update(shohin));
		}
		request.setAttribute("message", cec);
		request.setAttribute("verifyModel", verifyModel);
		RequestDispatcher dispatcher
		= request.getRequestDispatcher("/WEB-INF/jsp/updateShohin.jsp");
			dispatcher.forward(request,response);
	}

}
