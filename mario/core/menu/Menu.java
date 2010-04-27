/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mario.core.menu;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import mario.MarioWorld;
import mario.core.KeyButtons;
import mario.core.Sprites;

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
        sprite.getImage("/images/marioMainMenu.png");
    }

    public void draw(Graphics graphics)
    {
        int y = 1000 / 3;
        int i = 1;
        graphics.drawImage(sprite.getImage("/images/marioMainMenu.png"), 0, 0, null);
        for (String menuItem : menuItems)
        {
            if (i == selectedItem)
            {
                graphics.setColor(Color.red);
                graphics.fillRect(300, y + (i * 37), 15, 2);
            }
            graphics.setColor(Color.white);
            //graphics.drawString(menuItem, 700, y + (i * 35));
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

    public void handlePressedKeys(ArrayList<KeyButtons> keyPressed)
    {
        if(keyPressed.contains(KeyButtons.DOWN))
        {
            menuDown();
        }
        if(keyPressed.contains(KeyButtons.UP))
        {
            menuUp();
        }
        if(keyPressed.contains(KeyButtons.CONFIRM))
        {
            execute();
        }
    }
}
