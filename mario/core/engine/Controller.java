/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mario.core.engine;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import mario.MarioWorld;
import mario.core.CollisionDetector;
import mario.core.Doing;
import mario.core.KeyButtons;

/**
 *
 * @author Danny
 */
public class Controller implements KeyListener, Runnable
{
    private MarioWorld marioWorld = new MarioWorld();
    private JFrame frame;
    private View view;
    private Thread gameLoop = new Thread(this, "GameLoop");
    private final static int GAMESPEED = 10;
    private long gameTimer = System.currentTimeMillis();
    ////old trying to remove.
    private CollisionDetector collisionDetector;

    /**
     *
     * @param frame
     * @param debugger 
     */
    public Controller(JFrame frame, boolean debugger)
    {
        view = new View(frame, debugger);
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
        while (marioWorld.getWhatcha() != Doing.EXIT)
        {
            if ((System.currentTimeMillis() - gameTimer) > GAMESPEED)
            {
                marioWorld.doLoopAction();
                switch (marioWorld.getWhatcha())//doing
                {
                    case PLAYING:
                        view.drawStage(marioWorld.getStage());
                        break;
                    case MAIN:
                        view.drawMenu(marioWorld.getMainMenu());
                        break;
                    case PAUSE:
                        view.drawMenu(marioWorld.getPauzeMenu());
                        break;
                    case SELECTSTAGE:
                        view.drawStageSelector(marioWorld.getStageSelector());
                        break;
                }

// <editor-fold defaultstate="collapsed" desc="commented code from old code. Usable for referense">
//                if (!marioWorld.getGame().isRunning())
//                {
//                    selectedMenu = mainMenu;
//                    view.drawMenu(mainMenu);
//                }
//                else
//                {
//                    if (marioWorld.getGame().isPaused())
//                    {
//                        selectedMenu = pauzeMenu;
//                        view.drawMenu(pauzeMenu);
//                    }
//                    else
//                    {
//
//                        gameTimer = System.currentTimeMillis();
//                        ////System.out.println("going loop----------------------------------------------------------------");
//                        marioWorld.getGame().removeObjects();
//                        marioWorld.getGame().getAiDirector().createMapObjects();
//
//                        gameObjectLoopAction();
//
//                        collisionDetector.detectCollisionsGameObjects();
//
//                        view.draw();
//
//                        ////System.out.println("end loop----------------------------------------------------------------");
//                    }
//                }// </editor-fold>
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
        /**
         * special quik shutdown
         */
        if (e.getKeyCode() == KeyEvent.VK_0)
        {
            marioWorld.setWhatcha(Doing.EXIT);
        }
        
        checkKeys(e);
        marioWorld.passKeyPressed(checkKeys(e));
        
    }

    @Override
    public void keyReleased(KeyEvent e)
    {
        marioWorld.passKeyReleasedInpute(checkKeys(e));
    }

    private ArrayList<KeyButtons> checkKeys(KeyEvent e)
    {
        ArrayList<KeyButtons> keyPressed = new ArrayList<KeyButtons>();
        if (e.getKeyCode() == KeyEvent.VK_UP)
        {
            keyPressed.add(KeyButtons.UP);
        }
        if (e.getKeyCode() == KeyEvent.VK_DOWN)
        {
            keyPressed.add(KeyButtons.DOWN);
        }
        if (e.getKeyCode() == KeyEvent.VK_LEFT)
        {
            keyPressed.add(KeyButtons.LEFT);
        }
        if (e.getKeyCode() == KeyEvent.VK_RIGHT)
        {
            keyPressed.add(KeyButtons.RIGHT);
        }
        if (e.getKeyCode() == KeyEvent.VK_SPACE)
        {
            keyPressed.add(KeyButtons.JUMP);
        }
        if (e.getKeyCode() == KeyEvent.VK_ENTER)
        {
            keyPressed.add(KeyButtons.CONFIRM);
        }
        if (e.getKeyCode() == KeyEvent.VK_ESCAPE)
        {
            keyPressed.add(KeyButtons.ESCAPE);
        }
        return keyPressed;
    }

   
}
