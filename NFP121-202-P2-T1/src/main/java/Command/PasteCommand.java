/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Command;

import BuilderPattern.SplitPane;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextPane;

/**
 *
 * @author Rim
 */
public class PasteCommand extends Command {

    @Override
    public void execute() {
        if (tabbedPane.getTabCount() > 0) {
            int sel = tabbedPane.getSelectedIndex();
            JTextPane textPane = (JTextPane) (((JScrollPane) tabbedPane.getComponentAt(sel)).getViewport()).getComponent(0);
            Transferable cliptran = SplitPane.getInstanSplitPane().getClip().getContents(SplitPane.getInstanSplitPane().getRighTabbedPane());
            try {
                String selected_text = (String) cliptran.getTransferData(DataFlavor.stringFlavor);
                textPane.replaceSelection(selected_text);

                String tabtext = tabbedPane.getTitleAt(sel);
                if (tabtext.contains("*")) {
                } else {
                    tabbedPane.setTitleAt(sel, tabbedPane.getTitleAt(sel) + "*");
                }
            } catch (Exception exc) {
                System.out.println("error to paste");
            }

        }
    }
}
