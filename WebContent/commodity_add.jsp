
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>    
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="css/default.css" />
<script type="text/javascript" src="js/Calendar3.js"></script>
<title>商品添加</title>
<style type="text/css">
* {
    background: none repeat scroll 0 0 transparent;
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
	margin:0;
	padding:0;
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
	margin-top:10px; 
	width:100%;
	height:40px;
}
#buttonGroup{
	padding-left:10px;
	float:left;
	height:35px;
}
.button{
	margin-top:20px;
	padding-left:10px;
	padding-right:10px;
	font-size:14px;
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
<script type="text/javascript">
	function firm()
	{
		if( confirm( "已確認信息沒有錯誤?" ));
	}else{
		alert("取消")
	}

</script>
</head>
<body>
<div id="navi"> 
	<div id='naviDiv'>
		<span><img src="images/arror.gif" width="7" height="11" border="0" alt=""></span>&nbsp;商品管理<span>&nbsp;
		<span><img src="images/arror.gif" width="7" height="11" border="0" alt=""></span>&nbsp;<a href="queryCommodity.action">商品列表</a><span>&nbsp;
	</div>
</div>
<div id="tips"> 
	<strong>添加商品资料</strong>
</div>
<div id="mainContainer">
	<s:form name="commodity_add" action="addCommodity.action" method="post">
		<table width="400">
			<tr><td><s:textfield name="commodity_num" label="商品编号" type="number"/></td></tr>
			<tr><td><s:textfield name="commodity_name" label="商品名"/></td></tr>
			<tr><td><s:textfield name="commodity_price" label="商品价格"/></td></tr>
			<tr><td><s:textfield name="commodity_type" label="商品类型"/></td></tr>
			<tr>
				<td>库存:</td>
				<td><input type="number" min="1" step="1" name="commodity_information" /></td>
			</tr>
			<tr>
				<td>上架时间:</td>
				<td>
			 <!-- Struts2 tag 不能用readonly -->
			<!--<s:textfield name="commodity_time"  id="control_date" size="20" maxlength="10" onclick="new Calendar().show(this);" label="上架时间" readonly="readonly"/> -->
				<input type="text" name="commodity_time" id="control_date" size="20" maxlength="10" onclick="new Calendar().show(this);" readonly="readonly" />
				</td></tr>
			<tr><td colspan="2" align="center"><input type="submit" onclick="firm()" class="button" value="添加商品"></td></tr>
		</table>
	</s:form>
</div>
</body>
</html>