package day05;

public class Student {
	int num;
	String name;
	
	
	public Student() {
		// TODO Auto-generated constructor stub
	}
	public Student(int num, String name) {
		this.num = num;
		this.name = name;
	}
	
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Student) {
			Student std = (Student)obj;
			if(std.hashCode() == this.hashCode()) {
				return true;
			}
			else {
				return false;
			}
			
		}
		return false;
	}
	
	
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return this.num;
	}
}
