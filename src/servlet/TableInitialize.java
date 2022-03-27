package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.shohin.ShohinModel;

@WebServlet("/TableInitialize")
public class TableInitialize extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ShohinModel shohinModel = new ShohinModel();
		shohinModel.deleteAll();
		shohinModel.tableInitialize();
		response.sendRedirect("/shohinKanri_18/Main");
	}
}
