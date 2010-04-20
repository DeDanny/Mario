/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mario.mapObjects;

import java.awt.Rectangle;
import mario.Game;
import mario.core.Collision;
import mario.core.MapObject;
import mario.core.NoClip;

/**
 *
 * @author Nishchal Baldew
 */
public class Coin extends MapObject implements NoClip
{

    private boolean hit = false;
    private boolean changeAni = false;
    private int goinUp;
    private boolean hadCollision = false;
    

    public Coin(Game game, int x, int y, int width, int height)
    {
        super(game, x, y, width, height, "/images/nsmbtileset.png");
        frames.put("munt nothing", new Rectangle(0, 0, 1, 1));
        frames.put("munt 0", new Rectangle(457, 167, 45, 48));
        frames.put("munt 1", new Rectangle(922, 3873, 45, 48));
        frames.put("munt 2", new Rectangle(973, 3872, 45, 48));
        frames.put("munt 3", new Rectangle(1023, 3873, 45, 48));
        setAnimation(new String[]{"munt nothing"});
    }

    @Override
    public void doLoopAction() {
        if(hit)
        {
            doHit();

        }

        if(changeAni){
            setAnimation();
            changeAni = false;
        }
    }

    public void doHit() {

        if (goinUp < 20) {
            setY(getY() - 5);
        }
        else if(goinUp < 40)
        {
            setY(getY() + 5);
        }
        goinUp++;

    }

    public void setAnimation() {
        setAnimation(new String[]{"munt 0", "munt 1", "munt 2", "munt 3"});
    }

    @Override
    public void doCharacterCollision(Collision collision, MapObject mapObject) {
        if (mapObject instanceof mario.Mario) {
            if(hadCollision){
                game.getScoreBalk().addCoin();
                game.getSound().playSound("/sound/Coin.wav");
                setAlive(false);
            }

        }

        if (mapObject instanceof Questionmark) {
            hadCollision = true;
            hit = true;
            changeAni = true;
        }


    }
}


