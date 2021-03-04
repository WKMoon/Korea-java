package p1;

import java.util.Arrays;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {
	static int sum = 0;

	public static void main(String[] args) {

		//배열로 스트림
//		String[] strArr = {"홍길동","신용권","김미나"};
////		Stream<String> strStream = Arrays.stream(strArr);
//		Stream<String> strStream = Stream.of(strArr);
//		strStream.forEach(a->System.out.println(a));
//		
//		
//		double[] doubleArr = {1.1, 2.2, 3.3};
//		int[] intArr = {1,4,2,2};
//		
//		IntStream intStream = IntStream.of(intArr);
//		DoubleStream doubleStream = DoubleStream.of(doubleArr);
//		
//		intStream.forEach(a->System.out.println(a));
//		doubleStream.forEach(a->System.out.println(a));

		
		//숫자 범위로부터 스트림 얻기
		IntStream num = IntStream.range(1,100);
		num.forEach(a-> sum+= a);
		System.out.println(sum);
	}

}
