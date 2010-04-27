/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mario.Stages;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.net.URL;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import mario.Main;

/**
 *
 * @author danny
 */
public class StageLoader
{
//    private static HashMap<String, StageArray> stages = new HashMap<String, StageArray>();
//
//    public StageLoader()
//    {
//
//    }
//
//    public StageArray getStage(String key)
//    {
//        StageArray stage = stages.get(key);
//
//        if (stage == null)
//        {
//            stages.put(key, loadStage(key));
//            stage = stages.get(key);
//        }
//        return stage;
//    }
//
//    private StageArray loadStage(String key)
//    {
//        URL arrayUrl = Main.class.getResource("/stages/" + key + ".map");
//        BufferedReader in = null;
//
//        try
//        {
//            in = new BufferedReader(new FileReader(arrayUrl.getFile()));
//        } catch (FileNotFoundException ex)
//        {
//            Logger.getLogger(StageLoader.class.getName()).log(Level.SEVERE, null, ex);
//        }
//
//        StageArray stageArray = new StageArray(in);
//        return stageArray;
//    }
}
