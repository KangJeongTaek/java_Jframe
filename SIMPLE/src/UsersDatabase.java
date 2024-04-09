import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class UsersDatabase {
    Statement stmt =  null;
    Connection con = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    //DB 로그인 확인하기
    UsersDatabase(){
        
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            System.out.println("JDBC Driver 로드 성공!!");
            String url = "jdbc:oracle:thin:@localhost:1521:xe";
            String user = "ADAM";
            String pw = "1234";
            con = DriverManager.getConnection(url,user,pw);
            stmt = con.createStatement();
            System.out.println("연결 성공");
        }catch(ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    boolean logincheck(String i, String p){
        boolean b = false;
        String id = i;
        String pas = p;
        try {
			String checkingStr = "SELECT password FROM member WHERE id='" + id + "'";
			ResultSet result = stmt.executeQuery(checkingStr);
			int count = 0;
			while(result.next()) {
				if(pas.equals(result.getString("password"))) {
					b = true;
					System.out.println("로그인 성공");
				}
				
				else {
					b = false;
					System.out.println("로그인 실패");
				}
				count++;
			}
		} catch(Exception e) {
			b = false;
			System.out.println("로그인 실패 > " + e.toString());
		}
        return b;
    }
}