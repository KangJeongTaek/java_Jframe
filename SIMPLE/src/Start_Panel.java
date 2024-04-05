import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.plaf.DimensionUIResource;

public class Start_Panel extends JPanel{
    public static final int WIDTH = 600;
    public static final int HEIGHT = 300;
    public boolean signUpClick;
    public Start_Panel(){
        this.setPreferredSize(new DimensionUIResource(WIDTH, HEIGHT));
        this.setBackground(Color.WHITE);
        this.setLayout(null);



        // 종료 버튼 생성
        JButton btn1 = new JButton("종료");
        btn1.setBounds(WIDTH - 80, HEIGHT-30, 70,20);
        this.add(btn1);
        btn1.addActionListener(new ActionListener() {
            
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        // 로그인 버튼 구현
        JButton btn2 = new JButton("로그인");
        btn2.setBounds(WIDTH/2-35, HEIGHT/2-20, 90, 20);
        this.add(btn2);
        

        // 회원가입 버튼 구현
        JButton btn3 = new JButton("회원 가입");
        btn3.setBounds(WIDTH/2-35,HEIGHT/2,90,20);
        this.add(btn3);
        btn3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("회원가입");
                signUpClick = true;
                new SignUpFrame();
            }
        });
    }
}
