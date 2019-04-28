package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;

import model.MonthNumber;

@WebServlet("/GetMonthServlet")
public class GetMonthServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String[] months = {"1","2","3","4","5","6"};
		MonthNumber month = new MonthNumber();
		month.setMonth(months);
		String json = JSON.toJSONString(month);	
		response.getWriter().println(json);
	}

}
