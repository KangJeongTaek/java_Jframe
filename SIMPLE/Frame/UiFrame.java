package Frame;

import java.awt.BorderLayout;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URI;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import Database.UsersDatabase;
import Frame.UiFrame.RemainTime;
import Game.snake_main.SnakeStart;
import Game.tetris_main.Tetris;
public class UiFrame extends JFrame implements ActionListener ,Runnable{
    private JPanel southJPanel;
    private JPanel eastJPanel;
    private JPanel northJPanel;
    private JPanel centerPanel;
    private JButton shutdowJButton;
    private JButton timechargeJButton;
    private JButton tetrisJButton;
    private JButton snakeJButton;
    private JButton githubJButton;
    private JButton foodJButton;
    private static UsersDatabase udb;
    private static UiFrame instance;
    private long time;
    private int minute;
    public UiFrame() {
        instance = this;
        // DB 연결
        udb = new UsersDatabase();
        udb.connect();

        // 기본적인 프레임 설정
        setTitle("정택 PC");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setSize(new Dimension(800, 480));
        setResizable(false);
        
        setLocationRelativeTo(null);
        
        // 패널 생성
        northJPanel = new JPanel();
        northJPanel.setLayout(new FlowLayout());
        southJPanel = new JPanel();
        southJPanel.setLayout(new FlowLayout());
        eastJPanel = new JPanel();
        centerPanel = new JPanel();
        eastJPanel.setLayout(new GridLayout(3,0));

        // 레이아웃 설정
        setLayout(new BorderLayout());
        
        add(northJPanel, BorderLayout.NORTH);
        add(southJPanel,BorderLayout.SOUTH);
        add(eastJPanel,BorderLayout.EAST);
        add(centerPanel,BorderLayout.CENTER);

        
        // 북측 패널
        //먹거리 주문 버튼 추가
        foodJButton = new JButton("먹거리 주문");
        northJPanel.add(foodJButton);
        

        // 우측 패널
        // 우측 첫번 째 패널(남은 시간 레이블과 남은 시간 표시)
        RemainTime rmt = new RemainTime();
        eastJPanel.add(rmt);

        //우측 세번 째 패널 (시간 충전 버튼)
        timechargeJButton = new JButton("시간 충전");
        eastJPanel.add(timechargeJButton);


        //우측 네번 째 패널 (종료 버튼)
        shutdowJButton = new JButton("시스템 종료");
        eastJPanel.add(shutdowJButton);

        //남쪽 패널
        //테트리스 게임 버튼 추가
        tetrisJButton = new JButton("테트리스 게임");
        southJPanel.add(tetrisJButton);

        //스네이크 게임 버튼 추가
        snakeJButton = new JButton("지렁이 게임");
        southJPanel.add(snakeJButton);

        //인터넷 버튼 추가
        githubJButton = new JButton("GitHub 연결");
        southJPanel.add(githubJButton);


        //중앙 패널
        centerPanel.setLayout(new BorderLayout());
        
        //이미지 아이콘 생성
        ImageIcon icon = new ImageIcon("./SIMPLE/image/Image.jpg");
        //이미지 크기 변경
        Image img = icon.getImage();
        Image changeImage = img.getScaledInstance(726,423, Image.SCALE_SMOOTH);
        ImageIcon changeIcon = new ImageIcon(changeImage);
        JLabel imgJLabel = new JLabel(changeIcon);

        centerPanel.add(imgJLabel,BorderLayout.CENTER);



        // 시간을 업데이트하는 스레드 시작
        Thread thread = new Thread(this);
        thread.start();

        //버튼에 대한 리스너 추가
        shutdowJButton.addActionListener(this);
        timechargeJButton.addActionListener(this);
        tetrisJButton.addActionListener(this);
        snakeJButton.addActionListener(this);
        githubJButton.addActionListener(this);
        foodJButton.addActionListener(this);

        // 화면에 보이도록 설정
        setVisible(true);
        
    }
    
    class RemainTime extends JPanel{
        static RemainTime instance;
        static JLabel ret;
        RemainTime(){
            instance = this;
            setLayout(new GridLayout(2,0));
            add(new JLabel("남은 시간"));
            ret = new JLabel(String.valueOf(udb.get_remain_minutes() + "분"));
            add(ret);
        }
        static RemainTime getInstance(){
            return instance;
        }
    }


    // 각 버튼에 대한 작동
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == shutdowJButton){
            int ok = JOptionPane.showConfirmDialog(this, "종료하시겠습니까?");
            if(ok == 0){
                udb.updateTime(Integer.parseInt(RemainTime.ret.getText().split("분")[0]));
                udb.databaseClose();
                System.exit(0);
            }
        }
        if(e.getSource() == timechargeJButton){
            new TimeFrame1();
        }
        if(e.getSource() == foodJButton){
            new MenuFrame();
        }
        if(e.getSource() == tetrisJButton){
            new Tetris();
        }
        if(e.getSource() == snakeJButton){
            new SnakeStart();
        }
        if(e.getSource() == githubJButton){
            try {
                Desktop.getDesktop().browse(new URI("https://github.com/KangJeongTaek"));
            
            }catch(Exception ek){
                JOptionPane.showMessageDialog(null,"에러 발생");
            }
        }
    }
    public static UiFrame getInstance(){
        return instance;
    }
    public static UsersDatabase getUsersDatabase(){
        return udb;
    }


    //시간을 확인할 쓰레드
    @Override
    public void run() {
        long nanoPerSecond = 1000000000;
        long lastTime = System.nanoTime();
        while (true) { 
            long currentTime = System.nanoTime();
            if (currentTime - lastTime >= nanoPerSecond) {
                time++;
                System.out.println(time);
                if(time == 60){
                    minute ++;
                    time = 0;
                    int min = Integer.parseInt(RemainTime.ret.getText().split("분")[0]);
                    RemainTime.ret.setText(String.valueOf(min - minute) + "분");
                    UiFrame.getInstance().revalidate();
                    UiFrame.getInstance().repaint();
                }
                lastTime = currentTime;
            }
        }
    }
}


class TimeFrame1 extends JFrame{
    static TimeFrame1 instance;

    TimeFrame1(){
        instance = this;
        setTitle("시간을 선택해주세요.");
        setSize(600, 300);
        setLayout(new GridLayout(2, 4, 20, 30));
        TimeSel timeJButtons[] = new TimeSel[8];
                
                for(int i = 0 ;i <timeJButtons.length; i++){
                    timeJButtons[i] = new TimeSel();
                    add(timeJButtons[i]);
                    timeJButtons[i].addActionListener(new ButtnClickListener1());
                    timeJButtons[i].setText((i+1)*30 + "분");
                }
        setVisible(true);
        setLocationRelativeTo(null);
    }
    public static TimeFrame1 getInstance() {
        return instance;
    }
}
//시간 버튼에 대한 각각 다른 메소드 만들기
class ButtnClickListener1 implements ActionListener{
    @Override
    public void actionPerformed(ActionEvent e){
        JButton buttonCliked = (JButton) e.getSource();
        String buttonText = buttonCliked.getText();
        int timecharge = Integer.parseInt(buttonText.substring(0, buttonText.length() - 1));
        int con = JOptionPane.showConfirmDialog(null, timecharge + " 분 충전 하시겠습니까?", "확인", JOptionPane.OK_CANCEL_OPTION);
        if (con == JOptionPane.YES_OPTION) {
            int min = Integer.parseInt(RemainTime.ret.getText().split("분")[0]);
            RemainTime.ret.setText(String.valueOf(min +timecharge) + "분");
            JOptionPane.showMessageDialog(null, "요금이 충전됐습니다.");
            TimeFrame1.getInstance().dispose();
            UiFrame.getInstance().revalidate();
            UiFrame.getInstance().repaint();
            
        }
    }
}

