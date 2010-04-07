/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mario.enemy;

import java.awt.Rectangle;



/**
 *
 * @author Danny
 */
public class Goomba extends Enemy{
    
    public Goomba()
    {

        super(300, 100, 66, 66, "/images/smw_enemies_sheet.png");

        frames.put("goombaStandLeft 0", new Rectangle(205, 1301, 66, 66));
        frames.put("goombaWalkLeft 0", new Rectangle(45, 1301, 66, 66));
        setAnimation(new String[]{"goombaStandLeft 0","goombaWalkLeft 0"});
    }



    @Override
    public void doLoopAction()  {  };
    @Override
    public void hitBy() { } };
