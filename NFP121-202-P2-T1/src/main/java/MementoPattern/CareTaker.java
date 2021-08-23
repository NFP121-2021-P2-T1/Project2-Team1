package MementoPattern;

import java.util.EmptyStackException;
import java.util.Stack;

/**
 *
 * @author Rim
 */
public class CareTaker {

    private static CareTaker careTaker;
    private Stack<Memento> undo;
    private Stack<Memento> redo;

    private CareTaker() {
        undo = new Stack<Memento>();
        redo = new Stack<Memento>();
    }

    public static CareTaker getCareTaker() {
        if (careTaker == null) {
            careTaker = new CareTaker();
        }
        return careTaker;
    }

    //________________________________________________________
    public void saveToUndo(Memento m) {
        undo.push(m);
    }

    public void saveToRedo(Memento m) {
        redo.push(m);
    }

    public Memento getUndo() {

        Memento temp = null;
        try {
            if (!undo.isEmpty()) {
                temp = undo.pop();
                //redo.push(temp);
                return temp;
            }
        } catch (NullPointerException | EmptyStackException e) {
        }
        return temp;
    }

    public Memento getRedo() {
        Memento temp = null;
        try {
            if (!redo.isEmpty()) {
                temp = redo.pop();

                //undo.push(temp);
                return temp;
            }

            return temp;
        } catch (NullPointerException | EmptyStackException e) {
        }
        return temp;
    }

}
