package day02;

public class Car {
	String brand;
	String color;
	int price;


	public Car() {}

	public Car(String brand, String color, int price) {
		this.brand = brand;
		this.color = color;
		this.price = price;
	}//alt+shift+s
	
	public Car( String color, int price) {
		this.color = color;
		this.price = price;
	}//alt+shift+s
	
	
	
	
	void engineStart() {
		System.out.println("열쇠로 시동킴");
	}
	void engineStop() {
		System.out.println("열쇠로 시동끔");
	}
}
