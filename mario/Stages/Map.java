/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mario.Stages;

import java.util.HashMap;

/**
 *
 * @author danny
 */
public abstract class Map
{
    protected String theme;

    protected HashMap<Integer, StageChoose[]> map = new HashMap<Integer, StageChoose[]>();

    public Map(String theme)
    {
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

}
