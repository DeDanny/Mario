/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mario.core.engine;

import mario.StageSelector.StageSelector;
import mario.core.menu.Menu;
import java.awt.Color;
import java.awt.DisplayMode;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import javax.jws.soap.SOAPBinding.Style;
import javax.swing.JFrame;
import mario.core.Node;
import mario.Stages.Stage;
import mario.Stages.StageMario;
import mario.core.interfaces.BackGround;
import mario.core.interfaces.ForeGround;

/**
 *
 * @author danny
 */
public class View
{
    private JFrame frame;
    private GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
    private GraphicsDevice gd = ge.getDefaultScreenDevice();
    private GraphicsConfiguration gc = gd.getDefaultConfiguration();
    private BufferStrategy buffer;
    private BufferedImage bi;
    private boolean debugger;

    /**
     *
     * @param frame
     * @param debugger
     */
    public View(JFrame frame, boolean debugger)
    {
        this.frame = frame;
        setDoubleBuffer();
        this.debugger = debugger;
        if (debugger == false)
        {
            setFullScreen();
        }
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

    private Graphics startGraphics()
    {
        Graphics graphics = null;
        graphics = bi.createGraphics();
        return graphics;
    }

    private void endGraphics(Graphics graphics)
    {
        try
        {
            graphics = buffer.getDrawGraphics();
            graphics.drawImage(bi, 0, 0, null);

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

    public void drawStage(Stage stage)
    {
        Graphics graphics = startGraphics();

        graphics.setColor(new Color(107, 136, 255));
        graphics.fillRect(0, 0, 800, 600);
        GameObject gameObjectMario = null;
        ArrayList<GameObject> gameObjectForeGround = new ArrayList<GameObject>();
        ArrayList<GameObject> gameObjectMiddleGround = new ArrayList<GameObject>();
        ArrayList<GameObject> gameObjectBackGround = new ArrayList<GameObject>();
        for (GameObject gameObject : stage.getMapObjects())
        {

            if (gameObject instanceof StageMario) //filter out the mario
            {
                gameObjectMario = gameObject;
            }
            else if (gameObject instanceof ForeGround) //filter out foreground elements
            {
                gameObjectForeGround.add(gameObject);
            }
            else if (gameObject instanceof BackGround) //filter out background elements
            {
                gameObjectBackGround.add(gameObject);
            }
            else //collect the rest
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
        if (gameObjectMario != null)
        {
            gameObjectMario.draw(graphics);
        }
        for (GameObject gameObject : gameObjectForeGround)
        {
            gameObject.draw(graphics);
        }

        endGraphics(graphics);
    }

    public void drawMenu(Menu menu)
    {
        Graphics graphics = startGraphics();

        graphics.setColor(new Color(0, 0, 0));
        graphics.fillRect(0, 0, 800, 600);
        menu.draw(graphics);

        endGraphics(graphics);
    }

    void drawStageSelector(StageSelector stageSelector)
    {
        Graphics graphics = startGraphics();

        //stageSelector.draw(graphics);
        graphics.drawImage(stageSelector.getImage(), stageSelector.getX(), stageSelector.getY(), frame);
        for (GameObject stageObjects : stageSelector.getStageSelectorObjects())
        {
            graphics.drawImage(stageObjects.getImage(), stageObjects.getX(), stageObjects.getY(), frame);
        }
        graphics.setColor(Color.black);
        graphics.setFont(new Font("sansserif", Font.PLAIN, 25));
        graphics.drawString(stageSelector.getStageName(), 300, 59);
        graphics.drawString(stageSelector.getStageName(), 300, 61);
        graphics.drawString(stageSelector.getStageName(), 299, 60);
        graphics.drawString(stageSelector.getStageName(), 301, 60);

        graphics.setColor(Color.white);
        graphics.setFont(new Font("sansserif", Font.PLAIN, 25));
        graphics.drawString(stageSelector.getStageName(), 300, 60);

        if (debugger)
        {
            for (Node node : stageSelector.getNodes())
            {
                graphics.setColor(Color.red);
                graphics.fillRect(node.getX() - 2, node.getY() - 2, 4, 4);
            }
        }

        endGraphics(graphics);
    }
}
