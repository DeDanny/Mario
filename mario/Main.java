 /*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mario;

import javax.swing.JFrame;
import mario.core.Controller;
import mario.MarioWorld;
import mario.core.View;

/**
 *
 * @author Danny
 * 
 */
public class Main extends JFrame
{
    private MarioWorld MarioWorld = new MarioWorld();
    private View view;

    public Main()
    {
        setIgnoreRepaint(true);
        setUndecorated(true);
        setSize(800, 600);
        setLocationRelativeTo(null);
        setTitle("Awesome Mario Remake");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        view = new View(MarioWorld, this);
        Controller controller = new Controller(MarioWorld, view, this);
        setVisible(true);
    }

    public static void main(String[] args)
    {
        Main main = new Main();
        main.setVisible(true);
    }
}
