package NinjaWarrior;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;

public class GamePanel extends JPanel implements ActionListener, Runnable {
        /**
         * Instantiates the main player of our game.
         */
        Player p;

        /**
         * Instantiates background image of our game and menu image.
         */
        public Image img, menuBg;

        /**
         * Instantiates time of how fast a player can run.
         */
        Timer time;

        /**
         * controls the vertical position of the player corresponds to character's
         * position when it is jumping
         */
        static int v = 122;// 122

        /**
         * Instantiates menu object of Menu class
         */
        private Menu Menu;

        /**
         * Instantiates Frame object of Menu class
         */
        private Main Frame;

        /**
         * Instantiates Thread object animator starts the animation
         */
        Thread animation;

        /**
         * Instantiates the enemy objects
         */
        Enemy en, en2, en3, en4, en5, en6, en7, en8, en9, en10, en11, en12, en13, en14, en15, en16, en17, en18, en19,
                        en20;

        /**
         * initializes the score
         */
        public int score = 0;

        /**
         * defines lost to false at first
         */
        boolean died = false;

        /**
         * 
         */
        boolean done2 = false;

        /**
         * defines MENU, GAME methods
         */
        public static enum STATE {
                MENU, GAME
        };

        /**
         * this indicates showing menu
         */
        public static STATE State = STATE.MENU;

        static Font font = new Font("Arial", Font.BOLD, 24);

        public GamePanel() {

                this.addMouseListener(new MouseInput());

                Menu = new Menu();

                p = new Player();

                addKeyListener(new AL()); // Listen for keys

                setFocusable(true); // Allows movement

                ImageIcon ii = new ImageIcon("res/backgroundmenu (1).jpg"); // Image for menu
                menuBg = ii.getImage();

                ImageIcon i = new ImageIcon("res/bgxbg.jpg"); // Image for background
                img = i.getImage();

                /**
                 * time required for updating image
                 */
                time = new Timer(5, this); // how fast the player will run
                time.start();

                /**
                 * enemy initialization
                 */
                en = new Enemy(700, 120, "res/bee.gif");
                en2 = new Enemy(700, 120, "res/bee.gif");
                en3 = new Enemy(700, 120, "res/bee.gif");
                en4 = new Enemy(700, 120, "res/bee.gif");
                en5 = new Enemy(700, 120, "res/bee.gif");
                en6 = new Enemy(700, 120, "res/bee.gif");
                en7 = new Enemy(700, 120, "res/bee.gif");
                en8 = new Enemy(700, 120, "res/bee.gif");
                en9 = new Enemy(700, 120, "res/bee.gif");
                en10 = new Enemy(700, 120, "res/bee.gif");
                en11 = new Enemy(700, 120, "res/bee.gif");
                en12 = new Enemy(700, 120, "res/bee.gif");
                en13 = new Enemy(700, 120, "res/bee.gif");
                en14 = new Enemy(700, 120, "res/bee.gif");
                en15 = new Enemy(700, 120, "res/bee.gif");
                en16 = new Enemy(700, 120, "res/bee.gif");
                en17 = new Enemy(700, 120, "res/bee.gif");
                en18 = new Enemy(700, 120, "res/bee.gif");
                en19 = new Enemy(700, 120, "res/bee.gif");
                en20 = new Enemy(700, 120, "res/bee.gif");
        }

        /**
         * this method states the actions performed
         * 
         * @param e
         */
        @Override
        public void actionPerformed(ActionEvent e) {
                try {
                        checkCollisions();
                } catch (Exception ex) {

                }
                ArrayList bullets = Player.getBullets();
                for (int b = 0; b < bullets.size(); b++) {
                        Bullet m = (Bullet) bullets.get(b);
                        if (m.getVisible() == true) // if bullets are visible it will move
                                m.move();
                        else
                                bullets.remove(b);
                }
                /**
                 * calls the move method from player class
                 */
                p.move();

                if (p.x > 400)
                        en.move(p.getdx(), p.getLeft());
                if (p.x > 500)
                        en2.move(p.getdx(), p.getLeft());
                if (p.x > 600)
                        en3.move(p.getdx(), p.getLeft());
                if (p.x > 700)
                        en4.move(p.getdx(), p.getLeft());
                if (p.x > 800)
                        en5.move(p.getdx(), p.getLeft());
                if (p.x > 900)
                        en6.move(p.getdx(), p.getLeft());
                if (p.x > 1000)
                        en7.move(p.getdx(), p.getLeft());
                if (p.x > 1100)
                        en8.move(p.getdx(), p.getLeft());
                if (p.x > 1200)
                        en9.move(p.getdx(), p.getLeft());
                if (p.x > 1300)
                        en10.move(p.getdx(), p.getLeft());
                if (p.x > 1400)
                        en11.move(p.getdx(), p.getLeft());
                if (p.x > 1500)
                        en12.move(p.getdx(), p.getLeft());
                if (p.x > 1600)
                        en13.move(p.getdx(), p.getLeft());
                if (p.x > 1700)
                        en14.move(p.getdx(), p.getLeft());
                if (p.x > 1800)
                        en15.move(p.getdx(), p.getLeft());
                if (p.x > 1900)
                        en16.move(p.getdx(), p.getLeft());
                if (p.x > 2000)
                        en17.move(p.getdx(), p.getLeft());
                if (p.x > 2100)
                        en18.move(p.getdx(), p.getLeft());
                if (p.x > 2200)
                        en19.move(p.getdx(), p.getLeft());
                if (p.x > 2300)
                        en20.move(p.getdx(), p.getLeft());

                /**
                 * updating image.
                 */
                repaint();
        }

        public void checkCollisions() {
                Rectangle r1 = en.getBounds();
                Rectangle r2 = en2.getBounds();
                Rectangle r3 = en3.getBounds();
                Rectangle r4 = en4.getBounds();
                Rectangle r5 = en5.getBounds();
                Rectangle r6 = en6.getBounds();
                Rectangle r7 = en7.getBounds();
                Rectangle r8 = en8.getBounds();
                Rectangle r9 = en9.getBounds();
                Rectangle r10 = en10.getBounds();
                Rectangle r11 = en11.getBounds();
                Rectangle r12 = en12.getBounds();
                Rectangle r13 = en13.getBounds();
                Rectangle r14 = en14.getBounds();
                Rectangle r15 = en15.getBounds();
                Rectangle r16 = en16.getBounds();
                Rectangle r17 = en17.getBounds();
                Rectangle r18 = en18.getBounds();
                Rectangle r19 = en19.getBounds();
                Rectangle r20 = en20.getBounds();

                ArrayList bullets = Player.getBullets();
                for (int b = 0; b < bullets.size(); b++) {
                        Bullet m = (Bullet) bullets.get(b);
                        Rectangle m1 = m.getBounds();
                        if (r1.intersects(m1) && en.Alive()) {
                                score += 10;

                                en.isAlive = false;
                                m.visible = false;
                        } else if (r2.intersects(m1) && en2.Alive()) {
                                score += 10;
                                en2.isAlive = false;
                                m.visible = false;
                        }
                        if (r3.intersects(m1) && en3.Alive()) {
                                score += 10;

                                en3.isAlive = false;
                                m.visible = false;
                        } else if (r4.intersects(m1) && en4.Alive()) {
                                score += 10;
                                en4.isAlive = false;
                                m.visible = false;
                        }
                        if (r5.intersects(m1) && en5.Alive()) {
                                score += 10;

                                en5.isAlive = false;
                                m.visible = false;
                        } else if (r6.intersects(m1) && en6.Alive()) {
                                score += 10;
                                en6.isAlive = false;
                                m.visible = false;
                        }
                        if (r7.intersects(m1) && en7.Alive()) {
                                score += 10;

                                en7.isAlive = false;
                                m.visible = false;
                        } else if (r8.intersects(m1) && en8.Alive()) {
                                score += 10;
                                en8.isAlive = false;
                                m.visible = false;
                        }
                        if (r9.intersects(m1) && en9.Alive()) {
                                score += 10;

                                en9.isAlive = false;
                                m.visible = false;
                        } else if (r10.intersects(m1) && en10.Alive()) {
                                score += 10;
                                en10.isAlive = false;
                                m.visible = false;
                        }
                        if (r11.intersects(m1) && en11.Alive()) {
                                score += 10;

                                en11.isAlive = false;
                                m.visible = false;
                        } else if (r12.intersects(m1) && en12.Alive()) {
                                score += 10;
                                en12.isAlive = false;
                                m.visible = false;
                        }
                        if (r13.intersects(m1) && en13.Alive()) {
                                score += 10;

                                en13.isAlive = false;
                                m.visible = false;
                        } else if (r14.intersects(m1) && en14.Alive()) {
                                score += 10;
                                en14.isAlive = false;
                                m.visible = false;
                        }
                        if (r15.intersects(m1) && en15.Alive()) {
                                score += 10;

                                en15.isAlive = false;
                                m.visible = false;
                        } else if (r16.intersects(m1) && en16.Alive()) {
                                score += 10;
                                en16.isAlive = false;
                                m.visible = false;
                        }
                        if (r17.intersects(m1) && en17.Alive()) {
                                score += 10;

                                en17.isAlive = false;
                                m.visible = false;
                        } else if (r18.intersects(m1) && en18.Alive()) {
                                score += 10;
                                en18.isAlive = false;
                                m.visible = false;
                        }
                        if (r19.intersects(m1) && en19.Alive()) {
                                score += 10;

                                en19.isAlive = false;
                                m.visible = false;
                        } else if (r20.intersects(m1) && en20.Alive()) {
                                score += 10;
                                en20.isAlive = false;
                                m.visible = false;
                        }
                }
                /**
                 * gets the boundary of player and assigns it to d
                 */
                Rectangle d = p.getBounds();
                /**
                 * these checks whether we collide with an enemy or not if we collide with an
                 * enemy which is alive then we lose the game
                 */
                if (en.Alive() == true) {
                        if (d.intersects(r1)) {
                                died = true;
                        }
                } else if (en.Alive() == false) {
                        died = false;
                }
                if (en2.Alive() == true) {
                        if (d.intersects(r2))
                                died = true;
                } else if (en2.Alive() == false) {
                        died = false;
                }
                if (en3.Alive() == true) {
                        if (d.intersects(r3)) {
                                died = true;
                        }
                } else if (en3.Alive() == false) {
                        died = false;
                }
                if (en4.Alive() == true) {
                        if (d.intersects(r4)) {
                                died = true;
                        }
                } else if (en4.Alive() == false) {
                        died = false;
                }
                if (en5.Alive() == true) {
                        if (d.intersects(r5)) {
                                died = true;
                        }
                } else if (en5.Alive() == false) {
                        died = false;
                }
                if (en6.Alive() == true) {
                        if (d.intersects(r6)) {
                                died = true;
                        }
                } else if (en6.Alive() == false) {
                        died = false;
                }
                if (en7.Alive() == true) {
                        if (d.intersects(r7)) {
                                died = true;
                        }
                } else if (en7.Alive() == false) {
                        died = false;
                }
                if (en8.Alive() == true) {
                        if (d.intersects(r8)) {
                                died = true;
                        }
                } else if (en8.Alive() == false) {
                        died = false;
                }
                if (en9.Alive() == true) {
                        if (d.intersects(r9)) {
                                died = true;
                        }
                } else if (en9.Alive() == false) {
                        died = false;
                }
                if (en10.Alive() == true) {
                        if (d.intersects(r10)) {
                                died = true;
                        }
                } else if (en10.Alive() == false) {
                        died = false;
                }
                if (en11.Alive() == true) {
                        if (d.intersects(r11)) {
                                died = true;
                        }
                } else if (en11.Alive() == false) {
                        died = false;
                }
                if (en12.Alive() == true) {
                        if (d.intersects(r12)) {
                                died = true;
                        }
                } else if (en12.Alive() == false) {
                        died = false;
                }
                if (en13.Alive() == true) {
                        if (d.intersects(r13)) {
                                died = true;
                        }
                } else if (en13.Alive() == false) {
                        died = false;
                }
                if (en14.Alive() == true) {
                        if (d.intersects(r14)) {
                                died = true;
                        }
                } else if (en14.Alive() == false) {
                        died = false;
                }
                if (en15.Alive() == true) {
                        if (d.intersects(r15)) {
                                died = true;
                        }
                } else if (en15.Alive() == false) {
                        died = false;
                }
                if (en16.Alive() == true) {
                        if (d.intersects(r16)) {
                                died = true;
                        }
                } else if (en16.Alive() == false) {
                        died = false;
                }
                if (en17.Alive() == true) {
                        if (d.intersects(r17)) {
                                died = true;
                        }
                } else if (en17.Alive() == false) {
                        died = false;
                }
                if (en18.Alive() == true) {
                        if (d.intersects(r18)) {
                                died = true;
                        }
                } else if (en18.Alive() == false) {
                        died = false;
                }
                if (en19.Alive() == true) {
                        if (d.intersects(r19)) {
                                died = true;
                        }
                } else if (en19.Alive() == false) {
                        died = false;
                }
                if (en20.Alive() == true) {
                        if (d.intersects(r20)) {
                                died = true;
                        }
                } else if (en20.Alive() == false) {
                        died = false;
                }
        }

        /**
         * draws images to frame
         * 
         * @param g
         */
        public void paint(Graphics g) {

                if (died) {
                        // g.drawString("GAME OVER!\n Total Score:"+score, 400, 300);
                        System.out.println("GAME OVER");
                        System.out.println("Total Score: " + score);
                        System.exit(0);
                }

                if (p.dy == 1 && done2 == false) {
                        done2 = true;
                        animation = new Thread(this);
                        animation.start();
                }

                super.paint(g);
                Graphics2D g2d = (Graphics2D) g;

                if (State == STATE.GAME) {
                        if ((p.getX() - 570) % 2400 == 0)
                                p.nx = 0;
                        if ((p.getX() - 1790) % 2400 == 0)
                                p.nx2 = 0;// 1790

                        g2d.drawImage(img, 685 - p.getnX2(), 0, null);
                        // System.out.println(p.getX());

                        if (p.getX() > 570) // we get a new image when we get a value greater than 570
                        {
                                g2d.drawImage(img, 685 - p.getnX(), 0, null);
                        }
                        g2d.drawImage(p.getImage(), p.left, v, null);

                        if (p.getdx() == -1) {
                                g2d.drawImage(img, 685 - p.getnX2(), 0, null);
                                g2d.drawImage(p.getImage(), p.left, v, null);
                        }
                } else {
                        g.drawImage(menuBg, 0, 0, null);
                        Menu.render(g);
                }

                ArrayList bullets = Player.getBullets(); // player class returns bullet as an arraylist, so we need to
                                                         // create an arraylist for it
                for (int w = 0; w < bullets.size(); w++) {
                        Bullet m = (Bullet) bullets.get(w); // to get the bullet object we need to create m object,
                        // to store w and cast this into bullets

                        if (m.getVisible())
                                g2d.drawImage(m.getImage(), m.getX(), m.getY(), null); // drawing bullet
                }

                if (p.x > 400)
                        if (en.Alive() == true)
                                g2d.drawImage(en.getImage(), en.getX(), en.getY(), null);
                if (p.x > 500)
                        if (en2.Alive() == true)
                                g2d.drawImage(en2.getImage(), en2.getX(), en2.getY(), null);
                if (p.x > 600)
                        if (en3.Alive() == true)
                                g2d.drawImage(en3.getImage(), en3.getX(), en3.getY(), null);
                if (p.x > 700)
                        if (en4.Alive() == true)
                                g2d.drawImage(en4.getImage(), en4.getX(), en4.getY(), null);
                if (p.x > 800)
                        if (en5.Alive() == true)
                                g2d.drawImage(en5.getImage(), en5.getX(), en5.getY(), null);
                if (p.x > 900)
                        if (en6.Alive() == true)
                                g2d.drawImage(en6.getImage(), en6.getX(), en6.getY(), null);
                if (p.x > 1000)
                        if (en7.Alive() == true)
                                g2d.drawImage(en7.getImage(), en7.getX(), en7.getY(), null);
                if (p.x > 1100)
                        if (en8.Alive() == true)
                                g2d.drawImage(en8.getImage(), en8.getX(), en8.getY(), null);
                if (p.x > 1200)
                        if (en9.Alive() == true)
                                g2d.drawImage(en9.getImage(), en9.getX(), en9.getY(), null);
                if (p.x > 1300)
                        if (en10.Alive() == true)
                                g2d.drawImage(en10.getImage(), en10.getX(), en10.getY(), null);
                if (p.x > 1400)
                        if (en11.Alive() == true)
                                g2d.drawImage(en11.getImage(), en11.getX(), en11.getY(), null);
                if (p.x > 1500)
                        if (en12.Alive() == true)
                                g2d.drawImage(en12.getImage(), en12.getX(), en12.getY(), null);
                if (p.x > 1600)
                        if (en13.Alive() == true)
                                g2d.drawImage(en13.getImage(), en13.getX(), en13.getY(), null);
                if (p.x > 1700)
                        if (en14.Alive() == true)
                                g2d.drawImage(en14.getImage(), en14.getX(), en14.getY(), null);
                if (p.x > 1800)
                        if (en15.Alive() == true)
                                g2d.drawImage(en15.getImage(), en15.getX(), en15.getY(), null);
                if (p.x > 1900)
                        if (en16.Alive() == true)
                                g2d.drawImage(en16.getImage(), en16.getX(), en16.getY(), null);
                if (p.x > 2000)
                        if (en17.Alive() == true)
                                g2d.drawImage(en17.getImage(), en17.getX(), en17.getY(), null);
                if (p.x > 2100)
                        if (en18.Alive() == true)
                                g2d.drawImage(en18.getImage(), en18.getX(), en18.getY(), null);
                if (p.x > 2200)
                        if (en19.Alive() == true)
                                g2d.drawImage(en19.getImage(), en19.getX(), en19.getY(), null);
                if (p.x > 2300)
                        if (en20.Alive() == true)
                                g2d.drawImage(en20.getImage(), en20.getX(), en20.getY(), null);
        }

        /**
         * tells us what happens when a key is pressed and released
         */

        private class AL extends KeyAdapter {
                public void keyReleased(KeyEvent e) {
                        p.keyReleased(e);
                }

                public void keyPressed(KeyEvent e) {
                        p.keyPressed(e);
                }
        }

        /**
         * this h will tell us when the player is at the peak of his jump
         */
        boolean h = false;
        /**
         * this done will tell us when the player's whole jumping is done
         */
        boolean done = false;

        /**
         * cycle is basically jumping, as it changes along with y coordinate
         */
        public void cycle() {

                if (h == false) // we are subtracting while moving up
                        v--;

                if (v == 80) // if v is some maximum value we will set h true
                        h = true;

                if (h == true && v <= 122)// now we are adding values meaning we are coming back down
                {
                        v++;
                        if (v == 122) {
                                done = true;
                        }
                }
        }

        /**
         * runs the thread animator
         */
        public void run() {

                /**
                 * system clock to animate our character
                 */
                long beforeTime, timeDiff, sleep;

                beforeTime = System.currentTimeMillis();

                while (done == false) {

                        cycle();

                        timeDiff = System.currentTimeMillis() - beforeTime;
                        sleep = 10 - timeDiff;

                        if (sleep < 0)
                                sleep = 2;
                        try {
                                Thread.sleep(15);
                        } catch (InterruptedException e) {
                        }

                        beforeTime = System.currentTimeMillis();
                }
                done = false;
                h = false;
                done2 = false;
        }

}