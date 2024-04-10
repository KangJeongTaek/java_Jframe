package Frame;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MenuFrame extends JFrame{
    public MenuFrame(){

        //기본 설정
        setTitle("정택 PC");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        pack();
        setSize(new Dimension(600, 600));
        setResizable(false);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());


        //패널 생성하고 레이아웃 설정하기
        JPanel northJPanel = new JPanel();
        JPanel eastJPanel = new JPanel();
        JPanel southJPanel = new JPanel();
        JPanel centerJPanel = new JPanel();
        northJPanel.setLayout(new FlowLayout());
        southJPanel.setLayout(new FlowLayout());
        centerJPanel.setLayout(new GridLayout(3, 3));


        //패널 배치하기
        add(northJPanel,BorderLayout.NORTH);
        add(eastJPanel,BorderLayout.EAST);
        add(southJPanel,BorderLayout.SOUTH);
        add(centerJPanel,BorderLayout.CENTER);

        //북측 패널에 3개의 버튼 생성하기
        JButton ramenJButton = new JButton("라면");
        JButton snackJButton = new JButton("과자");
        JButton beverageJButton = new JButton("음료");





        // 나타나게 설정
        setVisible(true);
    }
}
