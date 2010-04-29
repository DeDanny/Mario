/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mario.core.menu;

import mario.MarioWorld;
import mario.core.Doing;
import mario.core.loadAndSave.loadAndSave;


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
                }, "/images/marioPauzeMenu.png");
    }

    public void execute()
    {
       switch(selectedItem)
       {
            case 1:
                marioWorld.setWhatcha(Doing.PLAYING);
            break;
            case 2:
                loadAndSave.save();
                marioWorld.setWhatcha(Doing.SELECTSTAGE);
                break;
           case 3:
              marioWorld.setWhatcha(Doing.MAIN);
                break;
        }
    }
}
