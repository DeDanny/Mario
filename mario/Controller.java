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
public class Controller implements Runnable, KeyListener
{
    private MarioWorld marioWorld;
    private View view;
    private JFrame frame;
    private Thread gameLoop = new Thread();

    public Controller(MarioWorld game, View view, JFrame frame)
    {
        this.marioWorld = game;
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
        while (marioWorld.isApplicationRunning())
        {
            try
            {
                if (!marioWorld.isGameRunning())
                {
                    //showPauseMenu();
                }
                else if (marioWorld.isPaused())
                {
                    //showMainMenu();
                }
                else
                {
                    //Do GAME
                }


                System.out.println("going loop");

                Thread.sleep(1000);
            } catch (InterruptedException ex)
            {
                System.out.println(ex);
            }
        }
        //shutDown();
        System.exit(0);
    }

    public void keyTyped(KeyEvent e)
    {
    }

    public void keyPressed(KeyEvent e)
    {
        if (e.getKeyCode() == KeyEvent.VK_ESCAPE)
        {
            marioWorld.setApplicationRunning(false);
        }

        if (e.getKeyCode() == KeyEvent.VK_LEFT)
        {
            marioWorld.getMario().setLeft(true);
        }
        if (e.getKeyCode() == KeyEvent.VK_RIGHT)
        {
            marioWorld.getMario().setRight(true);
        }
        if (e.getKeyCode() == KeyEvent.VK_UP)
        {
            marioWorld.getMario().setUp(true);
        }
        if (e.getKeyCode() == KeyEvent.VK_DOWN)
        {
            marioWorld.getMario().setDown(true);
        }
    }

    public void keyReleased(KeyEvent e)
    {
        if (e.getKeyCode() == KeyEvent.VK_LEFT)
        {
            marioWorld.getMario().setLeft(false);
        }
        if (e.getKeyCode() == KeyEvent.VK_RIGHT)
        {
            marioWorld.getMario().setRight(false);
        }
        if (e.getKeyCode() == KeyEvent.VK_UP)
        {
            marioWorld.getMario().setUp(false);
        }
        if (e.getKeyCode() == KeyEvent.VK_DOWN)
        {
            marioWorld.getMario().setDown(false);
        }
    }
}
