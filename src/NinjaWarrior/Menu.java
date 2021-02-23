package NinjaWarrior;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import javax.swing.ImageIcon;

public class Menu {

    /**
     * images for menu button
     */
    static Image play, help, exit;

    public Rectangle p = new Rectangle(250, 80, 197, 44);
    public Rectangle h = new Rectangle(250, 130, 197, 44);
    public Rectangle e = new Rectangle(250, 180, 197, 44);

    /**
     * this method helps to draw images to the menu button
     * 
     * @param g
     */
    public void render(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        Font font = new Font("arial", Font.BOLD, 45);
        g.setFont(font);
        g.setColor(Color.white);
        g.drawString("NINJA WARRIOR", 160, 40);

        ImageIcon i = new ImageIcon("res/play.jpg");
        ImageIcon i1 = new ImageIcon("res/help.jpg");
        ImageIcon i2 = new ImageIcon("res/exit.jpg");

        play = i.getImage();
        help = i1.getImage();
        exit = i2.getImage();

        g.drawImage(play, 250, 80, null);

        g2d.draw(p);

        g.drawImage(help, 250, 130, null);
        g2d.draw(h);
        g.drawImage(exit, 250, 180, null);
        g2d.draw(e);

    }
}