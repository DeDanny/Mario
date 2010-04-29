/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mario.core.loadAndSave;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import mario.MarioData;

/**
 *
 * @author Danny
 */
public class loadAndSave
{
    public static void save()
    {
        try
        {
            File f;
            f = new File(System.getProperty("user.home") + "\\.Awesome Mario Remake\\MarioData.save");
            if (!f.exists())
            {
                f.createNewFile();
            }
            FileOutputStream fos = new FileOutputStream(System.getProperty("user.home") + "\\.Awesome Mario Remake\\MarioData.save");
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            MarioData saveObject = MarioData.getMarioData();
            oos.writeObject(saveObject);
            oos.close();
        } catch (IOException ex)
        {
            //System.out.println(ex);
            JOptionPane.showMessageDialog(null, "Er is een fout opgetreden \n Voor het bevoegde gezag:" + ex, "Het lezen is mislukt", JOptionPane.WARNING_MESSAGE);
        }
    }

    public static MarioData load()
    {
        MarioData marioData = null;
        ObjectInputStream savedGame = null;
        File a;
        a = new File(System.getProperty("user.home") + "\\.Awesome Mario Remake\\MarioData.save");

        try
        {
            if (!a.exists())
            {
                a.createNewFile();
            }
            FileInputStream f = new FileInputStream(System.getProperty("user.home") + "\\.Awesome Mario Remake\\MarioData.save");
            savedGame = new ObjectInputStream(f);
            marioData = (MarioData) savedGame.readObject();
        }// <editor-fold defaultstate="collapsed" desc="Catch and finally blocks">
        catch (ClassNotFoundException ex)
        {
            Logger.getLogger(loadAndSave.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex)
        {
            JOptionPane.showMessageDialog(null, "Het inladen is mislukt \n Voor het bevoegde gezag:" + ex, "Er is een fout opgetreden", JOptionPane.WARNING_MESSAGE);
        } finally
        {
            try
            {
                savedGame.close();
            } catch (IOException ex)
            {
                JOptionPane.showMessageDialog(null, "Het lezen is mislukt \n Voor het bevoegde gezag:" + ex, "Er is een fout opgetreden", JOptionPane.WARNING_MESSAGE);
            }
        }// </editor-fold>

        MarioData game = marioData;

        return game;
    }
}
