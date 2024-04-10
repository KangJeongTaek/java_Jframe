package Frame;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import Game.tetris_main.Tetris;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


import EXE.TimeThread;
public class UiFrame extends JFrame{
    private JPanel southJPanel;
    private JPanel eastJPanel;
    private JPanel northJPanel;
    private JPanel centerPanel;


    public UiFrame() {
        // 기본적인 프레임 설정
        setTitle("정택 PC");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(800, 480));
        pack();
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
        northJPanel.add(new JButton("먹거리 주문"));
        

        // 우측 패널
        // 우측 첫번 째 패널(남은 시간 레이블과 남은 시간 표시)
        RemainTime rmt = new RemainTime();
        eastJPanel.add(rmt);

        //우측 세번 째 패널 (시간 충전 버튼)
        eastJPanel.add(new JButton("시간 충전"));
  

        //우측 네번 째 패널 (종료 버튼)
        eastJPanel.add(new JButton("시스템 종료"));
       
        //남쪽 패널
        //테트리스 게임 버튼 추가
        southJPanel.add(new JButton("테트리스 게임"));

        //스네이크 게임 버튼 추가
        southJPanel.add(new JButton("지렁이 게임"));

        //인터넷 버튼 추가
        southJPanel.add(new JButton("GitHub 연결"));


        //중앙 패널
        centerPanel.setLayout(new BorderLayout());
        //이미지 아이콘 생성
        ImageIcon icon = new ImageIcon("./SIMPLE/image/Image.jpg");
        //이미지 크기 변경
        Image img = icon.getImage();
        Image changeImage = img.getScaledInstance(centerPanel.getWidth(),centerPanel.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon changeIcon = new ImageIcon(changeImage);
        
        JLabel imgJLabel = new JLabel(changeIcon);
        centerPanel.add(imgJLabel,BorderLayout.CENTER);

        
        // 시간을 업데이트하는 스레드 시작
        new TimeThread();

        // 화면에 보이도록 설정
        
        setVisible(true);
        
    }

    class RemainTime extends JPanel{ // implements Runnable
        RemainTime(){
            setLayout(new GridLayout(2,0));
            add(new JLabel("남은 시간 표시"));
            add(new JLabel("표시"));
            
        
        }
    }
}

