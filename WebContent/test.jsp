<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
    <form enctype="multipart/form-data">
        <div>
            <textarea name="meno" style="height: 50px;width: 70px;resize: none;">asdfasdf</textarea>
            <select name="city" size="10" multiple="multiple">
                <option value="1">北京</option>
                <option value="2">上海</option>
                <option value="3" selected="selected">南京</option>
                <option value="4">成都</option>
            </select>
            <input type="text" name="user" />
            
            <select>
				<option value ="volvo">龙岩</option>
				<option value ="saab">厦门</option>
				<option value="opel">漳州</option>
				<option value="audi">泉州</option>
			</select>
            
            <p>请选择性别：</p>
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
        </div>
 
        <input type="submit" value="提交" />
        <input type="reset" value="重置" />
    </form>
</body>
</html>

