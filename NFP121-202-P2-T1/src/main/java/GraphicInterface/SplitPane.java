/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GraphicInterface;

import javax.swing.*;

public class SplitPane {

    private JSplitPane splitPane;
    private JTabbedPane leftTabbedPane, righTabbedPane;

    private JList list;
    private DefaultListModel listModel;
    private JScrollPane scrollPane;

    public SplitPane() {
        leftTabbedPane = new JTabbedPane();
        righTabbedPane = new JTabbedPane();

        listModel = new DefaultListModel();
        list = new JList(listModel);
        scrollPane = new JScrollPane(list);

        splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, leftTabbedPane, righTabbedPane);

        leftTabbedPane.addTab("Document Selector", scrollPane);
    }

    public JSplitPane getSplitPane() {
        return splitPane;
    }

}
