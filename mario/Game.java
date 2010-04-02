/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mario;

import java.util.ArrayList;

/**
 *
 * @author danny
 */
public class Game
{
    private boolean running = false;
    private Mario mario = new Mario();
    private ArrayList<GameObject> gameObjects = new ArrayList<GameObject>();

    public Game()
    {
        gameObjects.add(mario);
    }

    public boolean isRunning()
    {
        return running;
    }

    public void setRunning(boolean running)
    {
        this.running = running;
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
