/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GraphicInterface;

import javax.swing.*;

public class PatternPanel  {

    private JPanel mainPanel, categoryPanel, creationalPanel, structuralPanel, behavioralPanel;

    public PatternPanel(JPanel mainPanel) {
        this.mainPanel = mainPanel;
    } 

    public JPanel getMainPanel() {
        return mainPanel;
    }
    
}
