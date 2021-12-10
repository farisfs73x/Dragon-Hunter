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
public class Death extends DynamicBackground{
    public double orbitX = -110; /* x-coordinate in orbit's center */
    public double orbitY = -60; /* y-coordinate in orbit's center */
    
    @Override
    public void update(){
                        radian = orbitSpeed * t;
                        drawX = orbitX + orbitRadius * Math.cos(radian);
                        drawY = orbitY + orbitRadius * Math.sin(radian);
                        t+=1;
    }

    void mousePress(MouseEvent e) {
        int mx = e.getX();
        int my = e.getY();
        
        Begin.restart();
        
        if (mx>60 && mx<200 && my>350 && my<395){
            SoundEffect.makeSound("data/Sound/chooseButton.wav");
            Begin.State = "menu";
        }
        else if(mx>60 && mx<200 && my>410 && my<455){
            SoundEffect.makeSound("data/Sound/playButton.wav");
            Begin.State = "game";
        }
    }
}
