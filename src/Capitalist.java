import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Random;

public class Capitalist extends Person {
    private boolean notified;
    public Capitalist(String name, float balance) {
        super(name, balance);
    }

    public static Capitalist createCapitalist() {
        Random random = new Random();
        List<String> names = Arrays.asList("Господин Алишер", "Господин Фирамир", "Господин Хованский", "Господин КаваСенпай",
                "Господин Всеволод Канторов", "Господин Пшено", "Господин Мама Спаси Меня Я Устал", "Господин Дадая",
                "Господин Михаил Зубенко");

        return new Capitalist(names.get(random.nextInt(names.size())), 5000000 + random.nextInt(50000));
    }

    public void notifyCapitalist(){
        this.notified = true;
        System.out.println("КАПИТАЛИСТ " + this.name + "ПОЛУЧИЛ ОПОВЕЩЕНИЕ ПРИБЫТЬ НА СТРЕЛКУ");
    }

    public boolean isNotified(){
        return notified;
    }

    @Override
    public void addDisappointment(int disappointment){
        if(this.disappointment >= 100) {
            System.out.println("Капиталист "+ this.name + " ахуел");
        } else if (this.disappointment < 0) {
            this.disappointment += 0;
        } else {
            this.disappointment += disappointment;
        }
        if (disappointment > 0){
            System.out.println("Капиталист "+super.name + " повысил уровень злобы до "+this.disappointment);

        }else{
            System.out.println("Капиталист "+super.name + " понизил уровень злобы до "+this.disappointment);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Capitalist)) return false;
        Capitalist that = (Capitalist) o;
        return notified == that.notified;
    }

    @Override
    public int hashCode() {
        return Objects.hash(notified);
    }
}
