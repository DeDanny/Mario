/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mario.Stages;

import java.awt.Color;
import java.util.ArrayList;
import java.util.HashMap;
import mario.MarioWorld;
import mario.core.Node;
import mario.scenery.Theme;

/**
 *
 * @author danny
 */
public abstract class Map
{
    protected Theme theme;
    protected MarioWorld marioWorld;
    protected boolean disableInpute = false;
    protected HashMap<Integer, StageChoose[]> map = new HashMap<Integer, StageChoose[]>();
    protected ArrayList<Node> nodes;
    private Color color;

    public Map(MarioWorld marioWorld, Theme theme, Color color)
    {
        this.marioWorld = marioWorld;
        this.theme = theme;
        this.color = color;
    }

    public StageChoose[] getObjectsByStepCounter(int steps)
    {
        StageChoose[] stageChoose = new StageChoose[]
        {
        };
        stageChoose = map.get(steps);
        return stageChoose;
    }

    public abstract void startGame();

    public abstract void endgame();

    public abstract void finishgame();

    public boolean isDisableInpute()
    {
        return disableInpute;
    }

    public Color getBackgroundColor()
    {
        return color;
    }
}
