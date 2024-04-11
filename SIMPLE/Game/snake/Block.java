package Game.snake;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Block extends Rectangle {
    public int x,y;
    public static final int SIZE = 20;
    public Color c;

    public Block(Color c){
        this.c =c;
    }
    public void setXY(int x, int y){
        this.x = x;
        this.y = y;
    }
    public void draw(Graphics2D g2){
        g2.setColor(c);
        g2.fillRect(x, y, Block.SIZE, SIZE);
    }
}
