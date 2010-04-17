/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mario.core;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import mario.MarioWorld;

/**
 *
 * @author Danny
 */
public class Controller implements KeyListener, Runnable
{
    private MarioWorld marioWorld;
    private View view;
    private JFrame frame;
    private Thread gameLoop = new Thread(this, "GameLoop");
    private final static int GAMESPEED = 10;
    private long gameTimer = System.currentTimeMillis();
    private CollisionDetector collisionDetector;

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
        collisionDetector = new CollisionDetector(marioWorld);

        init();

        gameLoop.start();
    }

    private void init()
    {
        frame.addKeyListener(this);
    }

    @Override
    public void run()//GameLoop
    {
        while (marioWorld.isRunning())
        {
            if ((System.currentTimeMillis() - gameTimer) >  GAMESPEED)
            {
                gameTimer = System.currentTimeMillis();
                System.out.println("going loop----------------------------------------------------------------");

                if (!marioWorld.getGame().isPaused())
                {
                        marioWorld.getGame().removeDeadObjects();


                        gameObjectLoopAction();

                        collisionDetector.detectCollisionsGameObjects();

                        view.draw();

                        System.out.println("end loop----------------------------------------------------------------");
                }
                else
                {
                    //pauze menu
                }
            }

        }
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
            marioWorld.getGame().setPaused(true);
        }

        if (e.getKeyCode() == KeyEvent.VK_LEFT)
        {
            marioWorld.getGame().getMario().setLeft(true);
        }
        if (e.getKeyCode() == KeyEvent.VK_RIGHT)
        {
            marioWorld.getGame().getMario().setRight(true);
        }

//      if (e.getKeyCode() == KeyEvent.VK_UP)
//      {
//          marioWorld.getGame().getMario().setUp(true);
//      }
        if (e.getKeyCode() == KeyEvent.VK_DOWN)
        {
            marioWorld.getGame().getMario().setDown(true);
        }
        if (e.getKeyCode() == KeyEvent.VK_1)
        {
            marioWorld.getGame().getMario().setBig(true);
        }
        if (e.getKeyCode() == KeyEvent.VK_2)
        {
            marioWorld.getGame().getMario().setBig(false);
        }
        if (e.getKeyCode() == KeyEvent.VK_0)
        {
            marioWorld.setRunning(false);
        }
        if (e.getKeyCode() == KeyEvent.VK_3)
        {
            marioWorld.getGame().setPaused(false);
        }
        if (e.getKeyCode() == KeyEvent.VK_SPACE || e.getKeyCode() == KeyEvent.VK_UP)
        {
            marioWorld.getGame().getMario().setJump(true);
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
            marioWorld.getGame().getMario().setUp(false);
        }
        if (e.getKeyCode() == KeyEvent.VK_DOWN)
        {
            marioWorld.getGame().getMario().setDown(false);
        }
    }

    private void gameObjectLoopAction()
    {

        for (MapObject gameObject : marioWorld.getGame().getMapObjects())
        {
            //gameObject.doMapCollision(gameObject.checkCollisionMap());
            gameObject.doMapCollision();
            gameObject.doLoopAction();
        }
    }
}
