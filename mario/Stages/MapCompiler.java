/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mario.Stages;

import java.util.ArrayList;
import mario.core.StageObject;
import mario.enemy.Goomba;
import mario.enemy.Koopa;

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

    public void addObject(StageChoose[] stageChooseds)
    {
        ArrayList<StageObject> MapObjects = compile(stageChooseds);
        if (MapObjects != null)
        {
            for (StageObject mapObject : MapObjects)
            {

                stage.addMapObject(mapObject);
            }
        }
    }

    public ArrayList<StageObject> compile(StageChoose[] stageChooseds)
    {
        ArrayList<StageObject> mapObjectenList = new ArrayList<StageObject>();
        for (StageChoose stageChoose : stageChooseds)
        {
            switch (stageChoose)
            {
                case GOOMBA:
                    mapObjectenList.add(new Goomba(stage, 900, 500, 45, 51, 15, 15));
                    break;
                case KOOPA:
                    mapObjectenList.add(new Koopa(stage, 900, 500, 45, 51, 15, 15));
                    break;
            }
        }
        return mapObjectenList;
    }
}
