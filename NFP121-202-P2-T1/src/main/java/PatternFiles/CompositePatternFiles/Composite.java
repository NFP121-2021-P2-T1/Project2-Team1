/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PatternFiles.CompositePatternFiles;
import java.util.*;
/**
 *
 * @author Cynthia
 */
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
