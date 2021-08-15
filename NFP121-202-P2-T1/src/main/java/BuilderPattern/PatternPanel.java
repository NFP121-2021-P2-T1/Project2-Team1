/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BuilderPattern;

import javax.swing.*;

public class PatternPanel  {
    public static PatternPanel patternPanel;
    private JPanel mainPanel, categoryPanel, creationalPanel, structuralPanel, behavioralPanel;

    private PatternPanel(JPanel mainPanel) {
        this.mainPanel = mainPanel;
    } 
    public static PatternPanel getInstance(JPanel mainPanel){
        if(patternPanel== null) 
            patternPanel = new PatternPanel( mainPanel);
        return patternPanel;
    }
    public static PatternPanel getInstance(){
        if(patternPanel== null) 
            patternPanel = new PatternPanel(null);
        return patternPanel;
    }
    public JPanel getMainPanel() {
        if(mainPanel == null)
            mainPanel = PatternPanelButton.getInstancePattern().getMainPanel();
        return mainPanel;
    }
    
}
