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
        map.put(1, new StageChoose[]
                {
                    StageChoose.GROUNDLEFT, StageChoose.TUBE
                });
        map.put(10, new StageChoose[]
                {
                    StageChoose.GROUNDMIDDLE
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
        
    }

    @Override
    public void endgame()
    {
        //marioWorld.getStage().setMap("yoshi's house end");
        marioWorld.getStage().setMap("yoshi's house");
        disableInpute = false;
        //marioWorld.setWhatcha(Doing.SELECTSTAGE);
    }

    @Override
    public void finishgame()
    {
        disableInpute = true;
    }
}
