/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dragon_Hunter;

import java.awt.Rectangle;
import java.util.ArrayList;
/**
 *
 * @author HP-FSZ
 */
public class Enemy {
    private int maxHealth, currentHealth, power, speedX, centerX, centerY;
	private Background bg = Begin.getBg1();
        public Rectangle r = new Rectangle(0,0,0,0);
        public int health = 5;
        private boolean isdead;
        public static ArrayList<Enemy> enemies = new ArrayList<Enemy>();
        private int movementSpeed;
        public String direction = "left";
        
        public Enemy(int centerX, int centerY) {
		setCenterX(centerX);
		setCenterY(centerY);
	}
        
	// Behavioral Methods
	public static void update() {
            
            for (Enemy i: enemies) {
                  
                    i.follow();
                    i.centerX += i.speedX;
                    i.speedX = i.bg.getSpeedX() * 5 + i.movementSpeed;
                    i.r.setBounds(i.centerX - 30, i.centerY-10, 85, 60);

                    if (i.r.intersects(Hunter.yellowRed))
                            i.checkCollision();
            }
	}
        
        public void follow() {
		
                if (centerX - Begin.getRobot().getCenterX() >650){
                    this.movementSpeed = 0;
                }
                else if (Begin.getRobot().getCenterX() - centerX > 650){
                    this.movementSpeed = 0;
                }

		else if (Math.abs(Begin.getRobot().getCenterX() - centerX) < 5) {
			this.movementSpeed = 0;
		}

		else {

			if (Begin.getRobot().getCenterX() >= centerX) {
				this.direction = "right";
                                this.movementSpeed = 2;
			} 
                        else {
                                this.direction = "left";
				this.movementSpeed = -2;
			}
		}

	}
        
        private void checkCollision() {
		if (r.intersects(Hunter.rect) || r.intersects(Hunter.rect2)){
			Begin.State = "dead";
			}
        }


	public void attack() {

	}

	public int getMaxHealth() {
		return maxHealth;
	}

	public int getCurrentHealth() {
		return currentHealth;
	}

	public int getPower() {
		return power;
	}

	public int getSpeedX() {
		return speedX;
	}

	public int getCenterX() {
		return centerX;
	}

	public int getCenterY() {
		return centerY;
	}

	public Background getBg() {
		return bg;
	}

	public void setMaxHealth(int maxHealth) {
		this.maxHealth = maxHealth;
	}

	public void setCurrentHealth(int currentHealth) {
		this.currentHealth = currentHealth;
	}

	public void setPower(int power) {
		this.power = power;
	}

	public void setSpeedX(int speedX) {
		this.speedX = speedX;
	}

	public void setCenterX(int centerX) {
		this.centerX = centerX;
	}

	public void setCenterY(int centerY) {
		this.centerY = centerY;
	}

	public void setBg(Background bg) {
		this.bg = bg;
	}
        public boolean getIsDead(){
            return isdead;
        }
        public void setIsDead(boolean s){
            isdead = s;
        }
}
