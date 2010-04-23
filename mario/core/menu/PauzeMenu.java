/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mario.core.menu;

import mario.MarioWorld;
import mario.core.Doing;


/**
 *
 * @author danny
 */
public class PauzeMenu extends Menu
{
    public PauzeMenu(MarioWorld marioWorld)
    {
        super(marioWorld, new String[]
                {
                    "Resume Game", "Save Game", "Exit Game"
                });
    }

    public void execute()
    {
       switch(selectedItem)
       {
//            case 1:
//                marioWorld.getGame().setPaused(false);
//            break;
//            case 2:
//                loadAndSave.save(marioWorld.getGame());
//                marioWorld.getGame().setRunning(false);
//                break;
           case 3:
              marioWorld.setWhatcha(Doing.MAIN);
                break;
        }
    }
}
