package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class T04_ArrayListTest {
	/*
		문제1) 5명의 별명을 입력하여 ArrayList에 저장하고 별명의 길이가 제일 긴 별명을 출력하세요
	*/
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		List<String> member = new ArrayList<>();
		for(int i = 0; i<5; i++) {
			System.out.println("별명을 입력해주세요");
			member.add(sc.nextLine());
		}
		
		int temp = 0;
		int temp1 = 0;
		/*
		 * for(int i = 0; i<member.size(); i++) { if(temp < member.get(i).length()) {
		 * temp = member.get(i).length(); temp1 = i; }
		 * 
		 * } System.out.println(member.get(temp1));
		 */
		
	
	
	
	/*
		문제 2) 문제 1에서 별명의 길이가 같은 것을 여러개 입력했을 때에도 처리되도록 하시오
	*/
		
		for(int i = 0; i<member.size(); i++) {
			if(temp < member.get(i).length()) {
				temp = member.get(i).length();
			}
		}
		
		for(int i = 0; i<member.size(); i++) {
			if(member.get(i).length() == temp) {
				System.out.println(member.get(i));
			}
		}
		
		
	}
	
}

