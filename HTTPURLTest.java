package Network;

import java.net.*;
import java.io.*;

public class HTTPURLTest {
   public static void main(String[] args) throws Exception {
	   //구글 검색창에 java를 검색했다.
      String site = "https://www.google.com/search?q=java&ie=UTF-8";
      //1. url객체 생성
      URL url = new URL(site);
      
      //2. 연결설립
      HttpURLConnection con = (HttpURLConnection)url.openConnection();
//      URLConnection con = url.openConnection();
      
      //3. GET방식으로 데이터 전송
      con.setRequestMethod("GET");
      //?????
      con.setRequestProperty("User-Agent", "Mozilla/5.0");
      
      //에러 코드를 받아온다
      int code = con.getResponseCode();
      System.out.println("Response code:" + code);
      
      // 연결로부터 스트림을 얻어야 한다. 
      InputStream stream = con.getInputStream();
      //얻어온 스트림을 읽어준다
      InputStreamReader streamReader = new InputStreamReader(stream, "UTF-8");
      
      //?????
      BufferedReader reader = new BufferedReader(streamReader);
      String line;
      while((line = reader.readLine()) != null) {
         System.out.println(line);
      }
      System.out.println();
   }
}