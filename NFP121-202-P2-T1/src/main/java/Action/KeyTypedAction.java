package Action;

import BuilderPattern.SplitPane;
import java.awt.event.*;
import javax.swing.JTabbedPane;

/**
 *
 * @author Rim
 */
class KeyTypedAction implements KeyListener {

    JTabbedPane tabbedPane = SplitPane.getInstanSplitPane().getRighTabbedPane();

    @Override
    public void keyPressed(KeyEvent evt) {
        int keycode = evt.getKeyCode();
        boolean is_ControlDown = evt.isControlDown();

        if (keycode == KeyEvent.VK_X && is_ControlDown) {
           // Edit_Cut_Action();
        } else if (keycode == KeyEvent.VK_C && is_ControlDown) {
           // Edit_Copy_Action();
        } else if (keycode == KeyEvent.VK_V && is_ControlDown) {
            int sel = tabbedPane.getSelectedIndex();
            String tabtext = tabbedPane.getTitleAt(sel);
            if (tabtext.contains("*")) {
            } else {
                tabbedPane.setTitleAt(sel, tabbedPane.getTitleAt(sel) + "*");
                //_tabbedPane.setIconAt(sel, new ImageIcon(this.getClass().getResource("resources/unsaved.png")));
            }
        } else if (keycode == KeyEvent.VK_S && is_ControlDown) {
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
            String tabtext = tabbedPane.getTitleAt(sel);
            if (tabtext.contains("*")) {
            } else {
                tabbedPane.setTitleAt(sel, tabbedPane.getTitleAt(sel) + "*");
               // _tabbedPane.setIconAt(sel, new ImageIcon(this.getClass().getResource("resources/unsaved.png")));
            }
        }
    }
}
