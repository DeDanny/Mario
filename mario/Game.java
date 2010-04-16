/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mario;

import mario.core.GameObject;
import mario.core.CharacterObject;
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
    private Mario mario = new Mario(this);
    private Background background = new Background(this);
    private Mushroom Mushroom = new Mushroom(this);

    private Munt Munt   = new Munt(this);
    private Questionmark Questionmark   = new Questionmark(this);
    private Stone Stone   = new Stone(this);
    private ScoreBalk ScoreBalk = new ScoreBalk(this);

    private ArrayList<GameObject> gameObjects = new ArrayList<GameObject>();
    private ArrayList<MapObject> mapObjects = new ArrayList<MapObject>();

    public Game()
    {
        mapObjects.add(mario);
        mapObjects.add(Mushroom);
        mapObjects.add(Munt);
        mapObjects.add(Questionmark);

        mapObjects.add(new Goomba(this, 100, 205, 45, 45));
        //mapObjects.add(new Goomba(this, 300, 205, 45, 45));

        mapObjects.add(Stone);
        mapObjects.add(ScoreBalk);
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
}
