/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mario;

import java.awt.Rectangle;
import mario.*;

/**
 *
 * @author Mike
 */
public class ScoreBalk extends GameObject {

    private int score;

     public ScoreBalk(Game game) {
        super(game,0, 0, 45, 48, "/images/nsmbtileset.png");

        frames.put("munt 0", new Rectangle(457, 167, 45, 48));

        setAnimation(new String[]{"munt 0"});
     }

//    @Override
//    public void draw(String scoreString)
//    {
//        scoreString = Integer.toString(score);
//        System.out.println(scoreString);
//    }

    @Override
    public void doLoopAction()
    {
        score = score + 100;
        String scoreString = Integer.toString(score);
        System.out.println("Score: " + scoreString);
    }

 }