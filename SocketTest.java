package Network;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;


public class SocketTest {
	public static void main(String[] args) {
		try (Socket socket = new Socket("time-c.nist.gov", 13)){
			InputStream inStream = socket.getInputStream();
			BufferedReader  reader = new BufferedReader(new InputStreamReader(inStream));
			String line = null;
			while ((line = reader.readLine()) != null) {
				System.out.println(line);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("종료합니다....");
	}
}
