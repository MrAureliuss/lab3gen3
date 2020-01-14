import java.util.Objects;

public class GiantTree extends Entity{
    private String name = new String("Ебанутое гигантское дерево");
    GiantTree(float width,float length,float height){
        super(width, length, height);
    }

    public String getName(){
        return name;
    }

    public void grow(){
        this.height += 20;
        this.width += 10;
        this.length += 2;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof GiantTree)) return false;
        if (!super.equals(o)) return false;
        GiantTree giantTree = (GiantTree) o;
        return Objects.equals(name, giantTree.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), name);
    }
}