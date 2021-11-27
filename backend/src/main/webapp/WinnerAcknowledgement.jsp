<!-- @author Riya & Andrea -->

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Winner Acknowledgement</title>
</head>
<body>
	<h1>Thank you for Completing the form.</h1>
	<h2 style="color: red;">You are the raffle winner of two movie
		tickets</h2>
	<%@page import="java.util.List"%>
	<%--Importing all the dependent classes--%>
	<%@page import="edu.gmu.swe642.StudentDAOImpl"%>
	<%@page import="java.util.Iterator"%>

	<%
	List data = (List) request.getAttribute("data");
	String standardDev = (String) request.getAttribute("standardDev");
	Double mean = (Double) request.getAttribute("mean");
	%>
	<h2>
		Mean:
		<%=mean%></h2>
	<h2>
		Standard Deviation:
		<%=standardDev%></h2>
	<table>
		<tr>
			<th>Student ID</th>
		</tr>
		<%
		// Iterating through subjectList

		if (request.getAttribute("data") != null) // Null check for the object
		{
			Iterator iterator = data.iterator(); // Iterator interface
			while (iterator.hasNext()) // iterate through all the data until the last record
			{
		%>
		<tr>
			<td>
				<form action="processForm" method="get">
					<input readonly id="studentid" name="studentid"
						value="<%=iterator.next()%>">
					<button id="submit" type="submit">Go to completed form</button>
				</form>
			</td>
		</tr>
		<%
		}
		}
		%>
	</table>
</body>
</html>