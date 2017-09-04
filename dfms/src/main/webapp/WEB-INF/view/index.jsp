<#assign base=request.contextPath />
<%@page import="com.zdjy.bigdata.dfms.entity.User"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>

<html>

<head>
<title>HDFS 文件管理系统</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- Fonts -->
<link
	href='http://fonts.googleapis.com/css?family=Roboto+Condensed:300,400'
	rel='stylesheet' type='text/css'>
<link href='http://fonts.googleapis.com/css?family=Lato:300,400,700,900'
	rel='stylesheet' type='text/css'>
<!-- CSS Libs -->
<link rel="stylesheet" type="text/css"
	href="${base }/lib/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css"
	href="${base }/lib/css/font-awesome.min.css">
<link rel="stylesheet" type="text/css"
	href="${base }/lib/css/animate.min.css">
<link rel="stylesheet" type="text/css"
	href="${base }/lib/css/bootstrap-switch.min.css">
<link rel="stylesheet" type="text/css"
	href="${base }/lib/css/checkbox3.min.css">
<link rel="stylesheet" type="text/css"
	href="${base }/lib/css/jquery.dataTables.min.css">
<link rel="stylesheet" type="text/css"
	href="${base }/lib/css/dataTables.bootstrap.css">
<link rel="stylesheet" type="text/css"
	href="${base }/lib/css/select2.min.css">
<!-- CSS App -->
<link rel="stylesheet" type="text/css" href="${base }/css/style.css">
<link rel="stylesheet" type="text/css"
	href="${base }/css/themes/flat-blue.css">
</head>
<%
	User user=session.getAttribute("user")
%>

<body class="flat-blue">
	<div class="app-container">
		<div class="row content-container">
			<nav class="navbar navbar-default navbar-fixed-top navbar-top">
				<div class="container-fluid">
					<div class="navbar-header">
						<button type="button" class="navbar-expand-toggle">
							<i class="fa fa-bars icon"></i>
						</button>
						<ol class="breadcrumb navbar-breadcrumb">
							<li class="active">HDFS文件管理</li>
						</ol>
						<button type="button"
							class="navbar-right-expand-toggle pull-right visible-xs">
							<i class="fa fa-th icon"></i>
						</button>
					</div>
					<ul class="nav navbar-nav navbar-right">
						<button type="button"
							class="navbar-right-expand-toggle pull-right visible-xs">
							<i class="fa fa-times icon"></i>
						</button>
						<li class="dropdown"><a href="#" class="dropdown-toggle"
							data-toggle="dropdown" role="button" aria-expanded="false"><i
								class="fa fa-comments-o"></i></a>
							<ul class="dropdown-menu animated fadeInDown">
								<li class="title">Notification <span
									class="badge pull-right">0</span>
								</li>
								<li class="message">No new notification</li>
							</ul></li>
						<li class="dropdown danger"><a href="#"
							class="dropdown-toggle" data-toggle="dropdown" role="button"
							aria-expanded="false"><i class="fa fa-star-half-o"></i>
								文件系统总览</a>
							<ul class="dropdown-menu danger  animated fadeInDown">
								<li>
									<ul class="list-group notifications">
										<a href="#">
											<li class="list-group-item"><span class="badge">1</span>
												<i class="fa fa-exclamation-circle icon"></i> 最新修改</li>
										</a>
										<a href="#">
											<li class="list-group-item"><span class="badge success">1</span>
												<i class="fa fa-check icon"></i> 新的文件</li>
										</a>

										<a href="/dfms/ml/muluload.do">
											<li class="list-group-item message">查看所有文件</li>
										</a>
									</ul>
								</li>
							</ul></li>
						<li class="dropdown profile"><a href="#"
							class="dropdown-toggle" data-toggle="dropdown" role="button"
							aria-expanded="false">${user.name }<span class="caret"></span></a>
							<ul class="dropdown-menu animated fadeInDown">
								<li class="profile-img"><img
									src="${base }/img/profile/picjumbo.com_HNCK4153_resize.jpg"
									class="profile-img"></li>
								<li>
									<div class="profile-info">
										<h4 class="username">${user.name }</h4>
										<div class="btn-group margin-bottom-2x" role="group">
											<button type="button" class="btn btn-default">
												<i class="fa fa-user"></i> <a href="/dfms/ml/muluload.do">自己的文件</a>
											</button>
											<button type="button" class="btn btn-default">
												<i class="fa fa-sign-out"></i> <a href="/dfms/user/exit.do">退出</a>
											</button>
										</div>
									</div>
								</li>
							</ul></li>
					</ul>
				</div>
			</nav>
			<div class="side-menu sidebar-inverse">
				<nav class="navbar navbar-default" role="navigation">
					<div class="side-menu-container">
						<div class="navbar-header">
							<a class="navbar-brand" href="#">
								<div class="icon fa fa-paper-plane"></div>
								<div class="title">HDFS 文件管理系统</div>
							</a>
							<button type="button"
								class="navbar-expand-toggle pull-right visible-xs">
								<i class="fa fa-times icon"></i>
							</button>
						</div>
						<ul class="nav navbar-nav">
							<li class="active"><a href="index.html"> <span
									class="icon fa fa-tachometer"></span><span class="title">文件系统</span>
							</a></li>
							<li class="panel panel-default dropdown"><a
								data-toggle="collapse" href="#dropdown-element"> <span
									class="icon fa fa-desktop"></span><span class="title">文件目录</span>
							</a> <!-- Dropdown level 1 -->
								<div id="dropdown-element" class="panel-collapse collapse">
									<div class="panel-body">
										<ul class="nav navbar-nav">
											<#list dpList as a>
												<li><a>${a.name }</a></li>
											</#list>


										</ul>
									</div>
								</div></li>

							<!-- Dropdown-->

							<li><a href="license.html"> <span
									class="icon fa fa-thumbs-o-up"></span><span class="title">关于我们</span>
							</a></li>
						</ul>
					</div>
					<!-- /.navbar-collapse -->
				</nav>
			</div>
			<div class="copyrights">
				Collect from <a href="http://www.cssmoban.com/">系统整体</a>
			</div>
			<!-- Main Content -->
			<div class="container-fluid">
				<div class="side-body padding-top">
					<div class="row">
						<div class="col-lg-3 col-md-6 col-sm-6 col-xs-12">
							<a href="#">
								<div class="card red summary-inline">
									<div class="card-body">
										<i class="icon fa fa-inbox fa-4x"></i>
										<div class="content">
											<div class="title">50</div>
											<div class="sub-title">服务器个数</div>
										</div>
										<div class="clear-both"></div>
									</div>
								</div>
							</a>
						</div>
						<div class="col-lg-3 col-md-6 col-sm-6 col-xs-12">
							<a href="#">
								<div class="card yellow summary-inline">
									<div class="card-body">
										<i class="icon fa fa-comments fa-4x"></i>
										<div class="content">
											<div class="title">23</div>
											<div class="sub-title">用户数</div>
										</div>
										<div class="clear-both"></div>
									</div>
								</div>
							</a>
						</div>
						<div class="col-lg-3 col-md-6 col-sm-6 col-xs-12">
							<a href="#">
								<div class="card green summary-inline">
									<div class="card-body">
										<i class="icon fa fa-tags fa-4x"></i>
										<div class="content">
											<div class="title">280</div>
											<div class="sub-title">文件数</div>
										</div>

									</div>
								</div>
						</div>
						</a>
					</div>
					<div class="col-lg-3 col-md-6 col-sm-6 col-xs-12">
						<a href="#">
							<div class="card blue summary-inline">
								<div class="card-body">
									<i class="icon fa fa-share-alt fa-4x"></i>
									<div class="content">
										<div class="title">16</div>
										<div class="sub-title">最新上传的文件数</div>
									</div>
									<div class="clear-both"></div>
								</div>
							</div>
						</a>
					</div>
					<div>
						<div class="col-lg-3 col-md-6 col-sm-6 col-xs-12">
							<a href="#">
								<div class="card green summary-inline">
									<div class="card-body">
										<i class="icon fa fa-tags fa-4x"></i>
										<div class="content">
										<form
											action="${pageContext.request.contextPath }/dfms/upload.do"
											method="post" enctype="multipart/form-data">
											<input type="file" id="exampleInputFile" name="uploadFile"><button type="submit">提交</button>
										</form>
										
										<div class="title">上传区域</div>
									</div>
                                   </div>
								</div>
						</div>

					</div>
				</div>
				<div class="row  no-margin-bottom">
					<div class="col-sm-6 col-xs-12"></div>
					<div class="col-sm-6 col-xs-12">
						<div class="row">

							<div class="col-md-6 col-sm-12"></div>
							<div class="card card-success"></div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- Javascript Libs -->
	<script type="text/javascript" src="${base }/lib/js/jquery.min.js"></script>
	<script type="text/javascript" src="${base }/lib/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="${base }/lib/js/Chart.min.js"></script>
	<script type="text/javascript"
		src="${base }/lib/js/bootstrap-switch.min.js"></script>
	<script type="text/javascript"
		src="${base }/lib/js/jquery.matchHeight-min.js"></script>
	<script type="text/javascript"
		src="${base }/lib/js/jquery.dataTables.min.js"></script>
	<script type="text/javascript"
		src="${base }/lib/js/dataTables.bootstrap.min.js"></script>
	<script type="text/javascript"
		src="${base }/lib/js/select2.full.min.js"></script>
	<script type="text/javascript" src="${base }/lib/js/ace/ace.js"></script>
	<script type="text/javascript" src="${base }/lib/js/ace/mode-html.js"></script>
	<script type="text/javascript"
		src="${base }/lib/js/ace/theme-github.js"></script>
	<!-- Javascript -->
	<script type="text/javascript" src="${base }/js/app.js"></script>
	<script type="text/javascript" src="${base }/js/index.js"></script>
</body>

</html>
