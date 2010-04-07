/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mario.enemy;

import mario.GameObject;


/**
 *
 * @author Danny
 */
abstract public class Enemy extends GameObject
{

    public Enemy(int x, int y, int width, int height, String fileName)
    {
       super(x, y, width, height, fileName);
    }
    
    @Override
    public abstract void doLoopAction();

    public abstract void hitBy();
}
