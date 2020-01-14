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
}