/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mario;

import background.Background;
import java.util.ArrayList;
import mario.enemy.Goomba;

/**
 *
 * @author danny
 */
public class Game
{
    private boolean running         = false;
    private boolean paused          = false;

    private Mario mario             = new Mario();
    private Background background   = new Background();
    private Goomba Goomba   = new Goomba();
    private ArrayList<GameObject> gameObjects = new ArrayList<GameObject>();

    public Game()
    {
        gameObjects.add(background);
        gameObjects.add(mario);
        gameObjects.add(Goomba);
    }

    public boolean isRunning()
    {
        return running;
    }

    public void setRunning(boolean running)
    {
        this.running = running;
    }

    public boolean isPaused()
    {
        return paused;
    }

    public void setPaused(boolean paused)
    {
        this.paused = paused;
    }
    
    public ArrayList<GameObject> getGameObjects()
    {
        return gameObjects;
    }

    public Mario getMario()
    {
        return mario;
    }    
}
