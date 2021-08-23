
public class ConcreteComponent implements Component {
    
    private Component component;
    
    public ConcreteComponent(Component c){
        
        component = c;
        
    }
    public String operation(){
        
        return component.operation();
        
    }
    
}
