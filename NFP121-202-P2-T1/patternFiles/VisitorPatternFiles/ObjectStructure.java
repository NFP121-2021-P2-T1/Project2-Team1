
import java.util.*;

public class ObjectStructure {
    List visitors;
    public ObjectStructure(){
        visitors = new ArrayList();
    }
    
    public void addVisitor(AVisitor v){
        visitors.add(v);
    }
    
    public void removeVisitor(AVisitor v){
        visitors.remove(v);
    }
    
}
