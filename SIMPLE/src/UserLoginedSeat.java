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
        setTitle("좌석으로 이동 중");
        setSize(300,500);
        setVisible(true);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        
    }

    public static UserLoginedSeat getInstance(){
        return instance;
    }
}


