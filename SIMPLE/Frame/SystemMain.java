package Frame;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EtchedBorder;

public class SystemMain extends JFrame{
    private static SystemMain instance;
    public SystemMain(){
        instance = this;

        //50개의 좌석 만들기
        Seat[] seats = new Seat[50];

        //기본 설정
        setTitle("자리 선택");
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        

        //50개를 담을 JPanel 만들기
        JPanel jpanel = new JPanel();
        jpanel.setLayout(new GridLayout(5,10,10,10));

        //개 좌석의 패널 만들기
        for(int i =0; i<seats.length;i++){
            seats[i] = new Seat();
            seats[i].add(new JLabel(i+1 +"번 자리",SwingConstants.CENTER),SwingConstants.CENTER);
            jpanel.add(seats[i]);
        }


        

        add(jpanel);
        setSize(new Dimension(800,640));
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static SystemMain getInstance() {
        return instance;
    }
}


// 좌석 JPanel
class Seat extends JPanel{
    private static Seat instance;
    Seat(){
        instance = this;
        setBackground(new Color(0,183,235));
        setBorder(new EtchedBorder());
        setLayout(new BorderLayout());

        Font font = new Font("굴림체",0,10);

        //예약 버튼
        JButton reserve = new JButton("선택");
        reserve.setFont(font);
        reserve.setBorderPainted(false);
        reserve.setBackground(Color.YELLOW);
        add(reserve,BorderLayout.SOUTH);

        
        
        //선택 버튼을 클릭했을 때
        reserve.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int ok = JOptionPane.showConfirmDialog(null, "이 좌석으로 이동하시겠습니까?","확인 메시지",JOptionPane.OK_CANCEL_OPTION);
                if(ok ==0){
                    new UserLoginedSeat();
                    SystemMain.getInstance().dispose();
                }
                
            }
        });
    }

    public static Seat getInstance() {
        return instance;
    }
    
}

