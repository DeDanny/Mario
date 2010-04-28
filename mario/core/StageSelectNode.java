/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mario.core;

/**
 *
 * @author danny
 */
public class StageSelectNode extends Node{

    private boolean end;
    private String stageName = "";

    public StageSelectNode(int x, int y, boolean end)
    {
        super(x,y);
        if(end == true)
        {
            throw new UnsupportedOperationException("If end is true a stage name must be given");
        }
        this.end = end;
    }

    public StageSelectNode(int x, int y, boolean end, String stageName)
    {
        super(x,y);
        this.end = end;
        this.stageName = stageName;
    }

    public boolean isEnd()
    {
        return end;
    }

    public String getStageName()
    {
        return stageName;
    }
}
