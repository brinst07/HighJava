package kr.or.ddit.basic;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

public class Bingo {
	public static void main(String[] args) {
		Set set = new LinkedHashSet();
		//hashset으로 하면 저장된 순서를 보장하지 않고 정렬된 결과가 나오므로
		//이런때는 LinkedHashSet이 더 좋은 선택이다.
		int[][] board = new int[5][5];
		
		for(int i = 0; set.size()<25; i++) {
			set.add((int)(Math.random()*50)+1);
		}
		
		Iterator it = set.iterator();
		
		System.out.println(set);
		for(int i = 0; i<board.length; i++) {
			for(int j = 0; j<board[0].length; j++) {
				board[i][j] = (int) it.next();
				System.out.print((board[i][j] < 10 ? "  " : " ") + board[i][j]);
				if(j==board[0].length-1) {
					System.out.println();
				}
			}
		}
		
		
	}
}
