/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mario.core;

import java.awt.Color;
import java.awt.Graphics;
import mario.MarioWorld;

/**
 *
 * @author danny
 */
public abstract class Menu
{
    protected String[] menuItems;
    protected int menuItemsCount;
    protected int selectedItem = 1;
    protected MarioWorld marioWorld;
    private static Sprites sprite = new Sprites();

    public Menu(MarioWorld marioWorld, String[] menuItems)
    {
        this.marioWorld = marioWorld;
        this.menuItems = menuItems;
        this.menuItemsCount = menuItems.length;
        sprite.getImage("/images/Help Gamecontrols V0.0.1.png");
    }

    public void draw(Graphics graphics)
    {
        int y = 600 / 3;
        int i = 1;
        graphics.drawImage(sprite.getImage("/images/Help Gamecontrols V0.0.1.png"), 0, 0, null);
        for (String menuItem : menuItems)
        {
            if (i == selectedItem)
            {
                graphics.setColor(Color.red);
                graphics.fillRect(700 - 25, y + (i * 15)-7, 15, 2);
            }
            graphics.setColor(Color.white);
            graphics.drawString(menuItem, 700, y + (i * 15));
            i++;
        }
    }

    public void menuDown()
    {
        selectedItem++;
        if (selectedItem > menuItemsCount)
        {
            selectedItem = 1;
        }
    }

    public void menuUp()
    {
        selectedItem--;
        if (selectedItem < 1)
        {
            selectedItem = menuItemsCount;
        }
    }
    abstract public void execute();
}
