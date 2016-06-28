<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>   
<%@ taglib prefix="s" uri="/struts-tags" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="Font-Awesome-3.2.1/css/font-awesome.css">
<link rel="stylesheet" href="Font-Awesome-3.2.1/css/font-awesome.min.css">
    <style type="text/css">
table {
	font: normal;
	color:#1F6A8E;
	font-size: 20px;
}
.test {
   height: 35px;
   width: 35%;
   background:#EDE7D8;
}
body{
	background-image: url(images/body_bg.jpg);
	background-position: 50% 50%;
}
.button {
    position: relative;
    background-color: #217B96;
    border: none;
    font-size: 28px;
    color: #FFFFFF;
    padding: 16px;
    width: 200px;
    text-align: center;
    -webkit-transition-duration: 0.4s; /* Safari */
    transition-duration: 0.4s;
    text-decoration: none;
    overflow: hidden;
    cursor: pointer;
    border-radius: 12px;
}

.button:after {
    content: "";
    background: #90EE90;
    display: block;
    position: absolute;
    padding-top: 300%;
    padding-left: 350%;
    margin-left: -20px!important;
    margin-top: -120%;
    opacity: 0;
    transition: all 0.8s
}

.button:active:after {
    padding: 0;
    margin: 0;
    opacity: 1;
    transition: 0s
}
.button2 {
	padding: 16px 32px;
	font-size: 16px;
    margin: 4px 2px;
    background-color: #77B6C8;; 
    color: #1F6A8E; 
}

.button2:hover {
    background-color: #008CBA;
    color: white;
}
#i{width:350px;height:15px;color:blue;font-size:12px;}
.checkbox-wrapper {
    width: 58px;
    height: 16px;
    position: relative;
    display: inline-block;
    background: #ffffff;
    border-radius: 16px;
    transition: all .3s ease-out;
    box-shadow: 0px 0px 0px 2px #ddd;
}
.checkbox {
    display: none;
}
.checkbox-label {
    display: block;
    position: absolute;
    left: 0px;
    top: 0px;
    width: 32px;
    height: 16px;
    cursor: pointer;
    background: #ffffff;
    border-radius: 16px;
    box-shadow: 0px 2px 3px rgba(0,0,0,0.2);
    transition: all .3s ease-out;
}
.checkbox:checked + .checkbox-wrapper {
    background: #0bd318;
    box-shadow: 0px 0px 0px 2px #0bd318;
}
.checkbox:checked + .checkbox-wrapper .checkbox-label {
    left: 26px;
}

</style>
<!--[if IE 7]>
<link rel="stylesheet" href="assets/css/font-awesome-ie7.min.css">
<![endif]-->
<title>用户注册</title>
<script type="text/javascript" src="js/register_jsc.js"></script>
<script type="text/javascript" src="js/jquery-1.9.1.min.js"></script>
<script type="text/javascript" src="layer/layer.js"></script>
<script type="text/javascript">
     function loading(){
    var ii = layer.load();
    //此处用setTimeout演示ajax的回调
    setTimeout(function(){
        layer.close(ii);
    }, 3000);
};
	function vali(){
		var lo = layer.load(1);
		
		setTimeout(function(){
	        layer.close(lo);
	    }, 2000);
	};
</script>
</head>
<body onload="loading()">
	<s:form action="register.action" onsubmit="return validate();" method="post" theme="simple">
	<button class="button2" type="button" onclick="javascript:history.back(-1);"> << 返回</button>
	 <table align="center" width="1000"  height="600">
	   	<tr><th colspan="3"><font size="18px">新用户注册</font></th></tr>
	 	<tr align="right"><td><i class="icon-user"></i>用户名:</td>
	 		<td align="left"> 
	 			<s:textfield cssClass="test" name="name" maxLength="12" placeholder="请输入用户名" />
	 			<font id="i">用户名由字母开头、后跟字母数字或下划线！</font>
	 		</td>
	 	</tr>
	 	<tr align="right"><td><i class="icon-key"></i>密码:</td>
	 		<td align="left"> 
	 			<s:password cssClass="test" name="password" maxLength="15" placeholder="请输入密码" />
	 			<font id="i">请输入密码，至少设置六位</font>
	 		</td>
	 	</tr>
	 	<tr	align="right"><td><i class="icon-random"></i>确认密码:</td>
	 		<td	align="left"> 
	 			<s:textfield cssClass="test" name="repassword" maxLength="15" placeholder="请再次输入密码"/>
	 			<font id="i">请再次输入密码</font>
	 		</td>
	 	</tr>
	 	<tr	align="right"><td><i class="icon-magnet"></i>性别:</td>
	 		<td	align="left">
	 			<s:radio list="{'男','女'}" name="gender" value="1"/> 
	 		</td>
	 	</tr>
	 	<tr	align="right"><td><i class="icon-coffee"></i>职业:</td>
			<td	align="left">
				<s:select cssClass="test" list="{'计算机/互联网/通信','生产/工艺/制造','金融/银行/投资','文化/广告/传媒','公务员/行政/事业单位','学生','其他'}"  name="job" headerValue="---请选择你的职业---" headerKey="1"/>
			</td>
	 	</tr>
	 	<tr	align="right"><td><i class="icon-heart"></i>个人爱好:</td>
	 		<td	align="left"><s:checkboxlist name="hobby" list="{'运动', '音乐','阅读', '互联网'}"/>  
	 		</td>
	 	</tr>
	 	<tr	align="right"><td><i class="icon-info-sign"></i>电子邮箱:</td>
	 		<td	align="left">
	 			<s:textfield cssClass="test" name="information" placeholder="请输入常用电子邮箱"/> 
	 		</td>
	 	</tr>
	 	<tr>
	 		<td colspan="3" align="center" height="45">
	 			<input type="checkbox" id="checkbox" class="checkbox" name="accept" value="yes">
       			<div class="checkbox-wrapper">
    				<label for="checkbox" class="checkbox-label"></label>
				</div>
				 <font color="#224352" size="3">我已仔细阅读并接受用户使用协议</font>
	 		</td>
	 	</tr>
	 	<tr align="center">
	 		<td>
	 			<button class="button" onclick="vali()">注册</button>
	 		</td>
	 		<td>
	 		<button type="reset" class="button">重新填写</button>
	 		</td>
	 	</tr>
	</table>
	</s:form>
</body>
</html>