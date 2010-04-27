/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mario.core;

import java.awt.Rectangle;
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
                        int y_last = characterObject.getYLast();
                        int heightl = characterObject.getHeight();

                        int x = characterObject.getX() + 1;
                        int y = characterObject.getY() + 1;
                        int width = characterObject.getWidth();
                        int height = characterObject.getHeight() + 1;

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
                            if ((y_last + heightl) < yOthere)
                            {
                                characterObject.doCharacterCollision(Collision.DOWN, characterObjectLoop);
                                characterObjectLoop.doCharacterCollision(Collision.UP, characterObject);
                            }
                            else
                            {
                                characterObject.doCharacterCollision(Collision.UP, characterObjectLoop);
                                characterObjectLoop.doCharacterCollision(Collision.DOWN, characterObject);
                            }
                        }
                    }
                }
            }
        }
    }
}
