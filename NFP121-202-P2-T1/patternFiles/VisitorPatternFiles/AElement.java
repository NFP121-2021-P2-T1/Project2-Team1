
public interface AElement {
    
    public String getName();
    public abstract String accept(AVisitor v);
    
}
