/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GraphicInterface;

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
public class BuilderPatternFrame extends JFrame implements ActionListener, PatternPanelTemplate {

    private JMenuBar menubar;
    private JPanel panel, builderPanel;
    private JEditorPane builderText;
    private JLabel imageLabel, title;
    private String text, path;
    private ImageIcon image;
    private JButton back, create;

    public BuilderPatternFrame() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        //________________Menubar_______________________________________________      
        //menubar = new Menubar().getMenubar();
        //setJMenuBar(menubar);

        //_________________MainPanel____________________________________________
        // Director d = new Director();
        //PatternPanelBuilder teb = new PatternPanelBuilder();
        // d.construct(teb);
        //PatternPanel p = teb.getResult();
        panel = new JPanel();

        //________________Layout________________________________________________
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.BOTH;
        c.weightx = 0.5;
        c.weighty = 1.0;
        c.insets = new Insets(10, 20, 10, 20);

        //______________________________________________________________________
        builderPanel = new JPanel(new GridBagLayout());

        //______________________________________________________________________
        builderText = new JEditorPane("text/html", "");
        builderText.setEditable(false);
        builderText.setOpaque(false);
        setText();

        //______________________________________________________________________
        image = new ImageIcon(getImagepath());
        imageLabel = new JLabel(image);
        title = new JLabel("Builder Pattern");
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
        addComponent(c, builderPanel, back, 0, 0);
        addComponent(c, builderPanel, title, 1, 0);
        addComponent(c, builderPanel, builderText, 1, 1);
        addComponent(c, builderPanel, imageLabel, 1, 2);
        addComponent(c, builderPanel, create, 2, 3);

        //______________________________________________________________________ 
        panel.add(builderPanel);

        //______________________________________________________________________
        panel.setLayout(new GridBagLayout());
        panel.setBackground(new Color(251, 252, 251));
        panel.setVisible(true);

    }

    public void setText() {
        text = "<b>What it is : </b> \n Separate the construction of a complex object from its "
                + "representing so that the same construction\nprocess can create different representations.";
        builderText.setText(text);
    }

    public String getImagepath() {
        path = "images\\builder.png";
        return path;
    }
    
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == back) {
            builderPanel.setVisible(false);
            panel.setVisible(true);
            //add(panel);

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

    public static void main(String[] args) {
        BuilderPatternFrame builder = new BuilderPatternFrame();
    }
    
}
