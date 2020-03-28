package kr.or.ddit.basic;

import java.util.HashSet;
import java.util.Set;

public class HashSetEx1 {
	public static void main(String[] args) {
		Object[] objArr = {"1",new Integer(1),"2","3","3","1","2"};
		Set set = new HashSet();
		for(int i = 0; i<objArr.length; i++) {
			set.add(objArr[i]);
		}
		
		System.out.println(set);
	}
}
