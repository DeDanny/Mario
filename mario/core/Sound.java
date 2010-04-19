/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mario.core;

import java.util.logging.Level;
import java.util.logging.Logger;
import sun.audio.AudioStream;
import sun.audio.AudioPlayer;
import java.util.HashMap;
import mario.Main;
import java.io.*;
import java.net.URL;
import javax.sound.sampled.*;
import javazoom.jl.player.Player;

/**
 *
 * @author Danny
 */
public class Sound
{
    private static HashMap<String, AudioInputStream> sounds = new HashMap<String, AudioInputStream>();
    private Player player;


    public void playTheme()
    {
        
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
        //AudioInputStream sound = getSound(fileName);
        URL soundUrl = Main.class.getResource(fileName);
        AudioInputStream audioStream = null;
        try
        {
            audioStream = AudioSystem.getAudioInputStream(soundUrl);
        } catch (UnsupportedAudioFileException ex)
        {
            Logger.getLogger(Sound.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex)
        {
            Logger.getLogger(Sound.class.getName()).log(Level.SEVERE, null, ex);
        }

        AudioPlayer.player.start(audioStream);
    }

    public void loadSound(String fileName)
    {
        URL soundUrl = Main.class.getResource(fileName);
        AudioInputStream audioStream = null;
        try
        {
             audioStream = AudioSystem.getAudioInputStream(soundUrl);
        } catch (UnsupportedAudioFileException ex)
        {
            Logger.getLogger(Sound.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex)
        {
            Logger.getLogger(Sound.class.getName()).log(Level.SEVERE, null, ex);
        }
        sounds.put(fileName, audioStream);
    }
}
