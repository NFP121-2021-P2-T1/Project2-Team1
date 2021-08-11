/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GraphicInterface;

import javax.swing.*;
import java.awt.*;

public class TextEditor extends JFrame {
    
    private JMenuBar menubar;
    
    private JSplitPane splitPane;
    private JTabbedPane leftTabbedPane, righTabbedPane;

    private JList list;
    private DefaultListModel listModel;
    private JScrollPane scrollPane;
    

    public TextEditor() {

        menubar = new Menubar().getMenubar();
        setJMenuBar(menubar);
        
        leftTabbedPane = new JTabbedPane();
        righTabbedPane = new JTabbedPane();

        listModel = new DefaultListModel();
        list = new JList(listModel);
        scrollPane = new JScrollPane(list);

        splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, leftTabbedPane, righTabbedPane);

        leftTabbedPane.addTab("Document Selector", scrollPane);
                
        add(splitPane);
        
        setVisible(true);
        setPreferredSize(new Dimension(500, 500));

    }

    public static void main(String[] args) {
        new TextEditor();
    }

}
