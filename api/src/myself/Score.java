package myself;

public class Score {
	
	private int kor;
	private int eng;
	private int math;
	
	public Score() {
		
	}
	
	public Score(int kor, int eng, int math) {
		this.kor = kor;
		this.eng = eng;
		this.math = math;
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

	public int getMath() {
		return math;
	}

	public void setMath(int math) {
		this.math = math;
	}

	public int getTotal(){
		return kor + eng + math;
	}
	
	public int getAverage() {
		return getTotal()/3;
	}

	@Override
	public String toString() {
		return "Score [kor=" + kor + ", eng=" + eng + ", math=" + math + ", getTotal()=" + getTotal()
				+ ", getAverage()=" + getAverage() + "]";
	}
	
}
