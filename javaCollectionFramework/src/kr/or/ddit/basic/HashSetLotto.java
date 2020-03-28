package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class HashSetLotto {
	public static void main(String[] args) {
		Set<Integer> set = new HashSet();
		
		for(int i = 0; set.size()<6; i++) {
			set.add((int)(Math.random()*45)+1);
		}
		//collections.sort 기능을 사용하기 위해서 list로 바꿔주었다.
		List list = new ArrayList(set);
		Collections.sort(list);
		for(int i = 0; i<list.size(); i++) {
			System.out.println(list.get(i));
		}
		
	}
}
