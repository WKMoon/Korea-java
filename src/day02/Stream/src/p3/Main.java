package p3;

import java.util.*;
import java.util.stream.Stream;

public class Main {

	public static void main(String[] args) {
		List<Member> list = Arrays.asList(new Member("홍길동", Member.Male, 30), 
				new Member("김나리", Member.Female, 20), 
				new Member("신용권", Member.Male, 45),
				new Member("박수미", Member.Female, 27)
				);
		
		Stream<Member> os = list.stream();
		double ageAvg = os.filter(m -> m.getSex() == Member.Male)
						.mapToInt(Member::getAge)
						.average().getAsDouble();
						
		System.out.println(ageAvg);
		
		List<Student> list2 = Arrays.asList(new Student("1반",100,90),
				new Student("2반",80,100),
				new Student("1반",70,50),
				new Student("2반",85,100)
				);
		
		Stream<Student> os2 = list2.stream();
		int sum = os2.filter(m -> m.getRoom().equals("1반"))
			.mapToInt(Student::getKor).sum();
		System.out.println(sum);
		
	}

}

class Student{
	private String room;
	private int kor;
	private int eng;
	
	public Student(String room, int kor, int eng){
		this.room = room;
		this.kor = kor;
		this.eng = eng;
	}
	
	public String getRoom() {
		return room;
	}
	public void setRoom(String room) {
		this.room = room;
	}
	public int getKor() {
		return kor;
	}
	public void setKor(int kor) {
		this.kor = kor;
	}
	public int getEng() {
		return eng;
	}
	public void setEng(int eng) {
		this.eng = eng;
	}
	
	
}//end Student

class Member{
	public static int Male = 0;
	public static int Female = 1;
	private String name;
	private int sex;
	private int age;
	
	public Member(String name, int sex, int age){
		this.name = name;
		this.sex = sex;
		this.age = age;
	}

	public static int getMale() {
		return Male;
	}

	public static void setMale(int male) {
		Male = male;
	}

	public static int getFemale() {
		return Female;
	}

	public static void setFemale(int female) {
		Female = female;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSex() {
		return sex;
	}

	public void setSex(int sex) {
		this.sex = sex;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
}