package Network;

import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Calendar;

public class DateServer {
	public static void main(String[] args) throws Exception{
		ServerSocket serverSocket = new ServerSocket(9100);
		//자바로 서버를 열어준다
		
		while (true) {
			System.out.println("클라이언트의 요청을 기다립니다...");
			//클라이언트 요청을 기다리나
			Socket socket = serverSocket.accept();  //클라이언트가 서버소켓에 연결되기까지 기다린다
			System.out.println("클라이언트가 접속되었음...[" + socket.getRemoteSocketAddress() + "]");
			
			//클라이언트와 요청이 설립되면 새로운 socket을 생성해
			//그 클라이언트와 통신한다.
			Thread thread = new NewSocket(socket);
			thread.start();
		}
	}
}

class NewSocket extends Thread{
	Socket socket;
	public NewSocket(Socket socket) {
		this.socket = socket;
	}
	@Override
	public void run() {
		try {
			OutputStream ostream = socket.getOutputStream();  //서버가 클라이언트로 보낸다
			PrintWriter writer = new PrintWriter(ostream, true);  //효율적으로 보낸다.
			writer.println(Calendar.getInstance().getTime());  //클라이언트에게 괄호안의 값을 보내준다
			Thread.sleep(1000*10);
			writer.println();
			socket.close();
			System.out.println("클라이언트와의 연결을 종료합니다.");
		} catch (Exception e) {
			
		} finally {
			try {
				socket.close();
			} catch (Exception ignore) {
			}
		}
	}
}

