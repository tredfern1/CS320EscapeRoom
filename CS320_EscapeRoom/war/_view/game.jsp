<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<meta name="viewport" content="width=device-width, initial-scale=1.00, minimum-scale=1.00, maximum-scale=1.00, user-scalable=no">



<html>
	<head>
		<title>Game</title>
		<link href="https://fonts.googleapis.com/css2?family=VT323&display=swap" rel="stylesheet">
		<link rel="stylesheet" href="${pageContext.request.contextPath}/css/styles.css" />
		
		<style type="text/css">
		.error {
			color: red;
		}
		
		td.label {
			text-align: right;
			font-family: 'VT323', monospace;
		}
		</style>
	</head>

	<body>
		        
     <form action="${pageContext.servletContext.contextPath}/game" method="post">       
        <div class="test-title">
        <pre>
                                        `-----------------------.    `----------.      -----------   .-----------------------`                                     `----------------..``                   `.:+++++/-`                    `.:+++++/-`          `-------.            .--------`                                       
			                +MMMMNmdhdMMMMMmhhdmNMMMN`   -syNMMMMMdyo     `symMMMMMmys`  /syNMMMMMdysssssyhmNMMMMy                                     :sydMMMMMmyssyydmNNmds:`             `:ymMNdyoshNMmy:`              `:ymMNmyoshNMNh/`       :shNMMMMd            dMMMMMNys.                                       
			             mMMN+.    mMMMM-    .yMMM/      /MMMMd           `MMMMM`        /MMMMd          -oNMMM:                                        NMMMM-      `-sNMMMm/           :dMMMy-     .oNMMd:            -hMMMh-     `+NMMd:         oMMMMM-          :MMMMMM:                                          
			            /MMN-      mMMMM.      sMMd      :MMMMh           `MMMMM         :MMMMh            `yMMm`                                       mMMMM.         -NMMMM/         oMMMM+         -NMMM+          +NMMMo         .mMMMo        +MMMMMy          hMMMMMM-                                          
			            dMN:       mMMMM.       yMM-     :MMMMh           `MMMMM         :MMMMh              +NN+                                       mMMMM.          +MMMMN`       sMMMMo           /MMMMo        oMMMMs           :MMMMs       +MMMMMM`        -MMMMMMM-                                          
			           `os/        mMMMM.       `ss-     :MMMMh           `MMMMM         :MMMMh               .-`                                       mMMMM.          .MMMMM.      /MMMMd             dMMMM/      :MMMMm`            yMMMM+      +MMMMMMo        yMMMMMMM-                                          
			                       mMMMM.                :MMMMh           `MMMMM         :MMMMh         .--                                             mMMMM.          .MMMMM`     `NMMMM+             /MMMMm`     mMMMMo             :MMMMN`     +MMNMMMm       .MMmmMMMM-                                          
			                       mMMMM.                :MMMMh           `MMMMM         :MMMMh         sMM`                                            mMMMM.          oMMMMh      +MMMMM`             `MMMMM+    /MMMMM-              NMMMMo     +MM+MMMM/      sMM/mMMMM-                                          
			                       mMMMM.                :MMMMh           `MMMMM         :MMMMh         dMM`                                            mMMMM.         /NMMMd`      hMMMMm               mMMMMd    yMMMMN               hMMMMm     +MM-mMMMd     `NMN mMMMM-                                          
			                       mMMMM.                :MMMMh           `MMMMM         :MMMMd`````.-/hMMM`                                            mMMMM.      ./hMMMm+`       NMMMMd               hMMMMN    mMMMMm               yMMMMM`    +MM-+MMMM-    oMMo mMMMM-                                          
			                       mMMMM.                :MMMMNddddddddddddMMMMM         :MMMMNhhhhhhdNMMMM`                                            mMMMMdhhhhdNMMNhs:         `MMMMMh               yMMMMM`   NMMMMd               sMMMMM.    +MM-`NMMMy   `NMN` mMMMM-                                          
			                       mMMMM.                :MMMMh           `MMMMM         :MMMMh       `oMMM`                                            mMMMM-```oMMMM/            `MMMMMh               yMMMMM`   NMMMMd               sMMMMM.    +MM- sMMMM.  +MMs  mMMMM-                                          
			                       mMMMM.                :MMMMh           `MMMMM         :MMMMh         hMM`                                            mMMMM.    dMMMN.            NMMMMh               hMMMMM    mMMMMm               sMMMMM`    +MM- .MMMMo  mMM.  mMMMM-                                          
			                       mMMMM.                :MMMMh           `MMMMM         :MMMMh         oNN`                                            mMMMM.    .NMMMd`           dMMMMm               dMMMMm    yMMMMN               hMMMMN     +MM-  hMMMN /MMy   mMMMM-                                          
			                       mMMMM.                :MMMMh           `MMMMM         :MMMMh                                                         mMMMM.     /MMMMs           +MMMMM`              NMMMMs    /MMMMM.              mMMMMy     +MM-  /MMMM/dMM-   mMMMM-                                          
			                       mMMMM.                :MMMMh           `MMMMM         :MMMMh                                                         mMMMM.      yMMMM/          `NMMMM:             .MMMMM.    `mMMMM/             .MMMMM-     +MM-   mMMMMMMd    mMMMM-                                          
			                       mMMMM.                :MMMMh           `MMMMM         :MMMMh               `ys-                                      mMMMM.      `mMMMN.          +MMMMh             oMMMMs      /MMMMd             +MMMMy      +MM-   oMMMMMM/    mMMMM-                                          
			                       mMMMM.                :MMMMh           `MMMMM         :MMMMh              `hMN`                                      mMMMM.       :MMMMd`          sMMMM:           `NMMMh`       oMMMM/           `mMMMd`      +MM-   `MMMMMm     mMMMM-                                          
			                       mMMMM.                :MMMMh           `MMMMM         :MMMMh             .hMMo                                       mMMMM.        oMMMMy           oMMMN-         `dMMMy`         +MMMN:         `hMMMh`       +MM-    yMMMM+     mMMMM-                                          
			                       mMMMM.                :MMMMh           `MMMMM`        :MMMMd           -sNMMN`                                       NMMMM.         dMMMM+           :dMMN+`      :mMMN+            -dMMNo`      :dMMN+         oMM-    -MMMN`     mMMMM-                                          
			                  `oooyMMMMMdooo-         :oomMMMMMyo+     .oohMMMMMhoo.  +oomMMMMMyoooooooshmMMMMM+                                    -ooyMMMMMdoo/      .NMMMMhoo.        `/hNMms/:/odMMd+`               :yNMNs/:/odMMdo`       .osmMMmo+   dMMo   +oyMMMMMdoo.                                       
			                  `/////////////.         -///////////     .///////////.  :////////////////////////                                     .///////////:       -///////.           `:+sssss+:.                    `:+osssso:.`         `////////   -//`   ///////////`                                      </pre>
         </div>
        
            <div class="game-box">
				

				 <p> ${description == null ? "Press ENTER to play!" : ""}</p>

				 <c:forEach items="${description}" var="item">
				 ${item}<br>
                 </c:forEach>

                <input type="hidden" name = "x" value="${x}">
                <input type="hidden" name = "y" value="${y}">
                <input type="hidden" name = "room" value="${room}">
                
                <input type="hidden" name = "Inventory" value="${Inventory}">
                <input type="hidden" name = "MapInventory" value="${MapInventory}">
                <input type="hidden" name = "Actions" value="${Actions}">
              
              	<input type="hidden" name = "Score" value="${Score}">
             
              <table>
              	<tr>
              		<td class="label">Score: </td>
              		<td>${Score}</td>
              	</tr>
				<%--
                <tr>
					<td class="label"></td>
					<td>${result}</td>
				</tr>
				<tr>
					<td class="label">Coord:</td>
					<td>${coords}</td>
				</tr>
				
				<tr>
					<td class="label">Inventory:</td>
					<td>${Inventory}</td>
				</tr>
				
				<tr>
					<td class="label">Actions made:</td>
					<td>${Actions}</td>
				</tr>
				<tr>
					<td class="label">Map Inventory:</td>
					<td>${MapInventory}</td>
				</tr>
				<tr>
					<td class="label">Room number:</td>
					<td>${room}</td>
				</tr>
				--%>
				</table>
				
				<div class = "input-style">
				<label for="move">></label>
                <input autofocus autocomplete= "off" type="text" name="move" value="${move}">
				</div>
				
            </div>
        </form>   
          
            
  
	</body>
</html>