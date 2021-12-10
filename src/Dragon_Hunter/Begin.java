/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dragon_Hunter;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
/**
 *
 * @author HP-FSZ
 */
public class Begin extends JPanel implements Runnable, KeyListener, MouseListener{
    private boolean L_PRESS;
    static boolean MUTE = false;
        ArrayList projectiles;
        
        static Begin starter = new Begin();
        
	private static Hunter hunter;
	private BufferedImage  currentSprite, c0,c1, c2, c3,c4,c5,c6,c7,c8,c9, c10,c11,
                        s0,s1,s2,s3,s4,s5,s6,s7,s8,s9,s10,s11,crouch_r0,crouch_r1,crouch_r2,crouch_r3,
                        crouch_l0,crouch_l1,crouch_l2,crouch_l3,menu,bulletr,bulletl,
			characterJumped_r, characterJumped_l, background1,background2, 
                        el,e2l,er,e2r,play,exit,creditsButton,credits,backButton,credits1,introback,
                        introfront,guideback,guidefront,guideButton,introButton,logo,teamlogo,start,
                        deathimg,menubutton,playagain,fingerprint,fingerprintRelease,mute,unmute;
	private static Background bg1, bg2,bg3,bg4;
	public Animation anim_r,anim_l,anim,anim_still,anim_still_r,anim_still_l, 
                crouchdown_r,crouchdown_r1,crouchdown_l;
        public static Animation hanim_l,hanim_r;
        
        public static BufferedImage tiledirt,grasstop, tilestone,tiletree,tilerock;
        private static ArrayList<Tile> tilearray = new ArrayList<Tile>();
        
        static String State = "start";
        Menu MENU;
        Credits CREDITS;
        Intro INTRO;
        Guide GUIDE;
        Death DEATH;
        
        public static void restart(){
                hunter.getProjectiles().clear();
                tilearray.clear();
                Enemy.enemies.clear();
                bg1 = new Background(0, 0);
		bg2 = new Background(1920, 0);
                bg3 = new Background(-1920,0);
                bg4 = new Background(-1920*2,0);
                hunter = new Hunter();
                try {
                    starter.loadMap("data/map1.txt");
                } 
                catch (IOException e) {
                    e.printStackTrace();
                }
        }
	
	public void init() throws Exception{
                
            setFocusable(true);
            addKeyListener(this);
            addMouseListener(this);

            // Image Setups

            fingerprint = ImageIO.read(new File("data/Button/fingerprintButton.png"));
            fingerprintRelease = ImageIO.read(new File("data/Button/fingerprintReleaseButton.png"));
            
            characterJumped_r = ImageIO.read(new File("data/Hunter Jump/jumpedr.png"));
            characterJumped_l = ImageIO.read(new File("data/Hunter Jump/jumpedl.png"));

            background1 = ImageIO.read(new File("data/Background/bg1.png"));
            background2 = ImageIO.read(new File("data/Background/bg2.png"));


            tiledirt = ImageIO.read(new File("data/Tiles/tiledirt.png"));
            grasstop = ImageIO.read(new File("data/Tiles/grasstop.png"));
            tilestone = ImageIO.read(new File("data/Tiles/tilestone.png"));
            tiletree = ImageIO.read(new File("data/Tiles/tiletree.png"));
            tilerock = ImageIO.read(new File("data/Tiles/tilerock.png"));

            bulletr = ImageIO.read(new File("data/Power/bulletr.png"));
            bulletl = ImageIO.read(new File("data/Power/bulletl.png"));

            c0= ImageIO.read(new File("data/Hunter Walk/walk-r (1).png"));
            c1 = ImageIO.read(new File("data/Hunter Walk/walk-r (2).png"));
            c2 = ImageIO.read(new File("data/Hunter Walk/walk-r (3).png"));
            c3 = ImageIO.read(new File("data/Hunter Walk/walk-r (4).png"));
            c4 = ImageIO.read(new File("data/Hunter Walk/walk-r (5).png"));
            c5 = ImageIO.read(new File("data/Hunter Walk/walk-r (6).png"));
            c6 = ImageIO.read(new File("data/Hunter Walk/walk-r (7).png"));
            c7 = ImageIO.read(new File("data/Hunter Walk/walk-r (8).png"));
            c8 = ImageIO.read(new File("data/Hunter Walk/walk-r (9).png"));
            c9 = ImageIO.read(new File("data/Hunter Walk/walk-r (10).png"));
            c10 = ImageIO.read(new File("data/Hunter Walk/walk-r (11).png"));
            c11 = ImageIO.read(new File("data/Hunter Walk/walk-r (12).png"));

            s0 = ImageIO.read(new File("data/Hunter Walk/0.png"));
            s1 = ImageIO.read(new File("data/Hunter Walk/1.png"));
            s2 = ImageIO.read(new File("data/Hunter Walk/2.png"));
            s3 = ImageIO.read(new File("data/Hunter Walk/3.png"));
            s4 = ImageIO.read(new File("data/Hunter Walk/4.png"));
            s5 = ImageIO.read(new File("data/Hunter Walk/5.png"));
            s6 = ImageIO.read(new File("data/Hunter Walk/6.png"));
            s7 = ImageIO.read(new File("data/Hunter Walk/7.png"));
            s8 = ImageIO.read(new File("data/Hunter Walk/8.png"));
            s9 = ImageIO.read(new File("data/Hunter Walk/9.png"));
            s10 = ImageIO.read(new File("data/Hunter Walk/10.png"));
            s11 = ImageIO.read(new File("data/Hunter Walk/11.png"));

            crouch_r0 = ImageIO.read(new File("data/Hunter Crouch/r0.png"));
            crouch_r1 = ImageIO.read(new File("data/Hunter Crouch/r1.png"));
            crouch_r2 = ImageIO.read(new File("data/Hunter Crouch/r2.png"));
            crouch_r3 = ImageIO.read(new File("data/Hunter Crouch/r3.png"));

            crouch_l0 = ImageIO.read(new File("data/Hunter Crouch/1.png"));
            crouch_l1 = ImageIO.read(new File("data/Hunter Crouch/2.png"));
            crouch_l2 = ImageIO.read(new File("data/Hunter Crouch/3.png"));
            crouch_l3 = ImageIO.read(new File("data/Hunter Crouch/4.png"));


            // Menu Images

            menu = ImageIO.read(new File("data/Menu/menu.png"));
            logo = ImageIO.read(new File("data/Menu/logo.png"));
            teamlogo = ImageIO.read(new File("data/Menu/teamlogo.png"));
            play = ImageIO.read(new File("data/Button/playButton.png"));
            exit = ImageIO.read(new File("data/Button/exitButton.png"));
            creditsButton = ImageIO.read(new File("data/Button/creditsButton.png"));
            guideButton = ImageIO.read(new File("data/Button/guideButton.png"));
            introButton = ImageIO.read(new File("data/Button/introButton.png"));
            mute = ImageIO.read(new File("data/Menu/mute.png"));
            unmute = ImageIO.read(new File("data/Menu/unmute.png"));

            start = ImageIO.read(new File("data/Menu/opening.png"));

            deathimg = ImageIO.read(new File("data/Menu/deathimg.png"));
            menubutton = ImageIO.read(new File("data/Button/menuButton.png"));
            playagain = ImageIO.read(new File("data/Button/playagainButton.png"));


            //Credits Stuff
            credits = ImageIO.read(new File("data/Credits/credits.png"));
            credits1 = ImageIO.read(new File("data/Credits/credits1.png"));
            backButton = ImageIO.read(new File("data/Button/backButton.png"));

            //Intro stuff
            introback = ImageIO.read(new File("data/Intro/introback.png"));
            introfront = ImageIO.read(new File("data/Intro/introfront.png"));

            //Guide stuff
            guideback = ImageIO.read(new File("data/Guide/guideback.png"));
            guidefront = ImageIO.read(new File("data/Guide/guidefront.png"));

            el = ImageIO.read(new File("data/Enemy Dragon/heliboy.png"));
            e2l = ImageIO.read(new File("data/Enemy Dragon/heliboy2.png"));

            er = ImageIO.read(new File("data/Enemy Dragon/heliboyl.png"));
            e2r = ImageIO.read(new File("data/Enemy Dragon/heliboy2l.png"));

            hanim_l = new Animation(false);
            hanim_l.addFrame(el, 500);
            hanim_l.addFrame(e2l, 500);

            hanim_r = new Animation(false);
            hanim_r.addFrame(er, 500);
            hanim_r.addFrame(e2r, 500);

            crouchdown_r = new Animation(true);    
            crouchdown_r.addFrame(crouch_r0, 20);
            crouchdown_r.addFrame(crouch_r1, 20);
            crouchdown_r.addFrame(crouch_r2, 20);
            crouchdown_r.addFrame(crouch_r3, 20);

            crouchdown_l = new Animation(true);    
            crouchdown_l.addFrame(crouch_l0, 20);
            crouchdown_l.addFrame(crouch_l1, 20);
            crouchdown_l.addFrame(crouch_l2, 20);
            crouchdown_l.addFrame(crouch_l3, 20);

            anim_r = new Animation(false);
            anim_r.addFrame(c0, 50);
            anim_r.addFrame(c1, 50);
            anim_r.addFrame(c2, 50);
            anim_r.addFrame(c3, 50);
            anim_r.addFrame(c4, 50);
            anim_r.addFrame(c5, 50);
            anim_r.addFrame(c6, 50);
            anim_r.addFrame(c7, 50);
            anim_r.addFrame(c8, 50);
            anim_r.addFrame(c9, 50);
            anim_r.addFrame(c10, 50);
            anim_r.addFrame(c11, 50);


            anim_l = new Animation(false);
            anim_l.addFrame(s0, 50);
            anim_l.addFrame(s1, 50);
            anim_l.addFrame(s2, 50);
            anim_l.addFrame(s3, 50);
            anim_l.addFrame(s4, 50);
            anim_l.addFrame(s5, 50);
            anim_l.addFrame(s6, 50);
            anim_l.addFrame(s7, 50);
            anim_l.addFrame(s8, 50);
            anim_l.addFrame(s9, 50);
            anim_l.addFrame(s10, 50);
            anim_l.addFrame(s11, 50);

            anim = anim_r;

            currentSprite = c0;
	}

	
	public void start() {
            
            java.awt.Toolkit toolkit = java.awt.Toolkit.getDefaultToolkit();
            Image image = toolkit.getImage("data/GameCursor.png");
            Cursor a = toolkit.createCustomCursor(image , new Point(this.getX(),this.getY()), "");
            this.setCursor (a);
            
            bg1 = new Background(0, 0);
            bg2 = new Background(1920, 0);
            bg3 = new Background(-1920,0);
            bg4 = new Background(-1920*2,0);
            hunter = new Hunter();
            MENU = new Menu();
            CREDITS = new Credits();
            INTRO = new Intro();
            GUIDE = new Guide();
            DEATH = new Death();

            // Initialize Tiles
            try {
                loadMap("data/map1.txt");
            } 
            catch (IOException e) {
                e.printStackTrace();
            }

            Thread thread = new Thread(this);
            thread.start();
	}


	@Override
	public void run() {
		while (true) {
                    
                    switch (State){
                        
                        case "start":
                        case "startRelease":
                            break;
                        
                        case "menu":
                            MENU.update();
                            break;
                            
                        case "dead":
                            DEATH.update();
                            break;
                            
                        case "credits":
                            CREDITS.update();
                            break;
                            
                        case "intro":
                            INTRO.update();
                            break;
                            
                        case "guide":
                            GUIDE.update();
                            break;
                            
                        case "game":
                            gameUpdate();
                            break;
                        
                    }
			repaint();
                        
			try {
				Thread.sleep(17);
			} 
                        catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
        }
        
        public void gameUpdate(){
                        
            hunter.update();
            bg1.update();
            bg2.update();
            bg3.update();
            bg4.update();
            Enemy.update();
            updateTiles();

            hanim_l.update(50);
            hanim_r.update(50);


            ArrayList projectiles = hunter.getProjectiles();
            for (int i = 0; i < projectiles.size(); i++) {
                Power p = (Power) projectiles.get(i);
                if (p.isVisible() == true) {
                        p.update();
                } else {
                        projectiles.remove(i);
                }
            }

            for (int i = 0; i < Enemy.enemies.size(); i++){
                if (Enemy.enemies.get(i).getIsDead())
                    Enemy.enemies.remove(i);
            }

            if (hunter.isJumped() && hunter.getDirection() == "right") {
                currentSprite = characterJumped_r;
            }
            else if (hunter.isJumped() && hunter.getDirection() == "left") {
                currentSprite = characterJumped_l;
            } 
            else if ((hunter.getDirection() == "right") && (hunter.getSpeedX() == 0)&& hunter.isDucked()==false){
                currentSprite = c0;
            }
            else if ((hunter.getDirection() == "left") && (hunter.getSpeedX() == 0) && hunter.isDucked()==false){
                currentSprite = s0;
            }
            else {
                if (hunter.getSpeedX()<0){
                    anim = anim_l;
                }
                else if (hunter.getSpeedX()>0){
                    anim = anim_r;
                }
                else if (hunter.isDucked() && hunter.getDirection() == "right"){
                    anim = crouchdown_r;
                }
                else if (hunter.isDucked() && hunter.getDirection() == "left"){
                    anim = crouchdown_l;
                }
                currentSprite = anim.getImage();
                anim.update(10);
            }

            if (hunter.getCenterY()>1400){
                State = "dead";
            }
        }


        @Override
	public void paint(Graphics g) {
            
            switch (State) {
                
                case "start":
                    g.drawImage(start, 0, 0, this);
                    g.setColor(Color.MAGENTA);
                    g.fillRect(616, 507, 118, 137);
                    g.setColor(Color.cyan);
                    g.fillRect(619, 510, 112, 131);
                    g.drawImage(fingerprint,600,500,this);
                    g.setColor(Color.white);
                    g.setFont(new Font("Jokerman", Font.BOLD, 35));
                    g.drawString("Press SPACE or ENTER to continue...", 330, 690);
                    g.setFont(new Font("Arial", Font.BOLD, 30));
                    g.drawString("@ Scan Your Fingerprint Above |^o^|", 400, 740);
                    break;
                    
                case "startRelease":
                    g.drawImage(fingerprintRelease, 621, 512, this);
                    break;
                
                case "menu":
                    try{
                    g.drawImage(menu, (int) MENU.drawX,(int)MENU.drawY,this);
                    g.drawImage(logo, 510, 32, this);
                    g.drawImage(play,60,260,this);
                    g.drawImage(introButton, 60, 320, this);
                    g.drawImage(guideButton,60,380, this);
                    g.drawImage(creditsButton,60,440,this);
                    g.drawImage(exit,60,500,this);
                    g.drawImage(teamlogo,1150,580,this);
                    g.drawImage(mute,1250,150,this);
                    g.drawImage(unmute,1250,200,this);
                    }
                    catch(Exception e){ }
                    break;
                    
                case "dead":
                    g.drawImage(deathimg, (int) DEATH.drawX,(int)DEATH.drawY,this);
                    g.drawImage(menubutton,60,350, this);
                    g.drawImage(playagain,60,410, this);
                    break;
                    
                case "credits":
                    g.drawImage(credits, (int)CREDITS.drawX, (int)CREDITS.drawY, this);
                    g.drawImage(credits1,183,84, this);
                    g.drawImage(backButton,20,700, this);
                    break;
                    
                case "intro":
                    g.drawImage(introback,(int)INTRO.drawX, (int)INTRO.drawY, this);
                    g.drawImage(introfront,52, 70, this);
                    g.drawImage(backButton,20,700, this);
                    break;
                    
                case "guide":
                    g.drawImage(guideback,(int)GUIDE.drawX,(int)GUIDE.drawY, this);
                    g.drawImage(guidefront,478,170, this);
                    g.drawImage(backButton, 20,700, this);
                    break;
                    
                case "game":
                    g.drawImage(background1, bg1.getBgX(), bg1.getBgY(), this);
                    g.drawImage(background2, bg2.getBgX(), bg2.getBgY(), this);
                    g.drawImage(background2, bg3.getBgX(), bg3.getBgY(), this);
                    g.drawImage(background1, bg4.getBgX(), bg4.getBgY(), this);
                    paintTiles(g);
                    paintProjectiles(g);
                    paintEnemies(g);
                    g.drawImage(currentSprite, hunter.getCenterX() - 61,hunter.getCenterY() - 63, this);
                    break;
            }
	}
        
        
        private void updateTiles() {

            for (int i = 0; i < tilearray.size(); i++) {
                Tile t = (Tile) tilearray.get(i);
                t.update();
            }
	}
        
        private void paintEnemies(Graphics g){
            for (Enemy i: Enemy.enemies){
                if (i.getCenterX()>-50 && i.getCenterX()<1366){
                    if (i.direction == "right")
                        g.drawImage(hanim_r.getImage(), i.getCenterX() - 48, i.getCenterY() - 48, this);
                    else if (i.direction == "left")
                        g.drawImage(hanim_l.getImage(), i.getCenterX() - 48, i.getCenterY() - 48, this);
                }
            }
        }
        
        private void paintProjectiles(Graphics g){
            projectiles = hunter.getProjectiles();
            for (int i = 0; i < projectiles.size(); i++) {
                Power p = (Power) projectiles.get(i);

                if (hunter.getDirection() == "right")
                    g.drawImage(bulletr, p.getX(), p.getY(), this);
                else if (hunter.getDirection() == "left")
                    g.drawImage(bulletl, p.getX(), p.getY(), this);
            }
        }
        
	private void paintTiles(Graphics g) {
            for (int i = 0; i < tilearray.size(); i++) {
                Tile t = (Tile) tilearray.get(i);
                g.drawImage(t.getTileImage(), t.getTileX(), t.getTileY(), this);
            }
	}
        private void loadMap(String filename) throws IOException {
            ArrayList lines = new ArrayList();
            int width = 0;
            int height = 0;

            BufferedReader reader = new BufferedReader(new FileReader(filename));
            while (true) {
                String line = reader.readLine();
                // no more lines to read
                if (line == null) {
                    reader.close();
                    break;
                }

                if (!line.startsWith("!")) {
                    lines.add(line);
                    width = Math.max(width, line.length());

                }
            }
            height = lines.size();

            for (int j = 0; j < 20; j++) {
                String line = (String) lines.get(j);
                for (int i = 0; i < width; i++) {

                    if (i < line.length()) {
                        char ch = line.charAt(i);
                        if (ch == '*'){
                            Enemy.enemies.add(new Enemy(i*40, j*40-80));
                        }
                        else{
                            Tile t = new Tile(i, j, Character.getNumericValue(ch));
                            tilearray.add(t);
                        }
                    }

                }
            }

        }
        

	@Override
	public void keyPressed(KeyEvent e) {
            
            if (State == "start" || State == "startRelease"){
                if (e.getKeyCode() == KeyEvent.VK_ENTER || e.getKeyCode() == KeyEvent.VK_SPACE){
                    SoundEffect.makeSound("data/Sound/chooseButton.wav");
                    State = "menu";
                }
            }


            if (State == "credits"||State == "intro"||State == "guide"){
                switch(e.getKeyCode()){
                    case KeyEvent.VK_ESCAPE:
                        State="menu";
                        break;
                }
            }
            if (State == "game"){
                
                switch (e.getKeyCode()) {

                    case KeyEvent.VK_ESCAPE:
                        State = "menu";
                        break;

                    case KeyEvent.VK_UP:
                        System.out.println("Move up");
                        break;

                    case KeyEvent.VK_S:
                        hunter.setDucked(true);
                        break;

                    case KeyEvent.VK_A:
                        hunter.moveLeft();
                        break;

                    case KeyEvent.VK_D:
                        hunter.moveRight();
                        break;

                    case KeyEvent.VK_SPACE:
                    case KeyEvent.VK_W:
                        hunter.jump();
                        break;

                    case KeyEvent.VK_ENTER:
                        State = "game";
                        break;

                    case KeyEvent.VK_L:
                        L_PRESS = true;
                }
            }
        }

	@Override
	public void keyReleased(KeyEvent e) {
                
            
            switch (e.getKeyCode()) {
                
		case KeyEvent.VK_UP:
			break;

                case KeyEvent.VK_S:
                    if (State == "game"){
                        crouchdown_r.currentFrame = 0;
                        crouchdown_l.currentFrame = 0;
			hunter.setDucked(false);
                    }
                    break;

                case KeyEvent.VK_A:
                        if (State == "game")
                            hunter.stopLeft();
			break;

                case KeyEvent.VK_D:
                        if (State == "game")
        			hunter.stopRight();
			break;

		case KeyEvent.VK_SPACE:
                case KeyEvent.VK_W:
                        if (State == "game"){
                            hunter.setMovingLeft(false);
                            hunter.setMovingRight(false);
                        }
			break;
                
                case KeyEvent.VK_L:
                    if (State == "game"){
                        if (L_PRESS)
                            hunter.shoot();
                        //SoundEffect.setVolume(3000);
                        SoundEffect.makeSound("data/Sound/attackKamehameha.wav");
                        //SoundEffect.setVolume(3000);
                    }
                    break;
            }
	}

	@Override
	public void keyTyped(KeyEvent e) {
            
	}


    @Override
    public void mouseClicked(MouseEvent me) {
      
    }

    @Override
    public void mousePressed(MouseEvent me) {
        
        switch (State){
            case "start":
                if ( (me.getX() > 600 && me.getX() < 750) && (me.getY() > 500 && me.getY() < 650) )
                    State = "startRelease";
                break;
                
            case "credits":
                CREDITS.mousePress(me);
                break;
                
            case "dead":
                DEATH.mousePress(me);
                break;
                
            case "menu":
            {
                try {
                    MENU.mousePress(me);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Begin.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
                break;

            case "intro":
                INTRO.mousePress(me);
                break;
                
            case "guide":
                GUIDE.mousePress(me);
                break;
                
        }
    }

    @Override
    public void mouseReleased(MouseEvent me) {
        if (State == "startRelease") {
            try {
                SoundEffect.makeSound("data/Sound/fingerprintReleaseButton.wav");
                Thread.sleep(700);
                State = "menu";
            } catch (InterruptedException ex) {
                Logger.getLogger(Begin.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if(State == "menu") {
            MENU.mousePress = false;
        }
        if (State == "credits") {
            CREDITS.mousePress=false;
        }
        if(State == "intro") {
            INTRO.mousePress = false;
        }
        if (State == "guide") {
            GUIDE.mousePress=false;
        }
    }

    @Override
    public void mouseEntered(MouseEvent me) {
       
    }

    @Override
    public void mouseExited(MouseEvent me) {
        
    }
    
    // Getters

    public static Background getBg1() {
            return bg1;
    }

    public static Background getBg2() {
            return bg2;
    }

    public static Background getBg3(){
        return bg3;
    }

    public static Background getBg4(){
        return bg4;
    }

    public static Hunter getRobot(){
            return hunter;
    }
    public static ArrayList getTileArray(){
        return tilearray;
    }
        
    // Main Function
    
    public static void main(String[] args){
        
                JFrame frame = new JFrame("Dragon Hunter");
                frame.setSize(1366, 768); 
		frame.setBackground(Color.black);
                frame.add(starter);
                frame.setUndecorated(true);
                frame.setVisible(true);
                frame.setLocationRelativeTo(null);          //the window will be on the centre
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                
                try{
                    starter.init();
                    starter.start();
                }
                catch (Exception e){
                    e.printStackTrace();
                }
                SoundEffect.makeSound("data/Sound/opening.wav");
    }
}
