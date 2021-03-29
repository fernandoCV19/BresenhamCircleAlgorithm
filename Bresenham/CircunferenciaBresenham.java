import java.awt.*;
import javax.swing.JPanel;
import javax.swing.JFrame;
import java.util.concurrent.TimeUnit;
import java.awt.event.ActionListener;
import javax.swing.Timer;
import java.awt.event.ActionEvent;
import javax.swing.JApplet;
import java.util.concurrent.ScheduledExecutorService;

public class CircunferenciaBresenham extends JPanel implements ActionListener
{
    private int x;
    private int y;
    private int r;
    Timer timer;
    public CircunferenciaBresenham(int x, int y, int r){
        this.x = x;
        this.y = y;
        this.r = r;
        timer = new Timer(200, this);
        timer.setInitialDelay(1000);
        timer.start();
    }

    protected void paintComponent(Graphics g){
        super.paintComponent(g);

        g.setColor(Color.BLACK);

        CircleMidPoint(g, x, y, r);
    }

    void CircleMidPoint(Graphics g, int xc, int yc, int r){
        int x, y, p;

        x = 0;

        y = r;

        p = 1 - r;

        PlotPoint(g,xc,yc,x,y);

        /* se cicla hasta trazar todo un octante */

        while (x < y){

            x = x + 1;

            if (p < 0)

                p = p + 2*x + 1;

            else {

                y = y - 1;

                p = p + 2*(x - y) + 1;

            }
            PlotPoint(g,xc,yc,x,y);
            repaint();
        }
    }

    void PlotPoint(Graphics g, int xc, int yc, int x, int y)

    {

        g.drawLine(xc + x,yc + y,xc + x,yc + y);

        g.drawLine(xc - x,yc + y, xc - x,yc + y);

        g.drawLine(xc + x,yc - y, xc + x,yc - y);

        g.drawLine(xc - x,yc - y, xc - x,yc - y);

        g.drawLine(xc + y,yc + x, xc + y,yc + x);

        g.drawLine(xc - y,yc + x, xc - y,yc + x);

        g.drawLine(xc + y,yc - x, xc + y,yc - x);

        g.drawLine(xc - y,yc - x, xc - y,yc - x);
    }

    public void actionPerformed(ActionEvent e) {
        repaint();
    }
}
