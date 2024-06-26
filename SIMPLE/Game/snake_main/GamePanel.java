package Game.snake_main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;
import javax.swing.plaf.DimensionUIResource;

public class GamePanel extends JPanel implements Runnable{
    public static final int WIDTH = 1080;
    public static final int HEIGHT = 720;

    final int FPS = 60;
    Thread gameThread;
    PlayManager pm;
    
    public GamePanel(){
        this.invalidate();
        this.setPreferredSize(new DimensionUIResource(WIDTH, HEIGHT));
        this.setBackground(Color.black);
        this.addKeyListener(new KeyHandler());
        this.setLayout(null);
        this.setFocusable(true);
        pm = new PlayManager();
    }
    public void launchGame(){
        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run(){
        double drawInterval = 1000000000 /FPS;
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;

        while(SnakeStart.getWindows().isVisible()){
            currentTime = System.nanoTime();
            delta += (currentTime- lastTime) / drawInterval;
            lastTime = currentTime;
            if(delta>=1){
                update();
                repaint();
                delta--;
            }
        }
        this.removeAll();
    }
    private void update(){
        if(KeyHandler.pausePressed == false){
            if(PlayManager.game_over == false){
                pm.update();
            }
        }
        
    }
    public void paintComponent(Graphics g){
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;
        pm.draw(g2);
    }
}
