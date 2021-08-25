package Command;

import BuilderPattern.SplitPane;
import MementoPattern.*;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import javax.swing.*;

/**
 *
 * @author Rim
 */
public class PasteCommand extends Command {

    CareTaker c = CareTaker.getCareTaker();
    Originator o;

    @Override
    public void execute() {
        if (tabbedPane.getTabCount() > 0) {
            //get the index of the selected tabbedPane and get the textPane inide this tabbedPane
            int sel = tabbedPane.getSelectedIndex();
            JTextPane textPane = (JTextPane) (((JScrollPane) tabbedPane.getComponentAt(sel)).getViewport()).getComponent(0);
            Transferable cliptran = SplitPane.getInstanSplitPane().getClip().getContents(SplitPane.getInstanSplitPane().getRighTabbedPane());
            try {
                //save the current state of the textpane 
                o = Originator.getOriginator();
                Originator.getOriginator().setTextPane(textPane.getText());
                c.saveToUndo(o.saveToMemento());
                
                //paste the text to textpane
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
