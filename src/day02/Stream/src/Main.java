import java.awt.List;
import java.util.*;


public class Main {

	public static void main(String[] args) {
//		List list1 = (List) Arrays.asList(1,2,3,4,5);
		List list = (List) Arrays.asList(new Student("홍길동",10),new Student("신용권",20),new Student("유미선",30));
		List list1 = (List) Arrays.asList(1,2);
		
//		OptionalDouble avg = ((Collection<Student>) list).stream().mapToInt(Student::getScore).average();
		@SuppressWarnings("unchecked")
		double avg1 = ((Collection<Student>) list).stream().mapToInt(Student::getScore).average().getAsDouble();
		
		@SuppressWarnings("unchecked")
		double count = ((Collection<Student>) list1).stream().count();
		
		System.out.println(avg1);
		System.out.println(count);
		
		
	}

}

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