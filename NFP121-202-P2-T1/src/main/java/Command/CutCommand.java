/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Command;

import BuilderPattern.SplitPane;
import java.awt.datatransfer.StringSelection;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextPane;

/**
 *
 * @author Rim
 */
public class CutCommand extends Command {

    @Override
    public void execute() {
        if (tabbedPane.getTabCount() > 0) {
            int sel = tabbedPane.getSelectedIndex();
            JTextPane textPane = (JTextPane) (((JScrollPane) tabbedPane.getComponentAt(sel)).getViewport()).getComponent(0);
            String selected_text = textPane.getSelectedText();
            StringSelection ss = new StringSelection(selected_text);
            SplitPane.getInstanSplitPane().getClip().setContents(ss, ss);
            textPane.replaceSelection("");

            String tabtext = tabbedPane.getTitleAt(sel);
            if (tabtext.contains("*")) {
            } else {
                tabbedPane.setTitleAt(sel, tabbedPane.getTitleAt(sel) + "*");
            }

        }
    }

}
