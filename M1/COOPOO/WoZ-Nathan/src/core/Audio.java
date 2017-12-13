package core;

import sun.audio.*;
import java.io.*;

/**
 * This class manages the Audio of the Game.
 *
 * @author Group 8
 * @version 09/11/17
 */
public class Audio //extends display.Display
{
     public static void launchMusic(String music){
        AudioPlayer MGP = AudioPlayer.player;
        AudioStream BGM;
        AudioData MD;
         
        ContinuousAudioDataStream loop = null;
         
         try{
             InputStream test = new FileInputStream("sound/" + music);
             BGM = new AudioStream(test);
             AudioPlayer.player.start(BGM);
        } catch (IOException error){
            System.err.println(error.getMessage());
        }
        MGP.start(loop);
     }
}
