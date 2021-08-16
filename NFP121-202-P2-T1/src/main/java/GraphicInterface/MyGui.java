package GraphicInterface;

import BuilderPattern.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MyGui extends JFrame {

    private JMenuBar menubar;
    private JPanel mainPatternPanel, panelPattern, panelTextEditor;

    private JSplitPane splitPane;
    private JToolBar toolBar;

    public MyGui() {
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        //______________________________________________________________________        
        menubar = Menubar.getInstanceMenuBar().getMenubar();
        setJMenuBar(menubar);
        mainPatternPanel = new JPanel(new GridBagLayout());
        //______________________________________________________________________
        //Conctruction du PatternPanel
        Director d = new Director();
        /*PatternPanelBuilder patternPanelBuilder = new PatternPanelBuilder();
        d.construct(patternPanelBuilder);
        PatternPanel patternPanel = patternPanelBuilder.getResult();
        panelPattern = patternPanel.getMainPanel();
        mainPatternPanel.add(panelPattern);
        add(mainPatternPanel);*/
          
                //_____________________________________________________________________
                 panelTextEditor = new JPanel(new BorderLayout());
        //Construction du TextEditor
        TextEditorBuilder textEditorBuilder = new TextEditorBuilder();
        d.construct(textEditorBuilder);
        TextEditor textEditor = textEditorBuilder.getResult();
        splitPane = textEditor.getSplitPane();
        toolBar = textEditor.getToolBar();
        panelTextEditor.add(toolBar, BorderLayout.PAGE_START);
        panelTextEditor.add(splitPane);

        add(panelTextEditor);

        setPreferredSize(new Dimension(800, 600));
        setBackground(new Color(251, 252, 251));
        pack();
        setVisible(true);
        setLocationRelativeTo(null);

    }

    public static void main(String[] args) {
        MyGui editor = new MyGui();
    }

}
