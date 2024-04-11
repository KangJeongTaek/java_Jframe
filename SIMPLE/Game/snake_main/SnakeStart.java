package Game.snake_main;
import javax.swing.JFrame;

public class SnakeStart {
    public SnakeStart(){

    
        JFrame windows = new JFrame("snake_games");
        windows.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        windows.setResizable(false);
        
        GamePanel gp = new GamePanel();
        windows.add(gp);
        windows.pack();
        windows.setLocationRelativeTo(null);
        windows.setVisible(true);
        
        gp.launchGame();
    }
}
