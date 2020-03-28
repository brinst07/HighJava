package kr.or.ddit.basic;
/*
	제너릭 클래스를 만드는 방법
	형식)
	class 클래스명<제너릭타입글자>{
		제너릭타입글자 변수명; //변수선언에 제너릭을 사용할 경우 
		...
		제너릭타입글자 메서드명(){ //반환값이 있는 메서드에서 사용
			...
			return값;
		}
		...
	}
	-- 제너릭 타입글자 --
	T => Type
	K => Key
	V => Value
	E => Element(자료구조에 들어가는 것들을 나타날때 사용)
*/

// 타입이 object 받을때는 편하지만 객체.메소드를 사용할때 object안에서 구현되어 있는 메소드만 사용이 가능하다.
class NonGenericClass {
	private Object val;

	public Object getVal() {
		return val;
	}
	
	public void setVal(Object val) {
		this.val = val;
	}
}

class MyGeneric<T>{
	private T val;

	public T getVal() {
		return val;
	}

	public void setVal(T val) {
		this.val = val;
	}
	
}

public class T03_GenericTest {
	public static void main(String[] args) {
		NonGenericClass ng1 = new NonGenericClass();
		ng1.setVal("가나다라");
		
		NonGenericClass ng2 = new NonGenericClass();
		ng2.setVal(100);

		//object타입이기 때문에 casting이 필요함
	String rtnNg1 = (String)ng1.getVal();
		System.out.println("문자열 반환값 rtnNg1 => " + rtnNg1);
		
		Integer irtnNg2 = (Integer)ng2.getVal();
		System.out.println("정수 반환값 irtnNg2 => " +irtnNg2);
		
		MyGeneric<String> mg1 = new MyGeneric<>();
		MyGeneric<Integer> mg2 = new MyGeneric<>();
		
		mg1.setVal("우리나라");
		mg2.setVal(500);
		
		rtnNg1 = mg1.getVal();
		irtnNg2 = mg2.getVal();
		
		System.out.println("제너릭 문자열 반환값 : " + rtnNg1);
		System.out.println("제너릭 정수형 반환값 : " + irtnNg2);
		
	}
}
