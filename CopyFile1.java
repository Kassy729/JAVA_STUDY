package Network;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyFile1 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		FileInputStream in = null;  //파일에서 바이트를 읽는다.
		FileOutputStream out = null;  //파일에서바이트를 쓴다.
		
		try {
			in = new FileInputStream("input.txt");  //파일을 입력한
			out = new FileOutputStream("output.txt");  //파일을 출력한다
			int c;
			
			while ((c = in.read()) != -1) {  // -1될때까지 읽는다
				out.write(c);
			}
			System.out.println(c);
		} finally {
			if(in != null)
				in.close();
			if(out != null)
				out.close();
			
		}
	}

}
