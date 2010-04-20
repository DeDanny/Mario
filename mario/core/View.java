/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mario.core;

import java.awt.Color;
import java.awt.DisplayMode;
import java.awt.Graphics;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import javax.swing.JFrame;
import mario.Mario;
import mario.MarioWorld;
import mario.scenery.BackGround;
import mario.scenery.ForeGround;

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
        //setFullScreen();
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
        drawMenu(null);
    }

    void drawMenu(Menu menu)
    {
        Graphics graphics = null;

        try
        {
            // clear back buffer...
            graphics = bi.createGraphics();

            // Draw stuff here using Java's Graphics Object!!!


            if (menu == null)
            {
                graphics.setColor(new Color(107, 136, 255));
                graphics.fillRect(0, 0, 800, 600);
                GameObject gameObjectMario = null;
                ArrayList<GameObject> gameObjectForeGround = new ArrayList<GameObject>();
                ArrayList<GameObject> gameObjectMiddleGround = new ArrayList<GameObject>();
                ArrayList<GameObject> gameObjectBackGround = new ArrayList<GameObject>();
                for (GameObject gameObject : marioWorld.getGame().getMapObjects())
                {

                    if(gameObject instanceof Mario) //filter out the mario
                    {
                         gameObjectMario = gameObject;
                    }
                    else if(gameObject instanceof  ForeGround) //filter out foreground elements
                    {
                        gameObjectForeGround.add(gameObject);
                    }
                    else if (gameObject instanceof BackGround) //filter out background elements
                    {
                        gameObjectBackGround.add(gameObject);
                    }else //sort the rest
                    {
                        gameObjectMiddleGround.add(gameObject);
                    }
                }

                for (GameObject gameObject : gameObjectBackGround)
                {
                    gameObject.draw(graphics);
                }
                for (GameObject gameObject : gameObjectMiddleGround)
                {
                    gameObject.draw(graphics);
                }
                for (GameObject gameObject : gameObjectForeGround)
                {
                    gameObject.draw(graphics);
                }

                
                
                        
                gameObjectMario.draw(graphics);
            } else
            {
                graphics.setColor(new Color(0, 0, 0));
                graphics.fillRect(0, 0, 800, 600);
                menu.draw(graphics);
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
