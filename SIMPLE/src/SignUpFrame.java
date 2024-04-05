import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
public class SignUpFrame extends JFrame{
    public SignUpFrame(){
        new JFrame("회원가입");
        setResizable(false);
        pack();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        Container c = getContentPane();
        c.setLayout(new FlowLayout());


        //아이디 입력 공간
        JPanel idPanel = new JPanel();
        idPanel.add(new JLabel("아이디 "));
		JTextField idText = new JTextField(9);
        idPanel.add(idText);
		

        //비밀번호 입력 공간
        JPanel pasPanel = new JPanel();
        pasPanel.add(new JLabel("비밀번호"));
        JPasswordField pasText = new JPasswordField(9);
        pasPanel.add(pasText);
        

        //확인 버튼
        JPanel loginPanel = new JPanel();
        JButton btn1 = new JButton("확인");
        loginPanel.add(btn1);

        btn1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                String id = idText.getText();
                String pas = pasText.getText();
                System.out.println(id);
                System.out.println(pas);


                // 확인 버튼 누르고 끄기
                JFrame confirm = new JFrame();
                confirm.setSize(200,150);
                confirm.setLocationRelativeTo(null);
                setFocusableWindowState(false);
                JButton con = new JButton("회원가입 완료!!");
                confirm.add(con);
                con.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e){
                        confirm.dispose();
                        dispose();
                    }
                });
                confirm.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                confirm.setVisible(true);
            }
        });

        setSize( 250, 200);
        
        c.add(idPanel);
        c.add(pasPanel);
        c.add(loginPanel);
        setVisible(true);

    }
}
