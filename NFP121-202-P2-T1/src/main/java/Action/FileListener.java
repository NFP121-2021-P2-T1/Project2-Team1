package Action;

import BuilderPattern.*;
import java.awt.*;
import java.io.*;
import java.util.HashMap;
import javax.swing.*;
import javax.swing.filechooser.FileSystemView;

/**
 *
 * @author Rim
 */
public class FileListener {

    private static HashMap<Integer, String> listOfFiles = new HashMap<Integer, String>();
    private static HashMap<Integer, Integer> listOfFilesOpened = new HashMap<Integer, Integer>();
    private static int elementNum = 0;//index pour lisOfFiles
    private static int countTab = 0;//index pour listOfFilesOpened
    //__________________________________________________________________________

    public static void openFileInTextEditor(java.awt.event.MouseEvent evt) {
        JList list = (JList) evt.getSource();
        //if the element in the list is double clicked
        if (evt.getClickCount() == 2) {
            //getting the index of the element
            int index = list.locationToIndex(evt.getPoint());
            if (!listOfFilesOpened.containsValue(index)) {//Si le fichier n'est pas encore ouvert dans textPane

                //getting the path of the file using the index
                String path = listOfFiles.get(index);
                //adding the file to the list of files opened in the tabbedPane
                listOfFilesOpened.put(countTab, index);
                countTab += 1;
                try {
                    FileReader reader = new FileReader(path);
                    BufferedReader br = new BufferedReader(reader);
                    //getting the tabbedPane where to add the file to open
                    JTabbedPane tabbedPane = SplitPane.getInstanSplitPane().getRighTabbedPane();
                    //Creating the textPane where the file will be opened
                    JTextPane textPane = new JTextPane();
                    //adding a key listener for when we modifie the file
                    textPane.addKeyListener(new KeyTypedAction());
                    JScrollPane jsp = new JScrollPane(textPane);
                    String tabName = (String) list.getModel().getElementAt(index);
                    tabbedPane.addTab(tabName.trim(), jsp);
                    tabbedPane.setSelectedIndex(countTab - 1);

                    textPane.read(br, null);
                    br.close();
                    textPane.requestFocus();
                } catch (Exception e2) {
                    System.out.println(e2);
                }
            }
        }
    }
    // __________________________________________________________________________

    //choose the directory to open
    public static void openFolder() {
        JFileChooser j = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());

        // set the selection mode to Files and Directories
        j.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        // invoke the showsOpenDialog function to show the save dialog
        int r = j.showOpenDialog(null);

        JTextField myTextField = new JTextField();
        myTextField.setText(j.getSelectedFile().getAbsolutePath());
        String path = myTextField.getText();
        String name = j.getSelectedFile().toString();
        name = name.substring(name.lastIndexOf('\\') + 1);
        //if the Folder is not opened in the list , go and open it
        if (!listOfFiles.containsValue(path)) {
            SplitPane.getInstanSplitPane().addListElement(name);
            listOfFiles.put(elementNum, path);
            elementNum += 1;
        }
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
            if (!listOfFiles.containsValue(f.getAbsolutePath())) {
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
    }
    //__________________________________________________________________________

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

                    String tabtext = tabbedPane.getTitleAt(tabbedPane.getSelectedIndex());
                    if (tabtext.contains("*")) {
                        tabtext = tabtext.replace("*", "");
                        tabbedPane.setTitleAt(tabbedPane.getSelectedIndex(), tabtext);

                    }

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
    //__________________________________________________________________________
    public static HashMap<Integer, String> getListOfFiles() {
        return listOfFiles;
    }

    public static HashMap<Integer, Integer> getListOfFilesOpened() {
        return listOfFilesOpened;
    }
    //__________________________CloseAll________________________________________
    //Close all the file in textEditor and ask to save or not all the modified files
    public static void CloseAll_Action() throws IndexOutOfBoundsException {
        JTabbedPane tabbedPane = SplitPane.getInstanSplitPane().getRighTabbedPane();
        DefaultListModel listModel = SplitPane.getInstanSplitPane().getListModel();

        if (tabbedPane.getTabCount() > 0) {
            for (int j = 0; j < tabbedPane.getTabCount(); j++) {
                tabbedPane.setSelectedIndex(j);
                int sel = tabbedPane.getSelectedIndex();
                String tabtext = tabbedPane.getTitleAt(sel);

                if (tabtext.contains("*")) {
                    int n = JOptionPane.showConfirmDialog(null, "Do you want to save " + tabtext + " before close ?",
                            "Save or Not", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);

                    tabtext.replace("*", "");

                    if (n == 0) {
                        JTextPane textPane = (JTextPane) (((JScrollPane) tabbedPane.getComponentAt(sel)).getViewport()).getComponent(0);

                        File_Save_Action();

                        tabbedPane.remove(sel);
                        listModel.removeAllElements();
                        //adding all elements to list after removing the tab
                        for (int i = 0; i < tabbedPane.getTabCount(); i++) {
                            String item = tabbedPane.getTitleAt(i);
                            if (item.contains("*")) {
                                item = item.replace("*", "").trim();
                            }
                        }
                        CloseAll_Action();
                    }
                    if (n == 1) {
                        tabbedPane.remove(sel);
                        listModel.removeAllElements();
                        //adding all elements to list after removing the tab
                        for (int i = 0; i < tabbedPane.getTabCount(); i++) {
                            String item = tabbedPane.getTitleAt(i);
                            if (item.contains("*")) {
                                item = item.replace("*", "").trim();
                            }
                        }
                        CloseAll_Action();
                    }
                } else {
                    tabbedPane.remove(sel);
                    listModel.removeAllElements();

                    //adding all elements to list after removing the tab
                    for (int i = 0; i < tabbedPane.getTabCount(); i++) {
                        String item = tabbedPane.getTitleAt(i);
                        if (item.contains("*")) {
                            item = item.replace("*", "").trim();
                        }
                    }
                    CloseAll_Action();

                }
            }
        }
        listOfFiles.clear();
        listOfFilesOpened.clear();

        System.exit(0);

    }
    //______________________SaveAs__________________________________________
    //Save as a file to a folder
    public static void SaveAs_Action() {
        JTabbedPane tabbedPane = SplitPane.getInstanSplitPane().getRighTabbedPane();
        if (tabbedPane.getTabCount() > 0) {
            FileDialog fd = new FileDialog(new JFrame(), "Save File", FileDialog.SAVE);
            fd.show();
            if (fd.getFile() != null) {
                String filename = fd.getDirectory() + fd.getFile();
                int sel = tabbedPane.getSelectedIndex();
                JTextPane textPane = (JTextPane) (((JScrollPane) tabbedPane.getComponentAt(sel)).getViewport()).getComponent(0);
                try {
                    DataOutputStream d = new DataOutputStream(new FileOutputStream(filename));
                    String line = textPane.getText();
                    d.writeBytes(line);
                    d.close();

                    String file = filename.substring(filename.lastIndexOf("\\") + 1);
                    tabbedPane.setTitleAt(sel, file);

                } catch (Exception ex) {
                    System.out.println("File not found");
                }
                textPane.requestFocus();

            }
        }
    }
    //__________________________________SaveAll_______________________________
    public static void SaveAll_Action() {
        JTabbedPane tabbedPane = SplitPane.getInstanSplitPane().getRighTabbedPane();
        if (tabbedPane.getTabCount() > 0) {
            int maxindex = tabbedPane.getTabCount() - 1;
            for (int i = 0; i <= maxindex; i++) {
                tabbedPane.setSelectedIndex(i);
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

                        String tabtext = tabbedPane.getTitleAt(tabbedPane.getSelectedIndex());
                        if (tabtext.contains("*")) {
                            tabtext = tabtext.replace("*", "");
                            tabbedPane.setTitleAt(tabbedPane.getSelectedIndex(), tabtext);

                        }

                        //String tabtext = tabbedPane.getTitleAt(sel);
                    } catch (Exception ex) {
                        System.out.println("File not found");
                    }
                    textPane.requestFocus();
                }

            }
        }
    }
}
