
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>   
<%@ taglib prefix="s" uri="/struts-tags" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>商品列表</title>
<link rel="stylesheet" type="text/css" href="css/default.css" />
<style type="text/css">
* {
    background: none repeat scroll 0 0 transparent;
    border: 0 none;
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
	height:50px;
}
#buttonGroup{
	padding-left:10px;
	float:left;
	height:35px;
}
.button{
	float:left;
	margin-right:10px;
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
	text-align:center;
	width:98%;
	font-size:12px;
}
</style>
</head>
<body>
	<div id="navi">
	<div id='naviDiv'>
		<span><img src="images/arror.gif" width="7" height="11" border="0" alt=""></span>&nbsp;<span>商品管理</span>&nbsp;
		<span><img src="images/arror.gif" width="7" height="11" border="0" alt=""></span>&nbsp;<span><a href="queryCommodity.action">商品列表</a></span>&nbsp;
	</div>
</div>
<div id="tips">
	<div id="buttonGroup">
		<div class="button" onmouseout="this.style.backgroundColor='';this.style.fontWeight='normal'" onmouseover="this.style.backgroundColor='#77D1F6';this.style.fontWeight='bold'">
			<a href="commodity_add.jsp">添加商品</a>
		</div>
		<div class="button" onmouseout="this.style.backgroundColor='';this.style.fontWeight='normal'" onmouseover="this.style.backgroundColor='#77D1F6';this.style.fontWeight='bold'">
			<a href="commodity_search.jsp">查找商品</a>
		</div>
	</div>
</div>
<div id="mainContainer">

<table class="default" width="100%">
	<col width="10%">
	<col width="10%">
	<col width="10%">
	<col width="10%">
	<col width="10%">
	<col width="15%">
	<col width="10%">
	<col width="10%">
	<tr class="title">
		<td>商品编号</td>
		<td>商品名字</td>
		<td>价格</td>
		<td>类型</td>
		<td>库存</td>
		<td>上架时间</td>
		<td>下单</td>
		<td>操作</td>
	</tr>
	
	<!-- 迭代遍历开始 -->
	<s:iterator value="#session.commodity_list" var="commodity">
	<tr class="list">
		<td><s:property value="#commodity.commodity_num"/> </td>
		<td><a href="commoditySearch.action?commodity_num=<s:property value="#commodity.commodity_num"/>">
				<s:property value="#commodity.commodity_name"/> </a></td>
		<td>￥<s:property value="#commodity.commodity_price"/> </td>
		<td><s:property value="#commodity.commodity_type"/></td>
		<td><s:property value="#commodity.commodity_information"/> </td>
		<td><s:date name="#commodity.commodity_time" format="yyyy年MM月dd日" /> </td>
		<td><a href="GetPurchaseOrder_info.action?commodity_num=<s:property value="#commodity.commodity_num"/>">
				添加订单</a></td>
		<td><a href="deleteCommodity.action?commodity_num=<s:property value="#commodity.commodity_num"/>"
		onclick="javascript: return confirm('真的要删除吗？');">删除</a></td>
	</tr>
	</s:iterator>
	<!-- 迭代遍历结束 -->
</table>
<script type="text/javascript">
	function frim()
	{
		var num_count=prompt("请输入下单数量 ","");//将输入的内容赋给变量 num_count
	    if(num_count)//如果返回的有内容
	    {
	        alert("下单成功 ，数量为 :"+ num_count)
	    }
	}
</script>
</div>
</body>
</html>