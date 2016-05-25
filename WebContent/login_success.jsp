
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript">
function screenAdapter(){
	document.getElementById('footer').style.top=document.documentElement.scrollTop+document.documentElement.clientHeight- document.getElementById('footer').offsetHeight+"px";
		document.getElementById('navigator').style.height=document.documentElement.clientHeight-100+"px";
		document.getElementById('main').style.height=document.documentElement.clientHeight-100+"px";
		document.getElementById('main').style.width=window.screen.width-230+"px";
}

window.onscroll=function(){screenAdapter();};
window.onresize=function(){screenAdapter();};
window.onload=function(){screenAdapter();};
</script>
<script type="text/javascript">
function firm()
{
    if(confirm("你确信要退出?"))
    {
        location.href="logout.action";
    }
    else
    {
        alert("您已取消退出,可继续使用本系统");
    }
}

</script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="css/index.css" />
<link rel="stylesheet" href="Font-Awesome-3.2.1/css/font-awesome.css">
<link rel="stylesheet" href="Font-Awesome-3.2.1/css/font-awesome.min.css">
<title>RicSystem-CHEN</title>
</head>
<body>
	<div id="wrapper">
	<div id="header">
		<div id="title"><i class="icon-globe icon-spin"></i>后台管理系统</div>
		<div id="menu">
			<div id="menu_container">
				<ul id="menu_items">
					<li class="menu_item on" style="border-radius:8px 0 0 8px" onmouseout="this.style.backgroundColor=''" onmouseover="this.style.backgroundColor='#77D1F6';this.style.borderRadius='8px 0 0 8px'"><a>首页</a></li>
					<li class="menu_item" onmouseout="this.style.backgroundColor='';this.style.fontWeight='normal'" onmouseover="this.style.backgroundColor='#77D1F6';this.style.fontWeight='bold'"><a href="Employees_query_success.jsp" target="MainFrame">员工管理</a></li>
					<li class="menu_item" onmouseout="this.style.backgroundColor='';this.style.fontWeight='normal'" onmouseover="this.style.backgroundColor='#77D1F6';this.style.fontWeight='bold'"><a>商品管理</a></li>
					<li class="menu_item" onmouseout="this.style.backgroundColor='';this.style.fontWeight='normal'" onmouseover="this.style.backgroundColor='#77D1F6';this.style.fontWeight='bold'"><a>供应商和客户</a></li>
					<li class="menu_item" onmouseout="this.style.backgroundColor='';this.style.fontWeight='normal'" onmouseover="this.style.backgroundColor='#77D1F6';this.style.fontWeight='bold'"><a>销售订单</a></li>
					<li class="menu_item" style="border-radius:8px 0 0 8px;border:0px;" onmouseout="this.style.backgroundColor='';this.style.fontWeight='normal'" onmouseover="this.style.backgroundColor='#77D1F6';this.style.borderRadius='0 8px 8px 0';this.style.fontWeight='bold'">
					<a href="sign_up.jsp" target="_blank">SIGN UP</a></li>
				</ul>
			</div>
		</div>
		<div id="user_info">
			<div id="welcome">欢迎${sessionScope.loginUserName}使用本系统</div>
			<div id="logout"><a href="#" onclick="firm()">安全退出</a></div>
		</div>
	</div>
	<div id="navigator">
		<iframe src="tree.jsp"></iframe>
        </div>
	<div id="main">
		<iframe name="MainFrame" src="home_content.jsp" scrolling="auto"></iframe>
	</div>
	<div id="footer">Copyright © 2016-2060 All Rights Reserved Powered By ChenBaiCheng</div>
</div>
</body>
</html>