/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Command;

import BuilderPattern.SplitPane;
import javax.swing.JTabbedPane;

/**
 *
 * @author Rim
 */
public abstract class Command {

    SplitPane textEditor = SplitPane.getInstanSplitPane();
    JTabbedPane tabbedPane = textEditor.getRighTabbedPane();

    public abstract void execute();
}
