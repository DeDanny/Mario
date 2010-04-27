/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mario;

import java.util.ArrayList;
import mario.StageSelector.StageSelector;
import mario.Stages.Stage;
import mario.core.Doing;
import mario.core.KeyButtons;
import mario.core.menu.MainMenu;
import mario.core.menu.Menu;
import mario.core.menu.PauzeMenu;

/**
 *
 * @author danny
 */
public class MarioWorld
{
    private Doing whatcha = Doing.MAIN;
    private MarioData marioData = MarioData.getMarioData();
    private StageSelector stageSelector = new StageSelector(this, 0, 0, 600, 800, marioData, "/images/portal.png");
    private Stage stage = new Stage();
    private Menu mainMenu = new MainMenu(this);
    private Menu pauzeMenu = new PauzeMenu(this);

    public MarioWorld()
    {
    }

    public Stage getStage()
    {
        return stage;
    }

    public void doLoopAction()
    {
        switch (whatcha)
        {
            case PLAYING:
                stage.doLoopAction();
                break;
            case PAUSE:
                //pauzeMenu.doLoopAction();
                break;
            case MAIN:
                //mainMenu.doLoopAction();
                break;
            case SELECTSTAGE:
                stageSelector.doLoopAction();
                break;
        }
    }

    public void passKeyPressed(ArrayList<KeyButtons> keyPressed)
    {
        if (!keyPressed.isEmpty() && keyPressed != null);
        {
            switch (whatcha)
            {
                case PLAYING:
                    stage.handlePressedKeys(keyPressed);
                    break;
                case PAUSE:
                    pauzeMenu.handlePressedKeys(keyPressed);
                    break;
                case MAIN:
                    mainMenu.handlePressedKeys(keyPressed);
                    break;
                case SELECTSTAGE:
                    stageSelector.handlePressedKeys(keyPressed);
                    break;
            }
        }
    }

    public void passKeyReleasedInpute(ArrayList<KeyButtons> keyPressed)
    {
        switch (whatcha)
        {
            case PLAYING:
                stage.handleReleasedKeys(keyPressed);
                break;

            case SELECTSTAGE:
                stageSelector.handleReleasedKeys(keyPressed);
                break;
        }
    }

    public void setStage(Stage stage)
    {
        this.stage = stage;
    }

    public Doing getWhatcha()
    {
        return whatcha;
    }

    public void setWhatcha(Doing whatcha)
    {
        this.whatcha = whatcha;
    }

    public Menu getMainMenu()
    {
        return mainMenu;
    }

    public Menu getPauzeMenu()
    {
        return pauzeMenu;
    }

    public StageSelector getStageSelector()
    {
        return stageSelector;
    }

    public void setStageSelector(StageSelector stageSelector)
    {
        this.stageSelector = stageSelector;
    }

    public void newGame()
    {
        marioData.reset();
    }

    public void setStage(String stageName)
    {
        stage.setStage(stageName);
    }
}
