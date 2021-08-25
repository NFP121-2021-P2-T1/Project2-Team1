package Command;

import BuilderPattern.SplitPane;
import javax.swing.JTabbedPane;

/**
 *
 * @author Rim
 */
public abstract class Command {

    SplitPane textEditor = SplitPane.getInstanSplitPane();
    JTabbedPane tabbedPane = textEditor.getRighTabbedPane();

    public abstract void execute();
}
