/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mario.Stages;

import java.util.ArrayList;
import mario.core.StageObject;
import mario.enemy.Goomba;
import mario.enemy.Koopa;
import mario.mapObjects.Coin;
import mario.mapObjects.EndBackGround;
import mario.mapObjects.EndForeGround;
import mario.mapObjects.Stone;
import mario.scenery.Bush;
import mario.scenery.Cloud;
import mario.scenery.Ground;
import mario.scenery.GroundType;
import mario.scenery.SmallShrooms;
import mario.scenery.Tube;

/**
 *
 * @author danny
 */
public class MapCompiler {

    private Stage stage;

    public MapCompiler(Stage stage) {
        this.stage = stage;
    }

    public void addObjects(StageChoose[] stageChooseds) {
        if (stageChooseds != null) {
            ArrayList<StageObject> MapObjects = compile(stageChooseds);
            if (MapObjects != null) {
                for (StageObject mapObject : MapObjects) {

                    stage.addMapObject(mapObject);
                }
            }
        }
    }

    private ArrayList<StageObject> compile(StageChoose[] stageChooseds) {
        ArrayList<StageObject> mapObjectenList = new ArrayList<StageObject>();
        for (StageChoose stageChoose : stageChooseds) {
            switch (stageChoose) {
                case GOOMBA:
                    mapObjectenList.add(new Goomba(stage, 900, 500, 35, 40, 4, 6));
                    break;
                case KOOPA:
                    mapObjectenList.add(new Koopa(stage, 900, 500, 45, 51, 15, 15));
                    break;
                case GROUNDLEFT:
                    mapObjectenList.add(new Ground(stage, 800, 552, 48, 48, GroundType.LEFT, stage.getMap().getTheme()));
                    break;
                case GROUNDMIDDLE:
                    mapObjectenList.add(new Ground(stage, 800, 552, 192, 48, GroundType.MIDDLE, stage.getMap().getTheme()));
                    break;
                case GROUNDRIGHT:
                    mapObjectenList.add(new Ground(stage, 800, 552, 48, 48, GroundType.RIGHT, stage.getMap().getTheme()));
                    break;
                case CLOUD:
                    mapObjectenList.add(new Cloud(stage, 800, 200, 0, 0));
                    break;
                case COIN:
                    mapObjectenList.add(new Coin(stage, 900, 303, 45, 45));
                    break;
                case POWERUP:
                    // IF STATEMENT FOR WICH POWERUP
                    //mapObjectenList.add(new Cloud(stage, 800, 552, 48, 48, GroundType.RIGHT, stage.getMap().getTheme()));
                    break;
                case STONE:
                    mapObjectenList.add(new Stone(stage, 900, 350, 45, 45));
                    break;
                case TUBE:
                    mapObjectenList.add(new Tube(stage, 900, 456, 96, 96));
                    break;
                case SMALLMUSSCHROOM:
                    mapObjectenList.add(new SmallShrooms(stage, 900, 516, 96, 36));
                    break;
                case BUSH:
                    mapObjectenList.add(new Bush(stage, 900, 475, 99, 78));
                    break;
                case END:
                    mapObjectenList.add(new EndBackGround(stage, 800, 438, 0, 0));

                    mapObjectenList.add(new EndForeGround(stage, 850, 438, 80, 118, 20, 0));
                    break;
            }
        }
        return mapObjectenList;
    }
}
