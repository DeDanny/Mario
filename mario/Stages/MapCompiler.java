/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mario.Stages;

import java.util.ArrayList;
import mario.core.StageObject;
import mario.enemy.Goomba;

/**
 *
 * @author danny
 */
public class MapCompiler
{
    private Stage stage;

    public MapCompiler(Stage stage)
    {
        this.stage = stage;
    }

    public void compile(StageChoose[] stageChooseds)
    {
        ArrayList<StageObject> mapObjectenList = new ArrayList<StageObject>();
        for (StageChoose stageChoose : stageChooseds)
        {
            switch (stageChoose)
            {
                case GROUND:
                    mapObjectenList.add(new Goomba(stage, 900, 500, 45, 51, 15, 15));
                    break;
            }
        }
    }
}
