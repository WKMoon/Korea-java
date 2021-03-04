package zoo;

public class First {
	public static void main(String[] args) {
		Runnable r1 = new Second("멍멍");
		Runnable r2 = new Second("야옹");
		Runnable r3 = new Second("음메");
		
		Thread t1 = new Thread(r1);
		Thread t2 = new Thread(r2);
		Thread t3 = new Thread(r3);
	
		
		t1.start();
		t2.start();
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		t3.start();

		
	}
}
