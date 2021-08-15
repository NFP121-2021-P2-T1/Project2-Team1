/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BuilderPattern;

import javax.swing.*;

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
