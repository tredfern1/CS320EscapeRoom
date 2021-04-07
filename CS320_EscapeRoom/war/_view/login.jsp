<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<html>
	<head>
		<title>Login!</title>
        
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/styles.css" />
	</head>

	<body>

                   
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
        
           <input type="text">
           <input type="password">

        <form action="${pageContext.servletContext.contextPath}/game" method="doGet">
			
			<input type="Submit" name="submit" value="Login">
		</form>
        
        
	</body>
</html>