package Network;

import java.net.*;
import java.io.*;

public class HttpURLPostTest {
    public static void main(String[] args) throws Exception
    {
        String site = "http://localhost:9100/todos";

        URL url=new URL(site);

        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        
        //con에 데이터를 input가능 하게 함
        con.setDoInput(true);
        //?????
        con.setDoOutput(true);
        //?????
        con.setRequestMethod("POST");
        con.setRequestProperty("content-type", "application/x-www-form-urlencoded");

        String data = "id=scpark&pw=1111";
        // StringBuffer buffer = new StringBuffer();   // 계속 문자값을 이어갈 때 StringBuffer가 속도가 훨씬 빠르다
        // buffer.append("id=scpark&pw=1111");
        // buffer.append("id=scpark&").append("pw=1111");
        // data = "id=scpark" + "&pw=1111";

        OutputStream oStream = con.getOutputStream();

        OutputStreamWriter oWriter = new OutputStreamWriter(oStream, "UTF-8");  // 굳이 안해도 되는데 이렇게 해야 UTF-8 형식으로 보낼 수 있다.

        PrintWriter writer = new PrintWriter(oWriter);
        writer.println(data);   // 메모리상에 쌓임. 바로 갈 때도 있지만 안 갈 때도 있음
        						//PrintWriter와 println을 사용해 서버로 데이터를 전송
        writer.flush(); // 혹시 안 갔을 수도 있으니 메모리 상에 있는 걸 바로 보내는 메소드

        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));

        String inLine;

        while((inLine = in.readLine()) !=null)
        {
            System.out.println(inLine);
        }

        in.close();
    }
}