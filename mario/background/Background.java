/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mario.background;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;
import java.awt.Rectangle;
import mario.*;

/**
 *
 * @author Onno
 */
public class Background extends GameObject
{
    private Polygon mapLayOut = new Polygon();

    public Background(Game game)
    {
        super(game, 0, 0, 800, 600, "/images/background_gameplay.png");
        frames.put("drawBackground 0", new Rectangle(0, 0, 800, 600));
        setAnimation(new String[]
                {
                    "drawBackground 0"
                });

        mapLayOut.addPoint(0, 552);// left up
        mapLayOut.addPoint(800, 552);//right up
        mapLayOut.addPoint(800, 600);// right down
        mapLayOut.addPoint(0, 600); // left down
    }

    public Polygon getPolygon()
    {
        return mapLayOut;
    }

    @Override
    public void doLoopAction()
    {
    }

    @Override
    public void draw(Graphics graphics)
    {
        super.draw(graphics);
        graphics.setColor(Color.red);
        graphics.drawPolygon(mapLayOut);
    }
}
