/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mario.Stages.goombasGarden;

import java.awt.Color;
import mario.MarioWorld;
import mario.Stages.Map;
import mario.scenery.Theme;

/**
 *
 * @author danny
 */
public class GoombaGardenEnd extends Map
{
    public GoombaGardenEnd(MarioWorld marioWorld)
    {
        super(marioWorld, Theme.NORMAL, new Color(107, 136, 255));
    }

    @Override
    public void startGame()
    {
    }

    @Override
    public void endGame()
    {
    }

    @Override
    public void finishGame()
    {
        
    }
}
