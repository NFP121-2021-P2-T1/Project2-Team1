/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GraphicInterface;

import javax.swing.*;

public class PatternPanel  {

    private JPanel mainPanel, categoryPanel, creationalPanel, structuralPanel, behavioralPanel;

    public PatternPanel(JPanel mainPanel, JPanel categoryPanel, JPanel creationalPanel, JPanel structuralPanel,JPanel behavioralPanel) {
        this.mainPanel = mainPanel;
        this.categoryPanel = categoryPanel;
        this.creationalPanel = creationalPanel;
        this.structuralPanel = structuralPanel;
        this.behavioralPanel = behavioralPanel;
    } 

    public JPanel getMainPanel() {
        return mainPanel;
    }
    
}
