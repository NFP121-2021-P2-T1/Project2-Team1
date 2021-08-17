/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Command;

import java.util.Stack;

/**
 *
 * @author Rim
 */
public class Invoker {
    private Stack<Command> commands = new Stack<Command>();
    public void doCommand(Command c)
    {
        c.execute();
    }
    
            
    
}
