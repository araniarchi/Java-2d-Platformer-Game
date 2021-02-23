package NinjaWarrior;

import java.awt.Font;

import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author User
 */
public class Help extends JFrame {
    Image k;
    private JLabel j, j1, j2;
    private Font f;

    public void help() {
        JFrame frame = new JFrame(); // Create JFrame called frame

        // Go to board class
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Make frame close on X click
        frame.setSize(700, 330);
        // frame.setIconImage("H:/ICS3U1/scene.jpg");
        frame.setResizable(false); // Make sure the user can't resize the frame
        frame.setLocation(20, 50); // Place the frame in a nicer position
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);// Make the frame visible
        Font font = new Font("arial", Font.BOLD, 25);
        j = new JLabel("1.To move the player press the arrow buttons.");

        j1 = new JLabel("2.To jump press the up button.");
        j2 = new JLabel("3.To shoot use \"F\" button.");
        j.setBounds(10, 20, 600, 30);
        j1.setBounds(10, 80, 500, 30);
        j2.setBounds(10, 140, 300, 30);
        j.setFont(font);
        j1.setFont(font);
        j2.setFont(font);
        frame.add(j);
        frame.add(j1);
        frame.add(j2);
    }

}
