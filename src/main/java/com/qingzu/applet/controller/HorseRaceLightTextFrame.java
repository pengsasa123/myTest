package com.qingzu.applet.controller;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.net.URL;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class HorseRaceLightTextFrame extends JFrame {
    private Image img = null; // 声明图像对象
    private HorseRaceLightTextPanel horseRaceLightTextPanel = new HorseRaceLightTextPanel();
    public static void main(String args[]) {
        HorseRaceLightTextFrame frame = new HorseRaceLightTextFrame();
        frame.setVisible(true);
    }

    public HorseRaceLightTextFrame() {
        super();
        setTitle("文字跑马灯特效");
        setBounds(200, 160, 380, 537);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        URL imgUrl = HorseRaceLightTextFrame.class
                .getResource("/timg.jpg");// 获取图片资源的路径
        img = Toolkit.getDefaultToolkit().getImage(imgUrl); // 获取图像资源
        getContentPane().add(horseRaceLightTextPanel);
        Thread thread = new Thread(horseRaceLightTextPanel);// 创建线程对象
        thread.start();// 启动线程对象
    }

    class HorseRaceLightTextPanel extends JPanel implements Runnable { // 创建内部面板类
        String value = "我每天心中念念不忘的,只有E哥";// 存储绘制的内容
        char[] drawChar = value.toCharArray();// 将绘制内容转换为字符数组
        int[] x = new int[drawChar.length];// 存储每个字符绘制点x坐标的数组
        int y = 100;// 存储绘制点的y坐标
        public void paint(Graphics g) {
            g.clearRect(0, 0, getWidth(), getHeight());// 清除绘图上下文的内容
            g.drawImage(img, 0, 0, getWidth(), getHeight(), this);// 绘制图像
            Font font = new Font("宋体", Font.BOLD, 25);// 创建字体对象
            g.setFont(font);// 指定字体
            g.setColor(Color.RED);// 指定颜色
            for (int j = 0; j < drawChar.length; ++j){
                g.drawString(drawChar[j]+"",x[j] , y);// 绘制文本
            }
        }
        public void run() {
            try {
                boolean flag = false;// 为false时表示第一次执行，x坐标进行等比递增，否则进行等差递增
                while (true) { // 读取内容
                    Thread.sleep(500); // 当前线程休眠1000毫秒
                    for (int i = 0; i <= drawChar.length-1 ; ++i) {
                        if (!flag){
                            x[i]=x[i]+20*i;// x坐标进行等比递增
                        } else {
                            x[i]=x[i]+20;// x坐标进行等差递增
                        }
                        if (x[i]>=380 - 20){// 大于窗体宽度减20的值时
                            x[i] = 0;       // x坐标为0
                        }
                    }
                    repaint();// 调用paint()方法
                    if (!flag) {
                        flag = true;// 赋值为true
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
