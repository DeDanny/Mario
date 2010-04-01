/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mario;

import javax.swing.JPanel;

/**
 *
 * @author Danny
 */
public class Game extends JPanel
{
    private Mario mario = new Mario();
    public Game()
    {
        requestFocus(true);
    }

    public void gameLoop()
    {
        
    }    
}