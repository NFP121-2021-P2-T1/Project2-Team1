/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FactoryPattern;

import Action.FileListener;
import static Action.FileListener.addFilesToList;
import BuilderPattern.PatternPanelButton;
import GraphicInterface.MyGui;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FilenameFilter;
import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import java.io.IOException;
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
public class CompositePatternFrame extends JFrame implements ActionListener, PatternPanelInterface {

    private static CompositePatternFrame compositePatternFrame;

    private JEditorPane compositeText;
    private JPanel panel, compositePanel, container;
    private JLabel imageLabel, title, projectName, projectLoc;
    private String text, path, name, pa;
    private ImageIcon image;
    private JButton backBtn, create, finish, cancel, browse;
    private JDialog dialog;
    private JTextField pNameField, pLocField, myTextField;

    private CompositePatternFrame() {

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
        compositePanel = new JPanel(new GridBagLayout());

        //______________________________________________________________________
        compositeText = new JEditorPane("text/html", "");
        compositeText.setEditable(false);
        compositeText.setOpaque(false);
        setText();

        //______________________________________________________________________
        image = new ImageIcon(getImagepath());
        imageLabel = new JLabel(image);
        title = new JLabel("Composite Pattern");
        title.setFont(new Font("", Font.BOLD, 20));
        //______________________________________________________________________
        backBtn = new JButton("< Back");
        create = new JButton("Next >");

        //______________________________________________________________________
        backBtn.setFocusable(false);
        create.setFocusable(false);

        //______________________________________________________________________
        backBtn.addActionListener(this);
        create.addActionListener(this);

        //______________________________________________________________________
        PatternPanelButton.addComponent(c, compositePanel, backBtn, 0, 0);
        PatternPanelButton.addComponent(c, compositePanel, title, 1, 0);
        PatternPanelButton.addComponent(c, compositePanel, compositeText, 1, 1);
        PatternPanelButton.addComponent(c, compositePanel, imageLabel, 1, 2);
        PatternPanelButton.addComponent(c, compositePanel, create, 2, 3);

        //______________________________________________________________________ 
        panel.add(compositePanel);

        //______________________________________________________________________
        panel.setLayout(new GridBagLayout());
        panel.setBackground(new Color(251, 252, 251));
        panel.setVisible(true);

    }

    public static CompositePatternFrame getInstancFrame() {
        if (compositePatternFrame == null) {
            compositePatternFrame = new CompositePatternFrame();
        }
        return compositePatternFrame;
    }

    public void setText() {
        text = "<b>What it is : </b> \n Compose objects into tree structures to represent part-whole hierarchies. "
                + "Lets clients treat individual objects and compositions of objects uniformly.";
        compositeText.setText(text);
    }

    public String getImagepath() {
        path = "images\\composite.png";
        return path;
    }

    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == backBtn) {
            PatternPanelButton.getPan().setVisible(false);
            PatternPanelButton.getInstancePattern().getCategoryPanel().setVisible(false);
            PatternPanelButton.getInstancePattern().getBehavioralPanel().setVisible(false);
            PatternPanelButton.getInstancePattern().getCreationalPanel().setVisible(false);
            PatternPanelButton.getInstancePattern().getBack().setVisible(true);
            backBtn.setVisible(true);
            PatternPanelButton.getInstancePattern().getStructuralPanel().setVisible(true);

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
                    JFileChooser j = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
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
            compositePanel.setVisible(false);
            PatternPanelButton.getInstancePattern().getBack().setVisible(true);
            PatternPanelButton.getInstancePattern().getCreationalPanel().setVisible(true);
            container.setVisible(false);
            dialog.setVisible(false);
        } else if (e.getSource() == finish) {
            if (pNameField.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Folder name is Empty");
                finish.setEnabled(false);
            } //__________________copy files____________________________________________________
            else {
                pa = myTextField.getText() + "\\" + pNameField.getText();
                finish.setEnabled(true);
                pLocField.setText(pa);
                String pNameF = pNameField.getText();

                String pLoc = pLocField.getText();

                try {
                    Path pathh = Paths.get(pLoc.toString() + "\\" + pNameF.toString());
                    Files.createDirectories(pathh.getParent());
                    File f = new File(pathh.toString());
                    //f.mkdirs();

                } catch (FileAlreadyExistsException exx) {
                    System.err.println("already exists: " + exx.getMessage());
                } catch (IOException ex) {
                    Logger.getLogger(BuilderPatternFrame.class.getName()).log(Level.SEVERE, null, ex);
                }

                String sourceFolder = "patternFiles\\CompositePatternFiles";
                String targetFolder = pLoc.toString();

                File sFile = new File(sourceFolder);
                // Find files with specified extension
                File[] sourceFiles = sFile.listFiles(new FilenameFilter() {

                    @Override
                    public boolean accept(File dir, String name) {
                        if (name.endsWith(".java")) {
                            return true;
                        } else {
                            return false;
                        }
                    }
                });

                // copy each file to the target folder
                for (File fSource : sourceFiles) {
                    File fTarget = new File(new File(targetFolder), fSource.getName());
                    FileListener.copyFileUsingStream(fSource, fTarget);

                }
                //__________________________________________________________________

                addFilesToList(pa, 0);

                //__________________________________________________________________
                MyGui gui = MyGui.getGui();
                container.setVisible(false);
                dialog.setVisible(false);
                gui.getMainPatternPanel().setVisible(false);
                gui.getPanelTextEditor().setVisible(true);
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

    public static CompositePatternFrame getCompositePatternFrame() {
        return compositePatternFrame;
    }

    public JEditorPane getCompositeText() {
        return compositeText;
    }

    public JPanel getCompositePanel() {
        return compositePanel;
    }

    @Override
    public JPanel getContainer() {
        return container;
    }

    @Override
    public JLabel getImageLabel() {
        return imageLabel;
    }

    public JLabel getProjectName() {
        return projectName;
    }

    public JLabel getProjectLoc() {
        return projectLoc;
    }

    public String getText() {
        return text;
    }

    public String getPath() {
        return path;
    }

    public String getName() {
        return name;
    }

    public String getPa() {
        return pa;
    }

    public ImageIcon getImage() {
        return image;
    }

    public JButton getBackBtn() {
        return backBtn;
    }

    public JButton getCreate() {
        return create;
    }

    public JButton getFinish() {
        return finish;
    }

    public JButton getCancel() {
        return cancel;
    }

    public JButton getBrowse() {
        return browse;
    }

    public JDialog getDialog() {
        return dialog;
    }

    public JTextField getpNameField() {
        return pNameField;
    }

    public JTextField getpLocField() {
        return pLocField;
    }

    public JTextField getMyTextField() {
        return myTextField;
    }

    @Override
    public JTextField getMyTextFiled() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getNamePath() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
