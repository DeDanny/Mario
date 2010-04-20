/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mario.core;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.LineUnavailableException;
import java.util.HashMap;
import javax.sound.sampled.UnsupportedAudioFileException;
import mario.Main;
import java.io.*;
import java.net.URL;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

/**
 *
 * @author Danny
 */
public class Sound
{
    private static HashMap<String, AudioInputStream> sounds = new HashMap<String, AudioInputStream>();
    private Clip player;

    public Sound()
    {
        try
        {
            player = AudioSystem.getClip();
        } catch (LineUnavailableException ex)
        {
            Logger.getLogger(Sound.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private AudioInputStream getSound(String fileName)
    {
        AudioInputStream sound = sounds.get(fileName);

        if (sound == null)
        {
            loadSound(fileName);
            sound = sounds.get(fileName);
        }
        return sound;
    }

    public void playSound(String fileName)
    {
        try
        {
            AudioInputStream sound = getSound(fileName);

            player.open(sound);
            if (player.isRunning())
            {
                player.stop();   // Stop the player if it is still running
                player.setFramePosition(0); // rewind to the beginning
            }
            player.start();
            if (fileName.equals("/sound/theme.wav"))
            {
                player.loop(999);
            }

        } catch (IOException ex)
        {
            Logger.getLogger(Sound.class.getName()).log(Level.SEVERE, null, ex);
        } catch (LineUnavailableException ex)
        {
            Logger.getLogger(Sound.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void loadSound(String fileName)
    {
        AudioInputStream audioIn = null;
        try
        {
            URL url = Main.class.getResource(fileName);
            audioIn = AudioSystem.getAudioInputStream(url);
            sounds.put(fileName, audioIn);
        }// <editor-fold defaultstate="collapsed" desc="catch and try blocks">
        catch (UnsupportedAudioFileException ex)
        {
            Logger.getLogger(Sound.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex)
        {
            Logger.getLogger(Sound.class.getName()).log(Level.SEVERE, null, ex);
        }// </editor-fold>        
    }
}
