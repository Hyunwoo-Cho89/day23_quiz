package exam;

import java.util.Scanner;

public class MainClass {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Func func = new Func();
		//func.start();
		int num =0 ;
		
		while(true) {
			System.out.println("1.����ó");
			System.out.println("2.��ȭ");
			System.out.println("3.����");
			System.out.println("4.��������");
			System.out.println("5.����");
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
				System.out.println("�����մϴ�.");
				return;
			default :
				System.out.println("�߸� �����̽��ϴ�. �ٽ�.");
				break;
			}
		}
	}
}
