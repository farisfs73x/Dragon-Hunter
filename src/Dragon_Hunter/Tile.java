/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dragon_Hunter;

import java.awt.Image;
import java.awt.Rectangle;
/**
 *
 * @author HP-FSZ
 */
public class Tile {
    private int tileX, tileY, speedX, type;
    public Image tileImage;
    private Hunter robot = Begin.getRobot();
    private Background bg = Begin.getBg1();
    private Rectangle r;

    
    public Tile(int x, int y, int typeint){
        tileX = x*40;
        tileY = y*40;
        type = typeint;
        r = new Rectangle();    
        if (type == 2)
            tileImage = Begin.grasstop; 
        else if (type == 3)
            tileImage = Begin.tiledirt;
        else if (type == 4)
            tileImage = Begin.tilestone;
        else if (type == 5)
            tileImage = Begin.tiletree;
        else if (type == 6)
            tileImage = Begin.tilerock;
        else {
            type = 0;
        }
    }
    public void update(){
        speedX = bg.getSpeedX() * 5;
        tileX += speedX;  
        r.setBounds(tileX, tileY, 40, 40);
        
        if (r.intersects(Hunter.yellowRed) && type != 0) {
                                
				checkVerticalCollision(Hunter.rect, Hunter.rect2);
				checkSideCollision(Hunter.footleft, Hunter.footright);
			}
        for (Enemy i: Enemy.enemies){
                if(r.intersects(i.r)  && ( type == 2 || type == 3 || type == 6 )){
                        i.setSpeedX(0);
                        if (i.getCenterX()<tileX)
                            i.setCenterX(tileX-55);
                        else if (i.getCenterX()>tileX)
                            i.setCenterX(tileX+56);
                    }
            }
    }
    
   public int getTileX() {
        return tileX;
    }

    public void setTileX(int tileX) {
        this.tileX = tileX;
    }

    public int getTileY() {
        return tileY;
    }

    public void setTileY(int tileY) {
        this.tileY = tileY;
    }
    public Rectangle getRectangle(){
        return r;
    }
    public int getType(){
        return type;
    }

    public Image getTileImage() {
        return tileImage;
    }

    public void setTileImage(Image tileImage) {
        this.tileImage = tileImage;
    }
    
    public void checkVerticalCollision(Rectangle rtop, Rectangle rbot) {
        if ( type == 2 || type == 3 || type == 6 ){
            if (rtop.intersects(r)) {
                robot.setCenterY(tileY+100);
                robot.setSpeedY(-robot.JUMPSPEED);
            }

            if (rbot.intersects(r)) {
                robot.setJumped(false);
                robot.setSpeedY(0);
                robot.setCenterY(tileY - 75);
            }
        }
    }
    
     public void checkSideCollision(Rectangle leftfoot, Rectangle rightfoot) {
        if (type == 2 || type == 3 || type == 6 ){
            
           if (leftfoot.intersects(r)) {
                robot.setCenterX(tileX + 100);
                robot.setSpeedX(0);
            }
            
            else if (rightfoot.intersects(r)) {
                robot.setCenterX(tileX + 15);
                robot.setSpeedX(0);
            }
        }
    }
}
