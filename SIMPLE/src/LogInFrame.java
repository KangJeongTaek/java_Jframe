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

public class LogInFrame extends JFrame{

    public LogInFrame(){
        setTitle("로그인");
        setResizable(false);
        pack();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        Container c = getContentPane();
        c.setLayout(new FlowLayout());


        
        //아이디 입력 공간
        JPanel idPanel = new JPanel();
        idPanel.add(new JLabel("   아이디  "));
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

            @Override
            public void actionPerformed(ActionEvent e) {
                String id = idText.getText();
                String pas = pasText.getText();
                if(id.equals("dfgddjd") && pas.equals("123")){
                    closeWindow();
                    Main.getInstance().closeWindow();
                    new SystemMain();
                }else{
                    System.out.println("로그인 실패");
                }
            }
        });



        
        setSize(240,160);
        c.add(idPanel);
        c.add(pasPanel);
        c.add(btn1);
        setLocationRelativeTo(null);
        setVisible(true);


    }

    public void closeWindow() {
        this.dispose();
    }
}