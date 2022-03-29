package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.shohin.Shohin;

@WebServlet("/SelectProcess")
public class SelectProcess extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	String processName = (String) request.getAttribute("processName");
	String id =null;
	String hanbai = request.getParameter("hanbai_tanka");
	String shiire = request.getParameter("shiire_tanka");

	if(id==null) {id="0";}
	if(hanbai==null) {hanbai="0";}
	if(shiire==null) {shiire="0";}
	HttpSession session = request.getSession(true);
	session.setAttribute("shohin",Shohin.builder()
			.shohin_id(Integer.parseInt(id))
			.shohin_mei(request.getParameter("shohin_mei"))
			.shohin_bunrui(request.getParameter("shohin_bunrui"))
			.hanbai_tanka(Integer.parseInt(hanbai))
			.shiire_tanka(Integer.parseInt(shiire))
			.build());

	String processPath=null;
	switch(processName) {
		case "更新":	processPath="/UpdateShohin";break;
		case "削除":	processPath="/DeleteShohin";break;
		case "テーブル初期化":processPath="/TableInitialize";break;
		case "追加":	processPath="/AddShohin";break;
		case "検索":processPath="/SearchShohin";break;
	}
	request.getRequestDispatcher(processPath).forward(request,response);
	}

}
