package Game.snake_main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener{
    public static boolean upPressed, downPressed,leftPressed,rightPressed,pausePressed,restartPressed;

    @Override
    public void keyTyped(KeyEvent e){

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        if(code == KeyEvent.VK_UP && !downPressed){
            downPressed = false;
            rightPressed = false;
            leftPressed = false;
            upPressed = true;
        }
        if(code == KeyEvent.VK_DOWN && !upPressed){
            upPressed = false;
            rightPressed = false;
            leftPressed = false;
            downPressed = true;
        }
        if(code == KeyEvent.VK_RIGHT && !leftPressed){
            leftPressed = false;
            upPressed = false;
            downPressed = false;
            rightPressed = true;
        }
        if(code == KeyEvent.VK_LEFT && !rightPressed){
            upPressed = false;
            downPressed = false;
            rightPressed = false;
            leftPressed = true;
        }
        if(code == KeyEvent.VK_SPACE){
            if(pausePressed == false){
                pausePressed = true;
            }else{
                pausePressed = false;
            }
        }
        if((code == KeyEvent.VK_R && PlayManager.game_over) || (code == KeyEvent.VK_R &&PlayManager.contact)){
            restartPressed = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
