package Network;

import java.net.Socket;
import java.io.BufferedReader;
import java.net.*;
import java.io.*;

public class DateClient {
	public static void main(String[] args) {
		try(Socket socket = new Socket("localhost", 9100)){  //소켓 생성
			InputStream stream = socket.getInputStream();
			InputStreamReader reader = new InputStreamReader(stream);  //문자열을 읽을때만 reader 사
			BufferedReader bufReader = new BufferedReader(reader);
			String line = bufReader.readLine();  
		}catch (Exception e) {
			e.printStackTrace();
		};
		
	}
}
