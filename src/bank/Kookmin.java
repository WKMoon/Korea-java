package bank;

public class Kookmin extends Bank{
	public Kookmin() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	void deposit(int money) {
		money *= 0.5;
		super.deposit(money);
	}
}
