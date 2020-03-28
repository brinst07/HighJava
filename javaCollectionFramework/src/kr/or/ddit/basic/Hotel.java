package kr.or.ddit.basic;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Hotel {

	private Scanner sc;
	private Map<String, String> hotel;

	public Hotel() {
		sc = new Scanner(System.in);
		hotel = new HashMap<>();
	}

	public static void main(String[] args) {

		Hotel h = new Hotel();
		while (true) {
			System.out.println("************************************");
			System.out.println("호텔문을 열었습니다.");
			System.out.println("************************************");
			System.out.println();
			System.out.println("************************************");
			System.out.println("어떤 업무를 하시겠습니까?");
			System.out.println("1.체크인 \t 2.체크아웃 \t 3.객실상태 \t 4.업무종료");
			Scanner sc = new Scanner(System.in);
			int cho = Integer.parseInt(sc.nextLine());

			switch (cho) {
			case 1:
				h.checkIn();
				break;
			case 2:
				h.checkOut();
				break;
			case 3:
				h.check();
				break;
			case 4:
				System.exit(0);
			}
		}
	}

	private void checkRoom() {
		if (hotel.size() == 0) {
			System.out.println("예약된 방이 없습니다.");
			return;
		}
		Set<Map.Entry<String, String>> mapSet = hotel.entrySet();

		Iterator<Map.Entry<String, String>> entryIt = mapSet.iterator();

		while (entryIt.hasNext()) {
			Map.Entry<String, String> entry = entryIt.next();

			System.out.println(entry.getKey() + "     " + entry.getValue());
		}

	}

	public void check() {
		Set<String> key = hotel.keySet();
		Iterator it = key.iterator();
		while (it.hasNext()) {
			String key1 = (String) it.next();
			System.out.println(key1 + "  " + hotel.get(key1));
		}
	}

	private void checkOut() {
		System.out.println("방번호를 입력해주세요");
		String room = sc.nextLine();
		if (hotel.get(room) == null) {
			System.out.println("예약되지 않은 방번호 입니다.");
			return;
		}
		hotel.remove(room);
	}

	private void checkIn() {
		System.out.println("방번호를 입력해주세요");
		String room = sc.nextLine();
		if (hotel.get(room) != null) {
			System.out.println("이미 예약된 방입니다.");
			return;
		}
		System.out.println("이름을 입력해주세요");
		String name = sc.nextLine();
		hotel.put(room, name);

	}

}
