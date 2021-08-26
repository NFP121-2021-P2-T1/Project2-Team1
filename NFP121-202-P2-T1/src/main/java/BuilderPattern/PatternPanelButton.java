package BuilderPattern;

import FactoryPattern.PatternPanelTemplate;
import FactoryPattern.PatternsFactory;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 *
 * @author Rim
 */
public class PatternPanelButton implements ActionListener {

    public static PatternPanelButton pattern;

    private JPanel mainPanel, categoryPanel, creationalPanel, structuralPanel, behavioralPanel;
    private JButton creationalBtn, structuralBtn, behavioralBtn;

    private JButton builderBtn, singletonBtn;
    private JButton decoratorBtn, compositeBtn;
    private JButton mementoBtn, visitorBtn;
    private JButton back;
    private PatternPanelTemplate pat;
    private static JPanel pan;

    PatternsFactory factory;

    private PatternPanelButton() {
        //this.factory = getInstanceFactory();
        this.factory = new PatternsFactory();
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

        //__________________________Creational Pattern____________________________________________
        builderBtn = new JButton("Builder Pattern");
        singletonBtn = new JButton("Singleton Pattern");

        builderBtn.setPreferredSize(new Dimension(150, 100));
        singletonBtn.setPreferredSize(new Dimension(150, 100));

        //Set button unfocusable
        builderBtn.setFocusable(false);
        singletonBtn.setFocusable(false);

        //___________________Structural Patterns___________________________________________________
        decoratorBtn = new JButton("Decorator Pattern");
        compositeBtn = new JButton("Composite Pattern");

        decoratorBtn.setPreferredSize(new Dimension(150, 100));
        compositeBtn.setPreferredSize(new Dimension(150, 100));

        //Set button unfocusable
        decoratorBtn.setFocusable(false);
        compositeBtn.setFocusable(false);

        //______________________Behavioral Pattern________________________________________________
        mementoBtn = new JButton("Memento Pattern");
        visitorBtn = new JButton("Vistor Pattern");

        mementoBtn.setPreferredSize(new Dimension(150, 100));
        visitorBtn.setPreferredSize(new Dimension(150, 100));

        //Set button unfocusable
        mementoBtn.setFocusable(false);
        visitorBtn.setFocusable(false);

        //______________________________________________________________________
        back = new JButton("Back");

        //Set button unfocusable
        back.setFocusable(false);

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

        //________________________________________________________________________
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

    public static PatternPanelButton getInstancePattern() {
        if (pattern == null) {
            pattern = new PatternPanelButton();
        }
        return pattern;
    }

    public static JPanel getPan() {
        return pan;
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
            pat = factory.getPattern(builderBtn.getText());
            pan = pat.getPanel();
            mainPanel.add(pan);
            pan.setVisible(true);
            categoryPanel.setVisible(false);
            creationalPanel.setVisible(false);
            structuralPanel.setVisible(false);
            behavioralPanel.setVisible(false);
            back.setVisible(false);
        } else if (e.getSource() == singletonBtn) {
            pat = factory.getPattern(singletonBtn.getText());
            pan = pat.getPanel();
            mainPanel.add(pan);
            pan.setVisible(true);
            categoryPanel.setVisible(false);
            creationalPanel.setVisible(false);
            structuralPanel.setVisible(false);
            behavioralPanel.setVisible(false);
            back.setVisible(false);
        } else if (e.getSource() == compositeBtn) {
            pat = factory.getPattern(compositeBtn.getText());
            pan = pat.getPanel();
            mainPanel.add(pan);
            pan.setVisible(true);
            categoryPanel.setVisible(false);
            creationalPanel.setVisible(false);
            structuralPanel.setVisible(false);
            behavioralPanel.setVisible(false);
            back.setVisible(false);
        } else if (e.getSource() == decoratorBtn) {
            //pat = DecoratorPatternFrame.getInstancFrame();
            //pan = pat.getPanel();
            pat = factory.getPattern(decoratorBtn.getText());
            pan = pat.getPanel();
            mainPanel.add(pan);
            pan.setVisible(true);
            categoryPanel.setVisible(false);
            creationalPanel.setVisible(false);
            structuralPanel.setVisible(false);
            behavioralPanel.setVisible(false);
            back.setVisible(false);

        } else if (e.getSource() == mementoBtn) {
            //pat = MementoPatternFrame.getInstancFrame();
            //pan = pat.getPanel();
            pat = factory.getPattern(mementoBtn.getText());
            pan = pat.getPanel();
            mainPanel.add(pan);
            pan.setVisible(true);
            categoryPanel.setVisible(false);
            creationalPanel.setVisible(false);
            structuralPanel.setVisible(false);
            behavioralPanel.setVisible(false);
            back.setVisible(false);
        } else if (e.getSource() == visitorBtn) {
            //pat = VisitorPatternFrame.getInstancFrame();
            //pan = pat.getPanel();
            pat = factory.getPattern(visitorBtn.getText());
            pan = pat.getPanel();
            mainPanel.add(pan);
            pan.setVisible(true);
            categoryPanel.setVisible(false);
            creationalPanel.setVisible(false);
            structuralPanel.setVisible(false);
            behavioralPanel.setVisible(false);
            back.setVisible(false);
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


}
