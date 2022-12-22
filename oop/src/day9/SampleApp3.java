package day9;

public class SampleApp3 {

	public static void main(String[] args) {
		// 메소드의 중복정의 활용하기
		
		Sample2 sample = new Sample2();
		
		sample.plus(10, 20);
		sample.plus(10.5, 20);
		sample.plus(10, 20.8);
		sample.plus(10, 20, 30);
		sample.plus(10.7, 20.9);
	}
}
