import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class UserLoginedSeat extends JFrame {
    private static UserLoginedSeat instance;
    Random random = new Random();
    UserLoginedSeat(){
        instance = this;
        setTitle("좌석으로 이동 키보드 방향키 위 쪽을 눌러주세요.");
        setSize(300,500);
        setVisible(true);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel contentPane = new JPanel();
        contentPane.setLayout(new BorderLayout());
        setContentPane(contentPane);

        Block user = new Block(200, 50); // 중앙 아래로 변경
        

        
        Circle seat = new Circle(220, 50);
        contentPane.add(seat);
        contentPane.add(user);

        
    }

    public static UserLoginedSeat getInstance(){
        return instance;
    }
}

class Block extends JPanel{
    private int x, y;
    
    public Block(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void paintComponent(Graphics g2){
        super.paintComponent(g2);
        g2.setColor(Color.RED);
        g2.fillRect(x, y, 10, 10);
    }
}

class Circle extends JPanel {
    private int x, y;
    
    public Circle(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void paintComponent(Graphics g2){
        super.paintComponent(g2);
        g2.setColor(Color.BLUE);
        g2.fillOval(x, y, 10, 10);
    }
}
