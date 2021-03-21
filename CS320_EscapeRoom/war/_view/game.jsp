<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<html>
	<head>
		<title>Game</title>
		
		<link rel="stylesheet" href="${pageContext.request.contextPath}/css/styles.css" />
		
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
		        
     <form action="${pageContext.servletContext.contextPath}/game" method="post">       
        <div class="main-heading">
            <h1>Escape Room</h1>
         </div>
        
            <div class="game-box">
                <p> you are in a dark room</p>
                
                <input type="text" name="move" value="${move}">
                
                <input type="Submit" name="submit" value="Go!">
                
                <input type="hidden" name = "x" value="${x}">
                <input type="hidden" name = "y" value="${y}">
              <table>
                <tr>
					<td class="label">Result:</td>
					<td>${result}</td>
				</tr>
				<tr>
					<td class="label">Coord:</td>
					<td>${result2}</td>
				</tr>
				</table>
            </div>
        </form>   
          
            
  
	</body>
</html>