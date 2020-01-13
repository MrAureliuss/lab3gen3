import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Capitalist extends Person {
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
}
