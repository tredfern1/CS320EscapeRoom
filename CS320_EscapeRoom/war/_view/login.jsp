<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<html>
	<head>
		<title>Login!</title>
        
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/styles.css" />
	</head>

	<body>

                   
         <div class="main-heading">
            <h1>Escape Room</h1>
         </div>
        
           <input type="text">
           <input type="password">

        <form action="${pageContext.servletContext.contextPath}/game" method="doGet">
			
			<input type="Submit" name="submit" value="Login">
		</form>
        
        
	</body>
</html>