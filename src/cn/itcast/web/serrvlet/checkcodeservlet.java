package cn.itcast.web.serrvlet;

import com.sun.beans.editors.ColorEditor;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

@WebServlet("/checkcodeServlet")
public class checkcodeservlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int width=100;
        int height=50;
        //创建一个对象，在内存中画图（验证码图片对象）
        BufferedImage image = new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);

        //美化图片
        //填充背景色
        Graphics g = image.getGraphics();

        g.setColor(Color.pink);
        g.fillRect(0,0,width,height);


        //画边框
        g.setColor(Color.black);
        g.drawRect(0,0,width-1,height-1);

        String string = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmopqrstuvwxyz0123456789";
        Random ran=new Random();
        int index;
        //写验证码
        for(int i=0;i<4;i++){
            index=ran.nextInt(string.length());
            String str= String.valueOf(string.charAt(index));
            g.drawString(str,20+20*i,25);
        }

        int x1,x2,y1,y2;
        g.setColor(Color.red);
        for(int i=1;i<=8;i++){
            x1=ran.nextInt(width);
            y1=ran.nextInt(height);
            x2=ran.nextInt(width);
            y2=ran.nextInt(height);
            g.drawLine(x1,y1,x2,y2);
        }


        //将图片输出到页面展示
        ImageIO.write(image,"jpg",response.getOutputStream());


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
