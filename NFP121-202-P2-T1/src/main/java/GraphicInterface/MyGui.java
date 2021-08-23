package GraphicInterface;

import Action.FileListener;
import BuilderPattern.*;
import java.awt.*;
import javax.swing.*;

/**
 *
 * @author Rim
 */
public class MyGui extends JFrame {

    private static MyGui myInterface;

    private JMenuBar menubar;
    private JPanel framePanel, mainPatternPanel, panelPattern, panelTextEditor;

    private JSplitPane splitPane;
    private JToolBar toolBar;

    private MyGui() {
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                FileListener.CloseAll_Action();

            }

        });
        //______________________________________________________________________        
        menubar = Menubar.getInstanceMenuBar().getMenubar();
        setJMenuBar(menubar);

        framePanel = new JPanel();
        //framePanel.setLayout(new GridBagLayout());

        mainPatternPanel = new JPanel(new GridBagLayout());
        //______________________________________________________________________
        //Conctruction du PatternPanel
        Director d = new Director();
        PatternPanelBuilder patternPanelBuilder = new PatternPanelBuilder();
        d.construct(patternPanelBuilder);
        PatternPanel patternPanel = patternPanelBuilder.getResult();
        panelPattern = patternPanel.getMainPanel();
        mainPatternPanel.add(panelPattern);
        framePanel.add(mainPatternPanel);
        mainPatternPanel.setVisible(true);
        //_____________________________________________________________________
        panelTextEditor = new JPanel(new BorderLayout());
        panelTextEditor.setPreferredSize(new Dimension(800, 600));
        //Construction du TextEditor
        TextEditorBuilder textEditorBuilder = new TextEditorBuilder();
        d.construct(textEditorBuilder);
        TextEditor textEditor = textEditorBuilder.getResult();
        splitPane = textEditor.getSplitPane();
        toolBar = textEditor.getToolBar();
        panelTextEditor.add(toolBar, BorderLayout.PAGE_START);
        panelTextEditor.add(splitPane);

        framePanel.add(panelTextEditor);
        panelTextEditor.setVisible(false);
        add(framePanel);

        setPreferredSize(new Dimension(900, 700));
        setBackground(new Color(251, 252, 251));
        pack();
        setVisible(true);
        setLocationRelativeTo(null);

    }

    public static MyGui getGui() {
        if (myInterface == null) {
            myInterface = new MyGui();
        }
        return myInterface;
    }

    public static MyGui getMyInterface() {
        return myInterface;
    }

    public JPanel getFramePanel() {
        return framePanel;
    }

    public JMenuBar getMenubar() {
        return menubar;
    }

    public JPanel getMainPatternPanel() {
        return mainPatternPanel;
    }

    public JPanel getPanelPattern() {
        return panelPattern;
    }

    public JPanel getPanelTextEditor() {
        return panelTextEditor;
    }

    public JSplitPane getSplitPane() {
        return splitPane;
    }

    public JToolBar getToolBar() {
        return toolBar;
    }

    public static void main(String[] args) {
        getGui();
    }

}
