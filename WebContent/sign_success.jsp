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
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="refresh" content="5;url=sign_up.jsp">
<title>Insert title here</title>
</head>
<body>
	<center><h2>恭喜您成为第<font color="red" size="20">${user.id}</font>位注册用户</h2></center><br/>
	<h2><b style=color:blue><span id=jump>5</span> 秒钟后页面将自动返回主页面...</b></h2>
		<script>
                      function countDown(secs){
                           jump.innerText=secs;
                           if(--secs>0)
                                    setTimeout("countDown("+secs+" )",1000);
                    }
                     countDown(5);
            </script> 
	<hr width="100%"/>
		${user.name}<br/>
		${user.password}<br/>
		${user.gender} <br/>
		${user.job } <br/>
		${user.hobby } <br/>
		${user.information }<br/>
</body>
</html>