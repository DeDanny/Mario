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
        super(marioWorld, Theme.NORMAL, new Color(107, 136, 255));
        // ALWAYS PUT TOGETHER
        // TUBE - GROUNDMIDDLE

        //map.put(38 * 1, new StageChoose[]{StageChoose.GROUNDLEFT});
        //map.put(38 * 2, new StageChoose[]{StageChoose.GROUNDMIDDLE});
        //map.put(38 * 3, new StageChoose[]{StageChoose.GROUNDRIGHT});


        map.put(12 * 3, new StageChoose[]{StageChoose.GROUNDLEFT, StageChoose.CLOUD});
        map.put(12 * 4, new StageChoose[]{StageChoose.GROUNDMIDDLE, StageChoose.CLOUD, StageChoose.BUSH});
        map.put(12 * 8, new StageChoose[]{StageChoose.GROUNDRIGHT});

        map.put(12 * 10, new StageChoose[]{StageChoose.GROUNDLEFT, StageChoose.CLOUD});
        map.put(12 * 11, new StageChoose[]{StageChoose.GROUNDMIDDLE});
        map.put(12 * 15, new StageChoose[]{StageChoose.GROUNDMIDDLE, StageChoose.CLOUD, StageChoose.BUSH});
        map.put(12 * 19, new StageChoose[]{StageChoose.GROUNDMIDDLE, StageChoose.GOOMBA});
        map.put(12 * 23, new StageChoose[]{StageChoose.GROUNDMIDDLE, StageChoose.GOOMBA, StageChoose.CLOUD});
        map.put(12 * 27, new StageChoose[]{StageChoose.GROUNDRIGHT, StageChoose.GOOMBA, StageChoose.CLOUD});

        map.put(12 * 30, new StageChoose[]{StageChoose.GROUNDLEFT});
        map.put(12 * 31, new StageChoose[]{StageChoose.GROUNDMIDDLE, StageChoose.CLOUD});
        map.put(12 * 35, new StageChoose[]{StageChoose.GROUNDMIDDLE, StageChoose.TUBE, StageChoose.CLOUD});
        map.put(12 * 39, new StageChoose[]{StageChoose.GROUNDMIDDLE});
        map.put(12 * 43, new StageChoose[]{StageChoose.GROUNDMIDDLE, StageChoose.GOOMBA, StageChoose.CLOUD, StageChoose.POWERUP});
        map.put(12 * 47, new StageChoose[]{StageChoose.GROUNDRIGHT, StageChoose.GOOMBA, StageChoose.CLOUD});

        map.put(12 * 50, new StageChoose[]{StageChoose.GROUNDLEFT});
        map.put(12 * 51, new StageChoose[]{StageChoose.GROUNDMIDDLE, StageChoose.CLOUD});
        map.put(12 * 55, new StageChoose[]{StageChoose.GROUNDMIDDLE, StageChoose.TUBE, StageChoose.CLOUD, StageChoose.BUSH});
        map.put(12 * 59, new StageChoose[]{StageChoose.GROUNDMIDDLE});
        map.put(12 * 63, new StageChoose[]{StageChoose.GROUNDMIDDLE, StageChoose.GOOMBA, StageChoose.CLOUD, StageChoose.BUSH, StageChoose.POWERUP});
        map.put(12 * 67, new StageChoose[]{StageChoose.GROUNDRIGHT, StageChoose.GOOMBA, StageChoose.CLOUD});

        map.put(12 * 70, new StageChoose[]{StageChoose.GROUNDLEFT});
        map.put(12 * 71, new StageChoose[]{StageChoose.GROUNDMIDDLE, StageChoose.CLOUD});
        map.put(12 * 75, new StageChoose[]{StageChoose.GROUNDMIDDLE, StageChoose.TUBE, StageChoose.CLOUD});
        map.put(12 * 79, new StageChoose[]{StageChoose.GROUNDMIDDLE});
        map.put(12 * 83, new StageChoose[]{StageChoose.GROUNDMIDDLE, StageChoose.GOOMBA, StageChoose.CLOUD, StageChoose.BUSH , StageChoose.POWERUP});
        map.put(12 * 87, new StageChoose[]{StageChoose.GROUNDRIGHT, StageChoose.GOOMBA, StageChoose.CLOUD});





        map.put(49, new StageChoose[]
                {
                    //StageChoose.END
                });
        map.put(86, new StageChoose[]
                {
                   // StageChoose.GROUNDRIGHT
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
        marioWorld.getStage().getMario().setLeft(false);
        marioWorld.getStage().getMario().setRight(false);
        marioWorld.getStage().getMario().setDown(false);
        disableInpute = true;
    }
}
