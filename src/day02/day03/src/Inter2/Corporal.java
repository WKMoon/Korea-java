package Inter2;

public class Corporal implements Soldier {

	@Override
	public void eat() {
		// TODO Auto-generated method stub
		System.out.println("경치를 보며 식사한다.");
	}

	@Override
	public void sleep() {
		// TODO Auto-generated method stub
		System.out.println("잘잔다");
	}

	@Override
	public void salute() {
		// TODO Auto-generated method stub
		System.out.println("ㅊㅅ");
	}

	@Override
	public void work() {
		// TODO Auto-generated method stub
		System.out.println("후임들에게 일을 알려주다 어디 간다.");
	}

}
