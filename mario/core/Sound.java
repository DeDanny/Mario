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
/**
 *
 * @author Danny
 */
public class Sound
{
    private static HashMap<String, AudioStream> sounds = new HashMap<String, AudioStream>();
    private AudioStream lastSong;

    public void playTheme()
    {
    }

    private AudioStream getSound(String fileName)
    {
        AudioStream sound = sounds.get(fileName);

        if (sound == null)
        {
            loadSound(fileName);
            sound = sounds.get(fileName);
        }
        return sound;
    }

    public void playSound(String fileName)
    {

        AudioStream sound = getSound(fileName);

        if (lastSong != null)
        {
            AudioPlayer.player.stop(lastSong);
        }
        lastSong = sound;
        AudioPlayer.player.start(sound);
    }

    public void loadSound(String fileName)
    {
        InputStream soundUrl = Main.class.getResourceAsStream(fileName);
        AudioStream audioStream = null;
        try
        {
             audioStream = new AudioStream(soundUrl);
        } catch (IOException ex)
        {
            Logger.getLogger(Sound.class.getName()).log(Level.SEVERE, null, ex);
        }

        sounds.put(fileName, audioStream);
    }
}
