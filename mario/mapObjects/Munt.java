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
public class Munt extends MapObject implements NoClip
{

    private boolean raak = true;
    private int goinUp = 0;

    public Munt(Game game) {
        super(game,100, 350, 44, 48, "/images/nsmbtileset.png");

        frames.put("munt 0", new Rectangle(457, 167, 45, 48));

        setAnimation(new String[]{"munt 0"});

        frames.put("munt 1", new Rectangle(922, 3873, 45, 48));
        frames.put("munt 2", new Rectangle(973, 3872, 45, 48));
        frames.put("munt 3", new Rectangle(1023, 3873, 45, 48));
        setAnimation(new String[]{"munt 0", "munt 1", "munt 2", "munt 3"});
    }

    @Override
    public void doLoopAction() {
        doHit();
    }

    public void doHit(){
            if(goinUp < 20 && raak)
            {
                setY(getY() - 5);
                goinUp++;

            }
            else
            {
                raak = false;
            }
        }

    @Override
    public void doCharacterCollision(Collision collision, MapObject mapObject)
    {
        if(mapObject instanceof mario.Mario)
        {
            game.getScoreBalk().addCoin();
            setAlive(false);
        }
    }
    }


