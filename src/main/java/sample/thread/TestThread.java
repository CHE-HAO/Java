package sample.thread;

public class TestThread extends Thread {

	private String text;
	private long start;
	
	@Override
	public void run() {
		for (int i = 0 ; i < 100 ; i++) {
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(getName()+", text:"+text+", Thread:"+i);
		}
		System.out.println(getName()+", cost:" + (System.currentTimeMillis() - start));
	}
	
	public void setText(String text) {
		this.text = text;
	}
	
	public void setStart(long start) {
		this.start = start;
	}
	
	
}
