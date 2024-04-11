package Database;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Frame.LogInFrame;


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

    public int get_remain_minutes(){
        int minutes = 0;
        String selectStr = "Select TIME_RE FROM USERS WHERE ID = + " + "'"+ LogInFrame.id + "'";
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
    public boolean logincheck(String i, String p){
        boolean b = false;
        String id = i;
        String pas = p;
        try {
			String checkingStr = "SELECT PASSWORD FROM USERS WHERE ID='" + id + "'";
			ResultSet result = stmt.executeQuery(checkingStr);
			while(result.next()) {
				if(pas.equals(result.getString("PASSWORD"))) {
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
            ResultSet result = stmt.executeQuery(checkingStr);
            if(result.next() == false){
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

    public void addTime(int m){
        int minute = m;
        try{
            String selectStr = "Select TIME_RE FROM USERS WHERE ID = + " + "'"+ LogInFrame.id + "'";
            ResultSet rs = stmt.executeQuery(selectStr);
            if(rs.next() != false){
                int time_re = rs.getInt("TIME_RE");
                String updateStr = "UPDATE USERS SET TIME_RE = " + (minute + time_re) + "WHERE ID = " + "'" + LogInFrame.id + "'";
                pstmt = con.prepareStatement(updateStr);
                pstmt.executeUpdate();
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    public void updateTime(int m){
        try{
            String selectStr = "Select TIME_RE FROM USERS WHERE ID = + " + "'"+ LogInFrame.id + "'";
            ResultSet rs = stmt.executeQuery(selectStr);
            if(rs.next() != false){
                String updateStr = "UPDATE USERS SET TIME_RE = " + m + "WHERE ID = " + "'" + LogInFrame.id + "'";
                pstmt = con.prepareStatement(updateStr);
                pstmt.executeUpdate();
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
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