
public class ConcreteDecoratorB extends Decorator {
    
    public ConcreteDecoratorB (Component c){
        
        super(c);
        
    }
    public String operation(){
        
        return super.operation()+"";
        
    }
}
