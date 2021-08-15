/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BuilderPattern;

import FactoryPattern.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class PatternPanelButton implements ActionListener {
    
    public static PatternPanelButton pattern ;
    
    private JPanel mainPanel, categoryPanel, creationalPanel, structuralPanel, behavioralPanel;
    private JButton creationalBtn, structuralBtn, behavioralBtn;

    private JButton builderBtn, singletonBtn;
    private JButton decoratorBtn, compositeBtn;
    private JButton mementoBtn, visitorBtn;
    private JButton back;

    private JPanel builderFrame;
    private JPanel singletonFrame;
    private JPanel compositeFrame;
    private JPanel decoratorFrame;
    private JPanel mementoFrame;
    private JPanel visitorFrame;

    private PatternPanelButton() {
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.BOTH;
        c.weightx = 0.5;
        c.weighty = 1.0;
        c.insets = new Insets(10, 20, 10, 20);

        //______________________________________________________________________
        mainPanel = new JPanel(new GridBagLayout());
        creationalPanel = new JPanel(new GridBagLayout());

        categoryPanel = new JPanel(new GridBagLayout());
        structuralPanel = new JPanel(new GridBagLayout());
        behavioralPanel = new JPanel(new GridBagLayout());

        //____________________Pattern Categories__________________________________________________
        creationalBtn = new JButton("Creational Pattern");
        structuralBtn = new JButton("Structural Pattern");
        behavioralBtn = new JButton("Behavioral Pattern");

        creationalBtn.setPreferredSize(new Dimension(150, 100));
        structuralBtn.setPreferredSize(new Dimension(150, 100));
        behavioralBtn.setPreferredSize(new Dimension(150, 100));

        //__________________Set button unfocusable____________________________________________________
        creationalBtn.setFocusable(false);
        structuralBtn.setFocusable(false);
        behavioralBtn.setFocusable(false);

        //__________________Set button border_____________________________________________________
        // creationalBtn.setBorder(new RoundedBorder(20));
        // structuralBtn.setBorder(new RoundedBorder(20));
        // behavioralBtn.setBorder(new RoundedBorder(20));  
        //__________________________Creational Pattern____________________________________________
        builderBtn = new JButton("Builder Pattern");
        singletonBtn = new JButton("Singleton Pattern");

        builderBtn.setPreferredSize(new Dimension(150, 100));
        singletonBtn.setPreferredSize(new Dimension(150, 100));

        //Set button unfocusable
        builderBtn.setFocusable(false);
        singletonBtn.setFocusable(false);
        //Set button border
        // builderBtn.setBorder(new RoundedBorder(20));
        // singletonBtn.setBorder(new RoundedBorder(20)); 

        //___________________Structural Patterns___________________________________________________
        decoratorBtn = new JButton("Decorator Pattern");
        compositeBtn = new JButton("Composite Pattern");

        decoratorBtn.setPreferredSize(new Dimension(150, 100));
        compositeBtn.setPreferredSize(new Dimension(150, 100));

        //Set button unfocusable
        decoratorBtn.setFocusable(false);
        compositeBtn.setFocusable(false);
        //Set button border
        // decoratorBtn.setBorder(new RoundedBorder(20));
        // compositeBtn.setBorder(new RoundedBorder(20));

        //______________________Behavioral Pattern________________________________________________
        mementoBtn = new JButton("Memento Pattern");
        visitorBtn = new JButton("Vistor Pattern");

        mementoBtn.setPreferredSize(new Dimension(150, 100));
        visitorBtn.setPreferredSize(new Dimension(150, 100));

        //Set button unfocusable
        mementoBtn.setFocusable(false);
        visitorBtn.setFocusable(false);
        //Set button border
        //mementoBtn.setBorder(new RoundedBorder(20));
        //visitorBtn.setBorder(new RoundedBorder(20));

        //______________________________________________________________________
        back = new JButton("Back");

        //Set button unfocusable
        back.setFocusable(false);
        //Set button border
        //back.setBorder(new RoundedBorder(20));
        //______________________________________________________________________

        addComponent(c, creationalPanel, builderBtn, 0, 0);
        addComponent(c, creationalPanel, singletonBtn, 1, 0);
        //______________________________________________________________________

        addComponent(c, structuralPanel, compositeBtn, 0, 0);
        addComponent(c, structuralPanel, decoratorBtn, 1, 0);
        //______________________________________________________________________

        addComponent(c, behavioralPanel, mementoBtn, 0, 0);
        addComponent(c, behavioralPanel, visitorBtn, 1, 0);

        //______________________________________________________________________
        addComponent(c, categoryPanel, creationalBtn, 0, 0);
        addComponent(c, categoryPanel, structuralBtn, 1, 0);
        addComponent(c, categoryPanel, behavioralBtn, 2, 0);

        //______________________________________________________________________
        creationalBtn.addActionListener(this);
        structuralBtn.addActionListener(this);
        behavioralBtn.addActionListener(this);
        back.addActionListener(this);
        
        builderBtn.addActionListener(this);
        singletonBtn.addActionListener(this);
        compositeBtn.addActionListener(this);
        decoratorBtn.addActionListener(this);
        mementoBtn.addActionListener(this);
        visitorBtn.addActionListener(this);
        
        //______________________________________________________________________
        builderFrame = BuilderPatternFrame.getInstancFrame().getPanel();
        mainPanel.add(builderFrame);
        builderFrame.setVisible(false);

        singletonFrame = SingletonPatternFrame.getInstancFrame().getPanel();
        mainPanel.add(singletonFrame);
        singletonFrame.setVisible(false);
        
        compositeFrame = CompositePatternFrame.getInstancFrame().getPanel();
        mainPanel.add(compositeFrame);
        compositeFrame.setVisible(false);
        
        decoratorFrame = DecoratorPatternFrame.getInstancFrame().getPanel();
        mainPanel.add(decoratorFrame);
        decoratorFrame.setVisible(false);
        
        mementoFrame = MementoPatternFrame.getInstancFrame().getPanel();
        mainPanel.add(mementoFrame);
        mementoFrame.setVisible(false);
        
        visitorFrame = VisitorPatternFrame.getInstancFrame().getPanel();
        mainPanel.add(visitorFrame);
        visitorFrame.setVisible(false);
        
        mainPanel.setVisible(true);

        addComponent(c, mainPanel, back, 0, 0);
        addComponent(c, mainPanel, categoryPanel, 0, 0);
        addComponent(c, mainPanel, creationalPanel, 1, 1);
        addComponent(c, mainPanel, structuralPanel, 1, 1);
        addComponent(c, mainPanel, behavioralPanel, 1, 1);

        back.setVisible(false);
        categoryPanel.setVisible(true);
        creationalPanel.setVisible(false);
        structuralPanel.setVisible(false);
        behavioralPanel.setVisible(false);
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }
    
    public static PatternPanelButton getInstancePattern()
    {
        if (pattern == null)
            pattern = new PatternPanelButton();
        return pattern;
    }
    
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == creationalBtn) {
            back.setVisible(true);
            categoryPanel.setVisible(false);
            creationalPanel.setVisible(true);

        } else if (e.getSource() == structuralBtn) {
            back.setVisible(true);
            categoryPanel.setVisible(false);
            structuralPanel.setVisible(true);

        } else if (e.getSource() == behavioralBtn) {
            back.setVisible(true);
            categoryPanel.setVisible(false);
            behavioralPanel.setVisible(true);

        } else if (e.getSource() == back) {
            categoryPanel.setVisible(true);
            creationalPanel.setVisible(false);
            structuralPanel.setVisible(false);
            behavioralPanel.setVisible(false);
            back.setVisible(false);
        } else if (e.getSource() == builderBtn) {
            categoryPanel.setVisible(false);
            creationalPanel.setVisible(false);
            structuralPanel.setVisible(false);
            behavioralPanel.setVisible(false);
            back.setVisible(false);
            builderFrame.setVisible(true);
        } else if (e.getSource() == singletonBtn) {
            categoryPanel.setVisible(false);
            creationalPanel.setVisible(false);
            structuralPanel.setVisible(false);
            behavioralPanel.setVisible(false);
            back.setVisible(false);
            singletonFrame.setVisible(true);
        } else if (e.getSource() == compositeBtn) {
            categoryPanel.setVisible(false);
            creationalPanel.setVisible(false);
            structuralPanel.setVisible(false);
            behavioralPanel.setVisible(false);
            back.setVisible(false);
            compositeFrame.setVisible(true);
        } else if (e.getSource() == decoratorBtn) {
            categoryPanel.setVisible(false);
            creationalPanel.setVisible(false);
            structuralPanel.setVisible(false);
            behavioralPanel.setVisible(false);
            back.setVisible(false);
            decoratorFrame.setVisible(true);
        } else if (e.getSource() == mementoBtn) {
            categoryPanel.setVisible(false);
            creationalPanel.setVisible(false);
            structuralPanel.setVisible(false);
            behavioralPanel.setVisible(false);
            back.setVisible(false);
            mementoFrame.setVisible(true);
        } else if (e.getSource() == visitorBtn) {
            categoryPanel.setVisible(false);
            creationalPanel.setVisible(false);
            structuralPanel.setVisible(false);
            behavioralPanel.setVisible(false);
            back.setVisible(false);
            visitorFrame.setVisible(true);
        }
        


    }

    public void addComponent(GridBagConstraints c, JPanel panel, JComponent comp, int x, int y) {
        c.gridx = x;
        c.gridy = y;
        panel.add(comp, c);
    }

    public JPanel getCategoryPanel() {
        return categoryPanel;
    }

    public JPanel getCreationalPanel() {
        return creationalPanel;
    }

    public JPanel getStructuralPanel() {
        return structuralPanel;
    }

    public JPanel getBehavioralPanel() {
        return behavioralPanel;
    }

    public JButton getCreationalBtn() {
        return creationalBtn;
    }

    public JButton getStructuralBtn() {
        return structuralBtn;
    }

    public JButton getBehavioralBtn() {
        return behavioralBtn;
    }

    public JButton getBuilderBtn() {
        return builderBtn;
    }

    public JButton getSingletonBtn() {
        return singletonBtn;
    }

    public JButton getDecoratorBtn() {
        return decoratorBtn;
    }

    public JButton getCompositeBtn() {
        return compositeBtn;
    }

    public JButton getMementoBtn() {
        return mementoBtn;
    }

    public JButton getVisitorBtn() {
        return visitorBtn;
    }

    public JButton getBack() {
        return back;
    }

    public JPanel getBuilderFrame() {
        return builderFrame;
    }

    public JPanel getSingletonFrame() {
        return singletonFrame;
    }

    public JPanel getCompositeFrame() {
        return compositeFrame;
    }

    public JPanel getDecoratorFrame() {
        return decoratorFrame;
    }

    public JPanel getMementoFrame() {
        return mementoFrame;
    }

    public JPanel getVisitorFrame() {
        return visitorFrame;
    }
    

}
