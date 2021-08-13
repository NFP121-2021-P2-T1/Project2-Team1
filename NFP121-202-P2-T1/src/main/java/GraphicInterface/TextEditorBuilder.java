/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GraphicInterface;

import javax.swing.*;

public class TextEditorBuilder extends Builder {

    private JToolBar toolBar;
    private JSplitPane splitPane;

    @Override
    public void build() {
        this.toolBar = new ToolBar().getToolBar();
        this.splitPane = new SplitPane().getSplitPane();
    }

    public TextEditor getResult() {
        return new TextEditor(toolBar, splitPane);
    }

    public JToolBar getToolBar() {
        return toolBar;
    }

    public JSplitPane getSplitPane() {
        return splitPane;
    }

}