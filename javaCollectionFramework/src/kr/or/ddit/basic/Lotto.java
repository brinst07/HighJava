package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Lotto {
	
	public void buy() {
		System.out.println("금액을 입력해주세요");
		Scanner sc = new Scanner(System.in);
		int money = Integer.parseInt(sc.nextLine());
		int count = money/1000;
		int na = money%1000;
		List<Set> lottolist = new ArrayList<>();
		
		for(int i = 0; i<count; i++) {
		Set<Integer> lotto = new HashSet<>();
			while(lotto.size()<6) {
				lotto.add((int)(Math.random()*45)+1);
			}
			lottolist.add(lotto);
		}
		
		for(int i = 0; i<lottolist.size(); i++) {
			System.out.print("lotto ["+(i+1)+"] : ");
			System.out.println(lottolist.get(i));
		}
		System.out.printf("잔돈은" + na);
	}
	public static void main(String[] args) {
		Lotto l = new Lotto();
		l.buy();
}
}
