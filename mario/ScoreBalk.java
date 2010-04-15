/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mario;

import java.awt.Rectangle;
import java.awt.Graphics;
import java.awt.Color;
import mario.*;

/**
 *
 * @author Mike
 */
public class ScoreBalk extends GameObject {

    private int score;
    private int newScore;
//    private String scoreString;
    private int lives = 3;
    private int coins;

     public ScoreBalk(Game game) {
        super(game,0, 0, 45, 48, "/images/nsmbtileset.png");
        frames.put("muntje", new Rectangle(457, 167, 45, 48));
        frames.put("leven", new Rectangle(1338, 2337, 33, 30));
        setAnimation(new String[]{"muntje"});
     }


    @Override
    public void doLoopAction()
    {
        // Verhoog telkens score met 1 (als test).
        score++;
        //Controleerd telkens op nieuwe Score.
        //addScore();
//        scoreString = Integer.toString(score);
    }

     @Override
    public void draw(Graphics graphics)
    {
 
        graphics.setColor(Color.WHITE);
        graphics.drawString("Score: " + score, 10, 20);
        setAnimation(new String[]{"muntje"});
//        graphics.drawImage(getImage(), 50, 5, null);
        graphics.drawString("Coins: " + coins, 110, 20);
        setAnimation(new String[]{"leven"});
//        graphics.drawImage(getImage(), 20, 5, null);
        graphics.drawString("Lives: " + lives, 210, 20);
 
    }

     //Zit in de doLoop zodat altijd de juiste Score aangegeven wordt.
     public void addScore()
     {
         newScore = getScore() + (getCoins() * 100);
     }

     public void addScore(int punten)
     {
         score += punten;
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

        public int getScore()
	{
		return score;
	}

	public void setScore(int score)
	{
		this.score = score;
	}

}
