package day02;
class A{
	int data1;
	double data2;
	
	void setData1(int data1) {
		this.data1 = data1;
		System.out.println("this: "+this);
	}
}
public class ClassTest1 {
	public static void main(String[] args) {
		A a = new A();
		A b = new A();
		
		a.setData1(10);
		b.setData1(100);
	}
}
