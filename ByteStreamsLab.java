package Network;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Scanner;

public class ByteStreamsLab {
	public static void main(String[] args) throws IOException{
		Scanner input = new Scanner(System.in);
		System.out.println("원본 파일 이름을 입력하시오: ");
		String inputFilename = input.next();
		
		System.out.println("복사 파일 이름을 입력하시오: ");
		String outputFileName = input.next();
		
		try(InputStream inputStream = new FileInputStream(inputFilename);
				OutputStream outputStream = new FileOutputStream(outputFileName)){
			int c;
			
			while ((c = inputStream.read()) != -1) {
				outputStream.write(c);
			}
		}
		System.out.println(inputFilename + "을 " + outputFileName + "로 복사하였습니다.");
	}
}
