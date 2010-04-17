/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mario.core;

import java.util.ArrayList;
import mario.Game;

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
    private static final int MAXMAPOBJECTEN = 15;
    private int mapObjectenCount = 0;
    private Game game;

    public AiDirector(Game game)
    {
        this.game = game;
    }

    public void createObjects()
    {
        ArrayList<MapObject> MapObjects = createObject();
        for (MapObject mapObject : MapObjects)
        {
            if (mapObjectenCount <= MAXMAPOBJECTEN)
            {
                addObject();
                game.addMapObject(mapObject);
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

    private ArrayList<MapObject> createObject()
    {
        Math.random();
        return null;
    }
}
