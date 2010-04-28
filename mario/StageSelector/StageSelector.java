/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mario.StageSelector;

import java.awt.Rectangle;
import java.util.ArrayList;
import mario.MarioData;
import mario.MarioWorld;
import mario.core.Direction;
import mario.core.Doing;
import mario.core.KeyButtons;
import mario.core.StageSelectNode;
import mario.core.engine.GameObject;
import mario.core.engine.Sound;

/**
 *
 * @author danny
 */
public class StageSelector extends GameObject
{
    private MarioData marioData;
    private MarioWorld marioWorld;
    private Sound sound = new Sound();
    private boolean left = false;
    private boolean right = false;
    private boolean confirm = false;
    private boolean up = false;
    private boolean down = false;
    private StageSelectorMario stageSelectorMario;
    private ArrayList<GameObject> StageSelectorObjects = new ArrayList<GameObject>();
    private ArrayList<StageSelectNode> nodes = new ArrayList<StageSelectNode>();

    public StageSelector(MarioWorld marioWorld, int x, int y, int width, int height, MarioData marioData, String fileName)
    {
        super(x, y, width, height, fileName);
        this.marioData = marioData;
        this.marioWorld = marioWorld;
        sound.playBackGround("/sound/background/Yoster Island.wav");
        nodes.add(new StageSelectNode(240, 490, true, "Waterfall World"));
        nodes.add(new StageSelectNode(280, 490, false));
        nodes.add(new StageSelectNode(350, 458, false));
        nodes.add(new StageSelectNode(386, 458, true, "yoshi's house"));
        nodes.add(new StageSelectNode(422, 458, false));
        nodes.add(new StageSelectNode(492, 490, false));
        nodes.add(new StageSelectNode(532, 490, true, "Goomba's garden"));
        stageSelectorMario = new StageSelectorMario(this, 50, 60, marioData);
        
        frames.put("portal 0", new Rectangle(0, 0, 800, 600));

        setAnimation(new String[]
                {
                    "portal 0"
                });
        StageSelectorObjects.add(stageSelectorMario);

        
    }

    @Override
    public void doLoopAction()
    {
        for(GameObject gameObject : StageSelectorObjects)
        {
            gameObject.doLoopAction();
        }
        if (!stageSelectorMario.isFindPath())
        {
            if (confirm == true)
            {
                marioWorld.setStage(nodes.get(marioData.getNode()).getStageName());
                confirm = false;
                
                marioWorld.setWhatcha(Doing.PLAYING);
            }
            if (left == true)
            {
                stageSelectorMario.setFindPath(true);
                stageSelectorMario.setDirection(Direction.LEFT);
                stageSelectorMario.moveLeft();
                
            }
            if (right == true)
            {
                stageSelectorMario.setFindPath(true);
                stageSelectorMario.setDirection(Direction.RIGHT);
                stageSelectorMario.moveRight();
            }

            if (up == true)
            {
                stageSelectorMario.setFindPath(true);
                stageSelectorMario.setDirection(Direction.UP);
            }
            if (down == true)
            {
                stageSelectorMario.setFindPath(true);
                stageSelectorMario.setDirection(Direction.DOWN);
            }
        }
    }

    public void handlePressedKeys(ArrayList<KeyButtons> keyPressed)
    {
        if (keyPressed.contains(KeyButtons.LEFT))
        {
            left = true;
        }
        if (keyPressed.contains(KeyButtons.RIGHT))
        {
            right = true;
        }
        if (keyPressed.contains(KeyButtons.UP))
        {
            up = true;
        }
        if (keyPressed.contains(KeyButtons.DOWN))
        {
            down = true;
        }
        if (keyPressed.contains(KeyButtons.CONFIRM))
        {
            confirm = true;
        }
    }

    public void handleReleasedKeys(ArrayList<KeyButtons> keyReleased)
    {
        if (keyReleased.contains(KeyButtons.LEFT))
        {
            left = false;
        }
        if (keyReleased.contains(KeyButtons.RIGHT))
        {
            right = false;
        }
        if (keyReleased.contains(KeyButtons.UP))
        {
            up = false;
        }
        if (keyReleased.contains(KeyButtons.DOWN))
        {
            down = false;
        }
        if (keyReleased.contains(KeyButtons.CONFIRM))
        {
            confirm = false;
        }
    }

    /**
     * reset the stage selector
     */
    public void newGame()
    {
        marioData.reset();
    }

    public ArrayList<GameObject> getStageSelectorObjects()
    {
        return StageSelectorObjects;
    }

    public ArrayList<StageSelectNode> getNodes()
    {
        return nodes;
    }

    public String getStageName()
    {
        return nodes.get(marioData.getNode()).getStageName();
    }
}
