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
public class Mario extends Character
{
    private boolean left = false;
    private boolean right = false;
    private boolean up = false;
    private boolean down = false;

    public Mario(Game game)
    {

        super(game, 100, 480, 45, 63, "/images/mario_sprite.png");


        frames.put("smallMarioStandRight 0", new Rectangle(627, 0, 42, 60));
        frames.put("smallMarioStandLeft 0", new Rectangle(507, 0, 42, 60));

        frames.put("smallMarioWalkRight 0", new Rectangle(984, 0, 45, 57));
        frames.put("smallMarioWalkRight 1", new Rectangle(627, 0, 42, 60));

        frames.put("smallMarioWalkLeft 0", new Rectangle(150, 0, 45, 57));
        frames.put("smallMarioWalkLeft 1", new Rectangle(507, 0, 42, 60));

        frames.put("smallMarioLookUpLeft 0", new Rectangle(147, 117, 45, 63));
        frames.put("smallMarioLookUpRight 0", new Rectangle(985, 117, 45, 63));

        frames.put("smallMarioDuckLeft 0", new Rectangle(267, 129, 45, 42));
        frames.put("smallMarioDuckRight 0", new Rectangle(864, 129, 45, 42));

        // Big coordinates

        frames.put("bigMarioStandRight 0", new Rectangle(624, 228, 45, 84)); // RIGHT
        frames.put("bigMarioStandLeft 0", new Rectangle(507, 228, 45, 84)); // LEFT

        frames.put("bigMarioWalkRight 0", new Rectangle(1104, 228, 48, 84)); // RIGHT
        frames.put("bigMarioWalkRight 1", new Rectangle(984, 228, 48, 81)); // RIGHT
        frames.put("bigMarioWalkRight 2", new Rectangle(624, 228, 45, 84)); // RIGHT

        frames.put("bigMarioWalkLeft 0", new Rectangle(27, 228, 48, 84)); // LEFT
        frames.put("bigMarioWalkLeft 1", new Rectangle(147, 228, 48, 81)); // LEFT
        frames.put("bigMarioWalkLeft 2", new Rectangle(507, 228, 45, 84)); // LEFT

        frames.put("bigMarioLookUpLeft 0", new Rectangle(387, 588, 85, 81)); // LEFT
        frames.put("bigMarioLookUpRight 0", new Rectangle(744, 588, 85, 81)); // RIGHT

        frames.put("bigMarioDuckLeft 0", new Rectangle(264, 366, 48, 45)); // LEFT
        frames.put("bigMarioDuckRight 0", new Rectangle(864, 366, 48, 45)); // RIGHT

        state = new SmallMario(this);
    }

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

    @Override
    public void doGravity()
    {
        //temp
        setY(getY() - 1);
        //state = new FallState(this);
    }

    @Override
    protected void preAnimation()
    {
        
    }
    
    @Override
    protected void postAnimation()
    {

    }
}
