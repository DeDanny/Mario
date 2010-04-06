/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package background;

import java.awt.Rectangle;
import mario.GameObject;
/**
 *
 * @author Onno
 */
 public class Background extends GameObject
 {

    public Background ()
    {
        super(0, 0, 800, 600, "/images/background_gameplay.png");
        frames.put("drawBackground 0", new Rectangle(0, 0, 800, 600));
        setAnimation(new String[] {"drawBackground 0"});
    }

   @Override
   public void doLoopAction(){};
 }
