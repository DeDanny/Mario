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
import mario.enemy.*;
import mario.ScoreBalk;

/**
 *
 * @author danny
 */
public class Game
{
    private boolean running         = false;
    private boolean paused          = false;



    private Mario mario = new Mario(this);
    private Goomba goomba = new Goomba(this,300, 505, 47, 47);
    private Background background   = new Background(this);
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
        charactersObjects.add(goomba);
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

}
