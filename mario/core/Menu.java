/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mario.core;

import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author danny
 */
public abstract class Menu
{
    protected String[] menuItems;
    protected int menuItemsCount;
    protected int selectedItem = 1;

    public Menu(String[] menuItems)
    {
        this.menuItems = menuItems;
        this.menuItemsCount = menuItems.length;
    }

    public void draw(Graphics graphics)
    {
        int y = 600 / 3;
        int i = 1;
        for (String menuItem : menuItems)
        {
            if (i == selectedItem)
            {
                graphics.setColor(Color.red);
                graphics.fillRect(800 / 2 - 75, y + (i * 15)-7, 15, 2);
            }
            graphics.setColor(Color.white);
            graphics.drawString(menuItem, 800 / 2 - 50, y + (i * 15));
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
