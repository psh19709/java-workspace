package day22.generic.comparable;

/*
 * 제네릭 인터페이스 구현하기
 * 		구현할 인터페이스 
 * 			public interface Comparable<T>{
 *				int compareTo(T t);
 *			}
 *		Score에서 Comparable<T> 구현하기
 *			public class Score Implements Comparable<Score> {
 *		
 *			// 총점 순으로 오름차순 정렬하기
 *				public int compareTo(Score other){
 *					return this.total - other.total;
 *				}
 *			}
 */

public class Score implements Comparable<Score>{

	private String name;
	private int kor;
	private int eng;
	private int math;
	private int total;
	private int average;
	
	public Score(String name, int kor, int eng, int math) {
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
		this.total = kor + eng + math;
		this.average = total/3;
	}

	public String getName() {
		return name;
	}

	public int getKor() {
		return kor;
	}

	public int getEng() {
		return eng;
	}

	public int getMath() {
		return math;
	}

	public int getTotal() {
		return total;
	}

	public int getAverage() {
		return average;
	}

	@Override
	public int compareTo(Score otherScore) {
		/*
		 * 총점을 기준으로 오름차순 정렬하기
		 * 		Score a = new Score("김유신", 100, 100, 90);
		 * 		Score b = new Score("홍길동", 60, 70, 50);
		 * 		int x = a.compareTO(b);
		 * 
		 * 		a.getTotal() > b.getTotal()		 -> 양수
		 * 		a.getTotal() == b.getTotal()	 -> 0
		 * 		a.getTotal() < b.getTotal()		 -> 음수
		 * 
		 */
		System.out.println(this.total + ", " + otherScore.total);
		return this.total - otherScore.total;
	}
	
	@Override
	public String toString() {
		return "[name=" + name + ", kor=" + kor + ", eng=" + eng + ", math=" + math + ", total=" + total
				+ ", average=" + average + "]";
	}
	
}
