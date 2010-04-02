/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mario;

import java.awt.Color;
import java.awt.Graphics;
import mario.state.MoveState;
import mario.state.normal;

/**
 *
 * @author danny
 */
public class Mario extends GameObject
{
    private boolean left = false;
    private boolean right = false;

    public Mario()
    {
        super(100, 100, "smw_mario_sheet.png");

        state = new MoveState(this);
    }

    public void draw(Graphics graphics)
    {
        //BufferedImage subimage = sprite.getSubimage(100, 100, 50, 50);
        //subimage = copyBufferedImage(subimage);
        System.out.println("can you touch me? Yes you just did.");
        graphics.setColor(Color.red);
        graphics.fillRect(x, y, 100, 100);
        //graphics.drawImage(sprite, x, y, null);
    }

    public void doLoopAction()
    {
        state.doAction();
    }

    public void setLeft(boolean left)
    {
        this.left = left;
    }

    public void setRight(boolean right)
    {
        this.right = right;
    }

    public boolean isLeft()
    {
        return left;
    }

    public boolean isRight()
    {
        return right;
    }
}