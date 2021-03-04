package atm;

public class ATM implements Runnable{
	
	int money = 10000;
	
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		for (int i = 0; i < 5; i++) {
			synchronized (this) {
				withdraw(1000);
			}
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public /*synchronized*/ void withdraw(int money){
		this.money -= money;
		System.out.println(Thread.currentThread().getName() + "가 " +money + "원 출금");
		System.out.println("현재 잔액 " + this.money + "원");
		
	}

}
