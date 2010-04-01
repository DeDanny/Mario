/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mario;

import java.awt.Color;
import java.awt.DisplayMode;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import javax.swing.JFrame;

/**
 *
 * @author Danny
 */
public class Main extends JFrame
{
    private boolean running = true;
    private boolean pause = false;
    private GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
    private GraphicsDevice gd = ge.getDefaultScreenDevice();
    private GraphicsConfiguration gc = gd.getDefaultConfiguration();

    private BufferStrategy buffer = getBufferStrategy();
    private BufferedImage bi = gc.createCompatibleImage( 800, 600 );

    public Main()
    {
        init();
        setFullScreenWindow();
        addKeyListener(new Mario());
        loop();
        
    }

    private void init()
    {
        setIgnoreRepaint(true);
        setUndecorated(true);//haalt frame rand weg van venster
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        addKeyListener(new KeyAdapter()//laat de esc key het spel stoppen
        {
            @Override
            public void keyPressed(KeyEvent e)
            {
                if (e.getKeyCode() == KeyEvent.VK_ESCAPE)
                {
                    running = false;
                }
            }
        });
        createBufferStrategy(2);
        BufferStrategy buffer = app.getBufferStrategy();
    }


    private void loop()
    {
        Graphics2D g2d = null;
        g2d = bi.createGraphics();
        g2d.setColor(Color.red);
        Graphics graphics = null;
        while (running)
        {
            g2d = bi.createGraphics();
            g2d.fillRect(15, 15, 40, 40);
            if (!pause)//if pause is false
            {
               
            }
            else
            {
                //pauseLoop();
            }
            graphics = buffer.getDrawGraphics();
            graphics.drawImage( bi, 0, 0, null );

        }
        gd.setFullScreenWindow(null);
        System.exit(0);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        new Main();
    }

    private void setFullScreenWindow()
    {
        gd.setFullScreenWindow(this);
        if (gd.isDisplayChangeSupported())
        {
            gd.setDisplayMode(new DisplayMode(800, 600, 32, DisplayMode.REFRESH_RATE_UNKNOWN));
        }
    }
}
