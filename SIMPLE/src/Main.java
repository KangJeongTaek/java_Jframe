import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
public class Main extends JFrame{

    // 정적 변수 선언
    private static Main instance;

    // 이름과 비밀 번호를 담을 배열 선언
    public Main(){
       
        instance = this;
        final int WIDTH = 600;
        final int HEIGHT = 300;
        setTitle("Simple Login");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        //패널 추가하고 디자인하기
        JPanel start = new JPanel(new GridBagLayout());
        start.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        start.setBackground(new Color(240, 240, 240));
        start.setLayout(null);

            
        // 로그인 버튼 구현
        JButton btn2 = new JButton("로그인");
        btn2.setBounds(WIDTH/2-35, HEIGHT/2-20, 90, 20);
        btn2.setBackground(new Color(70, 130, 180));
        btn2.setForeground(Color.WHITE);
        start.add(btn2);
        btn2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                setEnabled(false);
                new LogInFrame();
            }
        });
        // 회원가입 버튼 구현
        JButton btn3 = new JButton("회원 가입");
        btn3.setBounds(WIDTH/2-35,HEIGHT/2,90,20);
        btn3.setBackground(new Color(70, 130, 180));
        btn3.setForeground(Color.WHITE);
        start.add(btn3);
        btn3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setEnabled(false);
                new SignUpFrame();
            }
        });



        add(start);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void closeWindow() {
        this.dispose();
    }

    public static Main getInstance() {
        return instance;
    }

    public static void main(String[] args){
        
        
        //메인 화면 띄우기
        new Main();

       
    }
}