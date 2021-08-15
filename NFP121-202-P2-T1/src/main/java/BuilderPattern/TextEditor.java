/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BuilderPattern;

import javax.swing.*;

public class TextEditor {

    private static TextEditor textEditor;
    private JToolBar toolBar;
    private JSplitPane splitPane;

    private TextEditor(JToolBar toolBar, JSplitPane splitPane) {
        this.toolBar = toolBar;
        this.splitPane = splitPane;
    }
    
    public static TextEditor getInstance(JToolBar toolBar, JSplitPane splitPane){
        if(textEditor == null) 
            textEditor = new TextEditor(toolBar,splitPane);
        return textEditor;
    }
    public static TextEditor getInstance(){
        if(textEditor == null) 
            textEditor = new TextEditor(null,null);
        return textEditor;
    }

    public void setToolBar(JToolBar toolBar) {
        this.toolBar = toolBar;
    }

    public void setSplitPane(JSplitPane splitPane) {
        this.splitPane = splitPane;
    }
    
    public JToolBar getToolBar() {
        if(toolBar == null)
            toolBar = new ToolBar().getToolBar();
        return toolBar;
    }

    public JSplitPane getSplitPane() {
        if(splitPane == null)
            splitPane = SplitPane.getInstanSplitPane().getSplitPane();
        return splitPane;
    }

}
