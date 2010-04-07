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
        frames.put("goombaStandLeft 0", new Rectangle(156, 978, 48, 48));
        frames.put("goombaWalkLeft 0", new Rectangle(35, 978, 50, 48));
        setAnimation(new String[]
                {
                    "goombaStandLeft 0", "goombaWalkLeft 0"

        });
    }

    @Override
    public void hitBy()
    {
        
    }
}
