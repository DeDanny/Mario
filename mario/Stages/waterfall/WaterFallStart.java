/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mario.Stages.waterfall;

import java.awt.Color;
import mario.MarioWorld;
import mario.Stages.Map;
import mario.Stages.StageChoose;
import mario.core.Doing;
import mario.scenery.Theme;

/**
 * size of GROUNDLEFT   = 9
 * guiss GROUNDRIGHT    = 9 //?!
 * size of GROUNDMIDDLE = 38
 *
 *
 * @author danny
 */
public class WaterFallStart extends Map
{
    public WaterFallStart(MarioWorld marioWorld)
    {
        super(marioWorld, Theme.SNOW, new Color(137, 136, 122), "/sound/background/Swimming.wav");
    }

    @Override
    public void startGame()
    {
        marioWorld.getStage().getMario().setX(100, true);
        marioWorld.getStage().getMario().setY(400, true);
        marioWorld.getStage().getMario().setHeight(60);
        marioWorld.getStage().getMario().setStepCounter(0);
        marioWorld.getStage().getMario().setDead(false);
        marioWorld.getStage().getMario().setFlowerPower(false);
        marioWorld.getStage().getMario().setBig(false);
        putObjects();
    }

    @Override
    public void endGame()
    {
        disableInpute = false;
        marioWorld.getStage().getMario().setLeft(false);
        marioWorld.getStage().getMario().setRight(false);
        marioWorld.getStage().getMario().setDown(false);
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
 private void putObjects() {
        //map.put(12 * 1, new StageChoose[]{StageChoose.GROUNDLEFT, StageChoose.CLOUD, StageChoose.GOOMBA, StageChoose.POWERUP});
        map.put(12 * 1, new StageChoose[]{StageChoose.GROUNDMIDDLE, StageChoose.CLOUD, StageChoose.GOOMBA, StageChoose.POWERUP});
        map.put(12 * 4, new StageChoose[]{StageChoose.GROUNDMIDDLE, StageChoose.CLOUD, StageChoose.COIN});
        map.put(12 * 8, new StageChoose[]{StageChoose.GROUNDMIDDLE});

        map.put(12 * 10, new StageChoose[]{StageChoose.GROUNDMIDDLE, StageChoose.CLOUD});
        map.put(12 * 11, new StageChoose[]{StageChoose.GROUNDMIDDLE});
        map.put(12 * 15, new StageChoose[]{StageChoose.GROUNDMIDDLE, StageChoose.CLOUD, StageChoose.STONE});
        map.put(12 * 19, new StageChoose[]{StageChoose.GROUNDMIDDLE, StageChoose.GOOMBA, StageChoose.BUSH});
        map.put(12 * 23, new StageChoose[]{StageChoose.GROUNDMIDDLE, StageChoose.GOOMBA, StageChoose.CLOUD, StageChoose.STONE});
        map.put(12 * 27, new StageChoose[]{StageChoose.GROUNDRIGHT, StageChoose.GOOMBA, StageChoose.CLOUD});

        map.put(12 * 30, new StageChoose[]{StageChoose.GROUNDLEFT});
        map.put(12 * 31, new StageChoose[]{StageChoose.GROUNDMIDDLE, StageChoose.CLOUD});
        map.put(12 * 35, new StageChoose[]{StageChoose.GROUNDMIDDLE, StageChoose.CLOUD});
        map.put(12 * 39, new StageChoose[]{StageChoose.GROUNDMIDDLE, StageChoose.TUBE});
        map.put(12 * 43, new StageChoose[]{StageChoose.GROUNDMIDDLE, StageChoose.GOOMBA, StageChoose.CLOUD, StageChoose.POWERUP});
        map.put(12 * 47, new StageChoose[]{StageChoose.GROUNDRIGHT, StageChoose.GOOMBA, StageChoose.CLOUD});

        map.put(12 * 48, new StageChoose[]{StageChoose.GROUNDLEFTFLY});
        map.put(12 * 49, new StageChoose[]{StageChoose.GROUNDMIDDLEFLY, StageChoose.CLOUD, StageChoose.COINFLY});
        map.put(12 * 53, new StageChoose[]{StageChoose.GROUNDMIDDLEFLY, StageChoose.CLOUD, StageChoose.POWERUPFLY});
        map.put(12 * 57, new StageChoose[]{StageChoose.GROUNDMIDDLEFLY, StageChoose.COINFLY});
        map.put(12 * 61, new StageChoose[]{StageChoose.GROUNDMIDDLEFLY, StageChoose.CLOUD, StageChoose.COINFLY});
        map.put(12 * 65, new StageChoose[]{StageChoose.GROUNDRIGHTFLY, StageChoose.CLOUD});

        map.put(12 * 68, new StageChoose[]{StageChoose.GROUNDLEFT});
        map.put(12 * 69, new StageChoose[]{StageChoose.GROUNDMIDDLE, StageChoose.CLOUD});
        map.put(12 * 73, new StageChoose[]{StageChoose.GROUNDMIDDLE, StageChoose.TUBE, StageChoose.SMALLMUSSCHROOM});
        map.put(12 * 77, new StageChoose[]{StageChoose.GROUNDMIDDLE});
        map.put(12 * 81, new StageChoose[]{StageChoose.GROUNDMIDDLE, StageChoose.GOOMBA, StageChoose.CLOUD, StageChoose.BUSH, StageChoose.POWERUP});
        map.put(12 * 85, new StageChoose[]{StageChoose.GROUNDRIGHT, StageChoose.GOOMBA, StageChoose.CLOUD});

        map.put(12 * 68, new StageChoose[]{StageChoose.GROUNDLEFT});
        map.put(12 * 69, new StageChoose[]{StageChoose.GROUNDMIDDLE, StageChoose.CLOUD, StageChoose.SMALLMUSSCHROOM});
        map.put(12 * 73, new StageChoose[]{StageChoose.GROUNDMIDDLE, StageChoose.BUSH, StageChoose.STONE});
        map.put(12 * 77, new StageChoose[]{StageChoose.GROUNDMIDDLE, StageChoose.COIN});
        map.put(12 * 81, new StageChoose[]{StageChoose.GROUNDMIDDLE, StageChoose.GOOMBA, StageChoose.COIN, StageChoose.SMALLMUSSCHROOM});
        map.put(12 * 85, new StageChoose[]{StageChoose.GROUNDMIDDLE, StageChoose.KOOPA, StageChoose.COIN});
        map.put(12 * 85, new StageChoose[]{StageChoose.GROUNDMIDDLE, StageChoose.KOOPA, StageChoose.STONE});
        map.put(12 * 89, new StageChoose[]{StageChoose.GROUNDRIGHT, StageChoose.CLOUD});

        map.put(12 * 90, new StageChoose[]{StageChoose.GROUNDLEFT});
        map.put(12 * 91, new StageChoose[]{StageChoose.GROUNDMIDDLE, StageChoose.CLOUD, StageChoose.POWERUP});
        map.put(12 * 95, new StageChoose[]{StageChoose.GROUNDMIDDLE, StageChoose.CLOUD, StageChoose.SMALLMUSSCHROOM});
        map.put(12 * 99, new StageChoose[]{StageChoose.GROUNDMIDDLE});
        map.put(12 * 103, new StageChoose[]{StageChoose.GROUNDMIDDLE, StageChoose.CLOUD, StageChoose.COIN});
        map.put(12 * 107, new StageChoose[]{StageChoose.GROUNDRIGHT, StageChoose.CLOUD});

        map.put(12 * 108, new StageChoose[]{StageChoose.GROUNDLEFT});
        map.put(12 * 109, new StageChoose[]{StageChoose.GROUNDMIDDLE, StageChoose.CLOUD, StageChoose.BUSH});
        map.put(12 * 113, new StageChoose[]{StageChoose.GROUNDMIDDLE, StageChoose.BUSH, StageChoose.POWERUP});
        map.put(12 * 117, new StageChoose[]{StageChoose.GROUNDMIDDLE, StageChoose.COIN, StageChoose.TUBE});
        map.put(12 * 121, new StageChoose[]{StageChoose.GROUNDMIDDLE, StageChoose.GOOMBA, StageChoose.STONE});
        map.put(12 * 125, new StageChoose[]{StageChoose.GROUNDMIDDLE, StageChoose.GOOMBA, StageChoose.COIN});
        map.put(12 * 129, new StageChoose[]{StageChoose.GROUNDMIDDLE, StageChoose.GOOMBA, StageChoose.COIN, StageChoose.SMALLMUSSCHROOM});
        map.put(12 * 133, new StageChoose[]{StageChoose.GROUNDRIGHT, StageChoose.CLOUD});


        map.put(12 * 135, new StageChoose[]{StageChoose.GROUNDLEFT, StageChoose.CLOUD});
        map.put(12 * 136, new StageChoose[]{StageChoose.GROUNDMIDDLE, StageChoose.SMALLMUSSCHROOM});
        map.put(12 * 140, new StageChoose[]{StageChoose.GROUNDMIDDLE, StageChoose.SMALLMUSSCHROOM});
        map.put(12 * 144, new StageChoose[]{StageChoose.GROUNDMIDDLE, StageChoose.SMALLMUSSCHROOM});
        map.put(12 * 148, new StageChoose[]{StageChoose.GROUNDMIDDLE, StageChoose.SMALLMUSSCHROOM});
        map.put(12 * 137, new StageChoose[]{StageChoose.END});
        map.put(12 * 140, new StageChoose[]{StageChoose.NEXTMAP});

    }
}
