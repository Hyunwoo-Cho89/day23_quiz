package exam;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class DBClass {
	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private String id = "mepuma";
	private String pwd = "1234";
	Connection con = null;
	PreparedStatement ps = null;
	
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
		String sql = "update quiz_member set name =?, num=?, addr=? where account_id =?";
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
	public void list() {}
	public void info() {}
}
