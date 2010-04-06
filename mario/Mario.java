/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor. git
 */
package mario;

import java.awt.Rectangle;
import mario.state.*;

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

        frames.put("smallMarioStandRight 0", new Rectangle(802, 0, 60, 80));
        frames.put("smallMarioStandLeft 0", new Rectangle(642, 0, 60, 80));

        frames.put("smallMarioWalkRight 0", new Rectangle(802, 0, 60, 80));
        frames.put("smallMarioWalkRight 1", new Rectangle(1278, 0, 60, 80));

        frames.put("smallMarioWalkLeft 0", new Rectangle(642, 0, 60, 80));
        frames.put("smallMarioWalkLeft 1", new Rectangle(162, 0, 60, 80));

        frames.put("smallMarioLookUpLeft 0", new Rectangle(162, 152, 64, 88));
        frames.put("smallMarioLookUpRight 0", new Rectangle(1278, 154, 64, 88));

        frames.put("smallMarioDuckLeft 0", new Rectangle(322, 170, 64, 59));
        frames.put("smallMarioDuckRight 0", new Rectangle(118, 43, 64, 59));

        // Big coordinates

        frames.put("bigMarioStandRight 0", new Rectangle(209, 76, 15, 28)); // RIGHT
        frames.put("bigMarioStandLeft 0", new Rectangle(169, 76, 15, 28)); // LEFT

        frames.put("bigMarioWalkRight 0", new Rectangle(368, 76, 16, 28)); // RIGHT
        frames.put("bigMarioWalkRight 1", new Rectangle(328, 76, 16, 27)); // RIGHT

        frames.put("bigMarioWalkLeft 0", new Rectangle(8, 76, 15, 28)); // LEFT
        frames.put("bigMarioWalkLeft 1", new Rectangle(48, 76, 15, 27)); // LEFT

        frames.put("bigMarioLookUpLeft 0", new Rectangle(129, 196, 15, 27)); // LEFT
        frames.put("bigMarioLookUpRight 0", new Rectangle(248, 196, 15, 27)); // RIGHT

        frames.put("bigMarioDuckLeft 0", new Rectangle(88, 122, 16, 15)); // LEFT
        frames.put("bigMarioDuckRight 0", new Rectangle(288, 122, 16, 15)); // RIGHT

        state = new SmallMario(this);
    }
    /*
    @Override
    public void draw(Graphics graphics)
    {
    //BufferedImage subimage = sprite.getSubimage(100, 100, 50, 50);
    //subimage = copyBufferedImage(subimage);



    //graphics.setColor(Color.red);
    //graphics.fillRect(x, y, 100, 100);// de 100 en 100 moeten nog worden gezet als variablen in de GameObject
    //graphics.drawImage(sprite, x, y, null);
    }
     */

    @Override
    public void doLoopAction()
    {
        state.doAction();
    }

    public boolean isMove()
    {
        return (left || right);
    }

    public boolean isPreformingSpecialMove()
    {
        return (up || down);
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

    public void setJump()
    {
        state = new JumpState(this);
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

    public void setState(MarioState state)
    {
        this.state = state;
    }
}
