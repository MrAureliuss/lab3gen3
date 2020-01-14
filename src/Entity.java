abstract public class Entity{
    protected float width;
    protected float length;
    protected float height;
    protected float weight;

    Entity(float width, float length, float height){
        this.width = width;
        this.height = height;
        this.length = length;
    }
    
    Entity(float width, float length, float height, float weight){
        this.width = width;
        this.height = height;
        this.length = length;
        this.weight = weight;
    }
}