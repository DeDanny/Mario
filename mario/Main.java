 /*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mario;

import javax.swing.JFrame;
import mario.core.Controller;

/**
 *
 * @author Danny
 * 
 */
public class Main extends JFrame
{
    public Main()
    {
        setIgnoreRepaint(true);
        setUndecorated(true);
        setSize(800, 600);
        setLocationRelativeTo(null);
        setTitle("Awesome Mario Remake");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);

        Controller controller = new Controller(this);
    }

    public static void main(String[] args)
    {
        Main main = new Main();
        main.setVisible(true);
    }
}
