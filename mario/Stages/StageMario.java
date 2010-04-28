/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor. git
 */
package mario.Stages;

import mario.core.Direction;
import mario.core.CharacterObject;
import mario.core.Collision;
import java.awt.Rectangle;
import java.util.ArrayList;
import mario.MarioState.*;
import mario.core.StageObject;
import mario.core.interfaces.NoClip;
import mario.enemy.Koopa;
import mario.enemy.Goomba;
import mario.mapObjects.Cube;


/**
 *
 * @author danny
 */
public class StageMario extends CharacterObject implements NoClip
{
    private boolean init = false;
    private boolean left = false;
    private boolean right = false;
    private boolean up = false;
    private boolean down = false;
    private boolean jump = false;
    private boolean jumpExtra = false;
    private boolean grow = false;
    private boolean big = false; // False is SmallMario - True is BigMario
    private boolean dead = false;
    private boolean flowerPower = false;
    private long godModeTimer = System.currentTimeMillis();
    private int godModeTime = 1000;
    private Direction direction = Direction.LEFT;
    private SmallMario smallMario = new SmallMario(this);
    private BigMario bigMario = new BigMario(this);
    private JumpState jumpMario = new JumpState(this);
    private FallState fallMario = new FallState(this);
    private GrowMario growMario = new GrowMario(this);
    private DeadState deadState = new DeadState(this);
    protected int jumpTeller = 1;
    private int stepCounter = 0;

    public StageMario(Stage game, int x, int y, int width, int height)
    {
        super(game, x, y, width, height, "/images/mario_sprite.png");
        //state = new SmallMario(this);
        init();
    }

    @Override
    public void doLoopAction()
    {
        if(init){
            // Do this to change coordinates for Big mario - Normal or Flower
            init();
            init = false;
        }

        checkGap();


        if (dead)
        {
            setState(deadState);
        }
        else
        {
            if (grow)
            {
                setState(growMario);
                ////System.out.println("growMario");
            }
            else
            {
                if (fall)
                {
                    setState(fallMario);
                    //System.out.println("fallMario");
                }
                else
                {
                    if (jump || jumpExtra)
                    {
                        if (this.state != fallMario || jumpExtra)
                        {
                            setState(jumpMario);
                            this.jumpExtra = false;
                            // //System.out.println("jumpMario");
                        }
                        else
                        {
                            this.setJump(false);
                        }
                    }
                    else
                    {
                        if (big)
                        {
                            setState(bigMario);
                            ////System.out.println("bigMario");
                        }
                        else
                        {
                            setState(smallMario);
                            ////System.out.println("smallMario");
                        }
                    }
                }
            }

        }

        state.doAction();
    }

    public void init(){
        
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


        frames.put("deathMario 0", new Rectangle(24, 114, 48, 72)); // Left
        frames.put("deathMario 1", new Rectangle(1104, 114, 48, 72)); // RIGHT

        // Big coordinates
        if(!flowerPower){
            frames.put("bigMarioStandRight 0", new Rectangle(624, 228, 45, 84)); // RIGHT
            frames.put("bigMarioStandLeft 0", new Rectangle(507, 228, 45, 84)); // LEFT

            frames.put("bigMarioWalkRight 0", new Rectangle(1104, 228, 48, 84)); // RIGHT
            frames.put("bigMarioWalkRight 1", new Rectangle(984, 228, 48, 81)); // RIGHT
            frames.put("bigMarioWalkRight 2", new Rectangle(624, 228, 45, 84)); // RIGHT

            frames.put("bigMarioWalkLeft 0", new Rectangle(27, 228, 48, 84)); // LEFT
            frames.put("bigMarioWalkLeft 1", new Rectangle(147, 228, 48, 81)); // LEFT
            frames.put("bigMarioWalkLeft 2", new Rectangle(507, 228, 45, 84)); // LEFT

            //frames.put("bigMarioLookUpLeft 0", new Rectangle(387, 588, 85, 81)); // LEFT
            //frames.put("bigMarioLookUpRight 0", new Rectangle(744, 588, 85, 81)); // RIGHT

            frames.put("bigMarioDuckLeft 0", new Rectangle(264, 366, 48, 45)); // LEFT
            frames.put("bigMarioDuckRight 0", new Rectangle(864, 366, 48, 45)); // RIGHT

            frames.put("bigMarioJumpLeft 0", new Rectangle(504, 342, 48, 93)); // LEFT
            frames.put("bigMarioJumpRight 0", new Rectangle(624, 342, 48, 93)); // RIGHT

            frames.put("bigMarioFallLeft 0", new Rectangle(384, 345, 48, 87)); // LEFT
            frames.put("bigMarioFallRight 0", new Rectangle(744, 345, 48, 87)); // RIGHT

        }else{
            frames.put("bigMarioStandRight 0", new Rectangle(624, 1308, 45, 84)); // RIGHT
            frames.put("bigMarioStandLeft 0", new Rectangle(507, 1308, 45, 84)); // LEFT

            frames.put("bigMarioWalkRight 0", new Rectangle(1104, 1308, 48, 84)); // RIGHT
            frames.put("bigMarioWalkRight 1", new Rectangle(984, 1308, 48, 81)); // RIGHT
            frames.put("bigMarioWalkRight 2", new Rectangle(624, 1308, 45, 84)); // RIGHT

            frames.put("bigMarioWalkLeft 0", new Rectangle(27, 1308, 48, 84)); // LEFT
            frames.put("bigMarioWalkLeft 1", new Rectangle(147, 1308, 48, 81)); // LEFT
            frames.put("bigMarioWalkLeft 2", new Rectangle(507, 1308, 45, 84)); // LEFT

            frames.put("bigMarioDuckLeft 0", new Rectangle(264, 1447, 48, 45)); // LEFT
            frames.put("bigMarioDuckRight 0", new Rectangle(864, 1447, 48, 45)); // RIGHT

            frames.put("bigMarioJumpLeft 0", new Rectangle(504, 1425, 48, 93)); // LEFT
            frames.put("bigMarioJumpRight 0", new Rectangle(624, 1425, 48, 93)); // RIGHT

            frames.put("bigMarioFallLeft 0", new Rectangle(384, 1425, 48, 87)); // LEFT
            frames.put("bigMarioFallRight 0", new Rectangle(744, 1425, 48, 87)); // RIGHT

        }
    }

    public void checkGap(){
        if(getY() >= 552){
            setDead(true);
        }
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
        setDirection(Direction.LEFT);
    }

    public void setRight(boolean right)
    {
        this.right = right;
        setDirection(Direction.RIGHT);
    }

    public void setUp(boolean up)
    {
        this.up = up;
    }

    public void setJump(boolean jump)
    {
        this.jump = jump;
        stage.getSound().playSound("/sound/jump.wav");
    }

    public void setDown(boolean down)
    {
        this.down = down;
    }

    public int getJumpTeller()
    {
        return jumpTeller;
    }

    public void setJumpTeller(int jumpTeller)
    {
        this.jumpTeller = jumpTeller;
    }

    public void setJumpExtra(boolean jumpExtra)
    {
        this.jumpExtra = jumpExtra;
    }

    public boolean isFlowerPower() {
        return flowerPower;
    }

    public void setFlowerPower(boolean flowerPower) {
        this.flowerPower = flowerPower;
    }


    public boolean isInit() {
        return init;
    }

    public void setInit(boolean init) {
        this.init = init;
    }

    public void toggleBig()
    {
        if (this.big)
        {
            if (!this.down)
            {

                setY(getY() + 24);
                setHeight(58);
            }
            this.big = false;

        }
        else
        {
            this.big = true;
        }
    }

    public boolean isDead()
    {
        return dead;
    }

    public void setDead(boolean dead)
    {
        this.dead = dead;
    }

    public boolean isBig()
    {
        return big;
    }

    public boolean isGrow()
    {
        return grow;
    }

    public void setGrow(boolean grow)
    {
        this.grow = grow;
        stage.getSound().playSound("/sound/grow.wav");
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

    public Direction getDirection()
    {
        return direction;
    }

    public void setDirection(Direction direction)
    {
        this.direction = direction;
    }

    @Override
    public void doMapCollision()
    {
        checkCollisionMap();
        if (mapCollision == Collision.NONE && !isJump())
        {
            setFall(true);
        }
        if (mapCollision != Collision.NONE)
        {
            setFall(false);
        }
    }

    /**
     *
     * @todo REFACTOR THE TEMP SOLUTUION
     * @param collisions
     * @param mapObject
     */
    public void doCharacterCollision(ArrayList<Collision> collisions, StageObject mapObject)
    {
        //temp solution
        Collision collision = collisions.get(0);
        //end temp solution


        if ((System.currentTimeMillis() - godModeTimer) > godModeTime)
        {
            if (mapObject instanceof Goomba)
            {
                //System.out.println("collision:" + collision);

                switch (collision)
                {
                    case UP:
                        if (big)
                        {
                            godModeTimer = System.currentTimeMillis();
                            grow = true;
                        }
                        else
                        {
                            if (stage.getScoreBalk().getLives() > 1)
                            {
                                dead = true;
                                stage.getScoreBalk().setLives(stage.getScoreBalk().getLives() - 1);
                                godModeTimer = System.currentTimeMillis();
                            }
                            else
                            {
                                dead = true;
                                stage.getSound().playSound("/sound/dead.wav");
                            }
                        }
                        //System.out.println("MARIO DOOD");
                        break;
                    case DOWN:
                        stage.getSound().playSound("/sound/deadGoomba.wav");
                        setFall(false);
                        jumpExtra = true;
                        jump = true;
                        break;
                }
            }

            if (mapObject instanceof Koopa)
            {
                switch (collision)
                {
                    case UP:
                        Koopa koopa = (Koopa) mapObject;
                        if (!koopa.isShell())
                        {
                            if (big)
                            {
                                godModeTimer = System.currentTimeMillis();
                                grow = true;
                            }
                            else
                            {
                                if (stage.getScoreBalk().getLives() > 1)
                                {
                                    // Go to start of level
                                    dead = true;
                                    stage.getScoreBalk().setLives(stage.getScoreBalk().getLives() - 1);
                                    godModeTimer = System.currentTimeMillis();

                                }
                                else
                                {
                                    // Go to Stage selector
                                    dead = true;
                                    stage.getSound().playSound("/sound/dead.wav");
                                }
                            }
                        }
                        break;
                    case DOWN:
                        stage.getSound().playSound("/sound/deadGoomba.wav");
                        setFall(false);
                        jumpExtra = true;
                        jump = true;
                        break;
                }
            }
        }
        if (mapObject instanceof Cube)
        {
            switch (collision)
            {
                case DOWN:
                    setFall(false);
                    ////System.out.println("-----------------------------------------StageMario Fall state After DOWN @ CUBE");
                    break;
                case UP:
                    setFall(true);
                    jumpTeller = 0;
                    ////System.out.println("-----------------------------------------StageMario Fall state After UP @ CUBE");
                    break;
            }
        }
    }

    public BigMario getBigMario()
    {
        return bigMario;
    }

    public FallState getFallMario()
    {
        return fallMario;
    }

    public int getGodModeTime()
    {
        return godModeTime;
    }

    public long getGodModeTimer()
    {
        return godModeTimer;
    }

    public GrowMario getGrowMario()
    {
        return growMario;
    }

    public boolean isJumpExtra()
    {
        return jumpExtra;
    }

    public JumpState getJumpMario()
    {
        return jumpMario;
    }

    public SmallMario getSmallMario()
    {
        return smallMario;
    }

    public void setBig(boolean big)
    {
        this.big = big;
    }

    public int getStepCounter()
    {
        return stepCounter;
    }

    public void setStepCounter(int stepCounter)
    {
        this.stepCounter = stepCounter;
    }
}
