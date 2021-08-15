/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Action;

package BulderFrame;

import BuilderPattern.*;
import java.awt.*;
import java.io.File;
import javax.swing.*;
import javax.swing.filechooser.FileSystemView;

public class FileListener {

    public static void openFolder() {
        JFileChooser j = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());

        // set the selection mode to Files and Directories
        j.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);

        // invoke the showsOpenDialog function to show the save dialog
        int r = j.showOpenDialog(null);
        JTextField myTextField = new JTextField();
        myTextField.setText(j.getSelectedFile().getAbsolutePath());

        String path = myTextField.getText();
        
        addFiles(path, 0);
    }

    //to open directory and add element to modelList in SplitPane.
    public static void addFiles(String path, int index) {
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
            if (f.isFile()) {
                name = s + "" + f.getName();
                SplitPane.getInstanSplitPane().addListElement(name);

            } else {
                name = s + "> " + f.getName();
                SplitPane.getInstanSplitPane().addListElement(name);
                //index++;
                addFiles(f.getAbsolutePath(), index);
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

}

