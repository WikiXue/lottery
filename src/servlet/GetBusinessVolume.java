package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;

import model.BussinessVolume;

@WebServlet("/GetBusinessVolumeServlet")
public class GetBusinessVolume extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		BussinessVolume bv = new BussinessVolume();
		double[] bussinessVolume = {10*10,100*8.5,20*9.5,56*9,35*9.5,80*9};
		bv.setBussinessVolume(bussinessVolume);
		String json = JSON.toJSONString(bv);
		response.getWriter().println(json);
	}

}
