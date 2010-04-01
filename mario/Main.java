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
    private MarioWorld game = new MarioWorld();
    private View view;
    private Controller ctl;

    public Main()
    {
        setIgnoreRepaint(true);
        //setUndecorated(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        view = new View(game, this);
        ctl = new Controller(game, view, this);
    }

    public static void main(String[] args)
    {
        new Main();
    }
}
