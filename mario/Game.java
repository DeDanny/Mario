/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mario;

import mario.background.Background;
import mario.cube.Munt;
import mario.cube.Questionmark;
import mario.cube.Stone;
import mario.cube.Mushroom;
import java.util.ArrayList;
import java.util.Iterator;
import mario.enemy.*;
import mario.ScoreBalk;

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
    private ArrayList<CharacterObject> charactersObjects = new ArrayList<CharacterObject>();

    public Game()
    {
        charactersObjects.add(mario);
        gameObjects.add(Mushroom);
        gameObjects.add(Munt);
        gameObjects.add(Questionmark);
        //charactersObjects.add(new Goomba(this, 300, 505, 45, 45));

        charactersObjects.add(new Goomba(this, 100, 505, 45, 45));
        charactersObjects.add(new Goomba(this, 500, 505, 45, 45));

        //charactersObjects.add(new Goomba(this, 200, 505, 45, 45));
        //charactersObjects.add(new Goomba(this, 500, 505, 45, 45));

        gameObjects.add(Stone);
        gameObjects.add(ScoreBalk);
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

    public ArrayList<CharacterObject> getCharactersObjects()
    {
        return charactersObjects;
    }

    public void removeDeadObjects()
    {

        for (Iterator<CharacterObject> it = charactersObjects.iterator(); it.hasNext();)
        {
            CharacterObject characterObject = it.next();
            if (!characterObject.isAlive())
            {
                it.remove();
            }
        }

    }
}
