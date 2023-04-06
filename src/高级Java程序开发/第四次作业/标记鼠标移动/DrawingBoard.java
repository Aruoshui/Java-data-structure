package 高级Java程序开发.第四次作业.标记鼠标移动;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class DrawingBoard extends JFrame implements MouseListener, MouseMotionListener {
    private JPanel drawingPanel;
    private Graphics g;

    public DrawingBoard() {
        setTitle("画板");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        drawingPanel = new JPanel();
        drawingPanel.setBackground(Color.WHITE);
        drawingPanel.addMouseListener(this);
        drawingPanel.addMouseMotionListener(this);
        add(drawingPanel);
    }

    public void mousePressed(MouseEvent e) {
        g = drawingPanel.getGraphics();
        g.setColor(Color.BLACK);
        g.fillOval(e.getX(), e.getY(), 5, 5);
    }

    public void mouseDragged(MouseEvent e) {
        g.fillOval(e.getX(), e.getY(), 5, 5);
    }

    public void mouseClicked(MouseEvent e) {}
    public void mouseReleased(MouseEvent e) {}
    public void mouseEntered(MouseEvent e) {}
    public void mouseExited(MouseEvent e) {}
    public void mouseMoved(MouseEvent e) {}

    public static void main(String[] args) {
        DrawingBoard db = new DrawingBoard();
        db.setVisible(true);
    }
}
