/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package blokjes;

import java.awt.Rectangle;
import mario.GameObject;

/**
 *
 * @author Nishchal Baldew
 */
public class Questionmark extends GameObject
{
     public Questionmark()
    {
       super(0, 0, 2056, 5641, "/images/nsmbtileset.png");

       frames.put("questionmark 0", new Rectangle(745, 88, 63, 63));
       frames.put("questionmark up 1", new Rectangle(745, 88, 63, 67));

    }
}
