/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mario.core.loadAndSave;

import java.awt.FileDialog;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import mario.core.GameObject;
import mario.core.MapObject;

/**
 *
 * @author Danny
 */
public class loadAndSave
{
    public static void save(ArrayList<MapObject> mapObjects)
    {
        FileDialog filedialog = new FileDialog(new JFrame(), "Save the Mario", FileDialog.SAVE);
        filedialog.setVisible(true);

        String fileLocation = filedialog.getDirectory();
        if (filedialog.getFile() != null)
        {
            try
            {
                FileOutputStream f = new FileOutputStream(fileLocation + filedialog.getFile());
                ObjectOutputStream saveObject = new ObjectOutputStream(f);

                saveObject.writeObject(mapObjects);
                saveObject.close();
            } catch (IOException ex)
            {
                System.out.println(ex);
                JOptionPane.showMessageDialog(null, "Er is een fout opgetreden", "Het lezen is mislukt", JOptionPane.WARNING_MESSAGE);
            }
        }
    }
}
