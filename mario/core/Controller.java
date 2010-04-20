/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mario.core;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import mario.MarioWorld;

/**
 *
 * @author Danny
 */
public class Controller implements KeyListener, Runnable, MouseListener
{
    private MarioWorld marioWorld = new MarioWorld();
    private JFrame frame;
    private View view;
    private Thread gameLoop = new Thread(this, "GameLoop");
    private final static int GAMESPEED = 10;
    private long gameTimer = System.currentTimeMillis();
    private CollisionDetector collisionDetector;
    private Menu mainMenu = new MainMenu(marioWorld);
    private Menu pauzeMenu = new PauzeMenu(marioWorld);
    private Menu selectedMenu;

    /**
     *
     */
    public Controller(JFrame frame)
    {
        view = new View(marioWorld, frame);
        this.frame = frame;
        collisionDetector = new CollisionDetector(marioWorld);

        init();

        gameLoop.start();
    }

    private void init()
    {
        frame.addKeyListener(this);
        frame.addMouseListener(this);
    }

    @Override
    public void run()//GameLoop
    {
        while (marioWorld.isRunning())
        {
            if (!marioWorld.getGame().isRunning())
            {
                selectedMenu = mainMenu;
                view.drawMenu(mainMenu);
            }
            else
            {
                if (marioWorld.getGame().isPaused())
                {
                    selectedMenu = pauzeMenu;
                    view.drawMenu(pauzeMenu);
                }
                else
                {
                    if ((System.currentTimeMillis() - gameTimer) > GAMESPEED)
                    {
                        gameTimer = System.currentTimeMillis();
                        //System.out.println("going loop----------------------------------------------------------------");
                        marioWorld.getGame().removeObjects();
                        marioWorld.getGame().getAiDirector().createMapObjects();

                        gameObjectLoopAction();

                        collisionDetector.detectCollisionsGameObjects();

                        view.draw();

                        //System.out.println("end loop----------------------------------------------------------------");
                    }
                }
            }
            try
            {
                Thread.sleep(1);
            } catch (InterruptedException ex)
            {
                Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        SecurityManager security = System.getSecurityManager();
        if (security != null)
        {
            security.checkExit(0);
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
        if (!marioWorld.getGame().isRunning() || marioWorld.getGame().isPaused())
        {
            switch (e.getKeyCode())
            {
                case KeyEvent.VK_UP:
                    selectedMenu.menuUp();
                    break;
                case KeyEvent.VK_DOWN:
                    selectedMenu.menuDown();
                    break;
                case KeyEvent.VK_ENTER:
                    selectedMenu.execute();
                    break;
            }
        }
        else
        {
            switch (e.getKeyCode())
            {
                case KeyEvent.VK_ESCAPE:
                    marioWorld.getGame().setPaused(true);
                    break;
                case KeyEvent.VK_LEFT:
                    marioWorld.getGame().getMario().setLeft(true);
                    break;
                case KeyEvent.VK_RIGHT:
                    marioWorld.getGame().getMario().setRight(true);
                    break;
                case KeyEvent.VK_DOWN:
                    marioWorld.getGame().getMario().setDown(true);
                    break;
                case KeyEvent.VK_SPACE:
                    marioWorld.getGame().getMario().setJump(true);
                    break;
                case KeyEvent.VK_UP:
                    marioWorld.getGame().getMario().setJump(true);
                    break;
            }
        }
        if (e.getKeyCode() == KeyEvent.VK_0)
        {
            marioWorld.setRunning(false);
        }
        if (e.getKeyCode() == KeyEvent.VK_F1)
        {
            JFrame jFrame = new JFrame();
            jFrame.setSize(800, 600);
            jFrame.setLocationRelativeTo(null);
            jFrame.setVisible(true);
        }
    }

    @Override
    public void keyReleased(KeyEvent e)
    {
        switch (e.getKeyCode())
        {
            case KeyEvent.VK_LEFT:
                marioWorld.getGame().getMario().setLeft(false);
                break;
            case KeyEvent.VK_RIGHT:
                marioWorld.getGame().getMario().setRight(false);
                break;
            case KeyEvent.VK_DOWN:
                marioWorld.getGame().getMario().setDown(false);
                break;
        }
    }

    private void gameObjectLoopAction()
    {
        for (MapObject gameObject : marioWorld.getGame().getMapObjects())
        {
            gameObject.doMapCollision();
            gameObject.doLoopAction();
        }
    }

    public void mouseClicked(MouseEvent e)
    {
        System.out.println("mouseClicked");
        System.out.println(e);
    }

    public void mousePressed(MouseEvent e)
    {
        System.out.println("mousePressed");
        System.out.println(e);
    }

    public void mouseReleased(MouseEvent e)
    {
    }

    public void mouseEntered(MouseEvent e)
    {
    }

    public void mouseExited(MouseEvent e)
    {
    }
}
