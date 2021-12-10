/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dragon_Hunter;

import java.awt.event.MouseEvent;
/**
 *
 * @author HP-FSZ
 */
public class Menu extends DynamicBackground{
    public double orbitX = -700; /* x-coordinate in orbit's center */
    public double orbitY = -600; /* y-coordinate in orbit's center */
    
    
    @Override
    public void update(){
                        radian = orbitSpeed * t;
                        drawX = orbitX + orbitRadius * Math.cos(radian);
                        drawY = orbitY + orbitRadius * Math.sin(radian);
                        t+=1;
    }

    void mousePress(MouseEvent e) throws InterruptedException {
        
        int mx = e.getX();
        int my = e.getY();
        
        if (mx>1250 && mx<1290 && my>150 && my<190){
            SoundEffect.makeSound("data/Sound/muted.wav");
            Begin.MUTE = true;
            Begin.State = "menu";
        }
        else if (mx>1250 && mx<1290 && my>200 && my<240){
            Begin.MUTE = false;
            Begin.State = "menu";
            SoundEffect.makeSound("data/Sound/unmuted.wav");
        }
        else if (mx>60 && mx<200 && my>260 && my<310){ //Play button
            Begin.State = "game";
            SoundEffect.makeSound("data/Sound/playButton.wav");
        }
        else if (mx>60 && mx<200 && my>320 && my<370){ // intro button
            Begin.State = "intro";
            SoundEffect.makeSound("data/Sound/introButton.wav");
        }
        else if (mx>60 && mx<200 && my>380 && my<430){ //guide button
            Begin.State = "guide";
            SoundEffect.makeSound("data/Sound/guideButton.wav");
        }
        else if (mx>60 && mx<200 && my>440 && my<490){ // credits button
            Begin.State = "credits";
            SoundEffect.makeSound("data/Sound/creditButton.wav");
        }
        else if(mx>60 && mx<200 && my>500 && my<550){   // exit button
            SoundEffect.makeSound("data/Sound/exitButton.wav");
            Thread.sleep(3000);
            System.exit(1);
        }
    }
}
