import java.io.FileWriter;
import java.io.IOException;


import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint("/adminSocket")
public class adminSocket{
	private static Session admin = null;
	private static FileWriter fw = null;
	
	@OnOpen
	public void handleOpen(Session userSession) {
		if(admin!=null) {
			try {
				admin.close();
			}catch(IOException e) {
				
			}
		}
		admin = userSession;
		for(String key : chatSocket.getUserKeys()) {
			visit(key);
		}
	}
	@OnMessage
	public void handleMessage(String message, Session userSession) throws IOException{
		String[] split = message.split("#####",2);
		String key = split[0];
		String msg = split[1];
		chatSocket.sendMessage(key, msg);
	}
	@OnClose
	public void handleClose(Session userSession) {
		admin=null;
	}
	private static void send(String message) {
		if(admin!=null) {
			try {
				admin.getBasicRemote().sendText(message);
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
	}
	public static void visit(String key) {
		send("visit:::"+key);
	}
	public static void sendMessage(String key, String message) {
		send("message:::"+key+":::"+message);
	}
	public static void bye(String key) {
		send("bye:::"+key);
	}
}