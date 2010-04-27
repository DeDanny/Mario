/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mario.Stages;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Danny
 */
public class StageArray
{
    private String[] map;

    StageArray(String[] map)
    {
        this.map = map;
    }

    StageArray(BufferedReader in)
    {
        if (in == null)
        {
            throw new ExceptionInInitializerError("The file is not loaded");
        }
        //try
        {
            int i = 0;
            //for(String line : in.readLine())
            {

                //map[i] = line;
                i++;
            }
            //} catch (IOException ex)
            {
                //Logger.getLogger(StageArray.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }
}
