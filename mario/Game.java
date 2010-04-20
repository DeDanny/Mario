package mario;

import mario.background.Background;
import mario.mapObjects.Coin;
import mario.mapObjects.Questionmark;
import mario.mapObjects.Stone;
import mario.mapObjects.Mushroom;
import mario.scenery.Cloud;
import mario.scenery.Tube;
import mario.scenery.Bush;
import java.util.ArrayList;
import java.util.Iterator;
import mario.core.AiDirector;
import mario.core.MapObject;
import mario.core.ReUse;
import mario.core.Sound;

/**
 *
 * @author danny
 */
public class Game
{
    private boolean running = false;
    private boolean paused = false;
    private AiDirector aiDirector = new AiDirector(this);
    private Mario mario = new Mario(this,200, 420, 42, 57);
    private Sound sound = new Sound();

    private Background background = new Background(this, 0, 552, 800,  48);
    private Background background2 = new Background(this, 800, 552, 800,  48);

    private ScoreBalk ScoreBalk = new ScoreBalk(this, 0, 0, 45, 48);
    private ArrayList<MapObject> mapObjects = new ArrayList<MapObject>();

    public Game()
    {
        sound.playSound("/sound/theme.wav");
        mapObjects.add(background);
        mapObjects.add(background2);
        mapObjects.add(new Bush(this, 200, 475, 99, 78));
        mapObjects.add(new Cloud(this, 100, 100, 96, 48));
        mapObjects.add(mario);
        mapObjects.add(ScoreBalk);
        mapObjects.add(new Stone(this, 148, 350, 45, 45));
        mapObjects.add(new Stone(this, 194, 350, 45, 45));
        mapObjects.add(new Questionmark(this, 240, 350, 45, 45));
        mapObjects.add(new Coin(this, 240, 303, 45, 45));

        mapObjects.add(new Questionmark(this, 286, 350, 45, 45));
        mapObjects.add(new Mushroom(this, 286, 303, 45, 45));

        mapObjects.add(new Tube(this, 400, 456, 96, 96));

       //mapObjects.add(new Tube(this, 650, 456, 96, 96));
        
        //mapObjects.add(new Mushroom(this, 350, 205, 45, 45));

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

    public Mario getMario()
    {
        return mario;
    }

    public void addMapObject(MapObject mapObject)
    {
        mapObjects.add(mapObject);
    }

    public Background getBackground()
    {
        return background;
    }

    public ArrayList<MapObject> getMapObjects()
    {
        return mapObjects;
    }

    public void removeObjects()
    {
        for (Iterator<MapObject> it = mapObjects.iterator(); it.hasNext();)
        {
            MapObject mapObject = it.next();
            if (!mapObject.isAlive() || (mapObject.getX() + mapObject.getWidth()) < 0 || mapObject.getX() > 1200)
            {
                if(mapObject instanceof ReUse)
                {
                    mapObject.setX(800);
                }
                else
                {
                    it.remove();
                    aiDirector.removeObject();
                }
            }
        }
    }

    public ScoreBalk getScoreBalk()
    {
        return ScoreBalk;
    }

    public AiDirector getAiDirector()
    {
        return aiDirector;
    }

    public Sound getSound()
    {
        return sound;
    }
}