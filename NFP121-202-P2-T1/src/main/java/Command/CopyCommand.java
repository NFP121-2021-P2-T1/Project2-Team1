package Command;

import BuilderPattern.SplitPane;
import java.awt.datatransfer.StringSelection;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;

/**
 *
 * @author Rim
 */
public class CopyCommand extends Command {

    @Override
    public void execute() {
        if (tabbedPane.getTabCount() > 0) {
            //get the index of the selected tabbedPane and get the textPane inide this tabbedPane
            int sel = tabbedPane.getSelectedIndex();
            JTextPane textPane = (JTextPane) (((JScrollPane) tabbedPane.getComponentAt(sel)).getViewport()).getComponent(0);
            String selected_text = textPane.getSelectedText();
            StringSelection ss = new StringSelection(selected_text);
            SplitPane.getInstanSplitPane().getClip().setContents(ss, ss);

        }
    }
}
