/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mario;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;

/**
 *
 * @author danny
 */
public class gameObjects
{
    protected BufferedImage sprite;

    public gameObjects(String fileName)
    {
        //sprite = loadImage(fileName);
    }

    private BufferedImage loadImage(String fileName)
    {
        URL imageUrl = Main.class.getResource(fileName);

        try
        {
            sprite = ImageIO.read(imageUrl);
        } catch (IOException e)
        {
        }
        return sprite;
    }
}
