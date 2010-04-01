/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mario;

import java.awt.GraphicsConfiguration;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import javax.swing.JFrame;

/**
 *
 * @author Danny
 */
public class View
{
    private BufferStrategy buffer;
    private BufferedImage bi;
    private GraphicsDevice gd;
    private JFrame frame;
    private MarioWorld game;

    public View(MarioWorld game, JFrame frame)
    {
        this.frame = frame;
        this.game = game;
        
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        gd = ge.getDefaultScreenDevice();
        GraphicsConfiguration gc = gd.getDefaultConfiguration();
    }
}
