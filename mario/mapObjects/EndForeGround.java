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
 *
 * @author danny
 */
public class EndForeGround extends Scenery implements NoClip, ForeGround
{
    public EndForeGround(Stage stage, int x, int y, int width, int height)
    {
        super(stage, x, y, width, height, "/images/finish.png");
        frames.put("pole", new Rectangle(3, 4, 24, 118));
        setAnimation(new String[]
                {
                    "pole"
                });
    }

    @Override
    public void doCharacterCollision(ArrayList<Collision> collisions, StageObject stageObject)
    {
        if(stageObject instanceof StageMario)
        {
            System.out.println("END THE GAME");
            
            stage.getMap().endgame();
        }
    }
}
