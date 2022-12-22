package day12;

public class Circle {
	
	/*
	 * 정적변수와 정적 메소드
	 * 정적변수는 상수를 정의할떄 사용한다.
	 * 정적메소드는 여러 클래스에서 광범위하게 사용되는 유용한기능을 정의할 때 사용한다
	 * 	(정적메소드는 객체의 속서와 상호적용없이(갹체 생성할 필요없다.) 직접 값을 전달받아서 적절한 처리를 수행한다.
	 */
	
	private double x;
	private double y;
	private double r;
	public static final double PI = 3.14;
	
	public Circle(double x, double y, double r) {
		this.x = x;
		this.y = y;
		this.r = r;
	}
	
	public double round() {
		return 2*Circle.PI*Math.pow(r, 2);
	}
	
	public double area() {
		/*
		 * PI는 Circle 클래스 정적변수다.
		 * 			Circle.PI로 사용
		 * pow(double a, double b)는 Math 클래스의 정적 메소드다.
		 * 		Math.pow(r,2)호 사용
		 */
		return Circle.PI*Math.pow(r, 2);
		
	}
	
	public void display() {
		System.out.println("x좌표: " + x);
		System.out.println("r좌표: " + r);
		System.out.println("원의 둘레: " + round());
		System.out.println("원의 넓이: " + area());
	}
	

}
