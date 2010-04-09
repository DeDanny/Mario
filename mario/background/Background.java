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

        mapLayOut.addPoint(0, 552);//
        mapLayOut.addPoint(0, 0);//
        mapLayOut.addPoint(0, 552);//
        

        mapLayOut.addPoint(610, 552); //
        mapLayOut.addPoint(610, 501); //
        mapLayOut.addPoint(604, 501); //
        mapLayOut.addPoint(604, 456); //
        mapLayOut.addPoint(699, 456); //
        mapLayOut.addPoint(699, 501); //
        mapLayOut.addPoint(693, 501); //
        mapLayOut.addPoint(693, 552); //

        mapLayOut.addPoint(800, 552);//
        mapLayOut.addPoint(800, 0);//
        
        mapLayOut.addPoint(800, 600); //
        mapLayOut.addPoint(0, 600); //
        mapLayOut.addPoint(0, 552); //

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
