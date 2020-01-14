final class Dube extends Person {
    Dube(float balance){
        super("Господин ДУшаБЕ", balance);
    }


    public void giveSpeech(String text){
        System.out.println("Спрутс спизданул, что "+text);
    }
}