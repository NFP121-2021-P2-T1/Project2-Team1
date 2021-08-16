/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Action;

import BuilderPattern.*;
import static com.sun.javafx.tk.Toolkit.getToolkit;
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.io.*;
import java.util.HashMap;
import javax.swing.*;
import javax.swing.filechooser.FileSystemView;

public class FileListener {

    private static HashMap<Integer, String> listOfFiles = new HashMap<Integer, String>();
    private static HashMap<Integer, Integer> listOfFilesOpened = new HashMap<Integer, Integer>();
    private static int elementNum = 0;
    private static int countTab = 0;

    public static void openFileInTextEditor(java.awt.event.MouseEvent evt) {
        JList list = (JList) evt.getSource();
        //if the element in the list is double clicked
        if (evt.getClickCount() == 2) {
            //getting the index of the element
            int index = list.locationToIndex(evt.getPoint());
            //getting the path of the file using the index
            String path = listOfFiles.get(index);
            //adding the file to the list of files opened in the tabbedPane
            listOfFilesOpened.put(countTab, index);
            countTab += 1;
            try {
                FileReader reader = new FileReader(path);
                BufferedReader br = new BufferedReader(reader);

                JTabbedPane tabbedPane = SplitPane.getInstanSplitPane().getRighTabbedPane();
                JTextPane textPane = new JTextPane();
                JScrollPane jsp = new JScrollPane(textPane);
                String tabName = (String) list.getModel().getElementAt(index);
                tabbedPane.addTab(tabName.trim(), jsp);

                textPane.read(br, null);
                br.close();
                textPane.requestFocus();
            } catch (Exception e2) {
                System.out.println(e2);
            }
        }
    }

    public static void openFolder() {
        JFileChooser j = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());

        // set the selection mode to Files and Directories
        j.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        // invoke the showsOpenDialog function to show the save dialog
        int r = j.showOpenDialog(null);

        JTextField myTextField = new JTextField();
        myTextField.setText(j.getSelectedFile().getAbsolutePath());
        String path = myTextField.getText();
        String name = j.getSelectedFile().toString();
        name = name.substring(name.lastIndexOf('\\') + 1);

        SplitPane.getInstanSplitPane().addListElement(name);
        listOfFiles.put(elementNum, path);
        elementNum += 1;

        addFilesToList(path, 0);
    }

    //to open directory and add element to modelList in SplitPane.
    public static void addFilesToList(String path, int index) {
        File root = new File(path);
        File[] list = root.listFiles();

        if (list == null) {
            return;
        }
        String s = "     ";
        for (int i = 0; i < index; i++) {
            s += "     ";
        }
        index += 1;
        String name = "";
        for (File f : list) {
            String extension = f.getName().substring(f.getName().lastIndexOf('.') + 1);
            if (f.isFile()) {
                if (extension.equals("java")) {
                    name = s + "" + f.getName();
                    listOfFiles.put(elementNum, f.getAbsolutePath());
                    elementNum += 1;
                    SplitPane.getInstanSplitPane().addListElement(name);
                }

            } else {
                name = s + "> " + f.getName();
                listOfFiles.put(elementNum, f.getAbsolutePath());
                elementNum += 1;
                SplitPane.getInstanSplitPane().addListElement(name);
                addFilesToList(f.getAbsolutePath(), index);
            }
        }
    }

    //__________________________________________________________________________
    public static void newProject() {
    }

    public static void createFolder() {
        JDialog dialog = new JDialog();
        dialog.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent e) {
                dialog.dispose();
            }
        });

        JButton finish = new JButton("Finish");
        JButton cancel = new JButton("Cancel");

        JPanel container = new JPanel(new GridBagLayout());
        JLabel projectName = new JLabel("Project Name : ");
        JTextField pNameField = new JTextField(15);
        JLabel projectLoc = new JLabel("Project Location");
        JTextField pLocField = new JTextField(15);

        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.BOTH;
        c.insets = new Insets(10, 20, 10, 20);

        c.gridx = 0;
        c.gridy = 0;
        container.add(projectName, c);
        c.gridx = 0;
        c.gridy = 1;
        container.add(projectLoc, c);

        c.gridx = 1;
        c.gridy = 0;
        c.gridwidth = 2;
        container.add(pNameField, c);

        c.gridx = 1;
        c.gridy = 1;
        container.add(pLocField, c);

        c.gridwidth = 1;
        c.gridx = 1;
        c.gridy = 2;
        container.add(finish, c);

        c.gridx = 2;
        c.gridy = 2;
        container.add(cancel, c);

        container.setVisible(true);

        dialog.add(container);
        container.setSize(400, 400);
        dialog.setSize(480, 480);
        dialog.setLocationRelativeTo(null);
        dialog.setVisible(true);
    }

    //Save a folder
    public static void File_Save_Action() {
        JTabbedPane tabbedPane = SplitPane.getInstanSplitPane().getRighTabbedPane();
        if (tabbedPane.getTabCount() > 0) {
            int selected = tabbedPane.getSelectedIndex();
            int listElementIndex = listOfFilesOpened.get(selected);
            String filename = listOfFiles.get(listElementIndex);
            JTextPane textPane = (JTextPane) (((JScrollPane) tabbedPane.getComponentAt(selected)).getViewport()).getComponent(0);

            File f = new File(filename);
            if (f.exists()) {
                try {
                    DataOutputStream d = new DataOutputStream(new FileOutputStream(filename));
                    String line = textPane.getText();
                    d.writeBytes(line);
                    d.close();

                    //String tabtext = tabbedPane.getTitleAt(sel);
                } catch (Exception ex) {
                    System.out.println("File not found");
                }
                textPane.requestFocus();
            }

        }
    }
    //Find

    public static void Find_Action() {
        JTabbedPane tabbedPane = SplitPane.getInstanSplitPane().getRighTabbedPane();
        if (tabbedPane.getTabCount() > 0) {
            int sel = tabbedPane.getSelectedIndex();
            JTextPane textPane = (JTextPane) (((JScrollPane) tabbedPane.getComponentAt(sel)).getViewport()).getComponent(0);

            String input = (String) JOptionPane.showInputDialog(null, "Enter Text to Find :  ", "Find", JOptionPane.PLAIN_MESSAGE, null, null, null);
            if (input != null) {
                int start = textPane.getText().indexOf(input);
                int end = input.length();
                if (start >= 0 && end > 0) {
                    textPane.select(start, start + end);
                }
            }
        }
    }
/*
    Clipboard clip = (Clipboard) getToolkit().getSystemClipboard();

    //Copy
    public void Copy_Action() {
        JTabbedPane tabbedPane = SplitPane.getInstanSplitPane().getRighTabbedPane();
        if (tabbedPane.getTabCount() > 0) {
            int sel = tabbedPane.getSelectedIndex();
            JTextPane textPane = (JTextPane) (((JScrollPane) tabbedPane.getComponentAt(sel)).getViewport()).getComponent(0);
            String selected_text = textPane.getSelectedText();
            StringSelection ss = new StringSelection(selected_text);
            clip.setContents(ss, ss);

        }
    }

    //Paste
    public void Paste_Action() {
        JTabbedPane tabbedPane = SplitPane.getInstanSplitPane().getRighTabbedPane();
        if (tabbedPane.getTabCount() > 0) {
            int sel = tabbedPane.getSelectedIndex();
            JTextPane textPane = (JTextPane) (((JScrollPane) tabbedPane.getComponentAt(sel)).getViewport()).getComponent(0);
            Transferable cliptran = clip.getContents(SplitPane.getInstanSplitPane().getRighTabbedPane());
            try {
                String selected_text = (String) cliptran.getTransferData(DataFlavor.stringFlavor);
                textPane.replaceSelection(selected_text);
            } catch (Exception exc) {
                System.out.println("error to paste");
            }
        }
    }

    //Cut
    public void Edit_Cut_Action() {
        JTabbedPane tabbedPane = SplitPane.getInstanSplitPane().getRighTabbedPane();
        if (tabbedPane.getTabCount() > 0) {
            int sel = tabbedPane.getSelectedIndex();
            JTextPane textPane = (JTextPane) (((JScrollPane) tabbedPane.getComponentAt(sel)).getViewport()).getComponent(0);
            String selected_text = textPane.getSelectedText();
            StringSelection ss = new StringSelection(selected_text);
            clip.setContents(ss, ss);
            textPane.replaceSelection("");

            String tabtext = tabbedPane.getTitleAt(sel);

        }
    }
*/
}
