import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
public class Main extends JFrame{
    // 정적 변수 선언
    private static Main instance;

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

        JButton btn1 = new JButton("종료");
        btn1.setBounds(WIDTH - 80, HEIGHT-30, 70,20);
        start.add(btn1);
        btn1.addActionListener(new ActionListener() {
            
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

            
        // 로그인 버튼 구현
        JButton btn2 = new JButton("로그인");
        btn2.setBounds(WIDTH/2-35, HEIGHT/2-20, 90, 20);
        btn2.setBackground(new Color(70, 130, 180));
        btn2.setForeground(Color.WHITE);
        start.add(btn2);
        btn2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
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
        new Main();
    }
}
