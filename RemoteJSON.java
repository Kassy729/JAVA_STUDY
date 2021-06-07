package Network;

import java.net.*;
import java.sql.DriverManager;
import java.io.*;
import com.google.gson.*;
import com.sun.jdi.connect.spi.Connection;
import java.sql.*;


public class RemoteJSON {

	public static void main(String[] args)throws Exception {
		String site = "http://jsonplaceholder.typicode.com/posts";
		URL url = new URL(site);
		
		URLConnection con = url.openConnection();
		
		InputStream stream = con.getInputStream();  //스트림으로 가져온다
		InputStreamReader reader = new InputStreamReader(stream);
		BufferedReader buffReader = new BufferedReader(reader);  //한줄씩 효율적으로 읽기 위해서 사용
		
		String line = null;
		StringBuffer buf = new StringBuffer();  //속도가 더빠르다
		//버퍼리더로 읽어서 line에 저장해라, null인지 검사
		while ((line = buffReader.readLine()) != null) {
			System.out.println(line);
			buf.append(line);  
		}
		
		Gson gson = new Gson();  //구글의 JSON 라이브러리
		
		gson.fromJson(buf.toString(), Post[].class);  //????
		
		Post[] posts = gson.fromJson(buf.toString(), Post[].class);
		
		for(Post post : posts) {
			System.out.println("userID:" + post.getUserId() + ", id:" + post.getId());
			
		}
		insertIntoDB(posts);
		
		
		
		//길이의 총합????
		
		
		
		
//		Person person = gson.fromJson("{'name':'gbhon', 'age':10, 'graduated':false}", Person.class);
		
		/*
		 * Person p = new Person();
		 * p.setName("gdhon");
		 * p.setAge(10);
		 */
		
//		System.out.println(person.getName());
//		System.out.println(person.getAge());
//		System.out.println(person.isGraduated());
		
		
		buffReader.close();  //닫아라
		
	}
	
	private static void insertIntoDB(Post[] posts) throws Exception {
		//드라이버 로딩
		//DB서버에 연결하고
		/*
		 * create table posts(
		 * 		userId int,
		 * 		id int primary key,
		 * 		title varchar(50),
		 * 		body text
		 * )
		 */
		 Class.forName();
		 
		 String url = "jdbc://localhost:3306/OOP";		 
				
		 Connection con = DriverManager.getConnection(url, "root", "1111");
		 String sql = "insert into posts(userId, id, title, body) values(?, ?, ?, ?)";
		 
		 PreparedStatement pstmt = con.prepareStatement(sql);
		 
		 for (Post post : posts) {
			 pstmt.setInt(1, post.getUserId());
			 pstmt.setInt(2, post.getId());
			 pstmt.setString(3, post.getTitle());
			 pstmt.setString(4, post.getBody());
			 
			 pstmt.executeUpdate();
		 }
		 
		 pstmt.executeUpdate();
	}
	
}

//gson을 사용하기 위해 자바빈형태로 클래스를 구현
class Person{
	//JavaBean 형태로 클래스를 정의
	//1. pirvate member 변수에 대한 public getter와 setter를 가진다.
	//2. default 생성자를 가진다.
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
