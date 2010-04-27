/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mario.Stages.goombasGarden;

import mario.Stages.Map;
import mario.Stages.StageChoose;

/**
 *
 * @author danny
 */
public class GoombaGardenStart extends Map
{
    //private int mapGooma[] =
    public GoombaGardenStart(String theme)
    {
        super(theme);
        map = new int[]
                {
                    5, 12
                };
        testMap.put(2, new StageChoose[]
                {
                    StageChoose.GROUND, StageChoose.TUBE
                });
    }

    @Override
    public void startGame()
    {
    }

    @Override
    public void endgame()
    {
    }
}
