/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dragon_Hunter;

import java.io.File;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.*;

/**
 *
 * @author HP-FSZ
 */
public class SoundEffect {
    
    static void makeSound(String fileName){
        
        File lol = new File(fileName);
        
        try{
            Clip clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(lol));
            
            if (!Begin.MUTE) {
                if ( "data/Sound/attackKamehameha.wav".equals(fileName) ) {
                    FloatControl gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
                    gainControl.setValue(-20.0f);
                }
                else if ( "data/Sound/fingerprintReleaseButton.wav".equals(fileName)) {
                    FloatControl gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
                    gainControl.setValue(-10.0f);
                }
                clip.start();
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
