/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor. git
 */
package mario;

import java.awt.Graphics;
import java.awt.Rectangle;
import mario.state.MoveState;

/**
 *
 * @author danny
 */
public class Mario extends GameObject
{
    private boolean left = false;
    private boolean right = false;
    private boolean up = false;
    private boolean down = false;

    public Mario()
    {

        super(100, 100, 14, 21, "/images/smw_mario_sheet.png");

        frames.put("smallMarioStandRight 0", new Rectangle(209, 0, 15, 20));
        frames.put("smallMarioStandLeft 0", new Rectangle(169, 0, 15, 20));

        frames.put("smallMarioWalkRight 0", new Rectangle(209, 0, 15, 20));
        frames.put("smallMarioWalkRight 1", new Rectangle(327, 0, 15, 20));

        frames.put("smallMarioWalkLeft 0", new Rectangle(169, 0, 15, 20));
        frames.put("smallMarioWalkLeft 1", new Rectangle(49, 0, 15, 20));

        frames.put("smallMarioLookUpLeft 0", new Rectangle(49, 39, 15, 21));
        frames.put("smallMarioLookUpRight 0", new Rectangle(329, 39, 15, 21));

        frames.put("smallMarioDuckLeft 0", new Rectangle(89, 39, 15, 21));
        frames.put("smallMarioDuckRight 0", new Rectangle(288, 39, 15, 21));

        state = new MoveState(this);
    }

    @Override
    public void draw(Graphics graphics)
    {
        //BufferedImage subimage = sprite.getSubimage(100, 100, 50, 50);
        //subimage = copyBufferedImage(subimage);

        graphics.drawImage(getImage(), x, y, null);

        //graphics.setColor(Color.red);
        //graphics.fillRect(x, y, 100, 100);// de 100 en 100 moeten nog worden gezet als variablen in de GameObject
        //graphics.drawImage(sprite, x, y, null);
    }

    @Override
    public void doLoopAction()
    {
        state.doAction();
    }

    public boolean isMove()
    {
        return (left||right);
    }

    public boolean isPreformingSpecialMove()
    {
        return (up||down);
    }

    public void setLeft(boolean left)
    {
        this.left = left;
    }

    public void setRight(boolean right)
    {
        this.right = right;
    }

    public void setUp(boolean up)
    {
        this.up = up;
    }

    public void setDown(boolean down)
    {
        this.down = down;
    }

    public boolean isLeft()
    {
        return left;
    }

    public boolean isRight()
    {
        return right;
    }

    public boolean isUp()
    {
        return up;
    }

    public boolean isDown()
    {
        return down;
    }
}
