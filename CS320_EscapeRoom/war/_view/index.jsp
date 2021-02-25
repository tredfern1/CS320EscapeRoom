<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<html>
	<head>
		<title>INDEX</title>
		<style type="text/css">
		.error {
			color: red;
		}
		
		td.label {
			text-align: right;
		}
		</style>
	</head>
	

	<body>
		<c:if test="${! empty errorMessage}">
			<div class="error">${errorMessage}</div>
		</c:if>
	
		<form action="${pageContext.servletContext.contextPath}/addNumbers" method="doGet">
			
			<input type="Submit" name="submit" value="AddNumbers">
		</form>
		<form action="${pageContext.servletContext.contextPath}/guessingGame" method="doGet">
			
			<input type="Submit" name="submit" value="GuessingGame">
		</form>
		<form action="${pageContext.servletContext.contextPath}/MultiplyNumbers" method="doGet">
			
			<input type="Submit" name="submit" value="MultiplyNumbers">
		</form>
	</body>
</html>