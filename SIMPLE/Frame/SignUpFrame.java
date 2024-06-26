package Frame;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRootPane;
import javax.swing.JTextField;

import Database.UsersDatabase;
import EXE.MainFrame;
public class SignUpFrame extends JFrame{
    public SignUpFrame(){
        

        //기본 설정
        setTitle("회원가입");
        setResizable(false);
        pack();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        Container c = getContentPane();
        c.setLayout(new FlowLayout());
        JRootPane rootPane = getRootPane();


        //아이디 입력 공간
        JPanel idPanel = new JPanel();
        idPanel.add(new JLabel( "  아이디  "));
		JTextField idText = new JTextField(11);
        idPanel.add(idText);
		

        //비밀번호 입력 공간
        JPanel pasPanel = new JPanel();
        pasPanel.add(new JLabel("비밀번호"));
        JPasswordField pasText = new JPasswordField(11);
        pasPanel.add(pasText);
        

        //확인 버튼
        JPanel loginPanel = new JPanel();
        JButton btn1 = new JButton("확인");
        loginPanel.add(btn1);

        btn1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                //데이터베이스 연결하기
                UsersDatabase udb = new UsersDatabase();
                udb.connect();
                String id = idText.getText();
                @SuppressWarnings("deprecation")
                String pas = pasText.getText();
                if(id.equals("") || pas.equals("")){
                    JOptionPane.showMessageDialog(null, "아이디와 비밀번호를 입력해주세요.");
                }
                else{
                    if(udb.signUp(id, pas)){
                        closeWindow();
                        JOptionPane.showMessageDialog(null, "회원 가입 성공!!", "확인", JOptionPane.INFORMATION_MESSAGE);
                    }else{
                        JOptionPane.showMessageDialog(null, "중복되는 아이디가 있습니다. 아이디를 바꿔 주세요.");
                    }
                    udb.databaseClose();
                }
                
            }
        });

        setSize( 240, 160);
        
        c.add(idPanel);
        c.add(pasPanel);
        c.add(loginPanel);
        rootPane.setDefaultButton(btn1);
        setLocationRelativeTo(null);
        setVisible(true);
        
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent we) {
                MainFrame.getInstance().setEnabled(true);
                
            }
        });
    }
    public void closeWindow() {
        this.dispose();
    }
}
