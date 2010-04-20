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

import javax.sound.sampled.*;






/**
 *
 * @author Danny
 */
public class Sound
{
    private static HashMap<String, Clip> sounds = new HashMap<String, Clip>();

    public Sound()
    {
    }

    private Clip getSound(String fileName)
    {
        Clip clip = sounds.get(fileName);

        if (clip == null)
        {
            loadSound(fileName);
            clip = sounds.get(fileName);
        }
        return clip;
    }

    public void playSound(String fileName)
    {
        try
        {
            Clip player = getSound(fileName);
            
            if (!player.isRunning())
            {
                player.setFramePosition(0);
                player.start();
            }
            
            if (fileName.equals("/sound/theme.wav"))
            {
                player.loop(999);
            }
        }finally
        {
            
        }

    }

    public void loadSound(String fileName)
    {
        AudioInputStream audioIn = null;
        try
        {
            URL url = Main.class.getResource(fileName);
            audioIn = AudioSystem.getAudioInputStream(url);
            Clip player = AudioSystem.getClip();
            player.open(audioIn);
            sounds.put(fileName, player);
        }// <editor-fold defaultstate="collapsed" desc="catch and try blocks">
        catch (LineUnavailableException ex)
        {
            Logger.getLogger(Sound.class.getName()).log(Level.SEVERE, null, ex);
        }        catch (UnsupportedAudioFileException ex)
        {
            Logger.getLogger(Sound.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex)
        {
            Logger.getLogger(Sound.class.getName()).log(Level.SEVERE, null, ex);
        }// </editor-fold>        
    }
}
