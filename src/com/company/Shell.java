package com.company;

import java.awt.*;

public class Shell  extends  GameObject{

   private double degree;

    public Shell(){
        x = 200;
        y = 200;
        degree = Math.random()*Math.PI*2;
        width =10;
        height = 10;
        speed = 7;

    }

    @Override
    public void drawMyself(Graphics g) {
        Color c = g.getColor();
        g.setColor(Color.black);

        g.fillOval((int)x,(int)y,width,height);
     g.setColor(c);

     //根据自己的算法定义移动路径
        x+=speed*Math.cos(degree);
        y+=speed*Math.sin(degree);

        //碰到边界改变方向
        if(y>Constant.Game_Height-this.height||y<40){
            degree=-degree;

        }
        if(x>Constant.Game_Win-this.width||x<0){
            degree=-Math.PI-degree;

        }

    }
}
