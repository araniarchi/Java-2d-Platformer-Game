package NinjaWarrior;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;

public class Player {
        /**
         * Here, x and y is the initial position of the player dx is the change in x
         * co-ordinate while moving variable left controls the player's actual physical
         * position on the screen while variable x controls how much player has moved
         * relative to starting point nx controls the first background nx2 controls the
         * second background
         */
        int x, dx, y, nx, nx2, left, dy;

        /**
         * images for player's movement
         */
        Image still, jump, reverse;

        int fireball = 30;

        /**
         * reads image file.
         */
        ImageIcon s = new ImageIcon("res/idle.gif");
        ImageIcon j = new ImageIcon("res/jump.png");
        ImageIcon l = new ImageIcon("res/run.gif");
        ImageIcon d = new ImageIcon("res/landing.png");

        static ArrayList bullets;

        public Player() {

                /**
                 * initialization
                 */
                x = 75;
                left = 150;// 150
                nx = 0;

                /**
                 * instead of making our background at (0, 0) we are going to set a variable to
                 * it. so to do that we introduce a variable nx2.
                 */
                nx2 = 685;
                y = 100;
                still = s.getImage();
                bullets = new ArrayList();

        }

        /**
         * returns the boundary of player image
         * 
         * @return
         */
        public Rectangle getBounds() {
                return new Rectangle(left, y, 21, 34);
        }

        /**
         * this method has all the bullet objects in it and returns the bullets if
         * called
         * 
         * @return
         */
        public static ArrayList getBullets() {
                return bullets;
        }

        /**
         * it creates new objects from the bullet class and it adds it to the array list
         */
        public void fire() {
                if (fireball > 0) {
                        fireball--;
                        Bullet z = new Bullet((left + 30), (GamePanel.v + 15));
                        bullets.add(z);
                }
        }

        /**
         * this method determines the movement of the player
         */
        public void move() {
                if (dx != -1) {
                        if (left + dx <= 150)
                                left += dx; // it increases player's position if smaller than 150

                        else // otherwise it moved the whole background
                        {
                                x = x + dx;
                                nx2 = nx2 + dx;
                                nx = nx + dx;
                        }
                } else {
                        if (left + dx > 0) // it helps the player to update position
                                left = left + dx;
                }
        }

        /**
         * These methods are used to access x, left, nx2, dx, still from other class
         */
        public int getX() {
                return x;
        }

        public int getLeft() {
                return left;
        }

        public int getnX() {
                return nx;
        }

        public int getnX2() {
                return nx2;
        }

        public int getdx() {
                return dx;
        }

        public Image getImage() {
                return still;
        }

        /**
         * what happens if key is pressed
         * 
         * @param e
         */
        public void keyPressed(KeyEvent e) {
                int key = e.getKeyCode();
                if (key == KeyEvent.VK_LEFT) {
                        dx = -1;
                        still = l.getImage();
                }

                if (key == KeyEvent.VK_RIGHT) {
                        dx = 1;
                        still = l.getImage();
                }

                if (key == KeyEvent.VK_F) {
                        fire();
                }

                if (key == KeyEvent.VK_UP) {
                        dy = 1;

                        still = j.getImage();
                }
        }

        /**
         * what happens if key is released
         * 
         * @param e
         */
        public void keyReleased(KeyEvent e) {
                int key = e.getKeyCode();

                if (key == KeyEvent.VK_LEFT) {
                        dx = 0;
                        still = s.getImage();
                }

                if (key == KeyEvent.VK_RIGHT) {
                        dx = 0;
                        still = s.getImage();
                }

                if (key == KeyEvent.VK_UP) {

                        dy = 0;
                        still = d.getImage();
                }
        }
}