
public class ConcreteElement2 implements AElement {
    
     public String getName(){
        return "ConcreteElement1";
    }
     
    public String accept(AVisitor v){
        return v.visit(this);
    }
    
}
