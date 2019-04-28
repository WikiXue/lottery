package test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSON;

import model.BussinessVolume;
import model.MonthNumber;
import model.Sale;

class Month{
	private String[] month;

	public String[] getMonth() {
		return month;
	}

	public void setMonth(String[] month) {
		this.month = month;
	}
	
}

class Month1{
	private List<String> month;

	public List<String> getMonth() {
		return month;
	}

	public void setMonth(List<String> month) {
		this.month = month;
	}
	
}

public class FastJsonTest {

	public void test() {
		System.out.println("FastJsonTest.test()");
		String[] months = {"1","2","3","4","5","6"};
		Month month = new Month();
		month.setMonth(months);
		String json = JSON.toJSONString(month);	
		System.out.println(json);
		
	}
	
	public void test1() {
		System.out.println("FastJsonTest.test1()");
		String[] months = {"1","2","3","4","5","6"};
		List<String> monthList = Arrays.asList(months);
		Month1 month = new Month1();
		month.setMonth(monthList);
		String json = JSON.toJSONString(month);	
		System.out.println(json);
		
	}
	
	public void test2Map() {
		System.out.println("FastJsonTest.test2Map()");
		Map<String, List<String>> map = new HashMap<>();
		String[] months = {"1","2","3","4","5","6"};
		String[] monthName = {"Jan","Feb","Apr","Mar","May","June"};
		List<String> monthList = Arrays.asList(months);
		List<String> monthNameList = Arrays.asList(monthName);
		map.put("month", monthList);
		map.put("monthName", monthNameList);
		String json = JSON.toJSONString(map);
		System.out.println(json);
	}
	
	public void testComplextMap(){
		/*销量*/
		Integer[] salesVolume = {10,100,20,56,35,80};
		/*营业额*/
		double[] bussinessVolume = {10*10,100*8.5,20*9.5,56*9,35*9.5,80*9};
		/*横轴, 月份数据*/
		String[] months = {"1","2","3","4","5","6"};
		
		Map<String, Object> map = new HashMap<>();
		map.put("salesVolume", salesVolume);
		map.put("bussinessVolume",bussinessVolume);
		map.put("months", months);
		
		System.out.println(JSON.toJSONString(map));
	}
}
