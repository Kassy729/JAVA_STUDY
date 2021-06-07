package Network;

public class ThreadTest {
	public static void main(String[] args) {
		Thread c1 = new Counter(1);
		Thread c2 = new Counter(11);
		//Runnable
		c1.start();  //새로운 스레드로 실행
		c2.start();  //새로운 스레드로 실행
		System.out.println("main thread 종료...");
	}
}

class Counter extends Thread{
	private int start;
	public Counter(int start) {
		this.start = start;
	}
	
	public void run() {
		for(int i = start; i < (start+10); i++) {
			System.out.println(i);
			try  {
				Thread.sleep(1000);
			} catch (Exception e) {}
		}
		System.out.println(start + "~ " + (start+9) + "까지 count 종");
		
	}
}
