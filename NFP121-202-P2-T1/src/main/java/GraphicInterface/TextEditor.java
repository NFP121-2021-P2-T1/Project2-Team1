/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GraphicInterface;

import javax.swing.*;

public class TextEditor {

    private JToolBar toolBar;
    private JSplitPane splitPane;

    public TextEditor(JToolBar toolBar, JSplitPane splitPane) {
        this.toolBar = toolBar;
        this.splitPane = splitPane;
    }

    public JToolBar getToolBar() {
        return toolBar;
    }

    public JSplitPane getSplitPane() {
        return splitPane;
    }

}