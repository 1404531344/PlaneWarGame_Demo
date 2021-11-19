package com.company;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Date;

/**
 * 游戏住主窗口
 */



public class MyGameFrame extends Frame {



    //背景图片路径
    Image bg = GameUtil.getImages("image/background.jpg");
    //飞机图片路径
    Image planeImage = GameUtil.getImages("image/plane.jpg");


    Plane plane = new Plane(planeImage,100,100,10,22,33);//飞机

    Shell[] shells = new Shell[50];//炮弹

    Explode explode ;//爆炸效果

Date start = new Date();  //游戏开始的时间
    Date end;//游戏结束
    long second ;




    @Override
    public void paint(Graphics graphics){     //paint是一支笔
        graphics.drawImage(bg,0,0,Constant.Game_Win,Constant.Game_Height,null);//背景
        plane.drawMyself(graphics);//画飞机
drawTime(graphics);//画存活时间



        for(int i=0;i<shells.length;i++){      //画50个炮弹
            shells[i].drawMyself(graphics);
            Boolean peng = shells[i].getRec().intersects(plane.getRec());//矩形的碰撞方法
            if(peng){//飞机炮弹判断碰撞
                System.out.println("被击中了");
                plane.live=false;  //飞机生命等于零

                if(explode==null){  //爆炸效果开始
                    explode =new Explode(plane.x,plane.y);//爆炸位置

                }
                explode.drawMyself(graphics);

            }



        }





    }


    //画  存活提示

public void drawTime(Graphics graphics){
Color color = graphics.getColor();
Font font = graphics.getFont();

    graphics.setColor(Color.green);
    if(plane.live){

        second = (System.currentTimeMillis()-start.getTime())/1000;
        graphics.drawString("坚持了"+second,30,50);

    }else {
        if (end==null){
            end =new Date();
            second = (end.getTime()-start.getTime())/1000;
        }
    }

    //画 大结束字体
    graphics.setColor(Color.red);
    graphics.setFont(new Font("微软雅黑",Font.BOLD,30));
    graphics.drawString("最终时间"+second,200,300);

    graphics.setColor(color);
    graphics.setFont(font);

}




//    初始化窗口
  public void launchFrame(){

      this.setTitle("飞机大战");       //设置窗口标题
      setVisible(true);               //设置窗口可见
      setSize(500,500);  //设置窗口大小
      setLocation(400,400);     //设置窗口打开的位置

      //增加窗口按钮的关闭是事件
      this.addWindowListener(new WindowAdapter() {
          @Override
          public void windowClosing(WindowEvent e) {
              System.exit(0);
          }
      });

      new PaintThread().start();  //窗口开始线程
      this.addKeyListener(new KeyMonitor()); //启动键盘监听
//创建50个炮弹对象‘
      for(int i=0;i<50;i++){
          shells[i] =new Shell();
      }

  }


  //重画窗口线程类部类
    class PaintThread extends  Thread{
        @Override
      public void run(){
            while (true){
                repaint(); //内部类可以直接使用外部类的成员  （Frame里面的）

                try {
                    Thread.sleep(50);//一秒中内休息50毫秒（1000/50=20  ,一秒钟画20次）
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

    }




    //键盘内部类,实现键盘的监听处理
    class KeyMonitor extends KeyAdapter{

        @Override
        public void keyPressed(KeyEvent e) {
            System.out.println("按下" + e.getKeyCode());
//            System.out.println(KeyEvent.VK_A);
            plane.addDirection(e);


        }

        @Override
        public void keyReleased(KeyEvent e) {
            System.out.println("松开" + e.getKeyCode());
            plane.minusDirection(e);


        }
    }


    //    增加屏幕双缓冲
//    private Image  offScreeImage = null;
//    public void update(Graphics g){
//        if(offScreeImage == null){
//            offScreeImage = this.createImage(Constant.Game_Win,Constant.Game_Height);
//
//            Graphics goff = offScreeImage.getGraphics();
//            paint(goff);
//            g.drawImage (offScreeImage,0,0,null);
//        }
//
//    }

    public static void main(String[] args) {
        MyGameFrame myGameFrame = new MyGameFrame();
        myGameFrame.launchFrame();
    }





}
