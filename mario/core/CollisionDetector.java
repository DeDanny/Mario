/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mario.core;

import java.awt.Rectangle;
import java.util.ArrayList;
import mario.Stages.Stage;

/**
 *
 * @author Danny
 */
public class CollisionDetector
{
    private Stage stage;

    public CollisionDetector(Stage stage)
    {
        this.stage = stage;
    }

    public void detectCollisionsGameObjects()
    {
        for (StageObject characterObject : stage.getMapObjects())
        {
            if (characterObject.isAlive())
            {
                for (StageObject characterObjectLoop : stage.getMapObjects())
                {
                    if (characterObject != characterObjectLoop && characterObjectLoop.isAlive())
                    {
                        int x_last = characterObject.getXLast();
                        int y_last = characterObject.getYLast();
                        int heightl = characterObject.getHeight();
                        int widthl = characterObject.getWidth();

                        int x = characterObject.getX() + 1;
                        int y = characterObject.getY() + 1;
                        int width = characterObject.getWidth();
                        int height = characterObject.getHeight();

                        if (heightl == 0)
                        {
                            heightl = height;
                        }

                        int xOthere = characterObjectLoop.getX();
                        int yOthere = characterObjectLoop.getY();
                        int widthOthere = characterObjectLoop.getWidth();
                        int heightOthere = characterObjectLoop.getHeight();

                        Rectangle object = new Rectangle(x, y, width, height);
                        Rectangle othereObject = new Rectangle(xOthere, yOthere, widthOthere, heightOthere);
                        if (object.intersects(othereObject))
                        {

                            ArrayList<Collision> collisionsCharacter = new ArrayList<Collision>();
                            ArrayList<Collision> collisionsCharacterLoop = new ArrayList<Collision>();

                            if ((y_last + heightl) < yOthere)
                            {
                                collisionsCharacter.add(Collision.DOWN);
                                collisionsCharacterLoop.add(Collision.UP);
                            }
                            else
                            {
                                collisionsCharacter.add(Collision.UP);
                                collisionsCharacterLoop.add(Collision.DOWN);
                            }

                            if((x_last + widthl) < xOthere)
                            {
                                collisionsCharacter.add(Collision.LEFT);
                                collisionsCharacterLoop.add(Collision.RIGHT);
                            }
                            else 
                            {
                                collisionsCharacter.add(Collision.RIGHT);
                                collisionsCharacterLoop.add(Collision.LEFT);
                            }

                            characterObject.doCharacterCollision(collisionsCharacter, characterObjectLoop);
                            characterObjectLoop.doCharacterCollision(collisionsCharacterLoop, characterObject);
                        }
                    }
                }
            }
        }
    }
}
