package GraphicInterface;

import Action.*;
import BuilderPattern.*;
import Command.*;
import MementoPattern.*;
import FactoryPattern.PatternPanelTemplate;
import java.awt.*;
import java.awt.datatransfer.Transferable;
import java.awt.event.*;
import java.io.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

/**
 *
 * @author Rim
 */
public class Menubar {

    private static Menubar mainMenu;

    private JMenuBar menubar;
    private JMenu file, edit, view, window, help;

    private JMenuItem newFile, newProject, openFile, openProject, save, saveAs, saveAll, closeAll;
    private JMenuItem cut, copy, paste, find, replace, undo, redo;
    private JMenuItem font;
    private JMenu lookAndFeel;
    private JMenuItem fall;

    private JMenuItem run;
    private JMenuItem about, copyright;

    private Invoker command;

    private Menubar() {
        command = new Invoker();
        menubar = new JMenuBar();

        file = new JMenu("File");
        edit = new JMenu("Edit");
        view = new JMenu("View");
        help = new JMenu("Help");
        window = new JMenu("Window");
        //______________________________________________________________________
        newFile = new JMenuItem("New File");
        newProject = new JMenuItem("New Project");
        openFile = new JMenuItem("Open File");
        openProject = new JMenuItem("Open Project");
        save = new JMenuItem("Save");
        saveAs = new JMenuItem("Save As");
        saveAll = new JMenuItem("Save All");
        closeAll = new JMenuItem("Close All");

        //______________________________________________________________________
        cut = new JMenuItem("Cut");
        copy = new JMenuItem("Copy");
        paste = new JMenuItem("Paste");
        find = new JMenuItem("Find");
        replace = new JMenuItem("Replace");
        undo = new JMenuItem("Undo");
        redo = new JMenuItem("Redo");
        //______________________________________________________________________
        lookAndFeel = new JMenu("Look & Feel");
        font = new JMenuItem("Font");

        run = new JMenuItem("Run");
        //______________________________________________________________________
        fall = new JMenuItem("Fall");
        //______________________________________________________________________
        about = new JMenuItem("About");
        copyright = new JMenuItem("Copyright");
        //______________________________________________________________________
        //Set icon to some JMenuItem
        newFile.setIcon(new ImageIcon("icons\\newFile.png"));
        newProject.setIcon(new ImageIcon("icons\\newProject.png"));
        closeAll.setIcon(new ImageIcon("icons\\close.png"));

        openProject.setIcon(new ImageIcon("icons\\openProject.png"));

        undo.setIcon(new ImageIcon("icons\\undo.png"));
        redo.setIcon(new ImageIcon("icons\\redo.png"));

        run.setIcon(new ImageIcon("icons\\run.png"));

        about.setIcon(new ImageIcon("icons\\about.png"));
        copyright.setIcon(new ImageIcon("icons\\copyright.png"));

        file.add(newFile);
        file.add(newProject);

        file.addSeparator();

        file.add(openProject);
        file.add(openFile);

        file.addSeparator();

        file.add(save);
        file.add(saveAs);
        file.add(saveAll);

        file.addSeparator();

        file.add(closeAll);
        //______________________________________________________________________
        edit.add(cut);
        edit.add(copy);
        edit.add(paste);
        edit.addSeparator();
        edit.add(find);
        edit.add(replace);
        edit.addSeparator();
        edit.add(undo);
        edit.add(redo);
        //______________________________________________________________________
        view.add(font);
        view.add(lookAndFeel);
        //______________________________________________________________________
        lookAndFeel.add(fall);
        //______________________________________________________________________
        window.add(run);
        //______________________________________________________________________
        help.add(about);
        help.add(copyright);
        //______________________________________________________________________
        menubar.add(file);
        menubar.add(edit);
        menubar.add(view);
        menubar.add(window);
        menubar.add(help);

        //__________________________end of changing color______________________________________
        newFile.setAccelerator(KeyStroke.getKeyStroke("control  N"));
        newFile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                new NewFile();
            }
        });

        newProject.setAccelerator(KeyStroke.getKeyStroke("control shift N"));
        newProject.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                MyGui gui = MyGui.getGui();
                //gui.getFramePanel().setLayout(new FlowLayout());
                gui.getMainPatternPanel().setVisible(true);
                gui.getPanelTextEditor().setVisible(false);
            }
        });

        openProject.setAccelerator(KeyStroke.getKeyStroke("control shift O"));
        openProject.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                FileListener.openFolder();
                MyGui gui = MyGui.getGui();
                //gui.getFramePanel().setLayout(new FlowLayout());
                gui.getMainPatternPanel().setVisible(false);
                gui.getPanelTextEditor().setVisible(true);
            }
        });
        openFile.setAccelerator(KeyStroke.getKeyStroke("control  O"));
        openFile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                FileListener.openFolder();
                //MyGui gui = MyGui.getGui();
                //gui.getFramePanel().setLayout(new FlowLayout());
                //gui.getMainPatternPanel().setVisible(false);
                // gui.getPanelTextEditor().setVisible(true);
            }
        });
        save.setAccelerator(KeyStroke.getKeyStroke("control S"));
        save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                FileListener.File_Save_Action();
            }
        });

        saveAs.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                FileListener.SaveAs_Action();
            }
        });
        saveAll.setAccelerator(KeyStroke.getKeyStroke("control shift S"));
        saveAll.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                FileListener.SaveAll_Action();
            }
        });

        closeAll.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                FileListener.CloseAll_Action();
            }
        });

        //______________________________________________________________________
        find.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                FileListener.Find_Action();
            }
        });
        replace.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                Replace_Action();
            }
        });
        //______________________________________________________________________
        copy.setAccelerator(KeyStroke.getKeyStroke("control C"));
        copy.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                //FileListener.Copy_Action();
                command.doCommand(new CopyCommand());
            }
        });

        paste.setAccelerator(KeyStroke.getKeyStroke("control V"));
        paste.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                //FileListener.Paste_Action();
                command.doCommand(new PasteCommand());
            }
        });

        cut.setAccelerator(KeyStroke.getKeyStroke("control X"));
        cut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                //FileListener.Cut_Action();
                command.doCommand(new CutCommand());
            }
        });

        undo.setAccelerator(KeyStroke.getKeyStroke("control Z"));
        undo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {

                CareTaker c = CareTaker.getCareTaker();
                Originator o;

                JTabbedPane tabbedPane = SplitPane.getInstanSplitPane().getRighTabbedPane();
                int sel = tabbedPane.getSelectedIndex();
                JTextPane textPane = (JTextPane) (((JScrollPane) tabbedPane.getComponentAt(sel)).getViewport()).getComponent(0);
                Transferable cliptran = SplitPane.getInstanSplitPane().getClip().getContents(SplitPane.getInstanSplitPane().getRighTabbedPane());

                o = Originator.getOriginator();
                Originator.getOriginator().setTextPane(textPane.getText());
                c.saveToRedo(o.saveToMemento());

                Memento m = CareTaker.getCareTaker().getUndo();
                try {
                    textPane.setText(m.getText());
                } catch (NullPointerException z) {
                }
            }
        });

        redo.setAccelerator(KeyStroke.getKeyStroke("control Y"));
        redo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                JTabbedPane tabbedPane = SplitPane.getInstanSplitPane().getRighTabbedPane();
                int sel = tabbedPane.getSelectedIndex();
                JTextPane textPane = (JTextPane) (((JScrollPane) tabbedPane.getComponentAt(sel)).getViewport()).getComponent(0);
                Transferable cliptran = SplitPane.getInstanSplitPane().getClip().getContents(SplitPane.getInstanSplitPane().getRighTabbedPane());
                CareTaker c = CareTaker.getCareTaker();
                Originator o;
                o = Originator.getOriginator();
                Originator.getOriginator().setTextPane(textPane.getText());
                c.saveToUndo(o.saveToMemento());

                Memento m = CareTaker.getCareTaker().getRedo();

                try {
                    textPane.setText(m.getText());
                } catch (NullPointerException z) {
                }
            }
        });

        //______________________________________________________________________
        run.setAccelerator(KeyStroke.getKeyStroke("shift F6"));
        PatternPanelTemplate patt;
        run.addActionListener(new ActionListener() {
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
        //______________________________________________________________________

        //ABOUT
        JPanel aboutPanel = new JPanel();
        about.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F2, ActionEvent.CTRL_MASK));
        about.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String message = "Text Editor using Design Patterns\n"
                        + "Text editor for creating java design pattern.\n"
                        + "Choose a design pattern and start editing its classes.\n";

                JOptionPane.showMessageDialog(aboutPanel, "<html><center>" + "<br>" + message);
            }
        });

        //Copyright
        JPanel copyrightPanel = new JPanel();
        copyright.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F4, ActionEvent.CTRL_MASK));
        copyright.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String message = "Text Editor using Design Patterns\n"
                        + "Version 16/8/2021\n";
                JOptionPane.showMessageDialog(copyrightPanel, "<html><center>" + "<br>" + message);
            }
        });

    }
    //__________________________________________________________________________

    public static Menubar getInstanceMenuBar() {
        if (mainMenu == null) {
            mainMenu = new Menubar();
        }
        return mainMenu;
    }

    public JMenuBar getMenubar() {
        return menubar;
    }
    //__________________________________________________________________________
    //Replace
    JTextField findText;
    JTextField replaceText;
    JButton replaceButton;
    JButton cancelButton;
    JDialog jd;

    public void Replace_Action() {
        JTabbedPane tabbedPane = SplitPane.getInstanSplitPane().getRighTabbedPane();
        if (tabbedPane.getTabCount() > 0) {
            jd = new JDialog(new JDialog(), true);
            jd.setSize(360, 120);
            jd.setResizable(false);
            jd.setTitle("Replace");

            JPanel jp1 = new JPanel();
            JPanel jp2 = new JPanel();
            JLabel findwhat = new JLabel("Find What    :    ");
            JLabel replacewith = new JLabel("Replace With : ");
            findText = new JTextField(20);
            replaceText = new JTextField(20);

            replaceButton = new JButton("Replace All");
            cancelButton = new JButton("Cancel");

            replaceButton.addActionListener(new ReplaceText_Action());
            cancelButton.addActionListener(new ReplaceText_Action());

            jp1.add(findwhat);
            jp1.add(findText);
            jp1.add(replacewith);
            jp1.add(replaceText);
            jp2.add(replaceButton);
            jp2.add(cancelButton);

            jd.add(jp1, BorderLayout.CENTER);
            jd.add(jp2, BorderLayout.SOUTH);

            jd.show();
        }
    }

    class ReplaceText_Action implements ActionListener {

        public void actionPerformed(ActionEvent evt) {
            JTabbedPane tabbedPane = SplitPane.getInstanSplitPane().getRighTabbedPane();
            Object source = evt.getSource();
            if (source == replaceButton) {
                int sel = tabbedPane.getSelectedIndex();
                JTextPane textPane = (JTextPane) (((JScrollPane) tabbedPane.getComponentAt(sel)).getViewport()).getComponent(0);

                String find = findText.getText();
                String replace = replaceText.getText();

                textPane.setText(textPane.getText().replaceAll(find, replace));

                String tabtext = tabbedPane.getTitleAt(sel);
                if (tabtext.contains("*")) {
                } else {
                    tabbedPane.setTitleAt(sel, tabbedPane.getTitleAt(sel) + "*");
                }
            } else if (source == cancelButton) {
                jd.dispose();
            }
        }
    }
}
