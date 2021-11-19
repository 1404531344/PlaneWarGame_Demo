package com.company;

import java.awt.*;
import java.awt.event.KeyEvent;

public class Plane extends GameObject{


    boolean left,right,up,down;//上下左右控制键

    boolean live =true ;//飞机活着


    //    飞机动起来
    @Override
    public void drawMyself(Graphics g) {

  if(live){

    super.drawMyself(g);
//       x+=speed;
    if(left){
        x -= speed;
    }

    if(right){
        x+= speed;
    }
    if(up){
        y-= speed;
    }
    if(down){
        y+= speed;
    }
}

    }

//键盘控制飞机移动

    public void addDirection(KeyEvent e){
        switch (e.getKeyCode()) {
            case KeyEvent.VK_LEFT:
                left = true;
                break;
            case KeyEvent.VK_RIGHT:
                right = true;
                break;
            case KeyEvent.VK_UP:
                up = true;
                break;
            case KeyEvent.VK_DOWN:
                down = true;
                break;

        }
    }
    public void minusDirection(KeyEvent e){
        switch (e.getKeyCode()) {
            case KeyEvent.VK_LEFT:
                left = false;
                break;
            case KeyEvent.VK_RIGHT:
                right = false;
                break;
            case KeyEvent.VK_UP:
                up = false;
                break;
            case KeyEvent.VK_DOWN:
                down = false;
                break;

        }
    }



    public Plane(Image img, double x, double y, int speed, int width, int height) {
        super(img, x, y, speed, width, height);
    }

    public Plane(double x, double y) {
        super(x, y);
    }
}
