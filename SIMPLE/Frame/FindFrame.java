package Frame;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Database.UsersDatabase;

public class FindFrame extends JFrame{
    public FindFrame(){
    
    
    //기본 설정
        setTitle("찾기");
        setResizable(false);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setSize(new Dimension(240,160));
        Container c = getContentPane();
        c.setLayout(new FlowLayout());

        


        
        //아이디 입력 공간
        JPanel idPanel = new JPanel();
        idPanel.add(new JLabel("   아이디  "));
		JTextField idText = new JTextField(11);
        idPanel.add(idText);
        c.add(idPanel);
         //확인 버튼
        JPanel loginPanel = new JPanel();
        JButton btn1 = new JButton("찾기");
        loginPanel.add(btn1);
        c.add(btn1);
        btn1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id = idText.getText();
                if(id.equals("")){
                    JOptionPane.showMessageDialog(null, "아이디를 입력해주세요.");
                }else{
                    UsersDatabase udb = new UsersDatabase();
                    udb.connect();
                    JOptionPane.showMessageDialog(null,udb.findpas(id));
                    udb.databaseClose();
                }
            }
            
        });



        setVisible(true);
    }
}
