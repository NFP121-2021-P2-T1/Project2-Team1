package BuilderPattern;

import Action.FileListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Observable;
import javax.swing.*;

public class SplitPane extends Observable {

    private static SplitPane mainSplit;

    private JSplitPane splitPane;
    private JTabbedPane leftTabbedPane, righTabbedPane;

    private JList list;
    private DefaultListModel listModel;
    private JScrollPane scrollPane;

    private SplitPane() {
        leftTabbedPane = new JTabbedPane();
        righTabbedPane = new JTabbedPane();

        listModel = new DefaultListModel();
        list = new JList(listModel);
        scrollPane = new JScrollPane(list);

        splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, leftTabbedPane, righTabbedPane);

        leftTabbedPane.addTab("Document Selector", scrollPane);

        list.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                JList list = (JList) evt.getSource();
                FileListener.openFileInTextEditor(evt);
            }
        });
    }

    public static SplitPane getInstanSplitPane() {
        if (mainSplit == null) {
            mainSplit = new SplitPane();
        }
        return mainSplit;
    }

    public JSplitPane getSplitPane() {
        return splitPane;
    }

    public JTabbedPane getLeftTabbedPane() {
        return leftTabbedPane;
    }

    public JTabbedPane getRighTabbedPane() {
        return righTabbedPane;
    }

    public JList getList() {
        return list;
    }

    public DefaultListModel getListModel() {
        return listModel;
    }

    public JScrollPane getScrollPane() {
        return scrollPane;
    }

    public void addListElement(Object element) {
        if (element != null) {
            listModel.addElement(element);
        }
        setChanged();
        notifyObservers();
    }

}
