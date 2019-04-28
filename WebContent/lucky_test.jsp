<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	%>
<!DOCTYPE html>
<html lang="en">
<head>
	<script src="./js/jquery-3.2.1.js"></script>
	 			
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body onload="setData();">
    <form enctype="multipart/form-data">
        <div>
<!--             <textarea name="meno" style="height: 50px;width: 70px;resize: none;">asdfasdf</textarea>-->            	
			<label for="num">参与人</label>
            <select id="city_id" name="city" size="20" multiple="multiple">
                <!-- <option value="1">北京</option>
                <option value="2">上海</option>
                <option value="3">南京</option>
                <option value="4">成都</option> -->
            </select>
            <!-- <script>
				var objSelectNow=document.getElementById("city_id");
				var inner="<option value='5'>深圳</option>";
				objSelectNow.innerHTML=inner;
				var objOption = document.createElement("OPTION");
				objOption.text="广州";
				objOption.value=6;
				objSelectNow.options.add(objOption);
			</script> -->
			<label for="lucky">中奖人</label>
            <select name="city2" size="20" multiple="multiple">
                <option value="1">北京</option>
                <option value="2">上海</option>
                <option value="3" selected="selected">南京</option>
                <option value="4">成都</option>
                <option value="11">北京</option>
                <option value="21">上海ssssssss</option>
                <option value="32">南京</option>
                <option value="43">成都</option>
                <option value="14">北京</option>
                <option value="25">上海</option>
                <option value="36">南京</option>
                <option value="47">成都</option>
            </select>
           <!--  <input type="text" name="user" />
            <select>
				<option value ="volvo">龙岩</option>
				<option value ="saab">厦门</option>
				<option value="opel">漳州</option>
				<option value="audi">泉州</option>
			</select>
             -->
            <!-- <p>请选择性别：</p>
            男：<input type="radio" name="gender" value="1"  />
            女：<input type="radio" name="gender" value="2" checked="checked"/>
            Alex：<input type="radio" name="gender" value="3"/>
            <p>爱好</p>
            篮球：<input type="checkbox" name="favor"  value="1" />
            足球：<input type="checkbox" name="favor"  value="2" checked="checked" />
            皮球：<input type="checkbox" name="favor"  value="3" />
            台球：<input type="checkbox" name="favor"  value="4" checked="checked"/>
            网球：<input type="checkbox" name="favor"  value="5" />
            <p>技能</p>
            撩妹：<input type="checkbox" name="skill" checked="checked" />
            写代码：<input type="checkbox" name="skill"/>
            <p>上传文件</p>
            <input type="file" name="fname"/>
        </div> -->
 
        <input type="submit" value="开始抽奖" />
<!--         <input type="reset" value="重置" /> -->    
	</form>
   <%--  <%
    request.setCharacterEncoding("UTF-8");
    String semestersSql = "select * from semesterrecord";
    try{
        Connection cn = DataBase.getConnection();//链接数据库的常规操作
        PreparedStatement ps = cn.prepareStatement(semestersSql);
        ResultSet rs = ps.executeQuery();
        while(rs.next()){%>
        <script>
        $(document).ready(function(){
            $("#semester").append("<option value='<%=rs.getString(1)%>'><%=rs.getString(1)%></option>");
        });
        </script>
        <% }
    }catch(Exception e){}

%> --%>
 <script>
             function setData(){
         /*    	 var user_id =  document.getElementById("inputUsername").value;
            	 var user_password =  document.getElementById("inputPassword").value;
            	 var isVaild; */
            	 $.ajax({
     				type: "GET",
     				url: "LuckyServlet",
     				data:
     				{
     					
     				},
     				async:false,
     				dataType: "json",
     				success: function(data){
     	            	 var objSelectNow=document.getElementById("city_id");
     					$.each(data, function(i, list) {
     						var objOption = document.createElement("OPTION");
     						objOption.text=data[i];
     						objOption.value=i;
     						objSelectNow.options.add(objOption);
     					})
     				},
     				error: function(){
     					alert("error");
     				}
     				});
             }
             window.onload=setData;
</script>
</body>
</html>

