/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mario.core.menu;

import mario.MarioWorld;
import mario.StageSelector.StageSelector;
import mario.core.Doing;


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
                    "New Game", "Deat Match", "Load Game", "Exit"
                });
    }

    public void execute()
    {
        switch(selectedItem)
        {
            case 1:
                marioWorld.newGame();//reset
                marioWorld.setWhatcha(Doing.SELECTSTAGE);
                break;
//            case 2:
//                Stage game = loadAndSave.load();
//                marioWorld.setStage(game);
//                marioWorld.getGame().setRunning(true);
//                break;
            case 4:
                marioWorld.setWhatcha(Doing.EXIT);
                break;
        }
    }
}
