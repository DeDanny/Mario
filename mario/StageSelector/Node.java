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
    private String stageName = "";

    public Node(int x, int y, boolean end)
    {
        this.x = x;
        this.y = y;
        if(end == true)
        {
            throw new UnsupportedOperationException("If end is true a stage name must be given");
        }
        this.end = end;
    }

    public Node(int x, int y, boolean end, String stageName)
    {
        this.x = x;
        this.y = y;
        this.end = end;
        this.stageName = stageName;
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

    public String getStageName()
    {
        return stageName;
    }

}
