package Frame;
import java.awt.BorderLayout;
import java.awt.Color;
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
        Seat[] seats = new Seat[50];
        setTitle("자리 선택");
        setResizable(false);
       
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

       


        JPanel jpanel = new JPanel();
        jpanel.setLayout(new GridLayout(5,10,10,10));

        for(int i =0; i<seats.length;i++){
            seats[i] = new Seat();
            seats[i].add(new JLabel(i+1 +"번 자리",SwingConstants.CENTER),SwingConstants.CENTER);
            jpanel.add(seats[i]);
        }


        

        add(jpanel);
        setSize(800,640);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static SystemMain getInstance() {
        return instance;
    }
}

class Seat extends JPanel{
    private static Seat instance;
    Seat(){
        instance = this;
        setBackground(Color.CYAN);
        setBorder(new EtchedBorder());
        setLayout(new BorderLayout());

        Font font = new Font("굴림체",0,10);

        //예약 버튼
        JButton reserve = new JButton("선택");
        reserve.setFont(font);
        add(reserve,BorderLayout.SOUTH);
        

        //취소 버튼
        JButton cancle = new JButton("취소");
        cancle.setFont(font);
        
        
        

        reserve.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                TimeFrame timeSel = new TimeFrame();

            
                TimeSel timeJButtons[] = new TimeSel[8];
                
                for(int i = 0 ;i <timeJButtons.length; i++){
                    timeJButtons[i] = new TimeSel();
                    timeSel.add(timeJButtons[i]);
                    timeJButtons[i].setText((i+1)*30 + "분");
                }


                timeSel.setLocationRelativeTo(null);
                timeSel.setVisible(true);

                setBackground(Color.PINK);
                reserve.setVisible(false);
                add(cancle,BorderLayout.SOUTH);
                cancle.setVisible(true);
                
            }
        });

        cancle.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setBackground(Color.CYAN);
                cancle.setVisible(false);
                reserve.setVisible(true);
            }
            
        });
    }

    public static Seat getInstance() {
        return instance;
    }
    
}


class TimeSel extends JButton{
    TimeSel(){
        setBorder(new EtchedBorder());
        setBackground(Color.YELLOW);
        setForeground(Color.BLACK);
        setOpaque(true);
        addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                int con = JOptionPane.showConfirmDialog(null, "충전 하시겠습니까?", "확인",2 );
                if(con == 0){
                    JOptionPane.showMessageDialog(null, "요금이 충전됐습니다.");

                    SystemMain.getInstance().dispose();
                    TimeFrame.getInstance().dispose();
                    new UserLoginedSeat();
                }
            }
        });
    }
}

class TimeFrame extends JFrame{
    static TimeFrame instance;

    TimeFrame(){
        instance = this;
        setTitle("시간을 선택해주세요.");
        setSize(600, 300);
        setLayout(new GridLayout(2, 4, 20, 30));
    }
    public static TimeFrame getInstance() {
        return instance;
    }
}