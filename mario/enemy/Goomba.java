/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mario.enemy;

import java.awt.Rectangle;
import mario.enemy.ai.GoombaAi;

/**
 *
 * @author Danny
 */
public class Goomba extends Enemy
{

    public Goomba()
    {
        super(300, 100, 66, 66, "/images/smw_enemies_sheet.png");
        ai = new GoombaAi(this);
        frames.put("goombaStand 0", new Rectangle(205, 1301, 66, 66));
        frames.put("goombaWalk 0", new Rectangle(45, 1301, 66, 66));
        setAnimation(new String[]
                {
                    "goombaStand 0", "goombaWalk 0"

        });
    }

    @Override
    public void hitBy()
    {
        
    }
}
