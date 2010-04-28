/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mario.Stages.goombasGarden;

import java.awt.Color;
import mario.MarioWorld;
import mario.Stages.Map;
import mario.Stages.StageChoose;
import mario.scenery.Theme;

/**
 * size of GROUNDLEFT   = 9
 * guiss GROUNDRIGHT    = 9 //?!
 * size of GROUNDMIDDLE = 38
 *
 *
 * @author danny
 */
public class GoombaGardenStart extends Map
{
    public GoombaGardenStart(MarioWorld marioWorld)
    {
        super(marioWorld, Theme.STONE, new Color(107, 136, 255));
        map.put(1, new StageChoose[]
                {
                    StageChoose.GROUNDLEFT, StageChoose.TUBE
                });
        map.put(10, new StageChoose[]
                {
                    StageChoose.GROUNDMIDDLE, StageChoose.GOOMBA
                });
        map.put(48, new StageChoose[]
                {
                    StageChoose.GROUNDMIDDLE
                });
        map.put(49, new StageChoose[]
                {
                    StageChoose.END
                });
        map.put(86, new StageChoose[]
                {
                    StageChoose.GROUNDRIGHT
                });
    }

    @Override
    public void startGame()
    {
        marioWorld.getStage().getMario().setX(100, true);
        marioWorld.getStage().getMario().setY(400, true);
        marioWorld.getStage().getMario().setHeight(60);
        marioWorld.getStage().getMario().setStepCounter(0);
    }

    @Override
    public void endGame()
    {
        //marioWorld.getStage().setMap("yoshi's house end");
        marioWorld.getStage().setMap("yoshi's house");
        disableInpute = false;
        //marioWorld.setWhatcha(Doing.SELECTSTAGE);
    }

    @Override
    public void finishGame()
    {
        marioWorld.getStage().getMario().setRight(false);
        marioWorld.getStage().getMario().setLeft(false);
        marioWorld.getStage().getMario().setDown(false);
        disableInpute = true;
    }
}
