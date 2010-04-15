/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mario;

import java.awt.Rectangle;

/**
 *
 * @author Danny
 */
public class CollisionDetector
{
    private MarioWorld marioWorld;

    public CollisionDetector(MarioWorld marioWorld)
    {
        this.marioWorld = marioWorld;
    }

    public void detectCollisionsGameObjects()
    {
        for (CharacterObject characterObject : marioWorld.getGame().getCharactersObjects())
        {
            if (characterObject.isAlive())
            {
                for (CharacterObject characterObjectLoop : marioWorld.getGame().getCharactersObjects())
                {
                    if (characterObject != characterObjectLoop && characterObjectLoop.isAlive())
                    {
                        int y_last = characterObject.getYLast();
                        int height_last = characterObject.getHeightLast();

                        int x = characterObject.getX();
                        int y = characterObject.getY();
                        int width = characterObject.getWidth();
                        int height = characterObject.getHeight();

                        int xOthere = characterObjectLoop.getX();
                        int yOthere = characterObjectLoop.getY();
                        int widthOthere = characterObjectLoop.getWidth();
                        int heightOthere = characterObjectLoop.getHeight();

                        Rectangle object = new Rectangle(x, y, width, height);
                        Rectangle othereObject = new Rectangle(xOthere, yOthere, widthOthere, heightOthere);
                        if (object.intersects(othereObject))
                        {
                            if ((y_last + height_last) < yOthere)
                            {
                                characterObject.doCharacterCollision(Collision.DOWN, characterObjectLoop);
                                characterObjectLoop.doCharacterCollision(Collision.UP, characterObject);
                            } else
                            {
                                characterObject.doCharacterCollision(Collision.SIDE, characterObjectLoop);
                                characterObjectLoop.doCharacterCollision(Collision.SIDE, characterObject);
                            }
                        }
                    }
                }
            }

        }

    }
//    public Collision checkCollisionGameCharacters()
//    {
//         for (CharacterObject characterObjectLoop : game.getCharactersObjects())
//        {
//             characterObject = characterObjectLoop;
//             if(characterObject != this)
//             {
//                System.out.println(this.getClass());
//                Rectangle characterObjectRectangle =  new Rectangle(characterObject.getX(), characterObject.getY(), characterObject.getWidth(), characterObject.getHeight());
//                System.out.println(characterObject.getClass() + " : " +characterObject.getX()+ " . " +characterObject.getY()+ " . " +characterObject.getWidth()+ " . " +characterObject.getHeight());
//                System.out.println(x+ " . " + (y+height-1) + " . " + width+ " . " + 4);
//                System.out.println(x+ " . " + (y-1) + " . " + 1+ " . " + height);
//                System.out.println((x+width)+ " . " + (y-1) + " . " + 1+ " . " + height);
//                System.out.println((x-1)+ " . " + (y+1) + " . " + width + " . " + 2);
//                if (characterObjectRectangle.intersects(x, y+height-1, width, 4))
//                {
//                     System.out.println(Collision.DOWN);
//                    return Collision.DOWN;
//                }
//
//                if (characterObjectRectangle.intersects(x, y-1, 1, height) ||
//                     characterObjectRectangle.intersects(x+width, y-1, 1, height))
//                {
//                     System.out.println(Collision.SIDE);
//                    return Collision.SIDE;
//                }
//
//                if (characterObjectRectangle.intersects(x-1, y+1, width, 2))
//                {
//                     System.out.println(Collision.UP);
//                    return Collision.UP;
//                }
//             }
//        }
//
//        return Collision.NONE;
//    }
//                        if((xOthere + (widthOthere/2)) > (x + (width/2)))
//                        {
//                            xdirection = Direction.LEFT;
//                        }
//                        else if((xOthere + (widthOthere/2)) < (x + (width/2)))
//                        {
//                            xdirection = Direction.RIGHT;
//                        }else
//                        {
//                            xdirection = Direction.MIDDLE;
//                        }
//
//                        if((yOthere + (heightOthere/2)) > (y + (height/2)))
//                        {
//                            ydirection = Direction.LEFT;
//                        }
//                        else if((yOthere + (heightOthere/2)) < (x + (height/2)))
//                        {
//                            ydirection = Direction.RIGHT;
//                        }else
//                        {
//                            ydirection = Direction.MIDDLE;
//                        }
}
