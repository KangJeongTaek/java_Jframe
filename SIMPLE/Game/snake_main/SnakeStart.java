package Game.snake_main;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;

public class SnakeStart {
    private static JFrame windows;
    public SnakeStart(){

    
        windows = new JFrame("snake_games");
        windows.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        windows.setResizable(false);
        
        GamePanel gp = new GamePanel();
        windows.add(gp);
        windows.pack();
        windows.setLocationRelativeTo(null);
        windows.setVisible(true);
        
        gp.launchGame();

        windows.addWindowListener(new WindowListener() {

            @Override
            public void windowOpened(WindowEvent e) {

            }

            @Override
            public void windowClosing(WindowEvent e) {
                windows.removeAll();
            }

            @Override
            public void windowClosed(WindowEvent e) {
                
            }

            @Override
            public void windowIconified(WindowEvent e) {

            }

            @Override
            public void windowDeiconified(WindowEvent e) {

            }

            @Override
            public void windowActivated(WindowEvent e) {

            }

            @Override
            public void windowDeactivated(WindowEvent e) {
            }
            
        });
    }
    public static JFrame getWindows() {
        return windows;
    }
}
