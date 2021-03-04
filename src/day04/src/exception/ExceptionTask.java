package exception;

import java.util.Arrays;
import java.util.Scanner;

public class ExceptionTask {
	public static void main(String[] args) {
//		try {
//			System.out.println(10/0);
//		} catch (ArithmeticException e) {
//			// TODO Auto-generated catch block
////			System.out.println(e);
//			System.out.println("0으로 나눌수 없습니다.");
////			e.printStackTrace();
//		}
		
		
		
		//5개의 정수만 입력하는 프로그램
		//q를 입력하면 나가기
		Scanner sc = new Scanner(System.in);
		int[] arData = new int[5];
		int idx = 0;
		String temp = null;
		while(true) {
			System.out.println(++idx + "번째 정수 입력[q:나가기]");	
			temp = sc.next();
			if(temp.equals("q")) {break;}
			try {
				arData[idx-1] = Integer.parseInt(temp);
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				System.out.println("정수를 입력하세요");
				--idx;
			}catch(ArrayIndexOutOfBoundsException e) {
				System.out.println("더 이상 정수를 입력하실 수 없습니다.");
				System.out.println(Arrays.toString(arData));
				break;
			}
		}
	}
}
