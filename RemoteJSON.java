package Network;

import java.net.*;
import java.io.*;
import com.google.gson.*;
import java.sql.*;

public class RemoteJSON {

   public static void main(String[] args) throws Exception {
      String site = "https://jsonplaceholder.typicode.com/posts";
      URL url = new URL(site);
      
      URLConnection con = url.openConnection();
      
      InputStream stream = con.getInputStream();
      InputStreamReader reader = new InputStreamReader(stream);
      BufferedReader buffReader = new BufferedReader(reader);
      
      String line = null;
//      String content = "";
      StringBuffer buf = new StringBuffer();
      while((line = buffReader.readLine()) != null) {
         System.out.println(line);
//         content += line;
         buf.append(line);
      }
      
      Gson gson = new Gson();
      
      Post[] posts = 
            gson.fromJson(buf.toString(), Post[].class);
      
      for (Post post : posts) {
         System.out.println("userID:"+post.getUserId()
               +", id:" + post.getId());            
      }
      insertIntoDB(posts);
      
//      Person person = gson.fromJson("{'name':'gdhon', 'age':10, 'graduated':false}",
//                  Person.class);
      
      /* 
       * Person p = new Person();
       * p.setName("gdhon");
       * p.setAge(10);
       */
      
//      System.out.println(person.getName());
//      System.out.println(person.getAge());
//      System.out.println(person.isGraduated());
//      
      
      buffReader.close();

   }
   
   private static void insertIntoDB(Post[] posts) 
         throws Exception {
      // 드라이버 로딩
      // DB서버에 연결하고
      //Connection con = DriverManger.getConnection(. . .);
      /*
       * create table posts (
       *   userId int, 
       *   id int primary key, 
       *   title varchar(50),
       *   body text
       * )
       */
      Class.forName("org.mariadb.jdbc.Driver");
      String url = "jdbc:mariadb://localhost:3306/OOP";
      
      Connection con = 
            DriverManager.getConnection(url, "root", "1111");
      String sql = "insert into posts(userId, id, title, body) values(?, ?, ?, ?)";
      
      PreparedStatement pstmt = con.prepareStatement(sql);
      
      for (Post post : posts) {
         pstmt.setInt(1, post.getUserId());
         pstmt.setInt(2, post.getId());
         pstmt.setString(3,  post.getTitle());
         pstmt.setString(4,  post.getBody());
         
         pstmt.executeUpdate();
      }
      
      
   }
}

class Person {
   // JavaBean 형태로 클래스를 정의
   // 1. private member 변수에 대한 public getter와 setter를 가진다.
   // 2. default 생성자를 가진다. 
   private String name;
   private int age;
   private boolean graduated;

   public String getName() {
      return name;
   }
   public void setName(String name) {
      this.name = name;
   }
   public int getAge() {
      return age;
   }
   public void setAge(int age) {
      this.age = age;
   }
   public boolean isGraduated() {
      return graduated;
   }
   public void setGraduated(boolean graduated) {
      this.graduated = graduated;
   }
   
   
}