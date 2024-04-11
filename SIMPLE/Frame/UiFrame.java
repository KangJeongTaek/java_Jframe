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
import EXE.TimeThread;
import Game.snake_main.SnakeStart;
import Game.tetris_main.Tetris;
public class UiFrame extends JFrame implements ActionListener{
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
    private UsersDatabase udb;
    private URI uri;
    private int minutes;

    public UiFrame() {
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
        TimeThread tth = new TimeThread();
        System.out.println(tth.getMinute());

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

    class RemainTime extends JPanel{ // implements Runnable
        RemainTime(){
            setLayout(new GridLayout(2,0));
            add(new JLabel("남은 시간"));
            add(new JLabel("표시")); // 구현 안 됨
            
        
        }
    }


    // 각 버튼에 대한 작동
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == shutdowJButton){
            int ok = JOptionPane.showConfirmDialog(this, "종료하시겠습니까?");
            if(ok == 0){
                udb.databaseClose();
                System.exit(0);
            }
        }
        if(e.getSource() == timechargeJButton){
            new TimeFrame();
            udb.addTime(0); // 아직 구현덜 됨
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
}

