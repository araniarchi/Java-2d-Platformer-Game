package NinjaWarrior;

import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.ImageIcon;

/**
 * This class helps to listen the mouse input and works accordingly
 * 
 * @author User
 */
public class MouseInput implements MouseListener {

    // Image ig;

    Help hp = new Help();

    public void mousePressed(MouseEvent e) {

    }

    /**
     * this method works when mouse is clicked
     * 
     * @param e
     */
    public void mouseClicked(MouseEvent e) {

        // ImageIcon gi=new ImageIcon("G:/play.jpg");
        // ig=gi.getImage();
        int xl = e.getX();
        int yl = e.getY();

        if (xl >= 250 && xl <= 447) // boundary of x axis
        {
            if (yl >= 80 && yl <= 124) // boundary of y axis for play button
            {

                GamePanel.State = GamePanel.STATE.GAME;
            }
            if (yl >= 130 && yl <= 174) // boundary of y axis for help button
            {
                hp.help();
            }
            if (yl >= 180 && yl <= 224) // boundary of y axis for exit button
            {
                System.exit(1);
            }
        }
    }

    public void mouseReleased(MouseEvent e) {
    }

    public void mouseEntered(MouseEvent e) {
    }

    public void mouseExited(MouseEvent e) {
    }
}
