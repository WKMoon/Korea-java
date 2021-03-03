package day02;

public class Road {
	//null은 아직 어떤 주소값을 할당할 지 모를 떄 쓰는 주소 초기값이다.
	//	선언후 누적연결 사용 시 초기화 방법
	//	String data = "";
	//선언 후 대입 사용 시 초기화 방법
	//Strig data1 = null;
	public static void main(String[] args) {
		//casting
		Car matiz = new Car();
		SuperCar ferrari = new SuperCar();
		
		//up casting
		Car noOptionFerrari = new SuperCar();
		
		//down casting
		SuperCar fullOptionFerrari = (SuperCar)noOptionFerrari;
		//SuperCar brokenFerrari = (SuperCar)new Car();casting 오류
		
		System.out.println(matiz instanceof Car);
		System.out.println(matiz instanceof SuperCar);
		System.out.println(ferrari instanceof Car);
		System.out.println(ferrari instanceof SuperCar);
		
		System.out.println(noOptionFerrari instanceof Car);
		System.out.println(noOptionFerrari instanceof SuperCar);
		
		System.out.println(fullOptionFerrari instanceof Car);
		System.out.println(fullOptionFerrari instanceof SuperCar);
		
		////////////////////////////////
//		Car myCar = new Car("벤틀리","white",30000);
//		Car dadyCar = new Car("벤츠","black",15000);
//		Car momCar = new Car("yellow",50000);
		
//		SuperCar ferrari = new SuperCar();
//		ferrari.brand = "FERRARI";
//		ferrari.color = "RED";
//		ferrari.price = 30000;
//		
//		ferrari.engineStart();
//		ferrari.engineStop();
//		
	}
	
}
