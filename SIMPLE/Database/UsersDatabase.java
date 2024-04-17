package Database;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class UsersDatabase {
    Statement stmt =  null;
    Connection con = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    //DB 로그인 확인하기

    public void connect(){
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

    public int get_remain_minutes(String id){
        int minutes = 0;
        String selectStr = "Select TIME_RE FROM USERS WHERE ID = + " + "'"+ id + "'";
        try {
            rs = stmt.executeQuery(selectStr);
            if(rs.next()){
            minutes = rs.getInt("TIME_RE");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return minutes;
    }

    public boolean logincheck(String id, String pas){
        boolean b = false;
        try {
			String checkingStr = "SELECT PASSWORD FROM USERS WHERE ID='" + id + "'";
			rs = stmt.executeQuery(checkingStr);
			if(rs.next()) {
				if(pas.equals(rs.getString("PASSWORD"))) {
					b = true;
					System.out.println("로그인 성공");
				}
				else {
					b = false;
					System.out.println("로그인 실패");
				}
			}
		} catch(Exception e) {
			b = false;
			System.out.println("로그인 실패 > " + e.toString());
		}
        return b;
    }

    public boolean signUp(String i, String p){
        String id = i;
        String pas = p;
        boolean c = false;
        String updateStr = "INSERT INTO USERS VALUES (" + "'" + id + "'" + "," + "'" + pas + "'" + "," + 0 + ")";
        try {
            String checkingStr = "SELECT * FROM USERS WHERE ID='" + id + "'";
            rs = stmt.executeQuery(checkingStr);
            if(rs.next() == false){
                pstmt = con.prepareStatement(updateStr);
                pstmt.executeUpdate();
                c = true;
            }else{
                c = false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
            return c;
    }

    public void addTime(String id , int m){
        int minute = m;
        try{
            String selectStr = "SELECT TIME_RE FROM USERS WHERE ID = + " + "'"+ id + "'";
            rs = stmt.executeQuery(selectStr);
            if(rs.next() != false){
                int time_re = rs.getInt("TIME_RE");
                String updateStr = "UPDATE USERS SET TIME_RE = " + (minute + time_re) + "WHERE ID = " + "'" + id + "'";
                pstmt = con.prepareStatement(updateStr);
                pstmt.executeUpdate();
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    public void updateTime(String id, int m){
        try{
            String selectStr = "SELECT TIME_RE FROM USERS WHERE ID = + " + "'"+ id + "'";
            rs = stmt.executeQuery(selectStr);
            if(rs.next() != false){
                String updateStr = "UPDATE USERS SET TIME_RE = " + m + "WHERE ID = " + "'" + id + "'";
                pstmt = con.prepareStatement(updateStr);
                pstmt.executeUpdate();
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    public String findpas(String id){
        String passWord = "";
        try{
            String selectStr = "SELECT PASSWORD FROM USERS WHERE ID = "+ "'" + id + "'";
            rs = stmt.executeQuery(selectStr);
            if(rs.next() != false){
                passWord = rs.getString("PASSWORD");
                return "비밀번호는 " + passWord + "입니다.";
            }else{
                passWord = "해당하는 아이디가 없습니다.";
                
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return passWord;
    }

    public void databaseClose(){
        if(stmt!=null){
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(pstmt!=null){
            try {
                pstmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(rs!=null){
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(con != null){
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        System.out.println("연결 해제");
    }
}