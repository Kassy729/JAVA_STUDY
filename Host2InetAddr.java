package Network;

import java.net.*;

public class Host2InetAddr {

   public static void main(String[] args) {
      String hostName = "www.google.com";
      
      try {
    	  //자바에서 ip주소를 표현할때 사용하는 클래스 
         InetAddress address = InetAddress.getByName(hostName);
         //IP주소를 반환
         System.out.println("IP 주소:" + address.getHostAddress());
      }catch(UnknownHostException e) {
         System.err.println(e.getMessage());
      }
   }

}