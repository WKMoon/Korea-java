package p6;

import java.awt.List;
import java.util.*;
class Student{
	String name;
	int score;
	
	public Student(String name, int score){
		this.name = name;
		this.score= score;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}
	
	 
}
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] intArray = {1,2,3,4,5};
		IntStream intStream = Arrays.stream(intArray);
		intStream.asDoubleStream().forEach(a -> System.out.println(a));
		
		intStream = Arrays.stream(intArray);
		//boxed - 객체로 만드는 방법
		intStream.boxed().forEach(a->System.out.println(a.intValue()));
//		
//		List<Student> list = Arrays.asList(new Student("홍길동",10),new Student("신용권",20),new Student("유미선",30));
//
//		list.stream()
//		.maptoInt(Student::getScore)
//		.forEach(t->System.out.println(t));
	}

}
