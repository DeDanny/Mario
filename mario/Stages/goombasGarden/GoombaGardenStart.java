/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mario.Stages.goombasGarden;

import mario.MarioWorld;
import mario.Stages.Map;
import mario.Stages.StageChoose;
import mario.core.Doing;

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
    public GoombaGardenStart(MarioWorld marioWorld, String theme)
    {
        super(marioWorld, theme);
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
