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
