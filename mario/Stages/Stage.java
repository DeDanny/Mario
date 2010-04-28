package mario.Stages;

import mario.core.KeyButtons;
import java.util.ArrayList;
import java.util.Iterator;
import mario.MarioWorld;
import mario.Stages.goombasGarden.GoombaGardenEnd;
import mario.Stages.goombasGarden.GoombaGardenStart;
import mario.core.AiDirector;
import mario.core.CollisionDetector;
import mario.core.Direction;
import mario.core.StageObject;
import mario.core.interfaces.ReUse;
import mario.core.engine.Sound;
import mario.enemy.Goomba;
import mario.enemy.Koopa;
import mario.mapObjects.Flower;
import mario.mapObjects.Mushroom;
import mario.mapObjects.Questionmark;
import mario.scenery.Ground;
import mario.scenery.GroundType;
import mario.scenery.Tube;
import mario.weapons.Fireball;

/**
 *
 * @author danny
 */
public class Stage {

    private AiDirector aiDirector = new AiDirector(this);
    private StageMario mario = new StageMario(this, 200, 420, 42, 57);
    private Sound sound = new Sound();
    private MapCompiler mapCompiler = new MapCompiler(this);
    private CollisionDetector collisionDetector = new CollisionDetector(this);
    private Map map;
    private MarioWorld marioWorld;
    private ScoreBalk ScoreBalk = new ScoreBalk(this, 0, 0, 1, 1);
    private ArrayList<StageObject> mapObjects = new ArrayList<StageObject>();
    private boolean resetMap = true;
    private long fireBallTimer = System.currentTimeMillis();
    private int fireBallTime = 500;

    public Stage(MarioWorld marioWorld) {
        this.marioWorld = marioWorld;
        //sound.playSound("/sound/theme.wav");
    }

    public StageMario getMario() {
        return mario;
    }

    public void addMapObject(StageObject mapObject) {
        mapObjects.add(mapObject);
    }

    public ArrayList<StageObject> getMapObjects() {
        return mapObjects;
    }

    public void doLoopAction() {
        if (resetMap) {
            resetMap();
        }

        collisionDetector.detectCollisionsGameObjects();
        removeObjects();
        addObjects();
        for (StageObject stageObject : mapObjects) {
            stageObject.doMapCollision();
            stageObject.doLoopAction();
        }
    }

    public void removeObjects() {
        for (Iterator<StageObject> it = mapObjects.iterator(); it.hasNext();) {
            StageObject mapObject = it.next();
            if (!mapObject.isAlive() || (mapObject.getX() + mapObject.getWidth()) <= 0) //|| ((mapObject.getY() + mapObject.getHeight() )>= 556 && !(mapObject instanceof ReUse)))
            {
                if (mapObject instanceof ReUse) {
                    mapObject.setX(800, true);
                } else {
                    it.remove();
                    aiDirector.removeObject();
                }
            }
        }
    }

    public ScoreBalk getScoreBalk() {
        return ScoreBalk;
    }

    public AiDirector getAiDirector() {
        return aiDirector;
    }

    public Sound getSound() {
        return sound;
    }

    public void handlePressedKeys(ArrayList<KeyButtons> keyPressed) {
        if (!map.isDisableInpute()) {
            boolean setter = true;
            handleKeys(keyPressed, setter);
        }
    }

    public void handleReleasedKeys(ArrayList<KeyButtons> keyPressed) {
        if (!map.isDisableInpute()) {
            boolean setter = false;
            handleKeys(keyPressed, setter);
        }
    }

    private void handleKeys(ArrayList<KeyButtons> keyPressed, boolean setter) {
        if (keyPressed.contains(KeyButtons.LEFT)) {
            mario.setLeft(setter);
        }
        if (keyPressed.contains(KeyButtons.RIGHT)) {
            mario.setRight(setter);
        }
        if (keyPressed.contains(KeyButtons.JUMP)) {
            if (setter == true) {
                mario.setJump(setter);
            }
        }
        if (keyPressed.contains(KeyButtons.DOWN)) {
            mario.setDown(setter);
        }
        if (keyPressed.contains(KeyButtons.SHOOT)) {
            if ((System.currentTimeMillis() - fireBallTimer) > fireBallTime) {
                if (setter == true && mario.isFlowerPower()) {
                    fireBallTimer = System.currentTimeMillis();
                    getMapObjects().add(new Fireball(this, mario.getX() - 2, mario.getY() + 20, 12, 12, mario.getDirection()));
                }
            }
        }
    }

    public void setMap(String stageName) {
        if (stageName.equals("yoshi's house")) {
            map = new GoombaGardenStart(marioWorld);
        }
        if (stageName.equals("yoshi's house end")) {
            map = new GoombaGardenEnd(marioWorld);
        }

        resetMap = true;
    }

    private void resetMap() {
        mapObjects.clear();
        mapObjects.add(mario);
        mapObjects.add(ScoreBalk);

        map.startGame();

        mapObjects.add(new Ground(this, 0, 552, 48, 48, GroundType.LEFT, map.getTheme()));
        mapObjects.add(new Ground(this, 48, 552, 192, 48, GroundType.MIDDLE, map.getTheme()));
        mapObjects.add(new Ground(this, 48 + (192 * 1), 552, 192, 48, GroundType.MIDDLE, map.getTheme()));
        mapObjects.add(new Ground(this, 48 + (192 * 2), 552, 192, 48, GroundType.MIDDLE, map.getTheme()));
        mapObjects.add(new Ground(this, 48 + (192 * 3), 552, 192, 48, GroundType.MIDDLE, map.getTheme()));
        //mapObjects.add(new Ground(this, 240 + (48 * 2), 552, 48, 48, GroundType.RIGHT, map.getTheme()));

        //mapObjects.add(new Ground(this, 300, 552, 48, 48, GroundType.LEFT, map.getTheme()));
        //mapObjects.add(new Ground(this, 348, 552, 192, 48, GroundType.MIDDLE, map.getTheme()));
        //mapObjects.add(new Ground(this, 348 + 192, 552, 192, 48, GroundType.MIDDLE, map.getTheme()));
        //mapObjects.add(new Ground(this, 348 + (192 * 2), 552, 192, 48, GroundType.MIDDLE, map.getTheme()));
       // mapObjects.add(new Ground(this, 348 + (192 * 3), 552, 192, 48, GroundType.MIDDLE, map.getTheme()));
       // mapObjects.add(new Ground(this, 540 + (192 * 3), 552, 48, 48, GroundType.RIGHT, map.getTheme()));

        //mapObjects.add(new Koopa(this, 500, 400, 48, 81));
        //mapObjects.add(new Koopa(this, 400, 400, 48, 81));
        //mapObjects.add(new Goomba(this, 500, 400, 48, 47));
        //mapObjects.add(new Goomba(this, 400, 400, 48, 47));


        //mapObjects.add(new Questionmark(this, 300, 350, 45, 45));
        //mapObjects.add(new Mushroom(this, 300, 303, 45, 45));

        //mapObjects.add(new Questionmark(this, 345, 350, 48, 48));
        //mapObjects.add(new Flower(this, 348, 301, 42, 48));
        //mapObjects.add(new Tube(this, 0, 456, 96, 96));
       

        resetMap = false;
    }

    public Map getMap() {
        return map;
    }

    public void addObjects() {
        StageChoose[] stageChooseds = map.getObjectsByStepCounter(mario.getStepCounter());
        mapCompiler.addObjects(stageChooseds);
    }
}
