/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mario.Stages;

import java.util.ArrayList;
import mario.core.StageObject;
import mario.enemy.Goomba;
import mario.enemy.Koopa;
import mario.mapObjects.EndBackGround;
import mario.mapObjects.EndForeGround;
import mario.scenery.Ground;
import mario.scenery.GroundType;
import mario.scenery.Theme;

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
                case GROUNDLEFT:
                    mapObjectenList.add(new Ground(stage, 800, 552, 48, 48, GroundType.LEFT, Theme.NORMAL));
                    break;
                case GROUNDMIDDLE:
                    mapObjectenList.add(new Ground(stage, 800, 552, 192, 48, GroundType.MIDDLE, Theme.NORMAL));
                    break;
                case GROUNDRIGHT:
                    mapObjectenList.add(new Ground(stage, 800, 552, 48, 48, GroundType.RIGHT, Theme.NORMAL));
                    break;
                case END:
                    mapObjectenList.add(new EndBackGround(stage, 800, 438, 48, 48));
                    
                    mapObjectenList.add(new EndForeGround(stage, 850, 438, 48, 48));
                    break;
            }
        }
        return mapObjectenList;
    }
}
