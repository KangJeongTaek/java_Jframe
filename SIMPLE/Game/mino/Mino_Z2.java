package Game.mino;

import java.awt.Color;

public class Mino_Z2 extends Mino{
    public Mino_Z2(){
        create(Color.ORANGE);
    }
    public void setXY(int x,int y){
        //    ㅇㅇ
        //  ㅇㅇ
        b[0].x = x;
        b[0].y = y;
        b[1].x = b[0].x - Block.SIZE;
        b[1].y = b[0].y;
        b[2].x = b[0].x;
        b[2].y = b[0].y - Block.SIZE;
        b[3].x = b[0].x + Block.SIZE;
        b[3].y = b[0].y - Block.SIZE;
    }
    @Override
    public void getDirection1(){
        //    ㅇㅇ
        //  ㅇㅇ
        tempB[0].x = b[0].x;
        tempB[0].y = b[0].y;
        tempB[1].x = b[0].x - Block.SIZE;
        tempB[1].y = b[0].y;
        tempB[2].x = b[0].x;
        tempB[2].y = b[0].y - Block.SIZE;
        tempB[3].x = b[0].x + Block.SIZE;
        tempB[3].y = b[0].y - Block.SIZE;
        updateXY(1);
    }
    @Override
    public void getDirection2(){
        //ㅇ
        //ㅇㅇ
        //  ㅇ
        tempB[0].x = b[0].x;
        tempB[0].y = b[0].y;
        tempB[1].x = b[0].x + Block.SIZE;
        tempB[1].y = b[0].y;
        tempB[2].x = b[0].x;
        tempB[2].y = b[0].y - Block.SIZE;
        tempB[3].x = b[0].x + Block.SIZE;
        tempB[3].y = b[0].y + Block.SIZE;
        updateXY(2);
    }
    @Override
    public void getDirection3(){
        getDirection1();
        updateXY(3);
    }
    @Override
    public void getDirection4(){
        getDirection2();
        updateXY(4);
    }

}
