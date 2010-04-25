/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mario;

import java.util.HashMap;

/**
 *
 * @author danny
 */
public class MarioData
{
    private boolean big;
    private int coins, lives, node;
    private long points;
    private static MarioData marioData = new MarioData();
    private HashMap<String, Boolean> playableMaps = new HashMap<String, Boolean>();
    //private something with levels so i know which one you can play.

    private MarioData()
    {
        reset();
    }

    public boolean isBig()
    {
        return big;
    }

    public void setBig(boolean big)
    {
        this.big = big;
    }

    public int getCoins()
    {
        return coins;
    }

    public void setCoins(int coins)
    {
        this.coins = coins;
    }

    public int getLives()
    {
        return lives;
    }

    public void setLives(int lives)
    {
        this.lives = lives;
    }

    public static MarioData getMarioData()
    {
        return marioData;
    }

    public long getPoints()
    {
        return points;
    }

    public void setPoints(long points)
    {
        this.points = points;
    }

    public final void reset()
    {
        big = false;
        coins = 0;
        lives = 5;
        points = 0;
        node = 3;
    }

    public int getNode()
    {
        return node;
    }

    public void setNode(int node)
    {
        this.node = node;
    }
}
