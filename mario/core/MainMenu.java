/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mario.core;

import mario.Game;
import mario.MarioWorld;
import mario.core.loadAndSave.loadAndSave;


/**
 *
 * @author danny
 */
public class MainMenu extends Menu
{
    MainMenu(MarioWorld marioWorld)
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
                marioWorld.setGame(new Game());
                marioWorld.getGame().setRunning(true);
                break;
            case 2:
                Game game = loadAndSave.load();
                marioWorld.setGame(game);
                marioWorld.getGame().setRunning(true);
                break;
            case 3:
                marioWorld.setRunning(false);
                break;
        }
    }
}
