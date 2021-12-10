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
public class Guide extends DynamicBackground{
    public double orbitX = -20; /* x-coordinate in orbit's center */
    public double orbitY = -20; /* y-coordinate in orbit's center */
    
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
        
        if(mx>20 && mx<170 && my>700 && my<740){
            SoundEffect.makeSound("data/Sound/chooseButton.wav");
            Begin.State="menu";
        }
    }
}
