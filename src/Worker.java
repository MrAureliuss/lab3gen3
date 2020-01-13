import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Worker extends Person {
    private int anger;
    private float salary;

    public Worker(String name, float balance, int anger) {
        super(name, balance);
        this.anger = anger;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    public String getName() {
        return super.name;
    }

    public static List<Worker> createWorkers(int count) {
        Random random = new Random();
        List<Worker> workers = new ArrayList<>();
        List<String> names = Arrays.asList("Жека", "Дима", "Работяга с Девяткино", "Сашенька", "Владимир Владимирович");

        for (int i=0; i<count; i++) {
            workers.add(new Worker(names.get(random.nextInt(names.size())),100 + random.nextInt(1000), 10));
        }

        return workers;
    }

    private void riot() {
        System.out.println("ШОК! РАБОТЯГА " + name + " ВЗБУНТОВАЛСЯ! А стоп... Это же мир бредламов, который похож на одну страну.. Бунт отменяется");
        this.anger = 0;
    }

    public void work() {
        this.anger += 10;
        if (anger >= 100) { riot(); } // Если работяга уж слишком не доволен, то бунтуем.
    }

    @Override
    public String toString() {
        return super.name;
    }
}
