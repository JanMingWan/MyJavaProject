<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>挽手后台操作系统</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!-- Reset Stylesheet -->
<link rel="stylesheet" href="<%=basePath%>/resources/css/reset.css" type="text/css"
	media="screen" />
<!-- Main Stylesheet -->
<link rel="stylesheet" href="<%=basePath%>resources/css/style.css" type="text/css"
	media="screen" />
<!-- Invalid Stylesheet. This makes stuff look pretty. Remove it if you want the CSS completely valid -->
<link rel="stylesheet" href="<%=basePath%>resources/css/invalid.css" type="text/css"
	media="screen" />
<!--                       Javascripts                       -->
<!-- jQuery -->
<script type="text/javascript"
	src="<%=basePath%>resources/scripts/jquery-1.3.2.min.js"></script>
<!-- jQuery Configuration -->
<script type="text/javascript"
	src="<%=basePath%>resources/scripts/simpla.jquery.configuration.js"></script>
<!-- Facebox jQuery Plugin -->
<script type="text/javascript" src="<%=basePath%>resources/scripts/facebox.js"></script>
<!-- jQuery WYSIWYG Plugin -->
<script type="text/javascript" src="<%=basePath%>resources/scripts/jquery.wysiwyg.js"></script>
<!-- jQuery Datepicker Plugin -->
<script type="text/javascript"
	src="<%=basePath%>resources/scripts/jquery.datePicker.js"></script>
<script type="text/javascript" src="<%=basePath%>resources/scripts/jquery.date.js"></script>

</head>

<frameset rows="*" cols="235,*" framespacing="0" frameborder="no" border="0">
  <frame src="<%=basePath%>/manage/index/left.jsp" name="leftFrame" scrolling="no" noresize="noresize" id="leftFrame" title="leftFrame" />
  <frame src="<%=basePath%>/manage/index/main.jsp" name="mainFrame" id="mainFrame" title="mainFrame" />
</frameset>

<noframes><body>
</body></noframes>
</html>
