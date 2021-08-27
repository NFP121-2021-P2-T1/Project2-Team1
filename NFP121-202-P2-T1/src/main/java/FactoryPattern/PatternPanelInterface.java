/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FactoryPattern;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public interface PatternPanelInterface {

    public void setText();
    public JPanel getContainer();
    public JPanel getPanel();
    public JButton getBackBtn();
    public JButton getBrowse();
    public JButton getCancel();
    public JButton getCreate();
    public JButton getFinish();
    public JLabel getImageLabel();
    public JLabel getProjectLoc();
    public JLabel getProjectName();
    public JTextField getMyTextFiled();
    public JTextField getpLocField();
    public JTextField getpNameField();
    public JDialog getDialog();
    public ImageIcon getImage();
    public String getImagepath();
    public String getText();
    public String getPath();
    public String getNamePath();
    public String getPa();

}

