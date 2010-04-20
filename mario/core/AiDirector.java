/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mario.core;

import java.util.ArrayList;
import java.util.Random;
import mario.Game;
import mario.enemy.Goomba;
import mario.mapObjects.Coin;
import mario.mapObjects.Mushroom;
import mario.mapObjects.Questionmark;
import mario.mapObjects.Stone;
import mario.scenery.Bush;
import mario.scenery.Cloud;
import mario.scenery.Tube;

/**
 * 70% chanch on creating an object
 * 40% Goomba
 * 40% Cube -> 30% questioncube -> 15% mushroom
 * 20% Scenery -> 25% Tube
 *                25% Cloud
 *                25% mountain 1
 *                25% mountain 2
 *
 * @author danny
 */
public class AiDirector
{
    private static final int MAXMAPOBJECTEN = 10;
    private int mapObjectenCount = 0;
    private Game game;
    private int lastXMario;
    private int randomSteps = 30;

    public AiDirector(Game game)
    {
        this.game = game;
    }

    public void createMapObjects()
    {

        if (game.getMario().getStepCounter() > 30)
        {
            //randomSteps = ;
            game.getMario().setStepCounter(0);
            lastXMario = game.getMario().getX();
            ArrayList<MapObject> MapObjects = createObject();
            if (MapObjects != null)
            {
                for (MapObject mapObject : MapObjects)
                {
                    if (mapObjectenCount <= MAXMAPOBJECTEN)
                    {
                        addObject();
                        game.addMapObject(mapObject);
                    }
                }
            }
        }

    }

    public void removeObject()
    {
        mapObjectenCount--;
    }

    public void addObject()
    {
        mapObjectenCount++;
    }

    /**
     * 70% chanch on creating an object
     * 40% Goomba
     * 40% Cube -> 30% questioncube -> 15% mushroom
     * 20% Scenery -> 25% Tube
     *                25% Cloud
     *                25% mountain 1
     *                25% mountain 2
     *
     */
    private ArrayList<MapObject> createObject()
    {
        Random generator = new Random();
        ArrayList<MapObject> mapObjectenList = new ArrayList<MapObject>();

        int countNow = MAXMAPOBJECTEN - mapObjectenCount;

        while (countNow > 0)
        {
            int procent = generator.nextInt(100);

            if (procent < 70)
            {
                procent = generator.nextInt(100);
                if (procent < 40) //create an goobma
                {
                    mapObjectenList.add(new Goomba(game, 900 + (countNow * 96 + 2), 500, 45, 51));
                } else if (procent < 85)
                {
                    if (countNow >= 3)
                    {
                        procent = generator.nextInt(100);

                        if (procent < 70)
                        {
                            mapObjectenList.add(new Stone(game, 850 + (countNow * 45 + 2), 350, 45, 45));
                        } else
                        {
                            procent = generator.nextInt(100);
                            if (!game.getMario().isBig() && procent < 50)
                            {
                                mapObjectenList.add(new Mushroom(game, 850 + (countNow * 45 + 2), 303, 45, 45));
                            } else
                            {
                                mapObjectenList.add(new Coin(game, 850 + (countNow * 45 + 2), 303, 45, 45));
                            }
                            mapObjectenList.add(new Questionmark(game, 850 + (countNow * 45 + 2), 350, 45, 45));
                        }
                    }
                } else
                {
                    procent = generator.nextInt(100);
                    if (procent < 14)
                    {
                        mapObjectenList.add(new Tube(game, 900 + (countNow * 96 + 2), 456, 96, 96));
                    }
                    else
                    {
                        mapObjectenList.add(new Bush(game, 900 + (countNow * 96 + 2), 475, 99, 78));
                    }
                    
                    procent = generator.nextInt(300);
                    mapObjectenList.add(new Cloud(game, 900 + (countNow * 96 + 2 + procent), procent, 96, 48));
                }

            }
            countNow--;
        }

        return mapObjectenList;
    }
}
