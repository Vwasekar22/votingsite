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
	<h3>Analysis Page</h3>
	<table>
		<tr>
			<td><h2>Top Two Candidates</h2></td>
		</tr>
		<tr>
			<th>Candidate Name</th>
			<th>Political Party
			<th>Number of Votes</th>
		</tr>
		<c:forEach var="c" items="${sessionScope.cb.topTwoCandidates}">
			<tr>
				<td>${c.name}</td>
				<td>${c.party}</td>
				<td>${c.votes}</td>
			</tr>
		</c:forEach>
	</table>
	<table>
		<tr>
			<td><h2>Political Party-wise Votes</h2></td>
		</tr>
		<tr>
			<th>Political Party</th>
			<th>No of Votes</th>
		</tr>
		<c:forEach var="p" items="${sessionScope.cb.votesPartyWise}">
			<tr>
				<td>${p.party}</td>
				<td>${p.votes}</td>
			</tr>
		</c:forEach>
	</table>


</body>
</html>