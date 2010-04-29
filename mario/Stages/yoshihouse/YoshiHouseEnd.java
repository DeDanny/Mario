/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mario.Stages.yoshihouse;

import java.awt.Color;
import mario.MarioWorld;
import mario.Stages.Map;
import mario.scenery.Theme;

/**
 *
 * @author danny
 */
public class YoshiHouseEnd extends Map
{
    public YoshiHouseEnd(MarioWorld marioWorld)
    {
        super(marioWorld, Theme.NORMAL, new Color(107, 136, 255));
    }

    @Override
    public void startGame()
    {
        marioWorld.getStage().getMario().setX(100, true);
        marioWorld.getStage().getMario().setY(0, true);
        //marioWorld.getStage().getMario().setHeight(60);
        marioWorld.getStage().getMario().setStepCounter(0);
        marioWorld.getStage().getMario().setDead(false);
        marioWorld.getStage().getMario().setFlowerPower(false);
        putObjects();
    }

    @Override
    public void endGame()
    {
    }

    @Override
    public void finishGame()
    {
        
    }

    private void putObjects()
    {
        
    }
}
