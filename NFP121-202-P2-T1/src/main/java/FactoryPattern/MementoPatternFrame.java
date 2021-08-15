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
public class MementoPatternFrame extends JFrame implements ActionListener, PatternPanelTemplate {

    private static MementoPatternFrame mementoPatternFrame ;
    
    private JPanel panel, mementoPanel;
    private JEditorPane mementoText;
    private JLabel imageLabel, title;
    private String text, path;
    private ImageIcon image;
    private JButton back, create;

    private MementoPatternFrame() {

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
        mementoPanel = new JPanel(new GridBagLayout());

        //______________________________________________________________________
        mementoText = new JEditorPane("text/html", "");
        mementoText.setEditable(false);
        mementoText.setOpaque(false);
        setText();

        //______________________________________________________________________
        image = new ImageIcon(getImagepath());
        imageLabel = new JLabel(image);
        title = new JLabel("Memento Pattern");
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
        addComponent(c, mementoPanel, back, 0, 0);
        addComponent(c, mementoPanel, title, 1, 0);
        addComponent(c, mementoPanel, mementoText, 1, 1);
        addComponent(c, mementoPanel, imageLabel, 1, 2);
        addComponent(c, mementoPanel, create, 2, 3);

        //______________________________________________________________________ 
        panel.add(mementoPanel);

        //______________________________________________________________________
        panel.setLayout(new GridBagLayout());
        panel.setBackground(new Color(251, 252, 251));
        panel.setVisible(true);

    }
    
    public static MementoPatternFrame getInstancFrame()
    {
        if(mementoPatternFrame== null) 
            mementoPatternFrame = new MementoPatternFrame();
        return mementoPatternFrame;
    }

    public static MementoPatternFrame getBuilderPatternFrame() {
        return mementoPatternFrame;
    }

    public JEditorPane getMementoText() {
        return mementoText;
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
        text = "<b>What it is : </b> \n Without violating encapsulation, capture and externalize an object's internal state  "
                + "so that the object can be restored to this state later.";
        mementoText.setText(text);
    }

    public String getImagepath() {
        path = "images\\memento.png";
        return path;
    }
    
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == back) {
            mementoPanel.setVisible(false);
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
