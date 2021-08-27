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

public class BuilderPatternFrame extends JFrame implements ActionListener, PatternPanelInterface {

    private static BuilderPatternFrame builderPatternFrame;
    private JEditorPane builderText;
    private JPanel panel, builderPanel, container;
    private JLabel imageLabel, title, projectName, projectLoc;
    private String text, path, name, pa;
    private ImageIcon image;
    private JButton backBtn, create, finish, cancel, browse;
    private JDialog dialog;
    private JTextField pNameField, pLocField, myTextField;

    private BuilderPatternFrame() {

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
        builderPanel = new JPanel(new GridBagLayout());

        //______________________________________________________________________
        builderText = new JEditorPane("text/html", "");
        builderText.setEditable(false);
        builderText.setOpaque(false);
        setText();

        //______________________________________________________________________
        image = new ImageIcon(getImagepath());
        imageLabel = new JLabel(image);
        title = new JLabel("Builder Pattern");
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
        PatternPanelButton.addComponent(c, builderPanel, backBtn, 0, 0);
        PatternPanelButton.addComponent(c, builderPanel, title, 1, 0);
        PatternPanelButton.addComponent(c, builderPanel, builderText, 1, 1);
        PatternPanelButton.addComponent(c, builderPanel, imageLabel, 1, 2);
        PatternPanelButton.addComponent(c, builderPanel, create, 2, 3);

        //______________________________________________________________________ 
        panel.add(builderPanel);

        //______________________________________________________________________
        panel.setLayout(new GridBagLayout());
        panel.setBackground(new Color(251, 252, 251));
        panel.setVisible(true);

    }

    public static BuilderPatternFrame getInstancFrame() {
        if (builderPatternFrame == null) {
            builderPatternFrame = new BuilderPatternFrame();
        }
        return builderPatternFrame;
    }

    @Override
    public JPanel getPanel() {
        return builderPanel;
    }

    @Override
    public void setText() {
        text = "<b>What it is : </b> \n Separate the construction of a complex object from its "
                + "representing so that the same construction\nprocess can create different representations.";
        builderText.setText(text);
    }

    @Override
    public String getImagepath() {
        path = "images\\builder.png";
        return path;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == backBtn) {
            PatternPanelButton.getPan().setVisible(false);
            PatternPanelButton.getInstancePattern().getCategoryPanel().setVisible(false);
            PatternPanelButton.getInstancePattern().getStructuralPanel().setVisible(false);
            PatternPanelButton.getInstancePattern().getBehavioralPanel().setVisible(false);
            backBtn.setVisible(true);

            PatternPanelButton.getInstancePattern().getBack().setVisible(true);
            PatternPanelButton.getInstancePattern().getCreationalPanel().setVisible(true);

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
            builderPanel.setVisible(false);
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

                String sourceFolder = "patternFiles\\BuilderPatternFiles";
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

                //copy each file to the target folder
                for (File fSource : sourceFiles) {
                    File fTarget = new File(new File(targetFolder), fSource.getName());
                    FileListener.copyFileUsingStream(fSource, fTarget);
                }
                //__________________________________________________________________

                String path2 = pLocField.getText();
                String name2 = path2;
                name2 = name2.substring(path2.lastIndexOf('\\') + 1);
                if (!FileListener.getListOfFiles().containsValue(path)) {
                    SplitPane.getInstanSplitPane().addListElement(">"+name2);
                    FileListener.getListOfFiles().put(FileListener.getElementNum(), path2);
                    FileListener.setElementNum(FileListener.getElementNum() + 1);
                }
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

    public static BuilderPatternFrame getBuilderPatternFrame() {
        return builderPatternFrame;
    }

    public JPanel getBuilderPanel() {
        return builderPanel;
    }

    @Override
    public JPanel getContainer() {
        return container;
    }

    @Override
    public JLabel getImageLabel() {
        return imageLabel;
    }

    @Override
    public JLabel getProjectName() {
        return projectName;
    }

    @Override
    public JLabel getProjectLoc() {
        return projectLoc;
    }

    @Override
    public String getText() {
        return text;
    }

    @Override
    public String getPath() {
        return path;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getPa() {
        return pa;
    }

    @Override
    public ImageIcon getImage() {
        return image;
    }

    @Override
    public JButton getBackBtn() {
        return backBtn;
    }

    @Override
    public JButton getCreate() {
        return create;
    }

    @Override
    public JButton getFinish() {
        return finish;
    }

    @Override
    public JButton getCancel() {
        return cancel;
    }

    @Override
    public JButton getBrowse() {
        return browse;
    }

    @Override
    public JDialog getDialog() {
        return dialog;
    }

    @Override
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
