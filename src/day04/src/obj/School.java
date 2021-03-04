package obj;

public class School {
	public static void main(String[] args) {
		Student 문우경 = new Student(1,"문우경");
		
		System.out.println(문우경.equals(new Student(1,"문우경")));
	}
}
