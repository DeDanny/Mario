/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mario.mapObjects;

import java.awt.Rectangle;
import java.util.ArrayList;
import mario.Stages.Stage;
import mario.Stages.StageMario;
import mario.core.Collision;
import mario.core.StageObject;
import mario.core.interfaces.ForeGround;
import mario.core.interfaces.NoClip;
import mario.scenery.Scenery;
/**
 * invisiable object
 * @author danny
 */
public class EndGameObject extends Scenery implements NoClip, ForeGround
{
    public EndGameObject(Stage stage, int x, int y, int width, int height)
    {
        super(stage, x, y, width, height, "/images/finish.png");
        frames.put("nothing", new Rectangle(1, 1, 1, 1));
        setAnimation(new String[]
                {
                    "nothing"
                });
    }

    @Override
    public void doCharacterCollision(ArrayList<Collision> collisions, StageObject stageObject)
    {
        if(stageObject instanceof StageMario)
        {
            stage.getMap().endGame();
        }
    }
}
