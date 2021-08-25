package Action;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.filechooser.FileSystemView;

/**
 *
 * @author Rim
 */
public class NewFile {
    
    private JDialog dialog;
    private JLabel fileN, fileL;
    private JTextField fileName, fileLocation;
    private JButton browse, finish, cancel;
    
    public NewFile() {
        dialog = new JDialog();
        dialog.setTitle("Create New File");
        dialog.setLayout(new GridBagLayout());
        
        dialog.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent e) {
                dialog.dispose();
            }
        });
        
        fileN = new JLabel("File Name : ");
        fileName = new JTextField(15);
        
        fileL = new JLabel("File Location");
        fileLocation = new JTextField(15);
        fileLocation.setEditable(false);
        
        browse = new JButton("Browse");
        
        finish = new JButton("Finish");
        cancel = new JButton("Cancel");
        
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.BOTH;
        c.insets = new Insets(10, 20, 10, 20);
        
        c.gridx = 0;
        c.gridy = 0;
        dialog.add(fileN, c);
        
        c.gridx = 1;
        c.gridy = 0;
        dialog.add(fileName, c);
        
        c.gridx = 0;
        c.gridy = 1;
        dialog.add(fileL, c);
        
        c.gridx = 1;
        c.gridy = 1;
        dialog.add(fileLocation, c);
        
        c.gridx = 2;
        c.gridy = 1;
        dialog.add(browse, c);
        
        c.gridx = 1;
        c.gridy = 2;
        dialog.add(finish, c);
        
        c.gridx = 2;
        c.gridy = 2;
        dialog.add(cancel, c);
        
        dialog.setSize(480, 480);
        dialog.setLocationRelativeTo(null);
        dialog.setVisible(true);
        
        browse.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                //FileListener.openFolderw();
                JFileChooser j = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
                j.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
                int r = j.showOpenDialog(null);
                
                fileLocation.setText(j.getSelectedFile().getAbsolutePath());
                
            }
        });
        
        cancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                dialog.dispose();
            }
        });
        
        finish.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                String path = "";
                String name = "";
                String[] listFile = null;
                try {
                    if (!fileName.getText().equals("") && !fileLocation.equals("")) {
                        path = fileLocation.getText();
                        name = fileName.getText();
                        File file = new File(path, name + ".java");
                        file.createNewFile();
                        listFile = file.list();
                    }
                } catch (IOException ex) {
                    Logger.getLogger(NewFile.class.getName()).log(Level.SEVERE, null, ex);
                }
                FileListener.addFilesToList(path, 0);;
                //SplitPane.getInstanSplitPane().addListElement(listFile.length,name);
                dialog.dispose();
                
            }
        });
    }
    
}
