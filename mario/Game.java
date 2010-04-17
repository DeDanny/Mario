/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mario;

import mario.core.GameObject;
import mario.background.Background;
import mario.mapObjects.Munt;
import mario.mapObjects.Questionmark;
import mario.mapObjects.Stone;
import mario.mapObjects.Mushroom;
import java.util.ArrayList;
import java.util.Iterator;
import mario.core.MapObject;
import mario.enemy.*;

/**
 *
 * @author danny
 */
public class Game
{
    private boolean running = false;
    private boolean paused = false;
    private Mario mario = new Mario(this,200, 392, 42, 57);
    private Background background = new Background(this);
    private ScoreBalk ScoreBalk = new ScoreBalk(this, 0, 0, 45, 48);
    private ArrayList<GameObject> gameObjects = new ArrayList<GameObject>();
    private ArrayList<MapObject> mapObjects = new ArrayList<MapObject>();

    public Game()
    {
        mapObjects.add(mario);
        mapObjects.add(ScoreBalk);

        mapObjects.add(new Stone(this, 148, 350, 45, 45));
        mapObjects.add(new Stone(this, 194, 350, 45, 45));
        mapObjects.add(new Questionmark(this, 240, 350, 45, 45));
        mapObjects.add(new Stone(this, 286, 350, 45, 45));
        
        mapObjects.add(new Goomba(this, 100, 205, 45, 45));
        mapObjects.add(new Munt(this, 240, 300, 45, 45));
        mapObjects.add(new Mushroom(this, 500, 205, 45, 45));
        mapObjects.add(new Mushroom(this, 550, 205, 45, 45));
        mapObjects.add(new Mushroom(this, 400, 205, 45, 45));
        mapObjects.add(new Mushroom(this, 350, 205, 45, 45));
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

    public Background getBackground()
    {
        return background;
    }

    public ArrayList<MapObject> getMapObjects()
    {
        return mapObjects;
    }

    public void removeDeadObjects()
    {

        for (Iterator<MapObject> it = mapObjects.iterator(); it.hasNext();)
        {
            MapObject mapObject = it.next();
            if (!mapObject.isAlive())
            {
                it.remove();
            }
        }

    }

    public ScoreBalk getScoreBalk()
    {
        return ScoreBalk;
    }
}
