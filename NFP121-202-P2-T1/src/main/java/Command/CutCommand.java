package Command;

import BuilderPattern.SplitPane;
import MementoPattern.*;
import java.awt.datatransfer.StringSelection;
import javax.swing.*;

/**
 *
 * @author Rim
 */
public class CutCommand extends Command {

    CareTaker c = CareTaker.getCareTaker();
    Originator o;

    @Override
    public void execute() {
        if (tabbedPane.getTabCount() > 0) {
            //get the index of the selected tabbedPane and get the textPane inide this tabbedPane
            int sel = tabbedPane.getSelectedIndex();
            JTextPane textPane = (JTextPane) (((JScrollPane) tabbedPane.getComponentAt(sel)).getViewport()).getComponent(0);

            //save the current state of the textpane
            o = Originator.getOriginator();
            Originator.getOriginator().setTextPane(textPane.getText());
            c.saveToUndo(o.saveToMemento());
            
            //cut the selected text and add it to the clip
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
