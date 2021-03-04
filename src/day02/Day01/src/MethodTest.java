
public class MethodTest {
	
	
	
	//메소드는 저장공간이다.
	public int add(int num1, int num2) {
		return num1+num2;
	}
	
	//static
	//1.가장 먼저 메모리에 할당된다.
	//2.너무 많이 쓰면 안된다.
	
	public static void main(String[] args) {//args는 네트워크관련 파라미터를 받는다.
		// TODO Auto-generated method stub
		System.out.println(new MethodTest().add(5,9));
		
	}

}
