package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class T11_BaseBallTest {
	/*
		문제) Set을 이용하여 숫자 야구 게임 프로그램을 작성하시오.
			  컴퓨터의 숫자는 난수를 이용하여 구한다.
			  (스트라이크는 'S', 볼은 'B'로 출력한다.)
			  
			  컴퓨터의 난수가 9 5 7 일 떄 실행 예시)
			  		숫자 입력 => 3 5 6
			  		3 5 6	  => 1S 0B
		
	*/
	//난수를 반환하는 메소드
	public List<Integer> nan() {
		Set<Integer> set = new HashSet<>();
		while(set.size()<3) {
			set.add((int)(Math.random()*9)+1);
		}
		List<Integer> list = new ArrayList<>();
		Iterator<Integer> it = set.iterator();
		while(it.hasNext()) {
			list.add(it.next());
		}
		//데이터 섞기
		Collections.shuffle(list);
		return list;
		
	}
	
	//입력받은 숫자를 비교하는 메소드
	public void vs(List<Integer> list) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println(list.get(1));
		int strike = 0;
		int ball;
		int count = 0;
		int[] b = new int[3];
		
		while(strike != 3) {
			
			System.out.println("세자리 숫자를 입력해주세요");
			int temp = Integer.parseInt(sc.nextLine());
			for(int i = b.length-1; i>=0; i--) {
				b[i] = temp%10;
				temp /= 10;
			}
			System.out.println(Arrays.toString(b));
			strike = 0;
			ball = 0;

				for(int i = 0; i<list.size(); i++) {
					for(int j = 0; j<list.size(); j ++) {
						if(b[i]==list.get(j)) {
							if(i==j) {
								strike ++;
							}else {
								ball ++;
							}
						}
						
						
					}
				}
				
				System.out.println(strike);
				System.out.println(ball);
				System.out.println(3-(strike+ball));
				count ++;
		}
			System.out.println("3strike");
			System.out.println(count);
		}
	
	public static void main(String[] args) {
		T11_BaseBallTest a = new T11_BaseBallTest();
		
		List<Integer> list = a.nan();
		System.out.println(list);
		a.vs(list);
	
	}
	
}
