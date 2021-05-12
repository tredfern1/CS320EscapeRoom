<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<html>
	<head>
		<title>Login!</title>
		<link href="https://fonts.googleapis.com/css2?family=VT323&display=swap" rel="stylesheet">
		<link rel="stylesheet" href="${pageContext.request.contextPath}/css/styles.css" />
		
		<style type="text/css">
		.error {
			color: red;
			font-family: 'VT323', monospace;
			font-size: 30px;
		}
		.text{
			color: white;
			font-family: 'VT323', monospace;
			font-size: 30px;
			font-size: 2vw;
		}

		.button {
			background-color: black;
			border: 2px solid white;
			color: white;
			text-align: center;
			text-decoration: none;
			display: inline-block;
			font-size: 2vw;
			font-family: 'VT323', monospace;
		}

		</style>

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
        

		<%-- SKULL CITED FROM --> http://www.asciiworld.com/-Death-Co-.html--%>
		<form action="${pageContext.servletContext.contextPath}/login" method="post">
			<p class = "text">You've managed to escape the rooms! However, it seems that if you had looked a little harder you may have found more...</p>
			<div class="art">
        	<pre>
																		                             ...----....
																		                         ..-:"''         ''"-..
																		                      .-'                      '-.
																		                    .'              .     .       '.
																		                  .'   .          .    .      .    .''.
																		                .'  .    .       .   .   .     .   . ..:.
																		              .' .   . .  .       .   .   ..  .   . ....::.
																		             ..   .   .      .  .    .     .  ..  . ....:IA.
																		            .:  .   .    .    .  .  .    .. .  .. .. ....:IA.
																		           .: .   .   ..   .    .     . . .. . ... ....:.:VHA.
																		           '..  .  .. .   .       .  . .. . .. . .....:.::IHHB.
																		          .:. .  . .  . .   .  .  . . . ...:.:... .......:HIHMM.
																		         .:.... .   . ."::"'.. .   .  . .:.:.:II;,. .. ..:IHIMMA
																		         ':.:..  ..::IHHHHHI::. . .  ...:.::::.,,,. . ....VIMMHM
																		        .:::I. .AHHHHHHHHHHAI::. .:...,:IIHHHHHHMMMHHL:. . VMMMM
																		       .:.:V.:IVHHHHHHHMHMHHH::..:" .:HIHHHHHHHHHHHHHMHHA. .VMMM.
																		       :..V.:IVHHHHHMMHHHHHHHB... . .:VPHHMHHHMMHHHHHHHHHAI.:VMMI
																		       ::V..:VIHHHHHHMMMHHHHHH. .   .I":IIMHHMMHHHHHHHHHHHAPI:WMM
																		       ::". .:.HHHHHHHHMMHHHHHI.  . .:..I:MHMMHHHHHHHHHMHV:':H:WM
																		       :: . :.::IIHHHHHHMMHHHHV  .ABA.:.:IMHMHMMMHMHHHHV:'. .IHWW
																		       '.  ..:..:.:IHHHHHMMHV" .AVMHMA.:.'VHMMMMHHHHHV:' .  :IHWV
																		        :.  .:...:".:.:TPP"   .AVMMHMMA.:. "VMMHHHP.:... .. :IVAI
																		       .:.   '... .:"'   .   ..HMMMHMMMA::. ."VHHI:::....  .:IHW'
																		       ...  .  . ..:IIPPIH: ..HMMMI.MMMV:I:.  .:ILLH:.. ...:I:IM
																		     : .   .'"' .:.V". .. .  :HMMM:IMMMI::I. ..:HHIIPPHI::'.P:HM.
																		     :.  .  .  .. ..:.. .    :AMMM IMMMM..:...:IV":T::I::.".:IHIMA
																		     'V:.. .. . .. .  .  .   'VMMV..VMMV :....:V:.:..:....::IHHHMH
																		       "IHH:.II:.. .:. .  . . . " :HB"" . . ..PI:.::.:::..:IHHMMV"
																		        :IP""HHII:.  .  .    . . .'V:. . . ..:IH:.:.::IHIHHMMMMM"
																		        :V:. VIMA:I..  .     .  . .. . .  .:.I:I:..:IHHHHMMHHMMM
																		        :"VI:.VWMA::. .:      .   .. .:. ..:.I::.:IVHHHMMMHMMMMI
																		        :."VIIHHMMA:.  .   .   .:  .:.. . .:.II:I:AMMMMMMHMMMMMI
																		        :..VIHIHMMMI...::.,:.,:!"I:!"I!"I!"V:AI:VAMMMMMMHMMMMMM'
																		        ':.:HIHIMHHA:"!!"I.:AXXXVVXXXXXXXA:."HPHIMMMMHHMHMMMMMV
																		          V:H:I:MA:W'I :AXXXIXII:IIIISSSSSSXXA.I.VMMMHMHMMMMMM
																		            'I::IVA ASSSSXSSSSBBSBMBSSSSSSBBMMMBS.VVMMHIMM'"'
																		             I:: VPAIMSSSSSSSSSBSSSMMBSSSBBMMMMXXI:MMHIMMI
																		            .I::. "H:XIIXBBMMMMMMMMMMMMMMMMMBXIXXMMPHIIMM'
																		            :::I.  ':XSSXXIIIIXSSBMBSSXXXIIIXXSMMAMI:.IMM
																		            :::I:.  .VSSSSSISISISSSBII:ISSSSBMMB:MI:..:MM
																		            ::.I:.  ':"SSSSSSSISISSXIIXSSSSBMMB:AHI:..MMM.
																		            ::.I:. . ..:"BBSSSSSSSSSSSSBBBMMMB:AHHI::.HMMI
																		            :..::.  . ..::":BBBBBSSBBBMMMB:MMMMHHII::IHHMI
																		            ':.I:... ....:IHHHHHMMMMMMMMMMMMMMMHHIIIIHMMV"
																		              "V:. ..:...:.IHHHMMMMMMMMMMMMMMMMHHHMHHMHP'
																		               ':. .:::.:.::III::IHHHHMMMMMHMHMMHHHHM"
																		                 "::....::.:::..:..::IIIIIHHHHMMMHHMV"
																		                   "::.::.. .. .  ...:::IIHHMMMMHMV"
																		                     "V::... . .I::IHHMMV"'
																		                       '"VHVHHHAHHHHMMV:"'
        	</pre>
        </div>
			<input class = "button" type="Submit" name="submit" value="Reset game and return to login">
		</form>
	</body>
</html>