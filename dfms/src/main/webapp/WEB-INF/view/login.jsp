<#assign base=request.contextPath />




<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> 
<meta http-equiv="Pragma" content="no-cache"> 
<meta http-equiv="Cache-Control" content="no-cache"> 
<meta http-equiv="Expires" content="0"> 
<title>HDFS文件管理系统</title> 
<link href="${base }/css/login.css" type="text/css" rel="stylesheet"> 
</head> 
<body> 

<div class="login">
    <div class="message">HDFS文件管理系统</div>
    <div id="darkbannerwrap"></div>
    
    <form method="post" action="user/index.do">
		<input name="name" placeholder="用户名" required="" type="text">
		<hr class="hr15">
		<input name="pwd" placeholder="密码" required="" type="password">
		<hr class="hr15">
		<input value="登陆" style="width:100%;" type="submit">
		<hr class="hr20">

	</form>

	
</div>

<div class="copyright">© 2017 by <a href="" target="_blank">文件管理系统</a></div>

</body>
</html>