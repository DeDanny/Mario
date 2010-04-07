/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mario;

import java.awt.Color;
import java.awt.DisplayMode;
import java.awt.Graphics;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import javax.swing.JFrame;

/**
 *
 * @author danny
 */
public class View
{
    private MarioWorld marioWorld;
    private JFrame frame;
    private GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
    private GraphicsDevice gd = ge.getDefaultScreenDevice();
    private GraphicsConfiguration gc = gd.getDefaultConfiguration();
    private BufferStrategy buffer;
    private BufferedImage bi;

    public View(MarioWorld marioWorld, JFrame frame)
    {
        this.marioWorld = marioWorld;
        this.frame = frame;
        setDoubleBuffer();
        setFullScreen();
    }

    private void setFullScreen()
    {
        gd.setFullScreenWindow(frame);
        if (gd.isDisplayChangeSupported())
        {
            gd.setDisplayMode(new DisplayMode(800, 600, 32, DisplayMode.REFRESH_RATE_UNKNOWN));
        }

    }

    private void setDoubleBuffer()
    {
        frame.createBufferStrategy(2);
        buffer = frame.getBufferStrategy();

        // Create off-screen drawing surface
        bi = gc.createCompatibleImage(800, 600);

    }

    public void draw()
    {
        Graphics graphics = null;

        try
        {
            // clear back buffer...
            graphics = bi.createGraphics();
            graphics.setColor(Color.green);
            graphics.fillRect(0, 0, 640, 480);

            // Draw stuff here using Java's Graphics Object!!!

            for (GameObject gameObject : marioWorld.getGame().getGameObjects())
            {
                gameObject.draw(graphics);
            }

            graphics = buffer.getDrawGraphics();
            graphics.drawImage(bi, 0, 0, null);

            // blit the back buffer to the screen
            if (!buffer.contentsLost())
            {
                buffer.show();
            }

        } finally
        {
            if (graphics != null)
            {
                graphics.dispose();
            }
        }


    }
}
