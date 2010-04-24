/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mario.StageSelector;

/**
 *
 * @author Danny
 */
public class Node {
    private int x, y;
    private boolean end;

    public Node(int x, int y, boolean end)
    {
        this.x = x;
        this.y = y;
        this.end = end;
    }

    public boolean isEnd()
    {
        return end;
    }

    public int getX()
    {
        return x;
    }

    public int getY()
    {
        return y;
    }
}
