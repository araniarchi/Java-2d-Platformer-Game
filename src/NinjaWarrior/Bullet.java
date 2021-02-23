package NinjaWarrior;

import java.awt.*;

import javax.swing.ImageIcon;

/**
 * this class is going to represent each bullet player is firing
 * 
 * @author User
 */
public class Bullet {

        /**
         * x, y controls location of the bullet image stores img visible variable
         * defines whether the bullet is visible or not
         */
        int x, y;
        Image img;
        boolean visible;

        /**
         * bullet constructor
         * 
         * @param startX : starting value of x
         * @param startY : starting value of y
         */
        public Bullet(int startX, int startY) {
                x = startX;
                y = startY;

                ImageIcon newBullet = new ImageIcon("res/bullet.png");
                img = newBullet.getImage(); // image is stored in img

                visible = true; // bullet will be visible
        }

        /**
         * returns the boundary of bullet image
         * 
         * @return
         */
        public Rectangle getBounds() {
                return new Rectangle(x, y, 16, 16);
        }

        /**
         * these methods allows other classes to access these
         * 
         * @return x, y, visible, img
         */
        public int getX() {
                return x;
        }

        public int getY() {
                return y;
        }

        public boolean getVisible() {
                return visible;
        }

        public Image getImage() {
                return img;
        }

        /**
         * this method will let the bullet move
         */
        public void move() {
                x = x + 2; // here 2 is in pixels
                // it will call 2 pixels every 5 miliseconds

                if (x > 700) // if x is greater than our frame width we dont want to print bullet
                        visible = false;
        }

        public void setVisible(boolean isVisible)// down
        {
                visible = isVisible;
        }

}