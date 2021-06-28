/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GraphicInterface;

import java.awt.*;
import javax.swing.*;

public class MyGui extends JFrame {

    private JMenuBar menubar;

    public MyGui() {
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        //______________________________________________________________________        
        menubar = new Menubar().getMenubar();
        setJMenuBar(menubar);
        //______________________________________________________________________
        setPreferredSize(new Dimension(500, 500));
        setBackground(new Color(251, 252, 251));
        pack();
        setVisible(true);
       

    }

    public static void main(String[] args) {
        MyGui editor = new MyGui();
    }

}
