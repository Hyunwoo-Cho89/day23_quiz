package exam;

import java.util.Scanner;

public class MainClass {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Func func = new Func();
		//func.start();
		int num =0 ;
		
		while(true) {
			System.out.println("1.연락처");
			System.out.println("2.전화");
			System.out.println("3.문자");
			System.out.println("4.와이파이");
			System.out.println("5.종료");
			System.out.print(">>>>");
			num = sc.nextInt();
			switch(num) {
			case 1: func.list(); 
				break;
			case 2: func.call(); 
				break;
			case 3: func.text();
				break;
			case 4: func.wifi();
				break;
			case 5: 
				System.out.println("종료합니다.");
				return;
			default :
				System.out.println("잘못 누르셨습니다. 다시.");
				break;
			}
		}
	}
}
