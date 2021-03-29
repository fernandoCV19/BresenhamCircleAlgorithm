import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.swing.Timer;

public class Bresenham extends JPanel {

    private int x;
    private int y;
    private int r;
    private List<Point> bresenhamList;
    private List<Point> paintList;

    public Bresenham(int x, int y, int r) {
        this.x = x;
        this.y = y;
        this.r = r;
        bresenhamList = new ArrayList<>();
        createRandomPoints();
        paintList = new ArrayList<>();

        Timer timer = new Timer(1, new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        if (bresenhamList.isEmpty()) {
                            ((Timer) e.getSource()).stop();
                        } else {
                            paintList.add(bresenhamList.get(0));
                            bresenhamList.remove(0);
                        }
                        repaint();
                    }
                });
        timer.start();
    }

    private void createRandomPoints() {
        CircleMidPoint(x, y, r);
    }

    private void CircleMidPoint(int xc, int yc, int r){
        int x, y, p;

        x = 0;

        y = r;

        p = 1 - r;

        PlotPoint(xc,yc,x,y);

        /* se cicla hasta trazar todo un octante */

        while (x < y){

            x = x + 1;

            if (p < 0)

                p = p + 2*x + 1;

            else {

                y = y - 1;

                p = p + 2*(x - y) + 1;

            }
            PlotPoint(xc,yc,x,y);
        }
    }

    private void PlotPoint(int xc, int yc, int x, int y)

    {

        bresenhamList.add(new Point(xc + x,yc + y));

        bresenhamList.add(new Point(xc - x,yc + y));

        bresenhamList.add(new Point(xc + x,yc - y));

        bresenhamList.add(new Point(xc - x,yc - y));

        bresenhamList.add(new Point(xc + y,yc + x));

        bresenhamList.add(new Point(xc - y,yc + x));

        bresenhamList.add(new Point(xc + y,yc - x));

        bresenhamList.add(new Point(xc - y,yc - x));
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (Point p : paintList) {
            g.drawLine(p.x, p.y, p.x, p.y);
        }
    }
}