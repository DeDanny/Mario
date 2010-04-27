/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mario.Stages;

import java.util.ArrayList;
import mario.core.StageObject;
import mario.enemy.Goomba;
import mario.enemy.Koopa;
import mario.scenery.Ground;
import mario.scenery.GroundType;

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

    public void addObjects(StageChoose[] stageChooseds)
    {
        if (stageChooseds != null)
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
    }

    private ArrayList<StageObject> compile(StageChoose[] stageChooseds)
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
                case GROUND:
                    mapObjectenList.add(new Ground(stage, 800, 552, 48, 48, GroundType.LEFT));
                    mapObjectenList.add(new Ground(stage, 848, 552, 192, 48, GroundType.MIDDLE));
                    mapObjectenList.add(new Ground(stage, 1040, 552, 48, 48, GroundType.RIGHT));
                    break;
            }
        }
        return mapObjectenList;
    }
}
