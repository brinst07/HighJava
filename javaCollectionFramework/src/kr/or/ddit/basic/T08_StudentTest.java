package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/*
	문제) 학번, 이름, 국어점수, 영어점수, 수학점수, 총점, 등수를 멤버변수로 갖는
		  Student 클래스를 만든다.
		  생성자는 학번, 이름, 국어, 영어, 수학 점수만 매개변수로 받아서 처리한다.
		  
		  이 Student객체들은 List에 저장하여 관리한다.
		  List에 저장된 데이터들을 학번의 오름차순으로 정렬하여 출력하는 부분과
		  총점의 역순으로 정렬하는 부분을 프로그래밍 하시오
		  (총점이 같으면 학번의 내림차순으로 정렬되도록 한다.)
		  (학번의 정렬기준은 Student클래스 자체에서 제공하도록 하고, 총점 정렬기준은 외부클래스에서 제공하도록 한다)

*/
public class T08_StudentTest {
	public static void main(String[] args) {
		List<Students> studentlist = new ArrayList<>();
		studentlist.add(new Students("1", "홍길동", 80, 70, 60));
		studentlist.add(new Students("3", "강감찬", 70, 90, 50));
		studentlist.add(new Students("5", "아라리", 70, 90, 50));
		studentlist.add(new Students("2", "박효신", 80, 100, 90));
		studentlist.add(new Students("4", "하동균", 80, 20, 80));
		
		/*
		 * System.out.println("총합 계산"); for(int i = 0; i<studentlist.size(); i++) { int
		 * sum =
		 * studentlist.get(i).getKok()+studentlist.get(i).getEng()+studentlist.get(i).
		 * getMath(); studentlist.get(i).setSum(sum); }
		 */
		
		
		for(Students student : studentlist) {
			System.out.println(student);
		}
		
		Collections.sort(studentlist);
		System.out.println("=============== 정렬후 ==================");
		for(Students student : studentlist) {
			System.out.println(student);
		}
		
		System.out.println("======= 총점 정렬 =============");
		Collections.sort(studentlist, new SortSum());
		for(Students student : studentlist) {
			System.out.println(student);
		}
		

		
		
		
		System.out.println("======================== 마지막 조건 =================");
		for(int i = 0; i<studentlist.size(); i++) {
			for(int j=i; j<studentlist.size(); j++) {
				if(studentlist.get(i).sum ==  studentlist.get(j).sum) {
					if(Integer.parseInt(studentlist.get(i).getNo())<Integer.parseInt(studentlist.get(j).getNo()))
					Collections.swap(studentlist, i, j);
				}
			}
		}
		
	
		for(Students student : studentlist) {
			System.out.println(student);
		}
		
		System.out.println("============= 랭크 삽입 =================");
		for(int i = 0; i<studentlist.size(); i++) {
			studentlist.get(i).setRank(1);
			for(int j = 0; j<studentlist.size(); j++) {
				if(studentlist.get(i).sum<studentlist.get(j).sum) {
					studentlist.get(i).setRank(studentlist.get(i).getRank()+1);
				}
			}
		}
		
		for(Students student : studentlist) {
			System.out.println(student);
		}
		
	}
	
	
	
}

//총점의 역순으로 정렬하는 클래스
class SortSum implements Comparator<Students>{

	@Override
	public int compare(Students m1, Students m2) {
		// TODO Auto-generated method stub
		if(m1.sum>m2.sum) {
			return -1;
		}else if(m1.sum == m2.sum) {
			return 0;
		}else {
			return 1;
		}
	}
	
	
}

//student 클래스 생성
class Students implements Comparable<Students>{
	String no;
	String name;
	int kok;
	int eng;
	int math;
	int sum;
	int rank;
	
	
	public Students(String no, String name, int kok, int eng, int math) {
		super();
		this.no = no;
		this.name = name;
		this.kok = kok;
		this.eng = eng;
		this.math = math;
		this.sum = kok + eng + math;
	}


	public String getNo() {
		return no;
	}


	public void setNo(String no) {
		this.no = no;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getKok() {
		return kok;
	}


	public void setKok(int kok) {
		this.kok = kok;
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


	public int getSum() {
		return sum;
	}


	public void setSum(int sum) {
		this.sum = sum;
	}


	public int getRank() {
		return rank;
	}


	public void setRank(int rank) {
		this.rank = rank;
	}


	@Override
	public int compareTo(Students student) {
		// TODO Auto-generated method stub
		return getNo().compareTo(student.getNo())*-1;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return no + " " + name+ " " +  kok + " " + eng + " " +  math + " " +  sum + " " + rank;
	}
}
