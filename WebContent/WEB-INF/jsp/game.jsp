
<html>
<head>
<title> Kalah Spring MVC Example</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
</head>
<body>

	<br>
   
    <div style="width: 100%; overflow: hidden;">
        <div id="eventsDiv" style="width: 400px; float: left;">
            <p id="events">${message}</p>
        </div>
        <div id="boardDiv" style="margin-left: 400px;">
        	<br>
            <h2>Game Board</h2>
            <br>
        </div>
        <div id="statusDiv" style="margin-left: 400px;">
        	<br>
            <h3 style="background-color:pink;"> ${next_player} </h3>
            <br>
        </div>
        <div id="tableDiv" style="margin-left: 400px;">
            <table style="width:100%" border="1">
                <tr>
                    <td align="center" style="font-weight: bold">Kalah ${player_1}</td>
                    <td align="center">Pit 1</td>
                    <td align="center">Pit 2</td>
                    <td align="center">Pit 3</td>
                    <td align="center">Pit 4</td>
                    <td align="center">Pit 5</td>
                    <td align="center">Pit 6</td>
                    <td align="center" style="font-weight: bold">Kalah ${player_2}</td>
                </tr>
                <tr>
                    <td id="P17" rowspan="2" bgcolor="yellow" align="center" style="font-weight: bold">${P17}</td>
                    <td bgcolor="yellow" align="center">
                        <label id="P11">${P11}</label>
                    </td>
                    <td bgcolor="yellow" align="center">
                        <label id="P12">${P12}</label>
                    </td>
                    <td bgcolor="yellow" align="center">
                        <label id="P13">${P13}</label>
                    </td>
                    <td bgcolor="yellow" align="center">
                        <label id="P14">${P14}</label>
                    </td>
                    <td bgcolor="yellow" align="center">
                        <label id="P15">${P15}</label>
                    </td>
                    <td bgcolor="yellow" align="center">
                        <label id="P16">${P16}</label>
                    </td>
                    <td id="P27" rowspan="2" bgcolor="cyan" align="center" style="font-weight: bold">${P27}</td>
                </tr>
                
                <tr>
                    <td bgcolor="cyan" align="center">
                        <label id="P21">${P21}</label>
                    </td>
                    <td bgcolor="cyan" align="center">
                        <label id="P22">${P22}</label>
                    </td>
                    <td bgcolor="cyan" align="center">
                        <label id="P23">${P23}</label>
                    </td>
                    <td bgcolor="cyan" align="center">
                        <label id="P24">${P24}</label>
                    </td>
                    <td bgcolor="cyan" align="center">
                        <label id="P25">${P25}</label>
                    </td>
                    <td bgcolor="cyan" align="center">
                        <label id="P26">${P26}</label>
                    </td>
                </tr>
            </table>
            <br>
            <br>
            <div id="submitDiv" style="margin-left: 200px;">
            <form action="game.html" method="post">
            	<select name="pit_number">
				  <option value="1">Pit 1</option>
				  <option value="2">Pit 2</option>
				  <option value="3">Pit 3</option>
				  <option value="4">Pit 4</option>
				  <option value="5">Pit 5</option>
				  <option value="6">Pit 6</option>
				</select>
	    		<input type="submit" value="Play" width="200" height="150"/>
	    	</form>
	    	</div>
        </div>
        <form action="welcome.html" method="post">
	    	<input type="submit" value="Reset" width="200" height="150"/>
	    </form>
    </div>

</body>
</html>