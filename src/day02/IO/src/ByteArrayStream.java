import java.io.*;
import java.util.Arrays;

public class ByteArrayStream {

	public static void main(String[] args) {

		byte[] inSrc = {0,1,2,3,4,5,6,7,8,9};
		byte[] outSrc = null;
		byte[] temp = new byte[10];
		
		ByteArrayInputStream input = null;
		ByteArrayOutputStream output = null;
		
		input = new ByteArrayInputStream(inSrc);
		output = new ByteArrayOutputStream();
		
		int data = 0;
		
//		while((data = input.read()) != -1) {
//			output.write(data);
//		}
		
		input.read(temp, 0, temp.length);
		output.write(temp, 5, 5);
		
		outSrc = output.toByteArray();
		
		System.out.println("input: " + Arrays.toString(inSrc));
		System.out.println("output: " + Arrays.toString(outSrc));
		
	}

}