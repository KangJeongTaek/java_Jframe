package Frame;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;

import Database.UsersDatabase;

public class LoginAfterFrame extends JFrame{
static LoginAfterFrame instance;
static JLabel nameun;
    public LoginAfterFrame(){
        //기본 설정
        instance = this;
        setSize(new Dimension(240,200));
        setLayout(new BorderLayout());
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);

        //북측 패널 만들고 추가하기
        JPanel north = new JPanel();
        add(north,BorderLayout.NORTH);
        north.setLayout(new FlowLayout());
        north.setBackground(Color.cyan);
        //북측 패널에 글자 넣기
        JLabel welcome = new JLabel("환영합니다",JLabel.CENTER);
        JLabel idText = new JLabel(LogInFrame.id,JLabel.RIGHT);
        JLabel nim = new JLabel("님!",JLabel.LEFT);
        welcome.setForeground(Color.BLACK);
        idText.setForeground(Color.blue);
        nim.setForeground(Color.BLACK);
        north.add(welcome);
        north.add(idText);
        north.add(nim);


        //중앙 패널 만들고 추가하기
        JPanel center = new JPanel();
        center.setLayout(new BorderLayout());
        add(center,BorderLayout.CENTER);
        
        //중앙 패널의 북쪽에 남은 시간 표시하기
        nameun = new JLabel("남은 시간 : " + String.valueOf(UsersDatabase.getInstace().get_remain_minutes()) + "분",JLabel.CENTER);
        center.add(nameun,BorderLayout.NORTH);


        // 중앙 패널의 중앙에 버튼 2개 추가하기
        JButton atJButton = new JButton("시간 추가");
        center.add(atJButton,BorderLayout.BEFORE_LINE_BEGINS);
        JButton seatJButton = new JButton("좌석 선택");
        center.add(seatJButton,BorderLayout.AFTER_LINE_ENDS);


        //남은 시간이 0이라면 좌석 선택 불가능
        if(UsersDatabase.getInstace().get_remain_minutes() == 0){
            seatJButton.setEnabled(false);
        }

        //버튼 이벤트 처리하기
        atJButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                new TimeFrame();
            }
            
        });

        seatJButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                new SystemMain();
            }
        });


        //화면에 띄우기
        setVisible(true);
    }
    public static LoginAfterFrame getInstace(){
        return instance;
    }

}
// 선택 버튼을 클릭했을 때 나오는 버튼
class TimeSel extends JButton{
    TimeSel(){
        setBorder(new EtchedBorder());
        setBackground(Color.YELLOW);
        setForeground(Color.BLACK);
        setOpaque(true);
        
    }
}

// 선택 버튼을 클릭했을 때 나오는 프레임
class TimeFrame extends JFrame{
    static TimeFrame instance;

    TimeFrame(){
        instance = this;
        setTitle("시간을 선택해주세요.");
        setSize(600, 300);
        setLayout(new GridLayout(2, 4, 20, 30));
        TimeSel timeJButtons[] = new TimeSel[8];
                
                for(int i = 0 ;i <timeJButtons.length; i++){
                    timeJButtons[i] = new TimeSel();
                    add(timeJButtons[i]);
                    timeJButtons[i].addActionListener(new ButtnClickListener());
                    timeJButtons[i].setText((i+1)*30 + "분");
                }
        setVisible(true);
        setLocationRelativeTo(null);
    }
    public static TimeFrame getInstance() {
        return instance;
    }
}

//시간 버튼에 대한 각각 다른 메소드 만들기
class ButtnClickListener implements ActionListener{
    @Override
    public void actionPerformed(ActionEvent e){
        JButton buttonCliked = (JButton) e.getSource();
        String buttonText = buttonCliked.getText();
        int timecharge = Integer.parseInt(buttonText.substring(0, buttonText.length() - 1));
        int con = JOptionPane.showConfirmDialog(null, timecharge + " 분 충전 하시겠습니까?", "확인", JOptionPane.OK_CANCEL_OPTION);
        if (con == JOptionPane.YES_OPTION) {
            UsersDatabase udb = new UsersDatabase();
            udb.connect();
            udb.addTime(timecharge);
            JOptionPane.showMessageDialog(null, "요금이 충전됐습니다.");
            TimeFrame.getInstance().dispose();
            LoginAfterFrame.nameun.setText(UsersDatabase.getInstace().get_remain_minutes() + "분");
            udb.databaseClose();
            LoginAfterFrame.getInstace().revalidate();
            LoginAfterFrame.getInstace().repaint();
        }
    }
}
