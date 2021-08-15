/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FactoryPattern;

import BuilderPattern.PatternPanelButton;
import GraphicInterface.PatternPanelTemplate;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author Cynthia
 */
public class VisitorPatternFrame extends JFrame implements ActionListener, PatternPanelTemplate {

    private static VisitorPatternFrame visitorPatternFrame ;
    
    private JPanel panel, visitorPanel;
    private JEditorPane visitorText;
    private JLabel imageLabel, title;
    private String text, path;
    private ImageIcon image;
    private JButton back, create;

    private VisitorPatternFrame() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        //_________________MainPanel____________________________________________
        
        panel = new JPanel();

        //________________Layout________________________________________________
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.BOTH;
        c.weightx = 0.5;
        c.weighty = 1.0;
        c.insets = new Insets(10, 20, 10, 20);

        //______________________________________________________________________
        visitorPanel = new JPanel(new GridBagLayout());

        //______________________________________________________________________
        visitorText = new JEditorPane("text/html", "");
        visitorText.setEditable(false);
        visitorText.setOpaque(false);
        setText();

        //______________________________________________________________________
        image = new ImageIcon(getImagepath());
        imageLabel = new JLabel(image);
        title = new JLabel("Visitor Pattern");
        title.setFont(new Font("", Font.BOLD, 20));
        //______________________________________________________________________
        back = new JButton("< Back");
        create = new JButton("Next >");

        //______________________________________________________________________
        back.setFocusable(false);
        create.setFocusable(false);

        //______________________________________________________________________
        back.addActionListener(this);
        create.addActionListener(this);

        //______________________________________________________________________
        addComponent(c, visitorPanel, back, 0, 0);
        addComponent(c, visitorPanel, title, 1, 0);
        addComponent(c, visitorPanel, visitorText, 1, 1);
        addComponent(c, visitorPanel, imageLabel, 1, 2);
        addComponent(c, visitorPanel, create, 2, 3);

        //______________________________________________________________________ 
        panel.add(visitorPanel);

        //______________________________________________________________________
        panel.setLayout(new GridBagLayout());
        panel.setBackground(new Color(251, 252, 251));
        panel.setVisible(true);

    }
    
    public static VisitorPatternFrame getInstancFrame()
    {
        if(visitorPatternFrame== null) 
            visitorPatternFrame = new VisitorPatternFrame();
        return visitorPatternFrame;
    }

    public static VisitorPatternFrame getVisitorPatternFrame() {
        return visitorPatternFrame;
    }

    public JEditorPane getVisitorText() {
        return visitorText;
    }

    public JLabel getImageLabel() {
        return imageLabel;
    }

    public String getText() {
        return text;
    }

    public String getPath() {
        return path;
    }

    public ImageIcon getImage() {
        return image;
    }

    public JButton getBack() {
        return back;
    }

    public JButton getCreate() {
        return create;
    }
    

    public void setText() {
        text = "<b>What it is : </b> \n Represent an operation to be performed on the elements of an "
                + "object structure. Lets you define a new operation without changing the classes of the elements on which it operates.";
        visitorText.setText(text);
    }

    public String getImagepath() {
        path = "images\\visitor.png";
        return path;
    }
    
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == back) {
            visitorPanel.setVisible(false);
            PatternPanelButton.getInstancePattern().getBack().setVisible(true);
            PatternPanelButton.getInstancePattern().getBehavioralPanel().setVisible(true);

        }
    }

    public JPanel getPanel() {
        return panel;
    }

    public void addComponent(GridBagConstraints c, JPanel panel, JComponent comp, int x, int y) {
        c.gridx = x;
        c.gridy = y;
        panel.add(comp, c);
    }

}
