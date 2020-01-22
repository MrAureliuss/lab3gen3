import java.util.Random;

class Dubotolk extends Person implements Speaking {
    Dubotolk(String name, float balance){
        super(name, balance);
    }

    class Head extends Entity{
        Head() {
            super(1, 1, 1, 30);
        }
        
        public void turn(){
            System.out.println("Коротышка крутит головой и очень медленно");
        }
        public void bend(){
            System.out.println("Коротышка наклоняет голову и ему хуево, делает это он оч медленно");
        }
    }

    @Override
    public void giveSpeech(String text) {
        System.out.println(this.name+" спизданул, что "+text);

    }

    // А почему не может?
}