package com.company;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

public class GameUtil {

//    构造器私有化

    public GameUtil(){};



//    获取图片
    public static Image getImages(String path){
        BufferedImage img = null;
        URL url = GameUtil.class.getClassLoader().getResource(path);//获取图片路径

        try {
            img = ImageIO.read(url); //加载图片路径
        } catch (IOException e) {
            e.printStackTrace();
        }


        return img;
    }



}
