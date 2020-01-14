import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Worker extends Person {
    private float salary;

    @Override
    public void addDisappointment(int disappointment){
        if(this.disappointment >= 100){
            riot();
        } else if (this.disappointment < 0) {
            this.disappointment += 0;
        } else {
            this.disappointment += disappointment;
        }
        if (disappointment > 0){
            System.out.println("Рабочий "+super.name + " повысил уровень злобы до "+this.disappointment);

        }else{
            System.out.println("Рабочий "+super.name + " понизил уровень злобы до "+this.disappointment);
        }
    }

    public Worker(String name, float balance, int disappointment) {
        super(name, balance);
        this.disappointment = disappointment;
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
        this.disappointment = 0;
    }

    public void work() {
        addDisappointment(2);
        System.out.println("РАБОТЯГА " + name + " ПОШЕЛ НА ЗАВОД ДЕЛАТЬ КИРПИЧИ!");

    }

    @Override
    public String toString() {
        return super.name;
    }
}
