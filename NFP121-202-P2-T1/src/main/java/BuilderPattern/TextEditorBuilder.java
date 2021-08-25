package BuilderPattern;

import javax.swing.*;

/**
 *
 * @author Rim
 */
public class TextEditorBuilder extends Builder {

    private JToolBar toolBar;
    private JSplitPane splitPane;

    @Override
    public void build() {
        this.toolBar = new ToolBar().getToolBar();
        this.splitPane = SplitPane.getInstanSplitPane().getSplitPane();
    }

    public TextEditor getResult() {
        return TextEditor.getInstance(toolBar, splitPane);
    }

    public JToolBar getToolBar() {
        return toolBar;
    }

    public JSplitPane getSplitPane() {
        return splitPane;
    }

}
