
import java.util.*;

public class Composite implements Component {
    
    List <Component> components = new ArrayList<Component>();
    
    public void add(Component component) {  
        components.add(component);  
    }  
     
    public Component getChild(int i) {  
      return components.get(i);  
    }  
    
    public void remove(Component component) {  
      components.remove(component);
    }    
    
    public void operation(){
        //operation
    }
}
