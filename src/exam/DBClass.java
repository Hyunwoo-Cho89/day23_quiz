package exam;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;


public class DBClass {
	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private String id = "mepuma";
	private String pwd = "1234";
	Connection con = null;
	PreparedStatement ps = null;
	MemberDTO dto;
	
	public DBClass() {
		try {
			//오라클 관련된 기능을 사용하기 위해 제일 처음에 처리
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	public int insert(MemberDTO dto) {
		String sql = "insert into phone_list account_id, name, num, addr values(?,?,?,?)";
		int result = 0;
		try {
			con = DriverManager.getConnection(url, id, pwd);
			ps = con.prepareStatement(sql);
			ps.setString(1, dto.getAccount_id());
			ps.setString(2, dto.getName());
			ps.setString(3, dto.getNum());
			ps.setString(4, dto.getAddr());
			result = ps.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(con != null) con.close();
				if(ps != null) ps.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}return result;
	}
	public int modify(MemberDTO dto) {
		String sql = "update phone_list set name =?, num=?, addr=? where account_id =?";
		int result = 0;
		try {
			con = DriverManager.getConnection(url, id, pwd);
			ps = con.prepareStatement(sql);
			ps.setString(1, dto.getName());
			ps.setString(2, dto.getName());
			ps.setString(3, dto.getAddr());
			ps.setString(4, dto.getAccount_id());
			result = ps.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(con != null) con.close();
				if(ps != null) ps.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return result;
		
	}
	public ArrayList<MemberDTO> list() {
		String sql = "select * from phone_list";
		ArrayList<MemberDTO> list = new ArrayList<MemberDTO>();
		try {
			con = DriverManager.getConnection(url, id, pwd);
			ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				MemberDTO dto = new MemberDTO();
				dto.setAccount_id(rs.getString("account_id"));
				dto.setName(rs.getString("name"));
				dto.setNum(rs.getString("num"));
				dto.setAddr(rs.getString("addr"));
				list.add(dto);
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(con != null) con.close();
				if(ps != null) ps.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return list;
		
	}
	
	public MemberDTO info(String infoId) {
		String sql = "select * from phone_list where account_id = ?";
		try {
			con = DriverManager.getConnection(url, id, pwd);
			ps = con.prepareStatement(sql);
			ps.setString(1, infoId);
			
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				dto = new MemberDTO();
				dto.setAccount_id("account_id");
				dto.setName("name");
				dto.setNum("Num");
				dto.setAddr("addr");
			}else System.out.println("찾으시는 연락처가 없습니다.");
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(con != null) con.close();
				if(ps != null) ps.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return dto;
		
	}
	public int delete(String delId) {
		String sql = "delete from account_id = ?";
		int result = 0;
		try {
			con = DriverManager.getConnection(url, id, pwd);
			ps = con.prepareStatement(sql);
			ps.setString(1, delId);
			result = ps.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			try {
				if(con != null) con.close();
				if(ps != null) ps.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
			
			
		}return result;
		
	}
	public MemberDTO numSerch(String serchId) {
		String sql = "select num from phone_list where accont_id  = ?";
		int result =0;
		try {
			con = DriverManager.getConnection(url, id, pwd);
			ps = con.prepareStatement(sql);
			ps.setString(1, serchId);
			result = ps.executeUpdate();
			if(result ==1) {
				dto = new MemberDTO();
				dto.setNum("num");
			}else System.out.println("연락처가 존재하지 안습니다.");
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(con != null) con.close();
				if(ps != null) ps.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
			
		
		}return dto;
	}
}
