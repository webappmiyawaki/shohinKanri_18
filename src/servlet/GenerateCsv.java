package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.shohin.Shohin;


@WebServlet("/GenerateCsv")
public class GenerateCsv extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		List<Shohin>shohinList=(List<Shohin>)session.getAttribute("shohinList");
		if(shohinList==null) {
			request.getRequestDispatcher("/WEB-INF/jsp/main.jsp").forward(request, response);
		}

		String filename = "shohin.csv";
        response.setHeader("Content-Type", "text/csv; charset=UTF-8");
        response.setHeader("Content-Disposition", "attachment; filename=\""+filename+"\"");
        StringBuffer sb = new StringBuffer();
        sb.append("商品ID,商品名,商品分類,販売単価,仕入単価");
        for(Shohin shohin:shohinList) {
        	sb.append("\n").append(shohin);
        }

        PrintWriter pw = response.getWriter();
        pw.print(sb.toString());
        pw.flush();
	}

}
