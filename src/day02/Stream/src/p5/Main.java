package p5;

import java.util.Arrays;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> list = Arrays.asList("java8 lambda","stream mapping");
		list.stream().flatMap(data->Arrays.stream(data.split(" ")))
		.forEach(word->System.out.println(word));
		
		
		List<String> list2 = Arrays.asList("1.2, 2.3", "5.5");
		list2.stream().flatMapToDouble(data->{
					String[] strArr = data.split(",");
					double[] doubleArr = new double[strArr.length];
					for(int i = 0; i < strArr.length; i++){
						doubleArr[i] = Double.parseDouble(strArr[i].trim());
					}
					return Arrays.stream(doubleArr);
				}).forEach(n -> System.out.println(n));
	
		
	}

}
