package bank;

public class Shinhan extends Bank{
	public Shinhan() {
		// TODO Auto-generated constructor stub
	}
	boolean withdraw(int money) {
		money *= 1.5;
		return super.withdraw(money);
	}
	
}
