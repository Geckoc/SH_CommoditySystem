
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>    
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>查找商品</title>
<style type="text/css">
* {
    border: 1 none;
    margin: 0;
    padding: 0;
    vertical-align: baseline;
	font-family:微软雅黑;
	overflow:hidden;
}
#navi{
	width:100%;
	position:relative;
	word-wrap:break-word;
	border-bottom:1px solid #065FB9;
	padding:0;
	margin:0;
	height:40px;
	line-height:40px;
	vertical-align:middle;
    background-image: -moz-linear-gradient(top,#EBEBEB, #BFBFBF);
    background-image: -webkit-gradient(linear, left top, left bottom, color-stop(0, #EBEBEB),color-stop(1, 
#BFBFBF));
}
#naviDiv{
	font-size:14px;
	color:#333;
	padding-left:10px;
}
#tips{
	width:100%;
	height:40px;
	background-color: cadetblue;
	text-align: left;
	padding: 18px;
}
#buttonGroup{
	float:left;
	height:50px;
	padding-right: 24px;
}
.button{
	padding-left:10px;
	padding-right:10px;
	width:70px;
	height:30px;
	line-height:30px;
	vertical-align:middle;
	text-align:center;
	cursor:pointer;
    border-color: #77D1F6;
    border-width: 1px;
    border-style: solid;
    border-radius: 6px 6px;
    -moz-box-shadow: 2px 2px 4px #282828;
    -webkit-box-shadow: 2px 2px 4px #282828;
    background-image: -moz-linear-gradient(top,#EBEBEB, #BFBFBF);
    background-image: -webkit-gradient(linear, left top, left bottom, color-stop(0, #EBEBEB),color-stop(1, #BFBFBF));
}
#mainContainer{
	padding-left:10px;
	padding-right:10px;
	text-align:left;
	width:98%;   
	font-size:16px; 	
}
</style>
</head>
<body>
<div id="navi">
	<div id='naviDiv'>
		<span><img src="images/arror.gif" width="7" height="11" border="0" alt=""></span>&nbsp;商品管理<span>&nbsp;
		<span><img src="images/arror.gif" width="7" height="11" border="0" alt=""></span>&nbsp;<a href="queryCommodity.action">商品列表</a><span>&nbsp;
	</div>
</div>
<div id="tips">
		<s:textfield name = "commodity_num" label="编号" placeholder="请输入编号"/>
		<s:textfield name = "commodity_name" label="商品名" placeholder="请输入商品名"/>
		<s:textfield name = "commodity_type" label="类型" placeholder="请输入类型"/>
		<div id="buttonGroup">
			<div class="button" onmouseout="this.style.backgroundColor='';this.style.fontWeight='normal'" onmouseover="this.style.backgroundColor='#77D1F6';this.style.fontWeight='bold'">
				<a href="commoditySearch.action?commodity_num=<s:property value="commodity_num"/>">查找</a>
			</div>
		</div>
</div>
<div id="mainContainer">	
	
</div>
</html>