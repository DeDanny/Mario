/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mario.core;

import mario.MarioWorld;

/**
 *
 * @author danny
 */
public class MainMenu extends Menu
{
    public MainMenu(MarioWorld marioWorld)
    {
        super(marioWorld, new String[]
                {
                    "New Game", "Load Game", "Exit Game"
                });
    }

    public void execute()
    {
        switch(selectedItem)
        {
            case 1:
                marioWorld.getGame().setRunning(true);
                break;
            case 2:
                //marioWorld.getGame().setRunning(true);
                break;
            case 3:
                marioWorld.setRunning(false);
                break;
        }
    }
}
