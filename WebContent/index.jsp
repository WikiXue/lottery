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
			<label for="people_label" style="position: absolute; top:160px; left:360px;">
			<font style="font-weight: bold;"></font>参与人</label>
            <select id="people" name="city" size="20" multiple="multiple"
            style="position: absolute; top:200px; left:350px;width:200px;">
            </select>
			<label id="lucky_label" style="position: absolute; top:160px; left:660px;">
			<font style="font-weight: bold;"></font>中奖人</label>
            <select id="lucky" size="20" multiple="multiple"
            style="position: absolute; top:200px; left:650px;width:200px;">
            </select>
 			<label id="num" style="display:none">0</label>
        <input type="submit" value="开始抽奖" 
        style="position: absolute; top:550px; left:575px;"/>
	</form>
 <script>
             function setData(){
            	 $.ajax({
     				type: "GET",
     				url: "LuckyServlet",
     				data:
     				{
     					
     				},
     				async:false,
     				dataType: "json",
     				success: function(data){
     	            	 var objSelectNow=document.getElementById("people");
     	            	 var count = 0;
     					$.each(data, function(i, list) {
     						var objOption = document.createElement("OPTION");
     						objOption.text=data[i];
     						objOption.value=i;
     						objSelectNow.options.add(objOption);
     						count = i;
     					})
     					document.getElementById("num").innerText=count;
     				},
     				error: function(){
     					alert("error");
     				}
     				});
             }
</script>
<script>
             function setLucky(){
            	 var count = document.getElementById("num").innerText;
            	 $.ajax({
     				type: "GET",
     				url: "LuckyPeople",
     				data:
     				{	
     					num:count,
     				},
     				async:false,
     				dataType: "json",
     				success: function(data){
     	            	 var objSelectNow=document.getElementById("lucky");
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
             function start(){
            	 	setData();
            	 	setLucky();
             }
             window.onload=start;
</script>

</body>
</html>

<!-- 下一步工作是：
	1.进来加载人数，点击开始抽奖才开始抽奖
	2.抽奖的动态效果
	 -->


