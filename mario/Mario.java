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
public class Mario extends GameCharacter
{
    private boolean left = false;
    private boolean right = false;
    private boolean up = false;
    private boolean down = false;
    private boolean jump = false;
    private boolean isBig = false;
    private boolean fall = false;
    private SmallMario smallMario = new SmallMario(this);
    private BigMario bigMario = new BigMario(this);
    private JumpState jumpMario = new JumpState(this);
    private FallState fallMario = new FallState(this);
    private int moveY = 0;
    

    public Mario(Game game)
    {
        super(game, 100, 480, 42, 57, "/images/mario_sprite.png");

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

        frames.put("smallMarioJumpLeft 0", new Rectangle(504, 117, 48, 66));
        frames.put("smallMarioJumpRight 0", new Rectangle(624, 117, 48, 66));

        frames.put("smallMarioFallLeft 0", new Rectangle(384, 120, 48, 60));
        frames.put("smallMarioFallRight 0", new Rectangle(744, 120, 48, 60));

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

        frames.put("bigMarioJumpLeft 0", new Rectangle(504, 342, 48, 93)); // LEFT
        frames.put("bigMarioJumpRight 0", new Rectangle(624, 342, 48, 93)); // RIGHT

        frames.put("bigMarioFallLeft 0", new Rectangle(384, 345, 48, 87)); // LEFT
        frames.put("bigMarioFallRight 0", new Rectangle(744, 345, 48, 87)); // RIGHT

        state = new SmallMario(this);
    }

    @Override
    public void doLoopAction()
    {
        if(jump)
        {   
            setState(jumpMario);
            System.out.println("jumpMario");
        }
        else if(fall)
        {
            setState(fallMario);
            System.out.println("fallMario");
        }
        else
        {
            if(isBig)
            {
                setState(bigMario);
            System.out.println("bigMario");
            }
            else
            {
                setState(smallMario);
            System.out.println("smallMario");
            }
        }
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

    public void setJump(boolean jump)
    {
        this.jump = jump;
    }

    public void setFall(boolean fall)
    {
        this.fall = fall;
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

    public boolean isJump()
    {
        return jump;
    }
    public boolean isFall()
    {
        return fall;
    }

    @Override
    public void doCollision(Collision side)
    {
        System.out.print(side);
        if (side  == Collision.NONE)
        {
            setFall(true);
        }
        if(side != Collision.NONE)
        {
            setFall(false);
        }
    }

    @Override
    protected void preAnimation()
    {
        setY(getY()+moveY);   
    }
    
    @Override
    protected void postAnimation()
    {
        setY(getY()-moveY);
    }

    public void setMoveY(int moveY){
        this.moveY = moveY;
    }
}
