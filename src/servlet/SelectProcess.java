package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
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
	String baseProcessName = request.getParameter("baseProcessName");
	String addProcessUpdate = request.getParameter("addProcessUpdate");

	String shohin_id =request.getParameter("shohin_id");
	String shohin_mei =request.getParameter("shohin_mei");
	String shohin_bunrui =request.getParameter("shohin_bunrui");
	String hanbai = request.getParameter("hanbai_tanka");
	String shiire = request.getParameter("shiire_tanka");

	if(shohin_id==null||shohin_id.isBlank()) {shohin_id="0";}
	if(hanbai==null||hanbai.isBlank()) {hanbai="0";}
	if(shiire==null||shiire.isBlank()) {shiire="0";}

	HttpSession session = request.getSession(true);
	session.setAttribute("shohin",Shohin.builder()
			.shohin_id(Integer.parseInt(shohin_id))
			.shohin_mei(shohin_mei)
			.shohin_bunrui(shohin_bunrui)
			.hanbai_tanka(Integer.parseInt(hanbai))
			.shiire_tanka(Integer.parseInt(shiire))
			.build());

	String processPath=null;
	if(baseProcessName!=null) {
	switch(baseProcessName) {
		case "更新":	processPath="/UpdateShohin";break;
		case "削除":	processPath="/DeleteShohin";break;
		case "テーブル初期化":processPath="/shohinKanri_18/TableInitialize";break;
		case "追加":	processPath="/shohinKanri_18/AddShohin";break;
		case "検索":processPath="/SearchShohin";break;
		case "csvダウンロード": processPath="/GenerateCsv";break;
	}}
	if(addProcessUpdate!=null) {
	switch(addProcessUpdate) {
		case "更新": processPath="/ConfirmedUpdateShohin";break;
		case "追加": processPath="/ConfirmedAddShohin";break;
	}
	}

	 RequestDispatcher dispatch = request.getRequestDispatcher(processPath);
	dispatch.forward(request,response);
	}

}
