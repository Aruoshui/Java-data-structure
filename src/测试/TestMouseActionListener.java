package 测试;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Iterator;

public class TestMouseActionListener {
    public static void main(String[] args) {
        new MyMouseFrame("简易画板");
    }
}
class MyMouseFrame extends Frame {
    //存x,y轴的信息
    private ArrayList<Point> points;
    public MyMouseFrame(String title){
        super(title);
        setBounds(400,270,600,400);
        //存鼠标点击的x,y轴信息
        points = new ArrayList();
        //鼠标监听对当前窗口
        this.addMouseListener(new MyMouseActionListener());
        setVisible(true);
    }


    @Override
    public void paint(Graphics g) {
        //画画，监听鼠标的事件
        Iterator<Point> interator= points.iterator();
        while(interator.hasNext()){
            Point point = interator.next();
            g.setColor(new Color(9, 68, 245));
            g.fillOval(point.x,point.y,10,10);
            g.setColor(Color.BLACK);
        }
    }
    //添加一个点到界面上
    public void add(Point point){
        points.add(point);
    }
    private class MyMouseActionListener extends MouseAdapter{
        @Override
        //鼠标按下事件监听
        public void mousePressed(MouseEvent e) {
            MyMouseFrame frame = (MyMouseFrame) e.getSource();
            //当点击的时候会在x,y轴上有一个点
            //这个x,y轴就是鼠标的点
            frame.add(new Point(e.getX(),e.getY()));
            //每次点击鼠标重画一遍
            frame.repaint();
        }
    }
}
