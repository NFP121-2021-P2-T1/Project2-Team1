
public class ConcreteElement1 implements AElement {
    
    public String getName(){
        return "ConcreteElement1";
    }
    
    public String accept(AVisitor v){
        return v.visit(this);
    }
    
}
