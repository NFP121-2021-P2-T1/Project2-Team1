package GraphicInterface;

import Action.FileListener;
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
        //________________________
        newFile = new JMenuItem("New File");
        newProject = new JMenuItem("New Project");
        openFile = new JMenuItem("Open File");
        openProject = new JMenuItem("Open Project");
        save = new JMenuItem("Save");
        saveAs = new JMenuItem("Save As");
        //________________________
        cut = new JMenuItem("Cut");
        copy = new JMenuItem("Copy");
        paste = new JMenuItem("Paste");
        find = new JMenuItem("Find");
        replace = new JMenuItem("Replace");
        //________________________
        lookAndFeel = new JMenu("Look & Feel");
        font = new JMenuItem("Font");

        //________________________
        fall = new JMenuItem("Fall");
        //________________________
        about = new JMenuItem("About");
        copyright = new JMenuItem("Copyright");
        //________________________
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
        //________________________
        edit.add(cut);
        edit.add(copy);
        edit.add(paste);
        edit.addSeparator();
        edit.add(find);
        edit.add(replace);
        //________________________
        view.add(font);
        view.add(lookAndFeel);
        //________________________
        lookAndFeel.add(fall);
        //________________________
        help.add(about);
        help.add(copyright);
        //________________________
        menubar.add(file);
        menubar.add(edit);
        menubar.add(view);
        menubar.add(help);

        //___________Changing color_____________
        // changeTheme(new Color(191, 191, 191), new Color(250, 250, 250));
        //_________end of changing color_____________
        
        openProject.setAccelerator(KeyStroke.getKeyStroke("control shift O"));
        openProject.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                FileListener.openFolder();
                MyGui gui = MyGui.getGui();
                gui.getFramePanel().setLayout(new FlowLayout());
                gui.getMainPatternPanel().setVisible(false);
                gui.getPanelTextEditor().setVisible(true);
            }
        });
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

    //_______MenuBar Color change _________________
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
    //_______End Of MenuBar Color change _________________

    //_______Color change _________________
    private void changeComponentColors(Component comp, Color background, Color foreground) {
        //Method to change color of a component 
        comp.setBackground(background);
        comp.setForeground(foreground);
    }
    //_______End Of Color change _________________

}