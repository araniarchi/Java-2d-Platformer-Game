package NinjaWarrior;

import java.awt.*;

import javax.swing.ImageIcon;

/**
 * we created enemy class because we can have many enemies of same type. so
 * instead of reusing the code we create a new object of the enemy type
 * 
 * @author User
 */
public class Enemy {

        /**
         * stores image img
         */
        Image img;

        /**
         * location of enemy
         */
        int x, y;

        /**
         * determines whether enemy is alived or not. we declare it true at first.
         */
        boolean isAlive = true;

        /**
         * enemy constructor
         * 
         * @param startX:   starting x of enemy
         * @param startY:   starting y of enemy
         * @param location: location of the enemy
         */
        public Enemy(int startX, int startY, String location) {
                x = startX;
                y = startY;
                ImageIcon l = new ImageIcon(location);
                img = l.getImage();
        }

        /**
         * these methods allows other classes to access these
         * 
         * @return x, y, boolean value of isAlive(), img
         */
        public int getX() {
                return x;
        }

        public int getY() {
                return y;
        }

        public boolean Alive() {
                return isAlive;
        }

        public Image getImage() {
                return img;
        }

        /**
         * movement of enemy
         * 
         * @param dx:   the change in x position
         * @param left: actual physical position of enemy
         */
        public void move(int dx, int left) {
                if (dx == 1 && !((left + dx) < 150))// Added this to only move enemy when character moves forward (not
                                                    // back)

                        x = x - dx; // enemy image will show from right to left
        }

        /**
         * returns the boundary of enemy image
         * 
         * @return
         */
        public Rectangle getBounds() {
                return new Rectangle(x, y, 37, 39);// 73, 78
        }

}