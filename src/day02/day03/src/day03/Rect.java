package day03;

//상속을 막아주는 final 사용
public final class Rect extends Shape{

	@Override
	public double getArea(double w, double h) {
		// TODO Auto-generated method stub
		return w*h;
	}
	
	

}
