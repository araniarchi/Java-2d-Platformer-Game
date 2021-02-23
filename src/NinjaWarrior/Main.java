package NinjaWarrior;

import javax.swing.*;

/**
 * This class creates the main frame of our game.
 */
public class Main extends JFrame {

        public Main() {
                JFrame frame = new JFrame();
                frame.add(new GamePanel());
                frame.setTitle("NINJA WARRIOR");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setSize(700, 330);
                frame.setResizable(false);
                frame.setVisible(true);
                frame.setLocationRelativeTo(null);
        }

        public static void main(String[] args) {
                JFrame ob = new Main();
        }

}