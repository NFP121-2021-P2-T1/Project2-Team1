/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BuilderPattern;

import javax.swing.*;

public class TextEditorBuilder extends Builder {

    private JToolBar toolBar;
    private JSplitPane splitPane;

    @Override
    public void build() {
        this.toolBar = new ToolBar().getToolBar();
        this.splitPane = SplitPane.getInstanSplitPane().getSplitPane();
    }

    public TextEditor getResult() {
        return TextEditor.getInstance(toolBar , splitPane);
    }

    public JToolBar getToolBar() {
        return toolBar;
    }

    public JSplitPane getSplitPane() {
        return splitPane;
    }

}
