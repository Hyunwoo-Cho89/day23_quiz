package exam;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

import javax.swing.*;

public class Func {
	Scanner sc;
	DBClass db;
	int cnt = 0;
	public Func() {
		db = new DBClass();
		sc = new Scanner(System.in);
	}	
	public void list() {
		int num = 0 ;
		while(true) {
			System.out.println("1.����ó ���");
			System.out.println("2.����ó ����");
			System.out.println("3.����ó ����");
			System.out.println("4.����ó �˻�");
			System.out.println("5.��ü ����ó ����");
			System.out.print(">>>>");
			num = sc.nextInt();
			
			switch(num) {
			case 1:
				MemberDTO dto = new MemberDTO();
				System.out.print("����� ���̵� �Է� : "); dto.setAccount_id(sc.next());
				System.out.print("����� �̸� �Է� : "); dto.setName(sc.next());
				System.out.print("����� ��ȭ��ȣ �Է� : "); dto.setNum(sc.next());
				System.out.print("����� �ּ� �Է� : "); dto.setAddr(sc.next());
				int result = db.insert(dto);
				if(result == 1) {
					System.out.println("����� �Ϸ� �Ǿ����ϴ�.");
				}else System.out.println("��� �� �� �����ϴ�.");
				break;
			case 2:
				dto = new MemberDTO();
				System.out.print("������ ���̵� �Է� : "); dto.setAccount_id(sc.next());
				System.out.print("������ �̸� �Է� : "); dto.setName(sc.next());
				System.out.print("������ ��ȭ��ȣ �Է� : "); dto.setNum(sc.next());
				System.out.print("������ �ּ� �Է� : "); dto.setAddr(sc.next());
				result = db.modify(dto);
				
				break;
			case 3:
				break;
			case 4:
				break;
			case 5:
				System.out.println("�����մϴ�.");
				return;
			default : 
				break;
			}
			
		}
		
		
	}
	public void call() {
		
	}
	public void text() {
		
	}
	public void wifi() {
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		String wifiName;
		int wifiPwd;
		if(cnt == 0) {
			map.put("aaa", 1);
			map.put("bbb", 2);
			map.put("ccc", 3);
			cnt++;
		}
		
		while(true) {
			System.out.println("1.�������� �˻�");
			System.out.println("2.�������� ����");
			System.out.println("3.����");
			int num = sc.nextInt();
			switch(num) {
			case 1:
				System.out.println("===�������� ���===");
				Iterator it = map.keySet().iterator();
				for(int i=1;it.hasNext();i++) {
					System.out.println(i+". "+it.next());
				}
				break;
			case 2: 
				System.out.print("������ �������� �Է� : ");
				wifiName = sc.next();
				if(map.containsKey(wifiName)) {
					System.out.print("��й�ȣ�� �Է��ϼ��� : ");
					wifiPwd = sc.nextInt();
					if(map.get(wifiName) == wifiPwd) {
						System.out.println("�������̿� ����Ǿ����ϴ�.");
					}else System.out.println("��й�ȣ�� �߸� �Է��ϼ̽��ϴ�.");
				}else {
					System.out.println("ã���ô� �������̰� �����ϴ�.");
				}
				break;
			case 3:
				System.out.println("�����մϴ�.");
				return;
			}
		}
		
	}
}