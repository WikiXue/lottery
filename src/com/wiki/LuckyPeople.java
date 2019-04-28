package com.wiki;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

/**
 * Servlet implementation class LuckyPeople
 */
@WebServlet("/LuckyPeople")
public class LuckyPeople extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LuckyPeople() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pathname = "/Users/wikixue/eclipse-workspace2/LuckyWeb/data.txt";
		ArrayList<String> people = Lucky.readFile(pathname);
		String count = request.getParameter("num");
		System.out.println(count);
		int[] people_count = Lucky.luckyDraw(Integer.parseInt(count),5);
		ArrayList<String> people_lucky = new ArrayList<>();
		for (int p : people_count) {
			people_lucky.add(people.get(p));
			System.out.println(p);
		}
		JSONArray jsonArray = JSONArray.fromObject(people_lucky);
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.getWriter().print(jsonArray);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
