<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Frameset//EN" "http://www.w3.org/TR/html4/frameset.dtd">
<html>
<head>
<title>eMarketPlace</title>
</head>
<frameset rows="80,*" cols="*" frameborder="NO" border="0" framespacing="0">
	<frame src="<c:url value='/layouts/top.jsp'/>" name="topFrame" scrolling="NO" noresize>
	<frameset rows="*" cols="160,*" framespacing="0" frameborder="NO" border="0">
		<frame src="<c:url value='/layouts/left.jsp'/>" name="leftFrame" scrolling="NO" noresize>
		<frame src="<c:url value='/system/welcome.jsp'/>" name="rightFrame" scrolling="auto">
	</frameset>
</frameset>
<noframes>
	<body>

	</body>
</noframes>
</html>
