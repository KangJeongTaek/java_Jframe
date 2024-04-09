package Frame;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class UserLoginedSeat extends JFrame {
    private static final long serialVersionUID = 1L;
    private static final int FRAME_WIDTH = 300;
    private static final int FRAME_HEIGHT = 500;
    private static final int RECT_WIDTH = 20;
    private static final int RECT_HEIGHT = 20;
    private static final int SEAT_X = FRAME_WIDTH / 2 - RECT_WIDTH / 2;
    private static final int SEAT_Y = RECT_HEIGHT;
    private static final int MOVE_DISTANCE = 5;
    private boolean isRunning = true;
    private JPanel panel;
    private int x, y;

    public UserLoginedSeat() {
        setTitle("좌석으로 이동 중");
        setSize(FRAME_WIDTH, FRAME_HEIGHT);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                drawPerson(g);
                drawSeat(g);
            }
        };
        getContentPane().add(panel);
        
        x = FRAME_WIDTH / 2 - RECT_WIDTH / 2;
        y = FRAME_HEIGHT; 
        
        setVisible(true);

        movePerson();
    }

    private void drawPerson(Graphics g) {
        g.setColor(Color.BLUE);
        g.fillRect(x, y, RECT_WIDTH, RECT_HEIGHT);
    }
    private void drawSeat(Graphics g){
        g.setColor(Color.RED);
        g.fillRect(SEAT_X,SEAT_Y,RECT_WIDTH,RECT_HEIGHT);
    }

    private void movePerson() {
        new Thread(() -> {
            while (isRunning) {
                try {
                    Thread.sleep(100);
                    System.out.println("실행");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                y -= MOVE_DISTANCE;
                if (Math.abs(y - SEAT_Y) <= MOVE_DISTANCE) {
                    System.out.println(y);
                    dispose();
                    new UiFrame();
                    isRunning = false;
                }
                panel.repaint();
            }
        }).start();
    }
}