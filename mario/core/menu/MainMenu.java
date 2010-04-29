/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mario.core.menu;

import mario.MarioData;
import mario.MarioWorld;
import mario.core.Doing;
import mario.core.loadAndSave.loadAndSave;


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
                    "New Game", "Load Game", "Exit"
                }, "/images/marioMainMenu.png");
    }

    public void execute()
    {
        switch(selectedItem)
        {
            case 1:
                marioWorld.newGame();//reset
                marioWorld.setWhatcha(Doing.SELECTSTAGE);
                break;
            case 2:
                MarioData marioData = loadAndSave.load();
                marioWorld.setMarioData(marioData);
                marioWorld.setWhatcha(Doing.SELECTSTAGE);
                break;
            case 3:
                marioWorld.setWhatcha(Doing.EXIT);
                break;
        }
    }
}
