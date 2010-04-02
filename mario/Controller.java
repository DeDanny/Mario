/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mario;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;

/**
 *
 * @author Danny
 */
public class Controller implements KeyListener, Runnable
{
    private MarioWorld marioWorld;
    private View view;
    private JFrame frame;
    private Thread gameLoop = new Thread(this);
    private int gameSpeed = 10;

    /**
     *
     * @param marioWorld
     * @param view
     * @param frame
     */
    public Controller(MarioWorld marioWorld, View view, JFrame frame)
    {
        this.marioWorld = marioWorld;
        this.view = view;
        this.frame = frame;

        init();

        gameLoop.start();
    }

    private void init()
    {
        frame.addKeyListener(this);
    }

    
    public void run()//GameLoop
    {
        while (marioWorld.isRunning())
        {
            try
            {

                for (GameObject gameObject : marioWorld.getGame().getGameObjects())
                {
                    gameObject.doLoopAction();
                }

                view.draw();

                System.out.println("going loop");

                Thread.sleep(gameSpeed);
            } catch (InterruptedException ex)
            {
                System.out.println(ex);
            }
        }
        //shutDown();
        System.exit(0);
    }

    @Override
    public void keyTyped(KeyEvent e)
    {
    }

    @Override
    public void keyPressed(KeyEvent e)
    {
        if (e.getKeyCode() == KeyEvent.VK_ESCAPE)
        {
            marioWorld.setRunning(false);
        }

        if (e.getKeyCode() == KeyEvent.VK_LEFT)
        {
            marioWorld.getGame().getMario().setLeft(true);
        }
        if (e.getKeyCode() == KeyEvent.VK_RIGHT)
        {
            marioWorld.getGame().getMario().setRight(true);
        }
        if (e.getKeyCode() == KeyEvent.VK_UP)
        {
        }
        if (e.getKeyCode() == KeyEvent.VK_DOWN)
        {
        }
    }

    @Override
    public void keyReleased(KeyEvent e)
    {
        if (e.getKeyCode() == KeyEvent.VK_LEFT)
        {
            marioWorld.getGame().getMario().setLeft(false);
        }
        if (e.getKeyCode() == KeyEvent.VK_RIGHT)
        {
            marioWorld.getGame().getMario().setRight(false);
        }
        if (e.getKeyCode() == KeyEvent.VK_UP)
        {
        }
        if (e.getKeyCode() == KeyEvent.VK_DOWN)
        {
        }
    }
}

