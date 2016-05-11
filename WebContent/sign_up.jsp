
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>   
<%@ taglib prefix="s" uri="/struts-tags" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="Font-Awesome-3.2.1/css/font-awesome.css">
<link rel="stylesheet" href="Font-Awesome-3.2.1/css/font-awesome.min.css">
    <style type="text/css">
    body { font-size:15px;}
    #title{ color:#FF7B0B ;font-size:20px ; font-weight:bold; }
    .td{ height:80px ;}
    .info{ color:#BBBBBB ;}
    </style>
<!--[if IE 7]>
<link rel="stylesheet" href="assets/css/font-awesome-ie7.min.css">
<![endif]-->
<title>用户注册提交</title>
</head>
<body bgcolor="#222D52">
	<s:form action="register.action"  method="post" theme="simple">
	 <table align="center" border="1"  height=100%>
	   	<tr bgcolor="#7D7FC7"><th colspan="2"><font size="18px">新用户注册</font></th></tr>
	 	<tr><td><i class="icon-user"></i>用户名:</td>
	 		<td class="info"> <s:textfield name="user.name" maxLength="12" placeholder="请输入用户名"/>
	 		 用户名由字母开头，后跟字母、数字或下划线
	 		</td>
	 	</tr>
	 	<tr align="left"><td><i class="icon-key"></i>密码:</td>
	 		<td class="info"> <s:textfield name="user.password" label="密码" maxLength="15" placeholder="请输入密码"/>
	 		请输入密码，至少设置六位
	 		</td>
	 	</tr>
	 	<tr><td><i class="icon-random"></i>确认密码:</td>
	 		<td class="info"> <s:textfield name="password" label="密码" maxLength="15" placeholder="再次输入密码"/> 
	 		请再输一次你的密码
	 		</td>
	 	</tr>
	 	<tr><td><i class="icon-magnet"></i>性别:</td>
	 		<td class="info"><s:radio list="{'男','女'}" name="user.gender" value="1"/>
	 		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;请选择你的性别</td>
	 	</tr>
	 	<tr><td><i class="icon-coffee"></i>职业:</td>
			<td><s:select list="{'学生','教授','工程师'}" theme="simple" name="user.job" headerValue="---请选择你的职业---" headerKey="1"/> </td>
	 	</tr>
	 	<tr><td><i class="icon-heart"></i>个人爱好:</td>
	 		<td><s:checkboxlist name="user.hobby" list="{'football', 'music','basketball', 'computer'}"/>  </td>
	 	</tr>
	 	<tr><td valign="baseline"><i class="icon-info-sign"></i>个人信息:</td>
	 		<td><s:textarea rows="8" cols="60" name="user.information"/></td>
	 	</tr>
	 	<tr align="center"><td colspan="2"><input type="submit" value="注册">
	 		<input type="reset" value="重新输入"></td>
	 	</tr>
	</table>
	</s:form>
</body>
</html>