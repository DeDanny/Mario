package mario.Stages;

import mario.core.KeyButtons;
import java.util.ArrayList;
import java.util.Iterator;
import mario.Stages.goombasGarden.GoombaGardenStart;
import mario.core.AiDirector;
import mario.core.CollisionDetector;
import mario.core.StageObject;
import mario.core.interfaces.ReUse;
import mario.core.engine.Sound;
import mario.enemy.Goomba;
import mario.enemy.Koopa;
import mario.scenery.Ground;
import mario.scenery.GroundType;
import mario.scenery.Theme;

/**
 *
 * @author danny
 */
public class Stage
{
    private AiDirector aiDirector = new AiDirector(this);
    private StageMario mario = new StageMario(this,200, 420, 42, 57);
    private Sound sound = new Sound();
    private MapCompiler mapCompiler = new MapCompiler(this);
    private CollisionDetector collisionDetector = new CollisionDetector(this);
    private Map map;

    //private Background background = new Background(this, 0, 552, 800,  48);
    //private Background background2 = new Background(this, 800, 552, 800,  48);
    //work around try for bug. With out the 3rt background there where holes in the ground.
    //private Background background3 = new Background(this, 400, 552, 800,  48);


    private ScoreBalk ScoreBalk = new ScoreBalk(this, 0, 0, 45, 48);
    private ArrayList<StageObject> mapObjects = new ArrayList<StageObject>();
    

    public Stage()
    {
        //sound.playSound("/sound/theme.wav");
        //mapObjects.add(background);
        //mapObjects.add(background2);
       
        mapObjects.add(mario);
        mapObjects.add(ScoreBalk);
        
        mapObjects.add(new Ground(this, 0, 552, 48,  48, GroundType.LEFT, Theme.NORMAL));
        mapObjects.add(new Ground(this, 48, 552, 192,  48, GroundType.MIDDLE, Theme.NORMAL));
        mapObjects.add(new Ground(this, 240, 552, 48,  48, GroundType.RIGHT, Theme.NORMAL));

        mapObjects.add(new Ground(this, 300, 552, 48,  48, GroundType.LEFT, Theme.JUNGLE));
        mapObjects.add(new Ground(this, 348, 552, 192,  48, GroundType.MIDDLE, Theme.JUNGLE));
        mapObjects.add(new Ground(this, 348+48, 552, 192,  48, GroundType.MIDDLE, Theme.JUNGLE));
        mapObjects.add(new Ground(this, 348+(48*2), 552, 192,  48, GroundType.MIDDLE, Theme.JUNGLE));
        mapObjects.add(new Ground(this, 348+(48*3), 552, 192,  48, GroundType.MIDDLE, Theme.JUNGLE));
        mapObjects.add(new Ground(this, 540+(48*3), 552, 48,  48, GroundType.RIGHT, Theme.JUNGLE));

        mapObjects.add(new Koopa(this, 330, 400, 48,81));
        mapObjects.add(new Goomba(this, 400, 400, 48, 47));
    }

    public StageMario getMario()
    {
        return mario;
    }

    public void addMapObject(StageObject mapObject)
    {
        mapObjects.add(mapObject);
    }

    public ArrayList<StageObject> getMapObjects()
    {
        return mapObjects;
    }

    public void doLoopAction()
    {
        collisionDetector.detectCollisionsGameObjects();
        removeObjects();
        gameObjectLoopAction();
    }

    public void removeObjects()
    {
        for (Iterator<StageObject> it = mapObjects.iterator(); it.hasNext();)
        {
            StageObject mapObject = it.next();
//            if (!mapObject.isAlive() || (mapObject.getX() + mapObject.getWidth()) <= 0 || ((mapObject.getY() + mapObject.getHeight() )>= 556 && !(mapObject instanceof ReUse)))
//            {
//                if(mapObject instanceof ReUse)
//                {
//                    mapObject.setX(800, true);
//                }
//                else
//                {
//                    it.remove();
//                    aiDirector.removeObject();
//                }
//            }
        }
    }

     private void gameObjectLoopAction()
    {

        addObjects();
        for (StageObject stageObject : mapObjects)
        {
            stageObject.doMapCollision();
            stageObject.doLoopAction();
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

    public void handlePressedKeys(ArrayList<KeyButtons> keyPressed)
    {
        boolean setter = true;
        handleKeys(keyPressed, setter);
        
    }

    public void handleReleasedKeys(ArrayList<KeyButtons> keyPressed)
    {
        boolean setter = false;
        handleKeys(keyPressed, setter);
    }

    private void handleKeys(ArrayList<KeyButtons> keyPressed, boolean setter)
    {
        if(keyPressed.contains(KeyButtons.LEFT))
        {
            mario.setLeft(setter);
        }
        if(keyPressed.contains(KeyButtons.RIGHT))
        {
            mario.setRight(setter);
        }
        if(keyPressed.contains(KeyButtons.JUMP))
        {
            if(setter == true)
            {
                mario.setJump(setter);
            }
        }
        if(keyPressed.contains(KeyButtons.DOWN))
        {
            mario.setDown(setter);
        }
    }

    public void setStage(String stageName)
    {
       if(stageName.equals("yoshi's house"))
       {
                map = new GoombaGardenStart(stageName);
       }
    }

    public void addObjects()
    {
        StageChoose[] stageChooseds = map.getObjectsByStepCounter(mario.getStepCounter());
        mapCompiler.addObjects(stageChooseds);
    }
}