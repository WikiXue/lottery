package com.wiki;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Lucky {
	
	private static String DATA = "data.txt";
	private static String CONF = "lucky-conf.txt";
	private static int count = 0;//参与的人数
	private static int num = 0;//抽奖的人数
	private static ArrayList<String> people = new ArrayList<String>();
	private static String LOG = "log.txt";
	private static StringBuffer loginfo = new StringBuffer();
	private static HashMap<String, Integer> fridend_map = new HashMap<>(); 
	private static HashMap<String, Integer> stranger_map = new HashMap<>(); 
	public static void main(String[] args) {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");//设置日期格式
        String datetime = df.format(new Date());// new Date()为获取当前系统时间
		loginfo.append(datetime+"\r\n");
		
		readFile(DATA);//读入数据文件
		readConfFile(CONF);//读入配置文件
		writeFile(luckyDraw(count,num));//进行抽奖
		//writeLog();//写入日志
	}

	/**
     * 读入数据文件
     */
    public static ArrayList<String> readFile(String pathname) {
        try (FileReader reader = new FileReader(pathname);
             BufferedReader br = new BufferedReader(reader)
        ) {
        		String line;
        		//姓名-空行-评论-空行
        		if((line = br.readLine()) != null && line.equals("我的好友")){	//我的好友
        			br.readLine();//空行
        			line = br.readLine();//姓名
        			while (true) {
                		//System.out.println(line);
                		if(!fridend_map.containsKey(line)) {//
                    		count++;
                			fridend_map.put(line, 1);
                			people.add(count+"."+line);
                    		loginfo.append(count+"."+line+"\r\n");
                		}
                		br.readLine();//空行
                		while(true) {//评论可能有多行
                			if((line = br.readLine()).equals("")) {//空行
                				break;
                			}else {//评论
                			}
                		}
                		if((line = br.readLine()).equals("陌生人")) {//陌生人
                			//br.readLine();//空行
                			break;
                		}else if(line.equals("已加载全部")) {
                			return people;
                		}
                }   
        		}else {
        			
        		}
//        		//姓名-空行-评论-空行-加好友-空行
//        		if(!line.equals("陌生人")) {//不等于陌生人
//            		line = br.readLine();//陌生人
//            		br.readLine();//空行
//            		line = br.readLine();//姓名
//        		}
        		br.readLine();//空行
        		line = br.readLine();//姓名
            while (true) {
            		//System.out.println(line);//姓名
            		if(!stranger_map.containsKey(line)) {//
            			count++;
            			stranger_map.put(line, 1);
            			people.add(count+"."+line);
            			loginfo.append(count+"."+line+"\r\n");
            		}
            		br.readLine();//空行
            		while(true) {
            			if(!br.readLine().equals("")) {//评论	
            			}else {
            				break;//空行
            			}
            		}
            		br.readLine();//加好友
            		br.readLine();//空行
            		if((line = br.readLine()).equals("已加载全部")) {
            			break;
            		}
            }   		
        }catch (IOException e) {
            e.printStackTrace();
        }
		return people;
    }
    
    /**
     * 读入配置文件
     */
    public static void readConfFile(String pathname) {
        try (FileReader reader = new FileReader(pathname);
             BufferedReader br = new BufferedReader(reader)
        ) {
        		String line;
        		//姓名-空行-评论-空行
        		if((line = br.readLine()) != null){	//
        			line = line.substring(5, line.length());
        			Pattern pattern = Pattern.compile("[0-9]*");
        	        Matcher isNum = pattern.matcher(line);
        	        if( !isNum.matches() ){
        	        	   	loginfo.append("人数错误！"+"人数为:"+line+"\r\n");
        	            return;
        	        }
        	        num = Integer.parseInt(line);
        			//System.out.println(num);
        		}else {
        			loginfo.append("配置文件错误！\r\n");
        			return;
        		}  		
        }catch (IOException e) {
            e.printStackTrace();
        }
      
    }

    /**
     * 进行抽奖
     */
    public static int[] luckyDraw(int count,int num) {
    		int len = count;//参与抽奖人数
    		//初始化给定范围的待选数组  
        int[] source = new int[len];  
        for (int i = 0; i < len; i++){  
           	source[i] = i;  
        }  
        int[] result = new int[num];  
        Random rd = new Random();  
        int index = 0;  
        for (int i = 0; i < result.length; i++) {  
        		//待选数组0到(len-2)随机一个下标  
            index = Math.abs(rd.nextInt() % len--);  
            //将随机到的数放入结果集  
            result[i] = source[index];  
            //将待选数组中被随机到的数，用待选数组(len-1)下标对应的数替换  
            source[index] = source[len];  
        }     
        return result;      
    }
    
    /**
     * 写入TXT文件
     */
    public static void writeFile(int[] result) {
        try {
        	SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");//设置日期格式
        String datetime = df.format(new Date());// new Date()为获取当前系统时间
        File writeName = new File(datetime+".txt"); // 相对路径，如果没有则要建立一个新的txt文件
        writeName.createNewFile();  //创建新文件,有同名的文件的话直接覆盖
            try (FileWriter writer = new FileWriter(writeName);
                 BufferedWriter out = new BufferedWriter(writer)
            ) {
            	out.write("中奖人为:\r\n");
            	for(int i = 0;i < result.length;i++) {
                out.write(people.get(result[i])+"\r\n"); // \r\n即为换行
            }
        		out.write("\r\n\r\n参与人员:\r\n");
        		for (String str : people) {
				out.write(str+"\r\n");
			}
            out.flush(); // 把缓存区内容压入文件
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /**
     * 写入日志文件
     */
    public static void writeLog() {
    		try {
    			File writeName = new File(LOG); // 相对路径，如果没有则要建立一个新的txt文件
            try (FileWriter writer = new FileWriter(writeName,true);
                 BufferedWriter out = new BufferedWriter(writer)
            ) {
            		out.write(loginfo.toString());
            		out.flush(); // 把缓存区内容压入文件
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
