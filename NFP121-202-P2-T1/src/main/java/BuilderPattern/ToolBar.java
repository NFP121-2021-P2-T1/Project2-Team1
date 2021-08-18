package BuilderPattern;

import Action.FileListener;
import Action.NewFile;
import GraphicInterface.MyGui;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author Rim
 */
public class ToolBar {

    private JToolBar toolBar;
    private JButton toolbar_newFile, toolbar_newProject, toolbar_saveAll;
    private JButton toolbar_undo, toolbar_redo, toolbar_run;

    public ToolBar() {
        //_______Creating Toolbar_______________________________________
        toolBar = new JToolBar();
        toolBar.setFloatable(false);
        //__________Creating toolbar button_____________________________
        toolbar_newFile = new JButton(new ImageIcon("icons\\newFile.png"));
        toolbar_newFile.setToolTipText("New File (CTRL+N)");
        toolbar_newFile.setFocusable(false);

        toolbar_newProject = new JButton(new ImageIcon("icons\\newProject.png"));
        toolbar_newProject.setToolTipText("New Project (CTRL+Shift+N)");
        toolbar_newProject.setFocusable(false);

        toolbar_saveAll = new JButton(new ImageIcon("icons\\saveAll.png"));
        toolbar_saveAll.setToolTipText("Save All (CTRL+Shift+S)");
        toolbar_saveAll.setFocusable(false);

        toolbar_undo = new JButton(new ImageIcon("icons\\undo.png"));
        toolbar_undo.setToolTipText("Undo (CTRL+Z)");
        toolbar_undo.setFocusable(false);

        toolbar_redo = new JButton(new ImageIcon("icons\\redo.png"));
        toolbar_redo.setToolTipText("Redo (CTRL+Y)");
        toolbar_redo.setFocusable(false);

        toolbar_run = new JButton(new ImageIcon("icons\\run.png"));
        toolbar_run.setToolTipText("ReUn (Shift+F6)");
        toolbar_run.setFocusable(false);
        //_________________________________________________________________

        toolBar.add(toolbar_newFile);
        toolBar.add(toolbar_newProject);
        toolBar.add(toolbar_saveAll);
        toolBar.addSeparator();
        toolBar.add(toolbar_undo);
        toolBar.add(toolbar_redo);
        toolBar.addSeparator();
        toolBar.add(toolbar_run);

        toolbar_newFile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
               new NewFile();
            }
        });
        
        toolbar_newProject.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                MyGui gui = MyGui.getGui();
                //gui.getFramePanel().setLayout(new FlowLayout());
                gui.getMainPatternPanel().setVisible(true);
                gui.getPanelTextEditor().setVisible(false);
            }
        });

        toolbar_saveAll.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                FileListener.SaveAll_Action();
            }
        });
    }

    public JToolBar getToolBar() {
        return toolBar;
    }

}
