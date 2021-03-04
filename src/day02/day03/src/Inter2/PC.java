package Inter2;

public class PC implements Soldier{

	@Override
	public void eat() {
		// TODO Auto-generated method stub
		System.out.println("허리를 곧게 펴고 직각식사를 한다.급하게 먹는다.");
	}

	@Override
	public void sleep() {
		// TODO Auto-generated method stub
		System.out.println("고향 생각에 잠이 오질 않는다. 그러다 어디 간다.");
	}

	@Override
	public void salute() {
		// TODO Auto-generated method stub
		System.out.println("충!!!!성!!!!!!");
	}

	@Override
	public void work() {
		// TODO Auto-generated method stub
		System.out.println("일을 정말 열심히 한다. 그러다 어디간다.");
	}

}
