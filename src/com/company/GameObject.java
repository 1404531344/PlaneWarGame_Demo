package com.company;

import java.awt.*;

public class GameObject {
    Image img;             //图片
    double x,y;            //坐标
    int speed;             //物体移动的速度
    int width,height;      //图片宽高

    public GameObject() {
    }

    public GameObject(Image img, double x, double y, int speed, int width, int height) {
        this.img = img;
        this.x = x;
        this.y = y;
        this.speed = speed;
        this.width = width;
        this.height = height;
    }

    public GameObject(double x, double y) {
        this.x = x;
        this.y = y;
    }

    //画飞机，自己画自己(飞机动起来)
    public void drawMyself(Graphics g){
        g.drawImage(img,(int)x,(int)y,width,height,null);

    }

    //所有的物体都是矩形,当你获得对应矩形的时候可以进行相关的判断(碰撞检测)
    public Rectangle getRec(){
        return new Rectangle((int)x,(int)y,width,height);
    }
}
