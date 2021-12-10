/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dragon_Hunter;

/**
 *
 * @author HP-FSZ
 */
class DynamicBackground {
    
    public double orbitX; // x-coordinate in orbit's center */
    public double orbitY; // y-coordinate in orbit's center */
    public double orbitRadius = 20;
    public double orbitSpeed = 0.03;
    public double sphereRadius = 5;
    public double t;
    public double drawX;
    public double drawY;
    public double radian;
    boolean mousePress;
    
    public void update(){
                        radian = orbitSpeed * t;
                        drawX = orbitX + orbitRadius * Math.cos(radian);
                        drawY = orbitY + orbitRadius * Math.sin(radian);
                        t+=1;
    }
    
}
