package exam;

import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;


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
			System.out.println("1.연락처 등록");
			System.out.println("2.연락처 변경");
			System.out.println("3.연락처 삭제");
			System.out.println("4.연락처 검색");
			System.out.println("5.전체 연락처 보기");
			System.out.println("6.종료");
			System.out.print(">>>>");
			num = sc.nextInt();
			
			switch(num) {
			case 1:
				MemberDTO dto = new MemberDTO();
				System.out.print("등록할 아이디 입력 : "); dto.setAccount_id(sc.next());
				System.out.print("등록할 이름 입력 : "); dto.setName(sc.next());
				System.out.print("등록할 전화번호 입력 : "); dto.setNum(sc.next());
				System.out.print("등록할 주소 입력 : "); dto.setAddr(sc.next());
				int result = db.insert(dto);
				if(result == 1) {
					System.out.println("등록이 완료 되었습니다.");
				}else System.out.println("등록 할 수 없습니다.");
				break;
			case 2:
				dto = new MemberDTO();
				System.out.print("변경할 아이디 입력 : "); dto.setAccount_id(sc.next());
				System.out.print("변경할 이름 입력 : "); dto.setName(sc.next());
				System.out.print("변경할 전화번호 입력 : "); dto.setNum(sc.next());
				System.out.print("변경할 주소 입력 : "); dto.setAddr(sc.next());
				result = db.modify(dto);
				if(result == 1) {
					System.out.println("수정이 완료 되었습니다.");
				}else System.out.println("수정 할 수 없습니다.");
				break;
			case 3:
				System.out.println("삭제할 아이디 입력 : ");
				result = db.delete(sc.next());
				if(result==1) {
					System.out.println("삭제 완료");
				}else{
					System.out.println("삭제할 수 없습니다.");
				}
				break;
			case 4:
				System.out.print("검색할 아이디 입력 : ");
				dto =db.info(sc.next());
				System.out.println("아아디 : "+dto.getAccount_id());
				System.out.println("이름 : "+dto.getName());
				System.out.println("번호 : "+dto.getNum());
				System.out.println("주소 : "+dto.getAddr());
				break;
			case 5:
				ArrayList<MemberDTO> list = db.list();
				if(list.size() == 0) {
					System.out.println("저장되어 있는 데이터가 없습니다.");
				}else {
					System.out.println("==========================");
					System.out.println("id\t이름\t전화번호\t주소");
					System.out.println("==========================");
					for(int i=0;i<list.size();i++) {
						
						System.out.print(list.get(i).getAccount_id()+"\t");
						System.out.print(list.get(i).getName()+"\t");
						System.out.print(list.get(i).getNum()+"\t");
						System.out.println(list.get(i).getAddr());
						System.out.println("--------------------------");
					}
				}
				break;
			case 6:
				System.out.println("종료합니다.");
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
			System.out.println("1.와이파이 검색");
			System.out.println("2.와이파이 연결");
			System.out.println("3.종료");
			int num = sc.nextInt();
			switch(num) {
			case 1:
				System.out.println("===와이파이 목록===");
				Iterator it = map.keySet().iterator();
				for(int i=1;it.hasNext();i++) {
					System.out.println(i+". "+it.next());
				}
				break;
			case 2: 
				System.out.print("연결할 와이파이 입력 : ");
				wifiName = sc.next();
				if(map.containsKey(wifiName)) {
					System.out.print("비밀번호를 입력하세요 : ");
					wifiPwd = sc.nextInt();
					if(map.get(wifiName) == wifiPwd) {
						System.out.println("와이파이에 연결되었습니다.");
					}else System.out.println("비밀번호를 잘못 입력하셨습니다.");
				}else {
					System.out.println("찾으시는 와이파이가 없습니다.");
				}
				break;
			case 3:
				System.out.println("종료합니다.");
				return;
			}
		}
		
	}
}
