/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mario.StageSelector;

import java.awt.Rectangle;
import java.util.ArrayList;
import mario.MarioData;
import mario.core.Direction;
import mario.core.engine.GameObject;

/**
 *
 * @author danny
 */
public class StageSelectorMario extends GameObject
{
    private final static int moveSpeed = 2;
    private boolean findPath = false;
    private Direction direction;
    private MarioData marioData;
    private StageSelector stageSelector;
    private boolean left = false;
    private boolean right = false;
    private boolean up = false;
    private boolean down = false;
    private String[] rightAnimation = new String[]
    {
        "smallMarioWalkRight 0", "smallMarioWalkRight 1"
    };
    private String[] leftAnimation = new String[]
    {
        "smallMarioWalkLeft 0", "smallMarioWalkLeft 1"
    };
    private String[] standAnimation = new String[]
    {
        "small stand 0"
    };

    StageSelectorMario(StageSelector stageSelector, int width, int height, MarioData marioData)
    {
        super(stageSelector.getNodes().get(marioData.getNode()).getX() - (width / 2) - 4,// minus 4 for centering the mario (only small tested) do not know why
                (stageSelector.getNodes().get(marioData.getNode()).getY() - height),
                width,
                height,
                "/images/mario_sprite.png");
        this.marioData = marioData;
        this.stageSelector = stageSelector;


        frames.put("small stand 0", new Rectangle(740, 0, 49, 60));
        frames.put("smallMarioWalkRight 0", new Rectangle(984, 0, 45, 57));
        frames.put("smallMarioWalkRight 1", new Rectangle(627, 0, 42, 60));

        frames.put("smallMarioWalkLeft 0", new Rectangle(150, 0, 45, 57));
        frames.put("smallMarioWalkLeft 1", new Rectangle(507, 0, 42, 60));
        frameSpeed = 100;
        setAnimation(standAnimation);
    }

    @Override
    public void doLoopAction()
    {
        if (findPath)
        {
            ArrayList<Node> nodes = stageSelector.getNodes();

            int nodeX = nodes.get(marioData.getNode()).getX();
            int nodeY = nodes.get(marioData.getNode()).getY();

            int halfX = x + (width / 2) + 4; // plus 4 for centering the mario (only small tested) do not know why
            if (nodeX > halfX)
            {
                setAnimation(rightAnimation);
                x += moveSpeed;
            }

            if (nodeX < halfX)
            {
                setAnimation(leftAnimation);
                x -= moveSpeed;
            }

            if (nodeY > y + height)
            {
                y += moveSpeed;
            }

            if (nodeY < y + height)
            {
                y -= moveSpeed;
            }


            if (nodeX == halfX && nodeY == y + height && nodes.get(marioData.getNode()).isEnd())
            {
                findPath = false;
                setAnimation(standAnimation);
            }

            switch (direction)
            {
                case LEFT:
                    if (nodeX == halfX && nodeY == y + height && !nodes.get(marioData.getNode()).isEnd())
                    {
                        moveLeft();
                    }
                    break;
                case RIGHT:

                    if (nodeX == halfX && nodeY == y + height && !nodes.get(marioData.getNode()).isEnd())
                    {
                        moveRight();
                    }
                    break;
                default:
                    setAnimation(standAnimation);
                    break;
            }
        }
    }

    public void findPath(Direction direction)
    {
        this.direction = direction;
    }

    public Direction getDirection()
    {
        return direction;
    }

    public void setDirection(Direction direction)
    {
        this.direction = direction;
    }

    public boolean isDown()
    {
        return down;
    }

    public void setDown(boolean down)
    {
        this.down = down;
    }

    public boolean isFindPath()
    {
        return findPath;
    }

    public void setFindPath(boolean findPath)
    {
        this.findPath = findPath;
    }

    public boolean isLeft()
    {
        return left;
    }

    public void setLeft(boolean left)
    {
        this.left = left;
    }

    public MarioData getMarioData()
    {
        return marioData;
    }

    public void setMarioData(MarioData marioData)
    {
        this.marioData = marioData;
    }

    public boolean isRight()
    {
        return right;
    }

    public void setRight(boolean right)
    {
        this.right = right;
    }

    public boolean isUp()
    {
        return up;
    }

    public void setUp(boolean up)
    {
        this.up = up;
    }

    public void moveLeft()
    {
        if (marioData.getNode() > 0)
        {
            marioData.setNode(marioData.getNode() - 1);
        }
    }

    public void moveRight()
    {
        ArrayList<Node> nodes = stageSelector.getNodes();
        int nodeSize = nodes.size();
        if (marioData.getNode() + 1 < nodeSize)
        {
            marioData.setNode(marioData.getNode() + 1);
        }
    }
}
