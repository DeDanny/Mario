/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mario.StageSelector;

import java.awt.Rectangle;
import mario.MarioData;
import mario.core.engine.GameObject;

/**
 *
 * @author danny
 */
public class StageSelectorMario extends GameObject
{
    public StageSelectorMario(int x, int y, int width, int height, MarioData marioData)
    {
        super(x, y, width, height, "/images/mario_sprite.png");
        frames.put("small stand 0", new Rectangle(740, 0, 49, 60));
        setAnimation(new String[] {"small stand 0"});
    }

    @Override
    public void doLoopAction()
    {
        
    }
}
