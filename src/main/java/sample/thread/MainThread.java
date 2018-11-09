package sample.thread;

public class MainThread {


	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		TestThread t1 = new TestThread();
		t1.setName("t1"); 
		t1.setText("hello");
		t1.setStart(start);
		TestThread t2 = new TestThread();
		t2.setName("t2"); 
		t2.setText("yahoooo");
		t2.setStart(start);
		TestThread t3 = new TestThread();
		t3.setName("t3"); 
		t3.setText("yaaaaa");
		t3.setStart(start);

		
		
		t1.start();
		t2.start();
		t3.start();
		
		t1 = new TestThread();
//		t1.setName("t4"); 
		t1.setText("hellottttt");
		t2 = new TestThread();
//		t2.setName("t5"); 
		t2.setText("yahoooo22222");
		t3 = new TestThread();
//		t3.setName("t6"); 
		t3.setText("yaaaaaklllll");
		
		t1.setStart(start);
		t2.setStart(start);
		t3.setStart(start);
		t1.start();
		t2.start();
		t3.start();
		
		System.out.println("cost:" + (System.currentTimeMillis() - start));
	}
	
	
}
