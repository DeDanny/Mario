/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mario.core;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import javax.imageio.ImageIO;
import mario.Main;

/**
 *
 * @author Danny
 */
public class imagesLoader
{
    private BufferedImage sprite;
    private static HashMap<String, BufferedImage> images = new HashMap<String, BufferedImage>();

    public imagesLoader()
    {
        
    }

    public BufferedImage getImage(String fileName)
    {
        BufferedImage image = images.get(fileName);

        if(image == null)
        {
            loadImage(fileName);
            image = images.get(fileName);
        }

        return image;
    }

    private void loadImage(String[] fileNames)
    {
        for (String fileName : fileNames)
        {
            loadImage(fileName);
        }
    }

    private void loadImage(String fileName)
    {
        URL imageUrl = Main.class.getResource(fileName);
        try
        {
            sprite = ImageIO.read(imageUrl);
            images.put(fileName, sprite);
        } catch (IOException e)
        {
            System.out.println("Error int SpriteLoader/loadImage"
                    + "Error:");
            System.out.println(e);
        }
    }
}
