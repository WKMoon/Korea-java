package obj;

import java.util.Random;

public class ObejctTest {
	public static void main(String[] args) {
		String data1 = "ABC";
		String data2 = "ABC";
		
		String data3 = new String("ABC");
		String data4 = new String("ABC");
		
		System.out.println(data1 == data2);//constant pool
		System.out.println(data3 == data4);//checking address value
		
		System.out.println(data1.hashCode());
		System.out.println(data2.hashCode());		
		
		System.out.println(data3.hashCode());
		System.out.println(data4.hashCode());
		
		Random r1 = new Random();
		Random r2 = new Random();
		
		System.out.println(r1 == r2);
//		r1 = r2;
		System.out.println(r1.equals(r2));
		System.out.println(r1 == r2);

		
	}
}
