package it1995;

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
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Random;
import java.util.Set;

@WebServlet(value = "/first")
public class NewCode extends HttpServlet {

    private Random random = new Random();
    private int width = 80;
    private int height = 30;
    private int fontsize = 12;
    private String str = "0123456789abcdefABCDEF";

    private String randCode(int len){

        if(len < 4){

            len = 4;
        }

        width = 5 + fontsize * len;

        String code = "";

        for(int i = 0; i < len; i++){

            code += str.charAt(random.nextInt(str.length()));
        }

        return code;
    }

    private Color randColor(){

        int r = random.nextInt(256);
        int g = random.nextInt(256);
        int b = random.nextInt(256);

        return new Color(r, g, b);
    }




    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        this.doPost(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        //1. 创建画板
        BufferedImage img = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        //2. 创建画板
        Graphics2D pen = img.createGraphics();

        //3. 生成随机内容
        String code = randCode(4);
        request.getSession().setAttribute("valiCode", code);

        //4. 绘制内容
        //  4.1 设置绘制区域
        pen.fillRect(0, 0, width, height);

        //  4.2 设置字体
        pen.setFont(new Font("微软雅黑", Font.BOLD, fontsize + random.nextInt(5)));

        //  4.3 按顺序逐个绘制字符
        for(int i = 0; i < code.length(); i++){

            pen.setColor(randColor());
            pen.drawString(code.charAt(i) + "", 5 + i * fontsize, (fontsize + height) / 2 + random.nextInt(5));
        }

        //  4.4 绘制噪音线
        for(int i = 0; i < 3; i++){

            pen.setColor(randColor());
            pen.setStroke(new BasicStroke(3));
            pen.drawLine(random.nextInt(width / 2), random.nextInt(height), random.nextInt(width), random.nextInt(height));
        }

        //5.保存图片并发送
        ServletOutputStream out = response.getOutputStream();
        ImageIO.write(img, "png", out);
        out.flush();
        out.close();
    }
}
