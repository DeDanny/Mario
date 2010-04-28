/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mario.Stages;

import java.util.HashMap;
import mario.MarioWorld;

/**
 *
 * @author danny
 */
public abstract class Map
{
    protected String theme;
    protected MarioWorld marioWorld;
    protected boolean disableInpute = false;

    protected HashMap<Integer, StageChoose[]> map = new HashMap<Integer, StageChoose[]>();

    public Map(MarioWorld marioWorld, String theme)
    {
        this.marioWorld = marioWorld;
        this.theme = theme;
    }

    public StageChoose[] getObjectsByStepCounter(int steps)
    {
        StageChoose[] stageChoose = new StageChoose[]{};
        stageChoose = map.get(steps);
        return stageChoose;
    }

    public abstract void startGame();

    public abstract void endgame();

    public abstract void finishgame();

}
