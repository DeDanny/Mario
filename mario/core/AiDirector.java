/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mario.core;

import java.util.ArrayList;
import java.util.Random;
import mario.Game;
import mario.enemy.Goomba;

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

    public AiDirector(Game game)
    {
        this.game = game;
    }

    public void createMapObjects()
    {
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

            if (procent > 70)
            {
                procent = generator.nextInt(100);
                if (procent < 40) //create an goobma
                {
                    mapObjectenList.add(new Goomba(game, 600, 205, 45, 51));
                    mapObjectenList.add(new Goomba(game, 500, 205, 45, 51));
                    mapObjectenList.add(new Goomba(game, 400, 205, 45, 51));
                }
                else if (procent < 80)
                {
                    if (countNow >= 3)
                    {
                        //mapObjectenList.add(new Stone(game, 650, 350, 45, 45));
                        // mapObjectenList.add(new Stone(game, 650 + 45, 350, 45, 45));
                        // mapObjectenList.add(new Stone(game, 650 + (45 * 2), 350, 45, 45));
                        countNow -= 3;
                    }
                }
                else
                {
                    // mapObjectenList.add(new Goomba(game, procent, procent, procent, procent));
                }

            }
            countNow--;
        }

        return mapObjectenList;
    }
}
