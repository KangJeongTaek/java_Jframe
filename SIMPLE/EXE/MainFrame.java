package EXE;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import Database.UsersDatabase;
import Frame.FindFrame;
import Frame.LoginAfterFrame;
import Frame.SignUpFrame;
public class MainFrame extends JFrame{
    private String id;
    private String pas;
    // 정적 변수 선언
    private static MainFrame instance;
    private JButton btn2;
    UsersDatabase udb;
    
    public MainFrame(){
        instance = this;
        final int WIDTH = 600;
        final int HEIGHT = 300;
        setTitle("환영합니다");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        //패널 추가하고 디자인하기
        JPanel start = new JPanel();
        start.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        start.setBackground(new Color(255, 240, 240));
        start.setLayout(null);


        //로고 이미지 추가
        ImageIcon logoIcon = new ImageIcon("./SIMPLE/image/logo.png");
        Image sclaedLogo = logoIcon.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        JLabel logoLabel = new JLabel(new ImageIcon(sclaedLogo));
        logoLabel.setBounds(WIDTH/2-100,HEIGHT/2-100,200,100);
        start.add(logoLabel);
            


        //아이디 입력 공간
        JLabel idLabel = new JLabel("아이디");
        idLabel.setBounds(WIDTH/2 - 200,HEIGHT-95,40,20);
        start.add(idLabel);
        JTextField idText = new JTextField(30);
        idText.setBounds(WIDTH/2 - 150,HEIGHT-95,100,20);
        idText.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btn2.doClick();
            }
        });
        start.add(idText);
        

        //비밀 번호 입력 공간
        JLabel pasLabel = new JLabel("비밀번호");
        pasLabel.setBounds(WIDTH/2 - 200, HEIGHT-55,100,20);
        start.add(pasLabel);
        JPasswordField pasText = new JPasswordField(30);
        pasText.setEchoChar('*');
        pasText.setBounds(WIDTH/2 - 150, HEIGHT-55,100,20);
        pasText.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                btn2.doClick();
            }
        });
        start.add(pasText);

        // 로그인 버튼 구현
        btn2 = new JButton("로그인");
        btn2.setBounds(WIDTH/2-40, HEIGHT-100, 80, 80);
        btn2.setBackground(new Color(60,130,230));
        btn2.setForeground(Color.WHITE);
        btn2.setBorderPainted(false);
        start.add(btn2);
        btn2.setDefaultCapable(true);
        btn2.addActionListener(new ActionListener() {
            @SuppressWarnings("deprecation")
            @Override
            public void actionPerformed(ActionEvent e) {
                id = idText.getText();
                pas = pasText.getText();
                if(id.equals("")||pas.equals("")){
                    JOptionPane.showMessageDialog(null, "아이디와 비밀번호를 입력해주세요.");
                }else{
                    UsersDatabase udb = new UsersDatabase();
                    udb.connect();
                    if(udb.logincheck(id,pas)){
                        udb.databaseClose();
                        dispose();
                        new LoginAfterFrame();
                    }else{
                        JOptionPane.showMessageDialog(null, "해당하는 정보가 없습니다. 아이디/ 비밀번호를 확인해주세요.");
                    }
                
            }
            }
        });
        
        // 회원가입 버튼 구현
        JButton btn3 = new JButton("회원가입");
        btn3.setFont(new Font("나눔고딕",0,10));
        btn3.setBounds(WIDTH/2+45,HEIGHT-100,80,35);
        btn3.setBackground(new Color(70, 130, 180));
        btn3.setForeground(Color.WHITE);
        btn3.setBorderPainted(false);
        start.add(btn3);
        btn3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new SignUpFrame();
            }
        });

        //비밀번호 찾기 버튼
        JButton btn4 = new JButton("정보 찾기");
        btn4.setFont(new Font("나눔고딕",0,10));
        btn4.setBounds(WIDTH/2+45,HEIGHT-55,80,35);
        btn4.setBackground(new Color(70, 130, 180));
        btn4.setForeground(Color.WHITE);
        btn4.setBorderPainted(false);
        start.add(btn4);
        btn4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new FindFrame();
            }
        });


        add(start);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static MainFrame getInstance() {
        if (instance == null) {
            instance = new MainFrame();
        }
        return instance;
    }
    public String getId(){
        return id;
    }
    
    public static void main(String[] args){
        //메인 화면 띄우기
    new MainFrame();
    
    }
    

    
}