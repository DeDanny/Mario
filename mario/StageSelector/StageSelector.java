/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mario.StageSelector;

import java.awt.Rectangle;
import java.util.ArrayList;
import mario.MarioData;
import mario.MarioWorld;
import mario.core.Doing;
import mario.core.KeyButtons;
import mario.core.engine.GameObject;

/**
 *
 * @author danny
 */
public class StageSelector extends GameObject
{
    private MarioData marioData;
    private MarioWorld marioWorld;
    private boolean left = false;
    private boolean right = false;
    private boolean confirm = false;

    public StageSelector(MarioWorld marioWorld, int x, int y, int width, int height, MarioData marioData, String fileName)
    {
        super(x, y, width, height, fileName);
        this.marioData = marioData;
        this.marioWorld = marioWorld;
        frames.put("portal 0", new Rectangle(0, 0, 800, 600));

        setAnimation(new String[]
                {
                    "portal 0"
                });
    }

    @Override
    public void doLoopAction()
    {
        if(confirm == true)
        {
            confirm = false;
            marioWorld.setWhatcha(Doing.PLAYING);
        }
    }

    public void handlePressedKeys(ArrayList<KeyButtons> keyPressed)
    {
        if(keyPressed.contains(KeyButtons.LEFT))
        {
            left = true;
        }
        if(keyPressed.contains(KeyButtons.RIGHT))
        {
            right = true;
        }
        if(keyPressed.contains(KeyButtons.CONFIRM))
        {
            confirm = true;
        }
    }

    public void handleReleasedKeys(ArrayList<KeyButtons> keyReleased)
    {
        if(keyReleased.contains(KeyButtons.LEFT))
        {
            left = false;
        }
        if(keyReleased.contains(KeyButtons.RIGHT))
        {
            right = false;
        }
    }

    /**
     * reset the stage selector
     */
    public void newGame()
    {
    }
}
