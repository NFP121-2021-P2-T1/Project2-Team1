
public class ConcreteDecoratorA extends Decorator{
    
    public ConcreteDecoratorA (Component c){
        
        super(c);
        
    }
    public String operation(){
        
        return super.operation()+"";
        
    }
}
