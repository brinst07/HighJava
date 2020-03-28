package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class T03_ArrayListTest {
	/*
	 * 문제) 5명의 사람이름을 입력하여 ArrayList에 저장하고 이중에 '김'씨 성의 이름을 출력하시오		
	*/
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		List<String> member = new ArrayList<>();
		for(int i = 0; i<5; i++) {
			System.out.println("사람이름을 입력해주세요");
			member.add(sc.nextLine());
		}
		
		for(int i = 0; i<member.size(); i++) {
			if('김'==member.get(i).charAt(0)) {
				System.out.println(member.get(i));
			}
		}
		
		for(int i = 0; i<member.size(); i++) {
			if(member.get(i).indexOf("김")==0) {
				System.out.println(member.get(i));
			}
		}
		
		//startwith("김")도 가능
	}
	
	}
