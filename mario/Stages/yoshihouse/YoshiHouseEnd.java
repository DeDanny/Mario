/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mario.Stages.yoshihouse;

import java.awt.Color;
import mario.MarioWorld;
import mario.Stages.Map;
import mario.Stages.StageChoose;
import mario.core.Doing;
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
        disableInpute = false;
        marioWorld.setWhatcha(Doing.SELECTSTAGE);
    }

    @Override
    public void finishGame()
    {
        marioWorld.getStage().getMario().setLeft(false);
        marioWorld.getStage().getMario().setRight(true);
        marioWorld.getStage().getMario().setDown(false);
        disableInpute = true;
    }

    private void putObjects()
    {
        map.put(12 * 3, new StageChoose[]{StageChoose.GROUNDLEFT});
        map.put(12 * 4, new StageChoose[]{StageChoose.GROUNDMIDDLE});
        map.put(12 * 8, new StageChoose[]{StageChoose.GROUNDRIGHT});
        map.put(12 * 4 + 50, new StageChoose[]{StageChoose.END});
        map.put(12 * 4 + 115, new StageChoose[]{StageChoose.NEXTMAP});
    }
}
