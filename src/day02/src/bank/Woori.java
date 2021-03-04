package bank;

public class Woori extends Bank{
	public Woori() {
		// TODO Auto-generated constructor stub
	}
	@Override
	int balance() {
		// TODO Auto-generated method stub
		this.money *= 0.5;
		return super.balance();
	}
}
