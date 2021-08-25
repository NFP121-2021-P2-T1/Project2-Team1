package BuilderPattern;

import javax.swing.*;

/**
 *
 * @author Rim
 */
public class PatternPanel {

    public static PatternPanel patternPanel;
    private JPanel mainPanel;

    private PatternPanel(JPanel mainPanel) {
        this.mainPanel = mainPanel;
    }

    public static PatternPanel getInstance(JPanel mainPanel) {
        if (patternPanel == null) {
            patternPanel = new PatternPanel(mainPanel);
        }
        return patternPanel;
    }

    public static PatternPanel getInstance() {
        if (patternPanel == null) {
            patternPanel = new PatternPanel(null);
        }
        return patternPanel;
    }

    public JPanel getMainPanel() {
        if (mainPanel == null) {
            mainPanel = PatternPanelButton.getInstancePattern().getMainPanel();
        }
        return mainPanel;
    }

}
