<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>Status Page</h3>
	<h4>Hello, ${sessionScope.voter_dtls.role} --->
		${sessionScope.voter_dtls.email}</h4>
	<c:set var="status" value="${requestScope.status}" />
	<c:choose>
		<c:when test="${status}">
			<h4>Your Voting is Already Done!!</h4>
		</c:when>
		<c:otherwise>
			<h4>${sessionScope.vb.updateStatus()}</h4>
		</c:otherwise>
	</c:choose>

	<%-- ${pageContext.session.invalidate()} --%>

	<h4>
		LogOut and <a href="/user/index">Visit Again</a>
	</h4>
</body>
</html>