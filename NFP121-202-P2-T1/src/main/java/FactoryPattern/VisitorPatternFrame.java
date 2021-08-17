/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FactoryPattern;

import Action.FileListener;
import static Action.FileListener.addFilesToList;
import BuilderPattern.PatternPanelButton;
import BuilderPattern.SplitPane;
import GraphicInterface.MyGui;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.filechooser.FileSystemView;

/**
 *
 * @author Cynthia
 */
public class VisitorPatternFrame extends JFrame implements ActionListener, PatternPanelTemplate {

    private static VisitorPatternFrame visitorPatternFrame ;

    private JEditorPane visitorText;
    private JPanel panel, visitorPanel, container;
    private JLabel imageLabel, title, projectName, projectLoc;
    private String text, path;
    private ImageIcon image;
    private JButton back, create, finish, cancel, browse;
    private JDialog dialog;
    private JTextField pNameField, pLocField;
            public JFileChooser j;
    private String name;
    private JTextField myTextField;
    private String pa;
    
    private VisitorPatternFrame() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        //_________________MainPanel____________________________________________
        
        panel = new JPanel();

        //________________Layout________________________________________________
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.BOTH;
        c.weightx = 0.5;
        c.weighty = 1.0;
        c.insets = new Insets(10, 20, 10, 20);

        //______________________________________________________________________
        visitorPanel = new JPanel(new GridBagLayout());

        //______________________________________________________________________
        visitorText = new JEditorPane("text/html", "");
        visitorText.setEditable(false);
        visitorText.setOpaque(false);
        setText();

        //______________________________________________________________________
        image = new ImageIcon(getImagepath());
        imageLabel = new JLabel(image);
        title = new JLabel("Visitor Pattern");
        title.setFont(new Font("", Font.BOLD, 20));
        //______________________________________________________________________
        back = new JButton("< Back");
        create = new JButton("Next >");

        //______________________________________________________________________
        back.setFocusable(false);
        create.setFocusable(false);

        //______________________________________________________________________
        back.addActionListener(this);
        create.addActionListener(this);

        //______________________________________________________________________
        addComponent(c, visitorPanel, back, 0, 0);
        addComponent(c, visitorPanel, title, 1, 0);
        addComponent(c, visitorPanel, visitorText, 1, 1);
        addComponent(c, visitorPanel, imageLabel, 1, 2);
        addComponent(c, visitorPanel, create, 2, 3);

        //______________________________________________________________________ 
        panel.add(visitorPanel);

        //______________________________________________________________________
        panel.setLayout(new GridBagLayout());
        panel.setBackground(new Color(251, 252, 251));
        panel.setVisible(true);

    }
    
    public static VisitorPatternFrame getInstancFrame()
    {
        if(visitorPatternFrame== null) 
            visitorPatternFrame = new VisitorPatternFrame();
        return visitorPatternFrame;
    }

    public static VisitorPatternFrame getVisitorPatternFrame() {
        return visitorPatternFrame;
    }

    public JEditorPane getVisitorText() {
        return visitorText;
    }

    public JLabel getImageLabel() {
        return imageLabel;
    }

    public String getText() {
        return text;
    }

    public String getPath() {
        return path;
    }

    public ImageIcon getImage() {
        return image;
    }

    public JButton getBack() {
        return back;
    }

    public JButton getCreate() {
        return create;
    }
    

    public void setText() {
        text = "<b>What it is : </b> \n Represent an operation to be performed on the elements of an "
                + "object structure. Lets you define a new operation without changing the classes of the elements on which it operates.";
        visitorText.setText(text);
    }

    public String getImagepath() {
        path = "images\\visitor.png";
        return path;
    }
    
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == back) {
            visitorPanel.setVisible(false);
            PatternPanelButton.getInstancePattern().getBack().setVisible(true);
            PatternPanelButton.getInstancePattern().getBehavioralPanel().setVisible(true);

        } else if (e.getSource() == create) {
            dialog = new JDialog();
            dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                @Override
                public void windowClosing(java.awt.event.WindowEvent e) {
                    dialog.dispose();
                }
            });

            finish = new JButton("Finish");
            cancel = new JButton("Cancel");

            container = new JPanel(new GridBagLayout());
            projectName = new JLabel("Project Name : ");
            pNameField = new JTextField(15);
            projectLoc = new JLabel("Project Location");
            pLocField = new JTextField(15);

            //pNameField.setEditable(false);
            pLocField.setEditable(false);

            browse = new JButton("Browse");

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

            c.gridx = 3;
            c.gridy = 1;
            container.add(browse, c);

            //__________________________________________________________________
            finish.setEnabled(false);
            //______________________________________________________________________
            finish.addActionListener(this);
            cancel.addActionListener(this);
            //_______________________________________________________________________
            container.setVisible(true);

            dialog.add(container);
            container.setSize(400, 400);
            dialog.setSize(480, 480);
            dialog.setLocationRelativeTo(null);
            dialog.setVisible(true);
            //______________________________________________________________________________
            //openProject.setAccelerator(KeyStroke.getKeyStroke("control shift O"));
            browse.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent ae) {
                    //FileListener.openFolderw();
                    j = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
                    j.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
                    int r = j.showOpenDialog(null);
                    myTextField = new JTextField();
                    myTextField.setText(j.getSelectedFile().getAbsolutePath());
                    pa = myTextField.getText() + "\\" + pNameField.getText();
                    name = j.getSelectedFile().toString();
                    name = name.substring(name.lastIndexOf('\\') + 1);

                    finish.setEnabled(true);
                }
            });

        } else if (e.getSource() == cancel) {
            visitorPanel.setVisible(false);
            PatternPanelButton.getInstancePattern().getBack().setVisible(true);
            PatternPanelButton.getInstancePattern().getCreationalPanel().setVisible(true);
            container.setVisible(false);
            dialog.setVisible(false);
        } else if (e.getSource() == finish) {

            //__________________copy files____________________________________________________
            pLocField.setText(pa);
            String pNameF = pNameField.getText();

            String pLoc = pLocField.getText();

            try {
                Path pathh = Paths.get(pLoc.toString() + "\\" + pNameF.toString());
                Files.createDirectories(pathh.getParent());
                File f = new File(pathh.toString());
                f.mkdirs();

            } catch (FileAlreadyExistsException exx) {
                System.err.println("already exists: " + exx.getMessage());
            } catch (IOException ex) {
                Logger.getLogger(BuilderPatternFrame.class.getName()).log(Level.SEVERE, null, ex);
            }

            String sourceFolder = "patternFiles\\VisitorPatternFiles";
            String targetFolder = pLoc.toString() + "\\" + pNameF.toString();

            File sFile = new File(sourceFolder);
            // Find files with specified extension
            File[] sourceFiles = sFile.listFiles(new FilenameFilter() {

                @Override
                public boolean accept(File dir, String name) {
                    if (name.endsWith(".java")) {// change this to your extension
                        return true;
                    } else {
                        return false;
                    }
                }
            });

            // let us copy each file to the target folder
            for (File fSource : sourceFiles) {
                File fTarget = new File(new File(targetFolder), fSource.getName());
                copyFileUsingStream(fSource, fTarget);
                // fSource.delete(); // Uncomment this line if you want source file deleted
            }
            //__________________________________________________________________

            SplitPane.getInstanSplitPane().addListElement(name);
            Integer elementNum = 0;
            FileListener.getListOfFiles().put(elementNum, pa);
            elementNum += 1;

            addFilesToList(pa, 0);

            //__________________________________________________________________
            MyGui gui = MyGui.getGui();
            container.setVisible(false);
            dialog.setVisible(false);
            gui.getMainPatternPanel().setVisible(false);
            gui.getPanelTextEditor().setVisible(true);
        }
    }

    private static void copyFileUsingStream(File source, File dest) {
        InputStream is = null;
        OutputStream os = null;
        try {
            is = new FileInputStream(source);
            os = new FileOutputStream(dest);
            byte[] buffer = new byte[1024];
            int length;
            while ((length = is.read(buffer)) > 0) {
                os.write(buffer, 0, length);
            }
        } catch (Exception ex) {
            System.out.println("Unable to copy file:" + ex.getMessage());
        } finally {
            try {
                is.close();
                os.close();
            } catch (Exception ex) {
            }
        }
    }
    
    
    public String getNameFolder() {
        return pNameField.getText();
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public JPanel getPanel() {
        return panel;
    }

    public void addComponent(GridBagConstraints c, JPanel panel, JComponent comp, int x, int y) {
        c.gridx = x;
        c.gridy = y;
        panel.add(comp, c);
    }

}
