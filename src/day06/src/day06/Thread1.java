package day06;

public class Thread1 extends Thread{
	private String data;
	
	public Thread1() {
		// TODO Auto-generated constructor stub
	}
	
	public Thread1(String data) {
		// TODO Auto-generated constructor stub
		this.data = data;
	}
	
	@Override
	public void run() {
		for(int i = 0; i < 10; i++) {
			System.out.println(data);
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}
