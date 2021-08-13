/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GraphicInterface;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MyGui extends JFrame {

    private JMenuBar menubar;
    private JPanel panel;
    public MyGui() {
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        //______________________________________________________________________        
        menubar = new Menubar().getMenubar();
        setJMenuBar(menubar);
        //______________________________________________________________________
        Director d = new Director();
        PatternPanelBuilder teb = new PatternPanelBuilder();
        d.construct(teb);
        PatternPanel p = teb.getResult();
        panel = p.getMainPanel();
        add(panel);
        
        setLayout(new GridBagLayout());
        setPreferredSize(new Dimension(800, 600));
        setBackground(new Color(251, 252, 251));
        pack();
        setVisible(true);
        setLocationRelativeTo(null);
       
    }

    public static void main(String[] args) {
        MyGui editor = new MyGui();
    }

}
