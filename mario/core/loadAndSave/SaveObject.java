/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mario.core.loadAndSave;

import java.io.Serializable;
import mario.Stages.Stage;

/**
 *
 * @author Danny
 */
public class SaveObject implements Serializable
{
    private int score;
    private int lives;
    private int coins;
    private int kills;
    private boolean big;

    public SaveObject(Stage game)
    {
        score = game.getScoreBalk().getScore();
        lives = game.getScoreBalk().getLives();
        coins = game.getScoreBalk().getCoins();
        kills = game.getScoreBalk().getKilledEnemys();
        big = game.getMario().isBig();
    }

    public boolean isBig()
    {
        return big;
    }

    public int getCoins()
    {
        return coins;
    }

    public int getKills()
    {
        return kills;
    }

    public int getLives()
    {
        return lives;
    }

    public int getScore()
    {
        return score;
    }
}
