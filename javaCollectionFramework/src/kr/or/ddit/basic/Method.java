package kr.or.ddit.basic;

import java.util.ListIterator;
import java.util.Vector;

public class Method {
	public static void main(String[] args) {
		Vector<String> vector = new Vector();
		System.out.println("add method");
		vector.add(0, "a");
		
		
		vector.add("c");
		vector.add(1, "b");
		
		for(int i = 0; i<vector.size(); i++) {
			System.out.println(i + " : " + vector.get(i));
		}
		
		System.out.println("-------------- addall method ----------------");
		Vector<String> vector1 = new Vector();
		vector1.add("2");
		vector1.add("2");
		vector1.addAll(1, vector);
		
		for(int i = 0; i<vector1.size(); i++) {
			System.out.println(i + " : " + vector1.get(i));
		}
		
		System.out.println("------------- get(index) -------------");
		System.out.println(vector1.get(2));
		
		//하나를 찾으면 더이상 찾지 않는다. 따라서 indexof는 0번지를 last~는 4번지를 반환
		System.out.println("------------- indexOf(object) ---------");
		System.out.println(vector1.indexOf("2"));
		System.out.println("------------- lastindexof(object) ------------");
		System.out.println(vector1.lastIndexOf("2"));
		
		System.out.println("-------------- remove -----------------");
		String temp = vector1.remove(1);
		System.out.println(temp);
		for(int i = 0; i<vector1.size(); i++) {
			System.out.println(i + " : " + vector1.get(i));
		}
		
		System.out.println("-------------- listIterator -----------------");
		System.out.println(vector1.listIterator().nextIndex());
	
		System.out.println("---------- subList ----------------");
		System.out.println(vector1.subList(1, 4));
	}
}
