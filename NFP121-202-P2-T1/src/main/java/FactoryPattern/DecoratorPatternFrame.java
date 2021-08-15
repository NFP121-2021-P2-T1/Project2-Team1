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
public class DecoratorPatternFrame extends JFrame implements ActionListener, PatternPanelTemplate {

    private static DecoratorPatternFrame decoratorPatternFrame ;
    
    private JPanel panel, decoratorPanel;
    private JEditorPane decoratorText;
    private JLabel imageLabel, title;
    private String text, path;
    private ImageIcon image;
    private JButton back, create;

    private DecoratorPatternFrame() {

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
        decoratorPanel = new JPanel(new GridBagLayout());

        //______________________________________________________________________
        decoratorText = new JEditorPane("text/html", "");
        decoratorText.setEditable(false);
        decoratorText.setOpaque(false);
        setText();

        //______________________________________________________________________
        image = new ImageIcon(getImagepath());
        imageLabel = new JLabel(image);
        title = new JLabel("Decorator Pattern");
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
        addComponent(c, decoratorPanel, back, 0, 0);
        addComponent(c, decoratorPanel, title, 1, 0);
        addComponent(c, decoratorPanel, decoratorText, 1, 1);
        addComponent(c, decoratorPanel, imageLabel, 1, 2);
        addComponent(c, decoratorPanel, create, 2, 3);

        //______________________________________________________________________ 
        panel.add(decoratorPanel);

        //______________________________________________________________________
        panel.setLayout(new GridBagLayout());
        panel.setBackground(new Color(251, 252, 251));
        panel.setVisible(true);

    }
    
    public static DecoratorPatternFrame getInstancFrame()
    {
        if(decoratorPatternFrame== null) 
            decoratorPatternFrame = new DecoratorPatternFrame();
        return decoratorPatternFrame;
    }

    public static DecoratorPatternFrame getDecoratorPatternFrame() {
        return decoratorPatternFrame;
    }

    public JEditorPane getDecoratorText() {
        return decoratorText;
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
        text = "<b>What it is : </b> \n Attach additional responsibilities to an object dynamically. "
                + "Provide a flexible alternative to sub-classing for extending functionality.";
        decoratorText.setText(text);
    }

    public String getImagepath() {
        path = "images\\decorator.png";
        return path;
    }
    
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == back) {
            decoratorPanel.setVisible(false);
            PatternPanelButton.getInstancePattern().getBack().setVisible(true);
            PatternPanelButton.getInstancePattern().getStructuralPanel().setVisible(true);

        } else if (e.getSource() == create){
            JDialog dialog = new JDialog();
        dialog.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent e) {
                dialog.dispose();
            }
        });

        JButton finish = new JButton("Finish");
        JButton cancel = new JButton("Cancel");

        JPanel container = new JPanel(new GridBagLayout());
        JLabel projectName = new JLabel("Project Name : ");
        JTextField pNameField = new JTextField(15);
        JLabel projectLoc = new JLabel("Project Location");
        JTextField pLocField = new JTextField(15);

        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.BOTH;
        c.insets = new Insets(10, 20, 10, 20);

        c.gridx = 0;
        c.gridy = 0;
        container.add(projectName, c);
        c.gridx = 0;
        c.gridy = 1;
        container.add(projectLoc, c);

        c.gridx = 1;
        c.gridy = 0;
        c.gridwidth = 2;
        container.add(pNameField, c);

        c.gridx = 1;
        c.gridy = 1;
        container.add(pLocField, c);

        c.gridwidth = 1;
        c.gridx = 1;
        c.gridy = 2;
        container.add(finish, c);

        c.gridx = 2;
        c.gridy = 2;
        container.add(cancel, c);

        container.setVisible(true);

        dialog.add(container);
        container.setSize(400, 400);
        dialog.setSize(480, 480);
        dialog.setLocationRelativeTo(null);
        dialog.setVisible(true);
            
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
