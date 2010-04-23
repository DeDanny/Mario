/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mario;

/**
 *
 * @author danny
 */
public class MarioData
{
    private boolean big;
    private int coins;
    private int lives;
    private long points;
    private static MarioData marioData = new MarioData();
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

    public void reset()
    {
        big = false;
        coins = 0;
        lives = 5;
        points = 0;
    }
}
