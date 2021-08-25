package BuilderPattern;

import javax.swing.*;

/**
 *
 * @author Rim
 */
public class PatternPanelBuilder extends Builder {

    private JPanel mainPanel;

    @Override
    public void build() {
        this.mainPanel = PatternPanelButton.getInstancePattern().getMainPanel();

    }

    public PatternPanel getResult() {
        return PatternPanel.getInstance(mainPanel);
    }

}
