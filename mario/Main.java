/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mario;

import javax.swing.JFrame;

/**
 *
 * @author Danny
 */
public class Main extends JFrame
{
    private MarioWorld MarioWorld = new MarioWorld();
    private View view;

    public Main()
    {
        setIgnoreRepaint(true);
        //setUndecorated(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        view = new View(MarioWorld, this);
        new Controller(MarioWorld, view, this);
    }

    public static void main(String[] args)
    {
        new Main();
    }
}
