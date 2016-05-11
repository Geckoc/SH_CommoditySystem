<!--          
                                               ベジータ (VEGETA) In the Here.
                               BUG LESS.                   
                           My code is compiling…
                   		It's not a bug, it’s a feature.   
                   Have you tried turning it off and on again?
                                                     (IT CROWD---Roy)               
                                     ,
                               ,   ,'|
                             ,/|.-'   \.
                          .-'  '       |.
                    ,  .-'              |
                   /|,'                 |'
 				  / '   ベジータ (VEGETA)   |  ,
                 /    神兽镇守    无BUG        ,'/
              .  |          _              /
               \`' .-.    ,' `.           |
                \ /   \ /      \          /
                 \|    V        |        |  ,
                  (           ) /.--.   ''"/
                  "b.`. ,' _.ee'' 6)|   ,-'
                    \"= --""  )   ' /.-'
                     \ / `---"   ."|'
        \"..-    .'  |.
                       `-__..-','   |
                     __.) ' .-'/    /\._
               _.--'/----..--------. _.-""-._
            .-'_)   \.   /     __..-'     _.-'--.
           / -'/      """""""""         ,'-.   . `.
          | ' /                        /    `   `. \
          |   |                        |         | |
           \ .'\                       |     \     |
          / '  | ,'               . -  \`.    |  / /
         / /   | |                      `/"--. -' /\
        | |     \ \                     /     \     |
        | \      | \                  .-|      |    | 
                                                                         
                                                                         
                                                                          -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>   
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="css/login.css">
<title>后台管理员登录</title>
</head>
<body>
<div id="wrapper">
	<div id="header">
		<div id="logo"></div>
		<div id="heading">
			<div id="title">销售存管理系统</div>
			<div id="subTitle">Bveac 1.0</div>
		</div>
	</div>
	<div id="main">
		<div id="mainBg">
			<div id="mainPanel">
				<div id="left">
					<div id="image"></div>
				</div>
				<div id="right">
<s:form action="login.action" method="post">
	<!-- start of login form -->
					<div id="welcome">
						<span id="welcome-text">管&nbsp;理&nbsp;登&nbsp;录</span>
					</div>
					<div id="user-name">
						<span class="item">用户名:</span>
						<span><input type="text" name="user.name" class="form-input"></span>
					</div>
					<div id="user-password">
						<span class="item">密&nbsp;&nbsp;&nbsp;码:</span>
						<span class="input"><input type="password" name="user.password" class="form-input"></span>
					</div>
					<div id="button-group">
						<input type="submit" class="btn" value="登录"/>
						<input type="reset" class="btn" value="重置"/>
					</div>
					<div>
					  <s:fielderror cssStyle="color.red"/> <!-- 显示表单验证的出错信息 -->
					</div>
					<!-- end of form -->
</s:form>
		</div>
			</div>
		</div>
	</div>
	<div id="footer">
		<div id="text">Copyright © 2016-2060 All Rights Reserved Powered By ChenBaiCheng</div>
	</div>
</div>
</body>
</html>