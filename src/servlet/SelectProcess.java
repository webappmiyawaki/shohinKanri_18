package servlet;

import java.io.IOException;
import java.util.regex.Pattern;

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
	String shohin = request.getParameter("shohin");

	String shohin_id = "";
	String shohin_mei = "";
	String shohin_bunrui = "";
	String hanbai ="";
	String shiire = "";

	if(shohin==null) {
		shohin_id =request.getParameter("shohin_id");
		shohin_mei =request.getParameter("shohin_mei");
		shohin_bunrui =request.getParameter("shohin_bunrui");
		hanbai = request.getParameter("hanbai_tanka");
		shiire = request.getParameter("shiire_tanka");
	}else {
		String[] strAry = shohin.split(",");
		shohin_id=strAry[0];
		shohin_mei= strAry[1];
		shohin_bunrui = strAry[2];
		hanbai = strAry[3];
		shiire = strAry[4];
	}
	Pattern pattern = Pattern.compile("^[0-9]+$|-[0-9]+$");
	if(shohin_id==null||shohin_id.isBlank()) {shohin_id="0";}

	boolean isInteger_hanbai_tanka=false;
	boolean isInteger_shiire_tanka=false;

	if(hanbai==null||hanbai.isBlank()) {hanbai="0";
	}else {
    	isInteger_hanbai_tanka = pattern.matcher(hanbai).matches();
    	if(!isInteger_hanbai_tanka) {
    		hanbai=hanbai.substring(0, hanbai.indexOf("."));
    	}
	}

	if(shiire==null||shiire.isBlank()) {shiire="0";
	}else {
		isInteger_shiire_tanka = pattern.matcher(shiire).matches();
		if(!isInteger_shiire_tanka) {
    		shiire=shiire.substring(0, shiire.indexOf("."));
    	}
	}


    HttpSession session = request.getSession(true);
	session.setAttribute("shohin",Shohin.builder()
			.shohin_id(Integer.parseInt(shohin_id))
			.shohin_mei(shohin_mei)
			.shohin_bunrui(shohin_bunrui)
			.hanbai_tanka(Integer.parseInt(hanbai))
			.shiire_tanka(Integer.parseInt(shiire))
			.isInteger_hanbai_tanka(isInteger_hanbai_tanka)
			.isInteger_shiire_tanka(isInteger_shiire_tanka)
			.build());

	String processPath=null;
	if(baseProcessName!=null) {
	switch(baseProcessName) {
		case "更新":	processPath="/UpdateShohin";break;
		case "削除":	processPath="/DeleteShohin";break;
//		case "テーブル初期化":processPath="/TableInitialize";break;
		case "追加":	processPath="/shohinKanri_18/AddShohin";break;
		case "検索":processPath="/SearchShohin";break;
		case "csv全件出力": processPath="/GenerateCsv";break;
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
