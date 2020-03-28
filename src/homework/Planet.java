package homework;

import java.util.Scanner;

            public class Planet {
                public enum Planets {
                    수성(2439), 금성(6052), 지구(6371), 성(3390), 목성(69911), 토성(58232), 천왕성(25362), 해왕성(24622);
                    private int r;

                    private Planets(int r) {
                        this.r = r;
                    }

                    public void area() {
                        System.out.println((double) r * r * 3.14);
                    }

                }

                public static void main(String[] args) {

                    Scanner sc = new Scanner(System.in);


                    while (true) {
                        System.out.println("행성의 이름을 입력해주세요");
                        String temp = sc.nextLine();
                        Planets p = Planets.valueOf(temp);
            p.area();

        }
    }
}
