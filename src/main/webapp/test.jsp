<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!doctype html>
<html>
<head>
<title>Web Socket Example</title>
</head>
<body>
	<form>
		<input id="user" type="text" value="anonymous">
		<input id="textMessage" type="text">
		<input onclick="sendMessage()" value="Send" type="button">
		<input onclick="disconnect()" value="Disconnect" type="button">
	</form>
	<br />
	<textarea id="messageTextArea" rows="10" cols="50"></textarea>
	<script>
		var webSocket = new WebSocket("ws://localhost:8080/team/websocket");
		var messageTextArea = document.getElementById('messageTextArea');
		webSocket.onopen = function(message) {
			messageTextArea.value += "Server connect...\n";
		};
		webSocket.onclose = function(message) {
			messageTextArea.value +="Server Disconnect...\n";
		};
		webSocket.onerror = function(message) {
			messageTextArea.value += "error...\n";
		}
		webSocket.onmessage = function(message){
			messageTextArea.value += message.data + "\n";
		};
		
		function sendMessage(){
			var user = document.getElementById("user");
			var message = document.getElementById('textMessage');
			messageTextArea.value += user.value + "(me) => " + message.value +"\n";
			webSocket.send("{{"+user.value +"}}" + message.value);
			message.value="";
		}
		function disconnect() {
			webSocket.close();
		}
	</script>
</body>
</html>