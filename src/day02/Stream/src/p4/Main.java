package p4;

import java.util.*;

public class Main {

	public static void main(String[] args) {

		List<String> names = Arrays.asList("홍길동","신용","김바","신용권","신민철");
		//중복제거
		names.stream().distinct().forEach(n->System.out.println(n));
		
		names.stream().filter(n->n.startsWith("신")).forEach(n->System.out.println(n));
		names.stream().filter(n->n.endsWith("동")).forEach(n->System.out.println(n));

		names.stream().filter(n->n.length() < 3).forEach(n->System.out.println(n));

		
	}

}
