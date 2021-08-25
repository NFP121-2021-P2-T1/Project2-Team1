package BuilderPattern;

import javax.swing.*;

/**
 *
 * @author Rim
 */
public class Director extends JFrame {

    public void construct(Builder mainFrame) {
        mainFrame.build();
    }
}
