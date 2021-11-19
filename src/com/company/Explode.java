package com.company;

import java.awt.*;

public class Explode {

    double x,y;
    static Image[] images = new Image[13];

//    计数
    int count ;

    static  {
        for (int i=0;i<13;i++){
            images[i] =GameUtil.getImages("image/explode/"+(i+1)+".gif");
//            images[i].getWidth(null);
        }
    }

         public void drawMyself(Graphics graphics){
        if(count<13){
            graphics.drawImage(images[count],(int)x,(int)y,null );
            count ++;
        }

         }

    public Explode() {
    }

    public Explode(double x, double y) {
        this.x = x;
        this.y = y;

    }
}
