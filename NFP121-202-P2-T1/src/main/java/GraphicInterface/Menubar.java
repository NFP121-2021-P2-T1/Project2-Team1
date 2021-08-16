package GraphicInterface;

import Action.FileListener;
import BuilderPattern.SplitPane;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 *
 * @author Rim
 */
public class Menubar {

    private static Menubar mainMenu;

    private JMenuBar menubar;
    private JMenu file, edit, view, help;

    private JMenuItem newFile, newProject, openFile, openProject, save, saveAs;
    private JMenuItem cut, copy, paste, find, replace;
    private JMenuItem font;
    private JMenu lookAndFeel;
    private JMenuItem fall;
    private JMenuItem about, copyright;

    private Menubar() {
        menubar = new JMenuBar();

        file = new JMenu("File");
        edit = new JMenu("Edit");
        view = new JMenu("View");
        help = new JMenu("Help");
        //______________________________________________________________________
        newFile = new JMenuItem("New File");
        newProject = new JMenuItem("New Project");
        openFile = new JMenuItem("Open File");
        openProject = new JMenuItem("Open Project");
        save = new JMenuItem("Save");
        saveAs = new JMenuItem("Save As");
        //______________________________________________________________________
        cut = new JMenuItem("Cut");
        copy = new JMenuItem("Copy");
        paste = new JMenuItem("Paste");
        find = new JMenuItem("Find");
        replace = new JMenuItem("Replace");
        //______________________________________________________________________
        lookAndFeel = new JMenu("Look & Feel");
        font = new JMenuItem("Font");

        //______________________________________________________________________
        fall = new JMenuItem("Fall");
        //______________________________________________________________________
        about = new JMenuItem("About");
        copyright = new JMenuItem("Copyright");
        //______________________________________________________________________
        //Set icon to some JMenuItem
        newFile.setIcon(new ImageIcon("icons\\newFile.png"));
        newProject.setIcon(new ImageIcon("icons\\newProject.png"));

        openProject.setIcon(new ImageIcon("icons\\openProject.png"));

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
        //______________________________________________________________________
        edit.add(cut);
        edit.add(copy);
        edit.add(paste);
        edit.addSeparator();
        edit.add(find);
        edit.add(replace);
        //______________________________________________________________________
        view.add(font);
        view.add(lookAndFeel);
        //______________________________________________________________________
        lookAndFeel.add(fall);
        //______________________________________________________________________
        help.add(about);
        help.add(copyright);
        //______________________________________________________________________
        menubar.add(file);
        menubar.add(edit);
        menubar.add(view);
        menubar.add(help);

        //__________________________________Changing color____________________________________
        // changeTheme(new Color(191, 191, 191), new Color(250, 250, 250));
        //__________________________end of changing color______________________________________
        
        
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
        /*
        FileListener fileListener = new FileListener();
        copy.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                 fileListener.Copy_Action();
            }
        });
       paste.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                 fileListener.Paste_Action();
            }
        });
         */
    }

    public static Menubar getInstanceMenuBar() {
        if (mainMenu == null) {
            mainMenu = new Menubar();
        }
        return mainMenu;
    }

    public JMenuBar getMenubar() {
        return menubar;
    }

    //______________________MenuBar Color change ________________________________________________
    private void changeTheme(Color back, Color fore) {
        changeComponentColors(menubar, back, fore);

        MenuElement[] menus = menubar.getSubElements();

        for (MenuElement menuElement : menus) {

            JMenu menu = (JMenu) menuElement.getComponent();
            changeComponentColors(menu, back, fore);
            menu.setOpaque(true);

            MenuElement[] menuElements = menu.getSubElements();

            for (MenuElement popupMenuElement : menuElements) {

                JPopupMenu popupMenu = (JPopupMenu) popupMenuElement.getComponent();
                popupMenu.setBorder(null);

                MenuElement[] menuItens = popupMenuElement.getSubElements();

                for (MenuElement menuItemElement : menuItens) {

                    JMenuItem menuItem = (JMenuItem) menuItemElement.getComponent();
                    changeComponentColors(menuItem, back, fore);
                    menuItem.setOpaque(true);
                    //for the submenu lookAndFeel
                    MenuElement[] menuItens1 = menuItem.getSubElements();

                    for (MenuElement menuItemElement1 : menuItens1) {

                        JPopupMenu popupMenu1 = (JPopupMenu) menuItemElement1.getComponent();
                        popupMenu1.setBorder(null);

                        MenuElement[] menuItens2 = menuItemElement1.getSubElements();

                        for (MenuElement menuItemElement2 : menuItens2) {

                            JMenuItem menuItem2 = (JMenuItem) menuItemElement2.getComponent();
                            changeComponentColors(menuItem2, back, fore);
                            menuItem2.setOpaque(true);
                        }
                    }
                }//end menuItemElement
            }//end for popupMenuElement
        }//end for menuElement
    }
    //______________________End Of MenuBar Color change ________________________________________________

    //______________________Color change ________________________________________________
    private void changeComponentColors(Component comp, Color background, Color foreground) {
        //Method to change color of a component 
        comp.setBackground(background);
        comp.setForeground(foreground);
    }
    //______________________End Of Color change ________________________________________________
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
                tabbedPane.setIconAt(sel, new ImageIcon(this.getClass().getResource("resources/unsaved.png")));
            }
        } else if (source == cancelButton) {
            jd.dispose();
        }
    }
}
}

