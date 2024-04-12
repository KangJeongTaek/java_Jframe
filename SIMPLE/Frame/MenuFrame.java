package Frame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;


public class MenuFrame extends JFrame implements ActionListener{
    private JButton ramenJButton;
    private JButton snackJButton;
    private JButton beverageJButton;
    private JPanel centerJPanel;
    private RamenJPanel ramenMenu;
    private SnackJPanel snackMenu;
    private BeverageJPanel beverageMenu;
    private JButton purchaseBJButton;
    private DefaultTableModel cartTableModel;
    private JTable cartTable;
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
        centerJPanel = new JPanel();
        eastJPanel.setLayout(new BorderLayout());
        northJPanel.setLayout(new GridLayout());
        southJPanel.setLayout(new FlowLayout());
        centerJPanel.setLayout(new BorderLayout());
        centerJPanel.setBorder(new LineBorder(Color.GRAY,3));


        //패널 배치하기
        add(northJPanel,BorderLayout.NORTH);
        add(eastJPanel,BorderLayout.EAST);
        add(southJPanel,BorderLayout.SOUTH);
        add(centerJPanel,BorderLayout.CENTER);

        //북측 패널에 3개의 버튼 생성하기
        ramenJButton = new JButton("라면");
        snackJButton = new JButton("과자");
        beverageJButton = new JButton("음료");
        northJPanel.add(ramenJButton);
        northJPanel.add(snackJButton);
        northJPanel.add(beverageJButton);
        
        

        //우측 패널 사이즈 조절하기
        eastJPanel.setPreferredSize(new Dimension(200, getHeight()));
        //장바구니 이름 표시
        eastJPanel.add(new JLabel("구매 목록",JLabel.CENTER),BorderLayout.NORTH);

        //장바구니 만들기
        cartTableModel = new DefaultTableModel();
        cartTableModel.addColumn("제품명");
        cartTableModel.addColumn("가격");
        cartTable = new JTable(cartTableModel);
        JScrollPane sc = new JScrollPane(cartTable);
        eastJPanel.add(sc);


        //남쪽 패널에 결제 버튼 생성하기
        purchaseBJButton = new JButton("구매하기");
        southJPanel.add(purchaseBJButton);


        // 중앙에 들어갈 패널들 생성하기
        ramenMenu = new RamenJPanel();
        snackMenu = new SnackJPanel();
        beverageMenu = new BeverageJPanel();

        


        // 3개의 패널 버튼이 해야할 행동들
        ramenMenu.addMenuButtonListeners(cartTableModel);
        snackMenu.addMenuButtonListeners(cartTableModel);
        beverageMenu.addMenuButtonListeners(cartTableModel);

        //버튼들에 리스너 이벤트 추가하기

        ramenJButton.addActionListener(this);
        snackJButton.addActionListener(this);
        beverageJButton.addActionListener(this);
        purchaseBJButton.addActionListener(this);

        





        // 나타나게 설정
        setVisible(true);
    }
    

    //버튼들 리스너 이벤트 처리하기
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == ramenJButton){
            centerJPanel.removeAll();
            centerJPanel.add(ramenMenu);
            centerJPanel.add(new JLabel("라면",JLabel.CENTER),BorderLayout.NORTH);
            revalidate();
            repaint();
        }
        if(e.getSource() == snackJButton){
            centerJPanel.removeAll();
            centerJPanel.add(snackMenu);
            centerJPanel.add(new JLabel("스낵",JLabel.CENTER),BorderLayout.NORTH);
            revalidate();
            repaint();
        }
        if(e.getSource() == beverageJButton){
            centerJPanel.removeAll();
            centerJPanel.add(beverageMenu);
            centerJPanel.add(new JLabel("음료",JLabel.CENTER),BorderLayout.NORTH);
            revalidate();
            repaint();
        }
        // 구매하기 버튼 누르기
        if(e.getSource() == purchaseBJButton){
            purchaseItem();
            dispose();
            
        }
        
    }
    private void purchaseItem(){
        int sum = 0;
        for(int i = 0; i<cartTable.getRowCount();i++){
            Object value = cartTable.getValueAt(i, 1);
            String str = String.valueOf(value);
            sum += Integer.parseInt(str);
        }
        cartTableModel.setRowCount(0);
        JOptionPane.showMessageDialog(this, "구매 완료\n" + sum + "원 결제","구매가 완료됐습니다!!",JOptionPane.INFORMATION_MESSAGE);
    }


}

class RamenJPanel extends JPanel{
    JButton jinMe;
    JButton jinsun;
    RamenJPanel(){
        setLayout(new GridLayout(0, 2, 50, 50));
        jinMe = new JButton("구입");
        jinsun = new JButton("구입");
        JLabel jinmaeLabel = changeImage("jinmae");
        JLabel jinsunLabel = changeImage("jinsunjpg");
        

        
        
        
        add(jinmaeLabel);
        add(jinsunLabel);
        jinsunLabel.add(jinsun,BorderLayout.SOUTH);
        jinmaeLabel.add(jinMe,BorderLayout.SOUTH);
    }
    public void addMenuButtonListeners(DefaultTableModel cartTableModel){
        jinMe.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                cartTableModel.addRow(new Object[]{"진라면 매운맛",1500});
            }
            
        });
        jinsun.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                cartTableModel.addRow(new Object[]{"진라면 순한맛",1500});
            }
        });
    }
    //이미지 만드는 메소드
    JLabel changeImage(String name){
        //이미지 아이콘 생성
        ImageIcon icon = new ImageIcon("./SIMPLE/image/" + name + ".jpg");
        //이미지 크기 변경
        Image img = icon.getImage();
        Image changeImage = img.getScaledInstance(200,200, Image.SCALE_SMOOTH);
        ImageIcon changeIcon = new ImageIcon(changeImage);
        JLabel imgJLabel = new JLabel(changeIcon);
        imgJLabel.setLayout(new BorderLayout());
        return imgJLabel;
    }

}

class SnackJPanel extends JPanel{
    JButton kkang;
    JButton chip;
    SnackJPanel(){
        setLayout(new GridLayout(0, 2, 50, 50));
        kkang = new JButton("구입");
        chip = new JButton("구입");
        JLabel kkangLabel = changeImage("kkang");
        JLabel chipLabel = changeImage("chipjpg");


        add(kkangLabel);
        add(chipLabel);
        kkangLabel.add(kkang,BorderLayout.SOUTH);
        chipLabel.add(chip,BorderLayout.SOUTH);
    

    }
    public void addMenuButtonListeners(DefaultTableModel cartTableModel){
        kkang.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                cartTableModel.addRow(new Object[]{"새우깡",1500});
            }
            
        });
        chip.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                cartTableModel.addRow(new Object[]{"스윙칩",1700});
            }
        });
    }
    //이미지 만드는 메소드
    JLabel changeImage(String name){
        //이미지 아이콘 생성
        ImageIcon icon = new ImageIcon("./SIMPLE/image/" + name + ".jpg");
        //이미지 크기 변경
        Image img = icon.getImage();
        Image changeImage = img.getScaledInstance(200,200, Image.SCALE_SMOOTH);
        ImageIcon changeIcon = new ImageIcon(changeImage);
        JLabel imgJLabel = new JLabel(changeIcon);
        imgJLabel.setLayout(new BorderLayout());
        return imgJLabel;
    }
}

class BeverageJPanel extends JPanel{
    JButton pepsi;
    JButton coca;
    BeverageJPanel(){
        setLayout(new GridLayout(0, 2, 50, 50));
        pepsi = new JButton("구입");
        coca = new JButton("구입");
        JLabel pepsiLabel = changeImage("pepsi");
        JLabel cocaLabel = changeImage("coca");
        add(pepsiLabel);
        add(cocaLabel);
        pepsiLabel.add(pepsi,BorderLayout.SOUTH);
        cocaLabel.add(coca,BorderLayout.SOUTH);

    }
    public void addMenuButtonListeners(DefaultTableModel cartTableModel){
        pepsi.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                cartTableModel.addRow(new Object[]{"펩시",1800});
            }
            
        });
        coca.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                cartTableModel.addRow(new Object[]{"코카콜라",2000});
            }
        });
    }
    //이미지 만드는 메소드
    JLabel changeImage(String name){
        //이미지 아이콘 생성
        ImageIcon icon = new ImageIcon("./SIMPLE/image/" + name + ".jpg");
        //이미지 크기 변경
        Image img = icon.getImage();
        Image changeImage = img.getScaledInstance(200,200, Image.SCALE_SMOOTH);
        ImageIcon changeIcon = new ImageIcon(changeImage);
        JLabel imgJLabel = new JLabel(changeIcon);
        imgJLabel.setLayout(new BorderLayout());
        return imgJLabel;
    }
}
