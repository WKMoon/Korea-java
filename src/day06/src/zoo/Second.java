package zoo;

public class Second implements Runnable{
private String data;
	
	public Second() {
		// TODO Auto-generated constructor stub
	}
	
	Second(String data){this.data = data;}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
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
