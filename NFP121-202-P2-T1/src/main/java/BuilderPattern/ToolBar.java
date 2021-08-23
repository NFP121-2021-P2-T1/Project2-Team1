package BuilderPattern;

import Action.FileListener;
import Action.NewFile;
import Action.Run;
import TemplateMethodPattern.PatternPanelTemplate;
import GraphicInterface.MyGui;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

/**
 *
 * @author Rim
 */
public class ToolBar {

    private JToolBar toolBar;
    private JButton toolbar_newFile, toolbar_newProject, toolbar_saveAll;
    private JButton toolbar_undo, toolbar_redo, toolbar_run, toolbar_compile;

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

        toolbar_compile = new JButton("compile");
        //toolbar_compile.setToolTipText("ReUn (Shift+F6)");
        toolbar_compile.setFocusable(false);

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
        PatternPanelTemplate patt;
        toolbar_run.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                JTabbedPane tabbedPane = SplitPane.getInstanSplitPane().getRighTabbedPane();
                if (tabbedPane.getTabCount() > 0) {
                    int sel = tabbedPane.getSelectedIndex();
                    JTextPane textPane = (JTextPane) (((JScrollPane) tabbedPane.getComponentAt(sel)).getViewport()).getComponent(0);

                    int selected = tabbedPane.getSelectedIndex();
                    int listElementIndex = FileListener.getListOfFilesOpened().get(selected);
                    String fn = FileListener.getListOfFiles().get(listElementIndex);
                    File f = new File(fn);
                    String folderPath = f.getParent();
                    //folder path
                    File directory = new File(folderPath);
                    FileFilter fileFilter = file -> !file.isDirectory() && file.getName()
                            .endsWith(".java");
                    ArrayList<File> projectFiles = new ArrayList<>(Arrays.asList(directory.listFiles(fileFilter)));

                    try {
                        Run.compileJava(projectFiles);
                        Run.runJava(directory);
                    } catch (Exception ex) {
                        Logger.getLogger(ToolBar.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        });

    }

    public JToolBar getToolBar() {
        return toolBar;
    }
}
