import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Entity)) return false;
        Entity entity = (Entity) o;
        return Float.compare(entity.width, width) == 0 &&
                Float.compare(entity.length, length) == 0 &&
                Float.compare(entity.height, height) == 0 &&
                Float.compare(entity.weight, weight) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(width, length, height, weight);
    }
}