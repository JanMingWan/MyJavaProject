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

<title>挽手系统</title>

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

<body class="bodyClass">
	<div id="body-wrapper">
		<!-- Wrapper for the radial gradient background -->
		<div id="sidebar">
			<div id="sidebar-wrapper">
				<!-- Sidebar with logo and menu -->
				<h1 id="sidebar-title">
					<a href="#">Simpla Admin</a>
				</h1>
				<!-- Logo (221px wide) -->
				<a href="#"><img id="logo"
					src="resources/images/logo.png" alt="WanSo System" />
				</a>
				<!-- Sidebar Profile links -->
				<div id="profile-links">
					Hello, <a href="#" title="Edit your profile">管理员</a><!-- , you have <a
						href="#messages" rel="modal" title="3 Messages">3 Messages</a><br />
					<br /> <a href="#" title="View the Site">View the Site</a> --> | <a
						href="#" title="Sign Out" style="color: red">Sign Out</a>
				</div>
				<ul id="main-nav">
					<!-- Accordion Menu -->
					<li><a href="#"
						class="nav-top-item no-submenu"> <!-- Add the class "no-submenu" to menu items with no sub menu -->
							Dashboard </a></li>
					<li><a href="#" class="nav-top-item current"> <!-- Add the class "current" to current menu item -->
							Articles </a>
						<ul>
							<li><a href="#">Write a new Article</a>
							</li>
							<li><a class="current" href="#">Manage Articles</a>
							</li>
							<!-- Add class "current" to sub menu items also -->
							<li><a href="#">Manage Comments</a>
							</li>
							<li><a href="#">Manage Categories</a>
							</li>
						</ul></li>
					<li><a href="#" class="nav-top-item"> Pages </a>
						<ul>
							<li><a href="#">Create a new Page</a>
							</li>
							<li><a href="#">Manage Pages</a>
							</li>
						</ul></li>
					<li><a href="#" class="nav-top-item"> Image Gallery </a>
						<ul>
							<li><a href="#">Upload Images</a>
							</li>
							<li><a href="#">Manage Galleries</a>
							</li>
							<li><a href="#">Manage Albums</a>
							</li>
							<li><a href="#">Gallery Settings</a>
							</li>
						</ul></li>
					<li><a href="#" class="nav-top-item"> Events Calendar </a>
						<ul>
							<li><a href="#">Calendar Overview</a>
							</li>
							<li><a href="#">Add a new Event</a>
							</li>
							<li><a href="#">Calendar Settings</a>
							</li>
						</ul></li>
					<li><a href="#" class="nav-top-item"> Settings </a>
						<ul>
							<li><a href="#">General</a>
							</li>
							<li><a href="#">Design</a>
							</li>
							<li><a href="#">Your Profile</a>
							</li>
							<li><a href="#">Users and Permissions</a>
							</li>
						</ul></li>
				</ul>
				<!-- End #main-nav -->
				<div id="messages" style="display: none">
					<!-- Messages are shown when a link with these attributes are clicked: href="#messages" rel="modal"  -->
					<h3>3 Messages</h3>
					<p>
						<strong>17th May 2009</strong> by Admin<br /> Lorem ipsum dolor
						sit amet, consectetur adipiscing elit. Vivamus magna. Cras in mi
						at felis aliquet congue. <small><a href="#"
							class="remove-link" title="Remove message">Remove</a>
						</small>
					</p>
					<p>
						<strong>2nd May 2009</strong> by Jane Doe<br /> Ut a est eget
						ligula molestie gravida. Curabitur massa. Donec eleifend, libero
						at sagittis mollis, tellus est malesuada tellus, at luctus turpis
						elit sit amet quam. Vivamus pretium ornare est. <small><a
							href="#" class="remove-link" title="Remove message">Remove</a>
						</small>
					</p>
					<p>
						<strong>25th April 2009</strong> by Admin<br /> Lorem ipsum dolor
						sit amet, consectetur adipiscing elit. Vivamus magna. Cras in mi
						at felis aliquet congue. <small><a href="#"
							class="remove-link" title="Remove message">Remove</a>
						</small>
					</p>
					<form action="#" method="post">
						<h4>New Message</h4>
						<fieldset>
							<textarea class="textarea" name="textfield" cols="79" rows="5"></textarea>
						</fieldset>
						<fieldset>
							<select name="dropdown" class="small-input">
								<option value="option1">Send to...</option>
								<option value="option2">Everyone</option>
								<option value="option3">Admin</option>
								<option value="option4">Jane Doe</option>
							</select> <input class="button" type="submit" value="Send" />
						</fieldset>
					</form>
				</div>
				<!-- End #messages -->
			</div>
		</div>
		
	</div>
</body>
</html>
