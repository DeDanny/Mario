/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mario.Stages;

/**
 *
 * @author danny
 */
public abstract class Map
{
    protected String theme;
    protected int[] map;

    public Map(String theme, int[] map)
    {
        this.theme = theme;
        this.map = map;
    }

    

}