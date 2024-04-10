package Frame;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;


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
        eastJPanel.setLayout(new BorderLayout());
        northJPanel.setLayout(new GridLayout());
        southJPanel.setLayout(new FlowLayout());
        centerJPanel.setLayout(new GridLayout(3, 3,10,10));


        //패널 배치하기
        add(northJPanel,BorderLayout.NORTH);
        add(eastJPanel,BorderLayout.EAST);
        add(southJPanel,BorderLayout.SOUTH);
        add(centerJPanel,BorderLayout.CENTER);

        //북측 패널에 3개의 버튼 생성하기
        JButton ramenJButton = new JButton("라면");
        JButton snackJButton = new JButton("과자");
        JButton beverageJButton = new JButton("음료");
        northJPanel.add(ramenJButton);
        northJPanel.add(snackJButton);
        northJPanel.add(beverageJButton);


        //우측 패널 사이즈 조절하기
        eastJPanel.setPreferredSize(new Dimension(200, getHeight()));
        //장바구니 이름 표시
        eastJPanel.add(new JLabel("구매 목록",JLabel.CENTER),BorderLayout.NORTH);

        //장바구니 만들기
        DefaultTableModel cartTableModel = new DefaultTableModel();
        cartTableModel.addColumn("번호");
        cartTableModel.addColumn("제품명");
        cartTableModel.addColumn("가격");
        JTable cartTable = new JTable(cartTableModel);
        JScrollPane sc = new JScrollPane(cartTable);
        eastJPanel.add(sc);

        //남쪽 패널에 결제 버튼 생성하기
        JButton purchaseBJButton = new JButton("구매하기");
        southJPanel.add(purchaseBJButton);


        // 가운데 패널에 생성하기
        JPanel[] prodListJPanels = new JPanel[9];

        for (int i = 0; i<prodListJPanels.length ; i ++){
            prodListJPanels[i] = new JPanel();
            prodListJPanels[i].add(new JButton("하이"));
            centerJPanel.add(prodListJPanels[i]);
        }

        // 나타나게 설정
        setVisible(true);
    }
}

class RamenJPanel extends JPanel{

}
