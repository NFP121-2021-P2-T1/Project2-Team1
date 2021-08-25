/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FactoryPattern;

import javax.swing.JPanel;

public interface PatternPanelTemplate {

    public static Object getPat(){return PatternPanelTemplate.getPat();}
    
    public void setText();
    public String getImagepath();
    public String getTitle();
    public JPanel getPanel();

}

