<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

<body>
	<h3 style="color: cyan;"> ${requestScope.msg},
		${sessionScope.voter_dtls}</h3>
	<h3>Welcome to Voting Desk</h3>
	<h3>Candidate List</h3>
	<form action="../user/status" method="post">
		<table>
			<tr>
				<th></th>
				<th>Candidate Name</th>
				<th>Political Party</th>
			</tr>
			<c:forEach var="c" items="${requestScope.cand_list}">
				<%-- for(Candidate c: candidates) //candidates=ArrayList<Candidate>() --%>
				<tr>
					<td><input type="radio" name="canId" value="${c.id}"></td>
					<td>${c.name}</td>
					<td>${c.party}</td>
				</tr>
			</c:forEach>
			<tr>
				<td></td>
				<td><input type="submit" value="Vote"></td>
				<td></td>
			</tr>
		</table>
	</form>
</body>
</html>