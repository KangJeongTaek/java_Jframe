package Game.snake;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.ArrayList;

import Game.snake_main.KeyHandler;
import Game.snake_main.PlayManager;

public class Snake{
    // public Block b[] = new Block[4];
    // public Block tempB[] = new Block[4];
    public ArrayList <Block> bl = new ArrayList<>();
    public ArrayList <Block> tempBl = new ArrayList<>();
    public boolean targetEat;
    int timer;
    
    public Snake(){
        for(int i =0; i<5; i++){
            bl.add(i,new Block(Color.blue));
        }
    }
    public void setXY(int x, int y){
        for(int i =0;i<bl.size();i++){
            bl.get(i).x = x + Block.SIZE * i;
            bl.get(i).y = y;
        }
    }
    public void update(){
        if(KeyHandler.upPressed){
            timer ++;
            if(timer == 4){
                bl.get(0).y -= Block.SIZE;
                for(int i = bl.size()-1;i>0;i --){
                    bl.get(i).x = bl.get(i-1).x;
                    bl.get(i).y = bl.get(i-1).y;
                }
               timer = 0;
            }
        }  
        if(KeyHandler.leftPressed){
            timer ++;
            if(timer == 4){
                bl.get(0).x -= Block.SIZE;
                for(int i = bl.size()-1;i>0;i --){
                    bl.get(i).x = bl.get(i-1).x;
                    bl.get(i).y = bl.get(i-1).y;
                }
               timer = 0;
            }
        }
        if(KeyHandler.rightPressed){
            
            timer ++;
            if(timer == 4){
                bl.get(0).x += Block.SIZE;
                for(int i = bl.size()-1;i>0;i --){
                    bl.get(i).x = bl.get(i-1).x;
                    bl.get(i).y = bl.get(i-1).y;
                }
               timer = 0;
            }
        }
        if(KeyHandler.downPressed){
    
            timer ++;
            if(timer == 4){
                bl.get(0).y += Block.SIZE;
                for(int i = bl.size()-1;i>0;i --){
                    bl.get(i).x = bl.get(i-1).x;
                    bl.get(i).y = bl.get(i-1).y;
                }
               timer = 0;
            }
        }
        
   
        if(bl.get(0).y<=PlayManager.targetBlock_Y + Block.SIZE&&bl.get(0).y+Block.SIZE>=PlayManager.targetBlock_Y
                && bl.get(0).x <= PlayManager.targetBlock_X + Block.SIZE&& bl.get(0).x + Block.SIZE>=PlayManager.targetBlock_X){
            targetEat = true;
        }
    }
        
    
        
    public void draw(Graphics2D g2){
        g2.setColor(bl.get(0).c);
        for(int i = 0; i<bl.size(); i ++){
            g2.fillRect(bl.get(i).x, bl.get(i).y, Block.SIZE, Block.SIZE);
        }
    }
}
