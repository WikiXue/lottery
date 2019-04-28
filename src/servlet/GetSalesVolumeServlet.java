package servlet;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;

import model.Sale;

@WebServlet("/GetSalesVolumeServlet")
public class GetSalesVolumeServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		Sale sale = new Sale();
		Integer[] sales = {10,100,20,56,35,80};
		List<Integer> saleList = Arrays.asList(sales);
		sale.setSales(saleList);
		String json = JSON.toJSONString(sale);
		response.getWriter().println(json);
	}

}
