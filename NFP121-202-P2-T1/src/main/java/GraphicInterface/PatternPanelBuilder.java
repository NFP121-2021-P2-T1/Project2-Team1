/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GraphicInterface;

import javax.swing.*;

public class PatternPanelBuilder extends Builder {

    private JPanel mainPanel, categoryPanel, creationalPanel, structuralPanel, behavioralPanel;

    @Override
    public void build() {
        this.mainPanel = new PatternPanelButton().getMainPanel();
        this.categoryPanel = new PatternPanelButton().getCategoryPanel();
        this.creationalPanel = new PatternPanelButton().getCreationalPanel();
        this.structuralPanel = new PatternPanelButton().getStructuralPanel();
        this.behavioralPanel = new PatternPanelButton().getBehavioralPanel();

    }

    public PatternPanel getResult() {
        return new PatternPanel(mainPanel, categoryPanel, creationalPanel, structuralPanel, behavioralPanel);
    }

}
