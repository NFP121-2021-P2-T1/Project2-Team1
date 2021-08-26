package Action;

import BuilderPattern.SplitPane;
import Command.*;
import Command.Invoker;
import MementoPattern.*;
import java.awt.event.*;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextPane;

/**
 *
 * @author Rim
 */
class KeyTypedAction implements KeyListener {

    private Invoker command;

    JTabbedPane tabbedPane = SplitPane.getInstanSplitPane().getRighTabbedPane();
    CareTaker c = CareTaker.getCareTaker();
    Originator o;

    @Override
    public void keyPressed(KeyEvent evt) {
        int keycode = evt.getKeyCode();
        boolean is_ControlDown = evt.isControlDown();

        if (keycode == KeyEvent.VK_S && is_ControlDown) {
            FileListener.File_Save_Action();
        }
    }

    @Override
    public void keyReleased(KeyEvent evt) {
    }

    @Override
    public void keyTyped(KeyEvent evt) {
        if (!evt.isControlDown()) {

            int sel = tabbedPane.getSelectedIndex();

            JTextPane textPane = (JTextPane) (((JScrollPane) tabbedPane.getComponentAt(sel)).getViewport()).getComponent(0);

            o = Originator.getOriginator();
            Originator.getOriginator().setTextPane(textPane.getText());
            c.saveToUndo(o.saveToMemento());

            String tabtext = tabbedPane.getTitleAt(sel);
            if (tabtext.contains("*")) {
            } else {
                tabbedPane.setTitleAt(sel, tabbedPane.getTitleAt(sel) + "*");
            }
        }
    }
}
