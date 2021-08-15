package BuilderPattern;

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
    }

    public JToolBar getToolBar() {
        return toolBar;
    }
    
}
