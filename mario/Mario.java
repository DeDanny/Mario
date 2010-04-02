/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mario;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import mario.state.MoveState;

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
        super(100, 100, "/images/smw_mario_sheet.png");

        state = new MoveState(this);
        createSprites();
    }

    private void createSprites()
    {
        //sprite = new BufferedImage(209, 0, sprite.getType());
        sprite = sprite.getSubimage(209, 0, 14, 21);
				// Tell the graphics to draw only one block of the image
    }

    public void draw(Graphics graphics)
    {
        //BufferedImage subimage = sprite.getSubimage(100, 100, 50, 50);
        //subimage = copyBufferedImage(subimage);
        
	graphics.drawImage(sprite, x, y, null);

        //graphics.setColor(Color.red);
        //graphics.fillRect(x, y, 100, 100);// de 100 en 100 moeten nog worden gezet als variablen in de GameObject
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